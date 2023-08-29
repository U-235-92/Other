package com.other.json_test.simple_json_javax;

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
import javax.json.JsonValue.ValueType;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.other.json_test.obj.Book;

public class SimpleJsonJavax {

	public JsonObject testMakeDocument() {
		JsonObject obj = Json.createObjectBuilder().add("library", Json.createObjectBuilder().add("lib_name", "New library")
				.add("books", Json.createArrayBuilder()
						.add(Json.createObjectBuilder().add("id", "BN-1").add("type", "Test").add("title", "Foo").add("authors", Json.createArrayBuilder().add("Ivan Ivanov")))
						.add(Json.createObjectBuilder().add("id", "BN-2").add("type", "yo").add("title", "good").add("authors", Json.createArrayBuilder().add("Ivan Ivanov").add("Petr Petrov"))))).build();
		return obj;
	}
	
	public void printDocument(File source) {	
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void printObject(JsonObject obj) {
		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);
		JsonWriter jsonWriter = jsonWriterFactory.createWriter(System.out);
		jsonWriter.writeObject(obj);
		jsonWriter.close();
	}
	
	public void writeObject(File destination, JsonObject obj) {
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
	
	public JsonObject readObject(File source) {
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void printBooksLibraryDocument(File source) {
		var books = new ArrayList<Book>();
		JsonObject rootObj = readObject(source);
		JsonObject libObj = rootObj.getJsonObject("library");
		JsonArray booksArr = libObj.getJsonArray("books");
		for(JsonValue val : booksArr) {
			if(val.getValueType() == ValueType.OBJECT) {
				Book book = new Book();
				var authors = new ArrayList<String>();
				String id = "";
				String type = "";
				String title = "";
				JsonObject bookObj = val.asJsonObject();
				for(JsonValue element : bookObj.values()) {
					JsonObject obj = element.asJsonObject();
					id = obj.getString("id");
					type = obj.getString("type");
					title = obj.getString("title");
					JsonArray arr = obj.getJsonArray("authors");
					for(JsonValue authorVal : arr) {
						String author = authorVal.toString();
						authors.add(author);
					}
				}
				book.setId(id);
				book.setType(type);
				book.setTitle(title);
				book.setAuthors(authors);
				books.add(book);
			}
		}
		books.forEach(book -> System.out.println(book));
	}
	
	public void addBookDocument(File source, Book book) {
		JsonObject bookObj = makeBookObject(book);
		addBookToLibrary(source, bookObj);
	}
	
	private JsonObject makeBookObject(Book book) {
		JsonArrayBuilder authorArrBuilder = Json.createArrayBuilder(book.getAuthors());
		JsonObjectBuilder bookObjBuilder = Json.createObjectBuilder().add("book", Json.createObjectBuilder().add("id", book.getId()).add("type", book.getType()).add("title", book.getTitle()).add("authors", authorArrBuilder));
		return bookObjBuilder.build();
	}
	
	private void addBookToLibrary(File source, JsonObject bookObj) {
		JsonObject documentObj = readObject(source);
		JsonObject libraryObj = documentObj.asJsonObject().getJsonObject("library");
		JsonArray bookArr = libraryObj.getJsonArray("books");
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder(bookArr);
		arrayBuilder.add(bookObj);
		JsonObjectBuilder libraryBuilder = Json.createObjectBuilder();
		libraryBuilder.add("library", Json.createObjectBuilder().add("lib_name", libraryObj.get("lib_name")).add("books", arrayBuilder));
		JsonObjectBuilder documentBuilder = Json.createObjectBuilder(libraryBuilder.build());
		writeObject(source, documentBuilder.build());
	}
	
	public void editBookDocument(File source, String id, String type, String title, List<String> authors) {
		Book book = new Book(id, type, title, authors);
		JsonObject bookObj = makeBookObject(book);
		editBookAtLibrary(source, id, bookObj);
	}
	
	private void editBookAtLibrary(File source, String id, JsonObject bookObj) {
		JsonObject documentObj = readObject(source);
		JsonObject libraryObj = documentObj.asJsonObject().getJsonObject("library");
		JsonArray bookArr = libraryObj.getJsonArray("books");
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		for(JsonValue oldBookValue : bookArr) {
			if(oldBookValue.getValueType() == ValueType.OBJECT) {
				JsonObject oldBookObj = oldBookValue.asJsonObject();
				for(JsonValue element : oldBookObj.values()) {
					String idRead = element.asJsonObject().get("id").toString();
					idRead = idRead.substring(1, idRead.length() - 1);
					if(idRead.equals(id)) {
						arrayBuilder.add(bookObj);
					} else {
						arrayBuilder.add(oldBookObj);
					}
				}
			}
		}
		JsonObjectBuilder libraryBuilder = Json.createObjectBuilder();
		libraryBuilder.add("library", Json.createObjectBuilder().add("lib_name", libraryObj.get("lib_name")).add("books", arrayBuilder));
		JsonObjectBuilder documentBuilder = Json.createObjectBuilder(libraryBuilder.build());
		printObject(documentBuilder.build());
	}

	public void removeBookDocument(File source, String id) {
		removeBookDocument0(source, id);
	}
		
	private void removeBookDocument0(File source, String id) {
		JsonObject documentObj = readObject(source);
		JsonObject libraryObj = documentObj.asJsonObject().getJsonObject("library");
		JsonArray bookArr = libraryObj.getJsonArray("books");
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		for(JsonValue oldBookValue : bookArr) {
			if(oldBookValue.getValueType() == ValueType.OBJECT) {
				JsonObject oldBookObj = oldBookValue.asJsonObject();
				for(JsonValue element : oldBookObj.values()) {
					String idRead = element.asJsonObject().get("id").toString();
					idRead = idRead.substring(1, idRead.length() - 1);
					if(!idRead.equals(id)) {
						arrayBuilder.add(oldBookObj);
					}
				}
			}
		}
		JsonObjectBuilder libraryBuilder = Json.createObjectBuilder();
		libraryBuilder.add("library", Json.createObjectBuilder().add("lib_name", libraryObj.get("lib_name")).add("books", arrayBuilder));
		JsonObjectBuilder documentBuilder = Json.createObjectBuilder(libraryBuilder.build());
		printObject(documentBuilder.build());
	}
}
