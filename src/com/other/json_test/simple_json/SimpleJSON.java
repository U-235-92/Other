package com.other.json_test.simple_json;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.other.json_test.obj.Book;

public class SimpleJSON {

	public JsonObject testMakeDocument() {
		JsonObject obj = Json.createObjectBuilder().add("library", Json.createObjectBuilder().add("lib_name", "New library")
				.add("books", Json.createArrayBuilder()
						.add(Json.createObjectBuilder().add("id", "BN-1").add("type", "Test").add("title", "Foo").add("authors", Json.createArrayBuilder().add("Ivan Ivanov")))
						.add(Json.createObjectBuilder().add("id", "BN-2").add("type", "yo").add("title", "good").add("authors", Json.createArrayBuilder().add("Ivan Ivanov").add("Petr Petrov"))))).build();
//		System.out.println(obj.getJsonObject("books").getJsonArray("books").get(0));
		return obj;
	}
	
	public JsonObject testReadDocument(File source) {
		try(FileInputStream fis = new FileInputStream(source);
				JsonReader jsonReader = Json.createReader(fis)) {
			JsonObject obj = jsonReader.readObject();
			return obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String testStreamReadDocument(File source) {	
		try(FileInputStream fis = new FileInputStream(source);
				JsonParser jsonParser = Json.createParser(fis)) {
			while(jsonParser.hasNext()) {
				Event jsonEvent = jsonParser.next();
				if(jsonEvent == Event.START_OBJECT) {
					JsonObject obj = (JsonObject) jsonParser.getObject();
					System.out.println(obj);
				} else if(jsonEvent == Event.START_ARRAY) {
					JsonArray arr = (JsonArray) jsonParser.getArray();
					arr.forEach(element -> System.out.println(element));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public void testPrintObject(JsonObject obj) {
		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);
		JsonWriter jsonWriter = jsonWriterFactory.createWriter(System.out);
		jsonWriter.writeObject(obj);
		jsonWriter.close();
	}
	
	public void testWriteDocument(File destination, JsonObject obj) {
		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);
		try(FileOutputStream fos = new FileOutputStream(destination);
				JsonWriter jsonWriter = jsonWriterFactory.createWriter(fos)) {
			jsonWriter.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCopyDocument(File source, File destination) {
		try(FileInputStream fis = new FileInputStream(source);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(destination);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			int bytesRead = -1;
			while((bytesRead = bis.read()) != -1) {
				bos.write(bytesRead);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printBooksLibraryStream(File source) {
		List<Book> books = new ArrayList<>();
		boolean isParseBook = false;
		String readKeyName = "";
		String id = "";
		String type = "";
		String title = "";
		JsonArray authors = null;
		try(FileInputStream fis = new FileInputStream(source);
				JsonParser jsonParser = Json.createParser(fis)) {
			while(jsonParser.hasNext()) {
				Event event = jsonParser.next();
				if(event == Event.KEY_NAME) {
					if(jsonParser.getString().equals("book")) {
						isParseBook = true;
					} else if(jsonParser.getString().equals("id") && isParseBook) {
						readKeyName = "id";
					} else if(jsonParser.getString().equals("type") && isParseBook) {
						readKeyName = "type";
					} else if(jsonParser.getString().equals("title") && isParseBook) {
						readKeyName = "title";
					} else if(jsonParser.getString().equals("authors") && isParseBook) {
						readKeyName = "authors";
					}
				} else if(event == Event.VALUE_STRING) {
					if(readKeyName.equals("id")) {
						id = jsonParser.getString();
					} else if(readKeyName.equals("type")) {
						type = jsonParser.getString();
					} else if(readKeyName.equals("title")) {
						title = jsonParser.getString();
					} 
				} else if(event == Event.START_ARRAY) {
					if(readKeyName.equals("authors")) {
						authors = jsonParser.getArray();
					}
				} else if(event == Event.END_OBJECT) {
					if(readKeyName.equals("authors")) {
						isParseBook = false;
						readKeyName = "";
						List<String> authorsL = authors.stream().map(val -> val.toString()).toList();
						Book book = new Book(id, type, title, authorsL);
						books.add(book);
					}
				}
			}
			books.forEach(book -> System.out.println(book));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void printBooksLibraryDocument(File source) {
		JsonObject obj = testReadDocument(source);
		System.out.println(obj.get("library"));
	}
	
	public void addBook(Book book) {
		
	}
	
	public void editBook(Book book) {
		
	}
	
	public void removeBook(Book book) {
		
	}
}
