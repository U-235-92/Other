package com.other.json_test.jackson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.other.json_test.obj.Addres;
import com.other.json_test.obj.Cat;
import com.other.json_test.obj.Employee;
import com.other.json_test.obj.PrivateObj;
import com.other.json_test.obj.Role;

public class SimpleJackson {

	public void privateObjectToJson() {
		PrivateObj privateObj = new PrivateObj();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		String stringObj;
		try {
			stringObj = objectMapper.writeValueAsString(privateObj);
			System.out.println(stringObj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	public void employeeToJsonAndPrint() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		Employee employee = makeEmployee();
		try {
			String jsonEmployee = objectMapper.writeValueAsString(employee);
			System.out.println(jsonEmployee);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	private Employee makeEmployee() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("count", 10);
		properties.put("isValid", true);
		properties.put("status", "Default");
		List<String> phones = new ArrayList<>();
		phones.add("12345");
		phones.add("67890");
		String name = "John";
		String changeMyNameWhenRead = "Read change";
		String changeMyNameWhenWrite = "Write change";
		int age = 25;
		int noSaveData = -1;
		Role role = Role.WORKER;
		Addres addres = new Addres("Argentina", "Ushuaia", "Av San Martin", "V9410");
		Employee employee = new Employee(noSaveData, changeMyNameWhenRead, changeMyNameWhenWrite, properties, phones, name, age, role, addres);
		return employee;
	}
	
	public void jsonToEmployeeAndPrint() {
		String employeeJson = "{\r\n"
				+ "  \"properties\" : {\r\n"
				+ "    \"isValid\" : true,\r\n"
				+ "    \"count\" : 10,\r\n"
				+ "    \"status\" : \"Default\",\r\n"
				+ "    \"addition\" : \"ADDITION PROPERTY\"\r\n" 
				+ "  },\r\n"
				+ "  \"phones\" : [ \"12345\", \"67890\" ],\r\n"
				+ "  \"name\" : \"John\",\r\n"
				+ "  \"OLD_NAME\" : \"Read change\",\r\n"
				+ "  \"NEW_NAME\" : \"Write change\",\r\n"
				+ "  \"age\" : 25,\r\n"
				+ "  \"noSaveData\" : -1,\r\n"
				+ "  \"role\" : \"WORKER\",\r\n"
				+ "  \"DANGER\" : \"MAY INCORRECT\",\r\n"
				+ "  \"addres\" : {\r\n"
				+ "    \"country\" : \"Argentina\",\r\n"
				+ "    \"city\" : \"Ushuaia\",\r\n"
				+ "    \"street\" : \"Av San Martin\",\r\n"
				+ "    \"zip\" : \"V9410\"\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ "";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Employee employee = objectMapper.readValue(employeeJson.getBytes(), Employee.class);
			System.out.println(employee);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printCatsAsBind() {
		File catFile = Path.of("src/com/other/json_test/files/CatJSON.json").toFile();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			List<Cat> cats = objectMapper.readValue(catFile, new TypeReference<>(){});
			System.out.println(cats);
			List<?> objs = objectMapper.readValue(catFile, List.class);
			System.out.println(objs);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void crudOperationsAsDocument() {
		File catFile = Path.of("src/com/other/json_test/files/CatJSON.json").toFile();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			JsonNode root = objectMapper.readTree(catFile);
			addCat(root, objectMapper);
			editCat(root, objectMapper);
			removeCat(root, objectMapper);
			printResult(root, objectMapper);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addCat(JsonNode root, ObjectMapper objectMapper) {
		ObjectNode catNode1 = objectMapper.createObjectNode();
		catNode1.putPOJO("test", new Cat(14, "Test", new String[] {"Red"}));
		ObjectNode catNode2 = objectMapper.createObjectNode();
		catNode2.put("age", 10);
		catNode2.put("name", "Murlika");
		ArrayNode colorNode = JsonNodeFactory.instance.arrayNode();
		colorNode.add("gray");
		colorNode.add("white");
		catNode2.set("color", colorNode);
		if(root.isArray()) {
			ArrayNode arrayNode = (ArrayNode) root;
//			arrayNode.add(catNode1);
			arrayNode.add(catNode2);
		}
		System.out.println("VALUE NODE " + root.isValueNode());
		try {
			JsonNode n = catNode1.get("test");
			System.out.println(n.getNodeType());
			objectMapper.writeValue(System.out, n.get("age"));
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void editCat(JsonNode root, ObjectMapper objectMapper) {
		
	}

	private void removeCat(JsonNode root, ObjectMapper objectMapper) {
		
	}

	private void printResult(JsonNode root, ObjectMapper objectMapper) {
		try {
			objectMapper.writeValue(System.out, root);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
