package com.other.json_test.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.other.json_test.obj.Addres;
import com.other.json_test.obj.Employee;
import com.other.json_test.obj.Role;

public class SimpleJackson {

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
}
