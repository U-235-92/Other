package com.other.json_test.gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.other.json_test.obj.Book;
import com.other.json_test.obj.Cat;
import com.other.json_test.obj.Student;
import com.other.json_test.obj.Ticket;

@SuppressWarnings("unused")
public class SimpleGson {

	public void makeAndPrintStudentJson() {
		Student student = new Student();
		student.setRollNo(1);
		student.setName("Mahesh Kumar");
		student.setVerified(true);
		student.setId(1);
		Student.className = "VI";
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
//		gsonBuilder.setVersion(1.0);
//		gsonBuilder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
//		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = gsonBuilder.create();
		String jsonStudent = gson.toJson(student);
		System.out.println("To JSON: " + jsonStudent);
		System.out.println("From JSON: " + gson.fromJson(jsonStudent, Student.class));
	}

	public void makeAndPrintTicketJson(Ticket ticket) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Ticket.class, new TicketTypeAdapter());
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String jsonTicket = gson.toJson(ticket);
		System.out.println("To JSON: " + jsonTicket);
		System.out.println("From JSON: " + gson.fromJson(jsonTicket, Ticket.class));
	}

	public void makeAndPrintBookJson() {
		List<String> authors = new ArrayList<>();
		authors.add("author1");
		authors.add("author2");
		Book book = new Book("bn-1", "Type", "Title", authors);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String jsonBook = gson.toJson(book);
		System.out.println("To JSON: " + jsonBook);
		System.out.println("From JSON: " + gson.fromJson(jsonBook, Book.class));
	}

	public void makeAndPrintStringJson() {
		Gson gson = new Gson();
		String name = "Test name";
		String resultJson = gson.toJson(name);
		System.out.println("To JSON: " + resultJson);
		System.out.println("From JSON: " + gson.fromJson(resultJson, String.class));
	}

	public void printBooksAsDocument(File source) {
		List<Book> books = new ArrayList<>();
		try (FileReader fr = new FileReader(source)) {
			JsonReader reader = new JsonReader(fr);
			JsonElement rootElement = JsonParser.parseReader(reader);
			if (rootElement.isJsonObject()) {
				JsonObject rootObject = rootElement.getAsJsonObject();
				JsonObject libraryObject = rootObject.get("library").getAsJsonObject();
				JsonArray booksArray = libraryObject.get("books").getAsJsonArray();
				for (JsonElement bookElement : booksArray) {
					Book book = new Book();
					JsonObject bookObject = bookElement.getAsJsonObject().get("book").getAsJsonObject();
					String id = bookObject.get("id").getAsString();
					String type = bookObject.get("type").getAsString();
					String title = bookObject.get("title").getAsString();
					JsonArray authorArr = bookObject.get("authors").getAsJsonArray();
					List<String> authors = new ArrayList<>();
					for (JsonElement authorElement : authorArr) {
						String author = authorElement.getAsString();
						authors.add(author);
					}
					book.setAuthors(authors);
					book.setId(id);
					book.setTitle(title);
					book.setType(type);
					books.add(book);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (books.size() > 0) {
			books.forEach(book -> System.out.println(book));
		} else {
			System.out.println("No book found");
		}
	}

	public void crudBookAndPrintAsDocument(File source, Book book) {
		try (FileReader fr = new FileReader(source)) {
			JsonReader reader = new JsonReader(fr);
			JsonElement rootElement = JsonParser.parseReader(reader);
			System.out.println("BEFORE:");
			printElement(rootElement);
			if (rootElement.isJsonObject()) {
				JsonObject rootObject = rootElement.getAsJsonObject();
				JsonObject libraryObject = rootObject.get("library").getAsJsonObject();
				JsonArray booksArray = libraryObject.get("books").getAsJsonArray();
				createBookAsDocument(booksArray, book);
				editBookAsDocument(booksArray);
				removeBookAsDocument(booksArray);
			}
			System.out.println("AFTER:");
			printElement(rootElement);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createBookAsDocument(JsonArray booksArray, Book book) {
		JsonObject bookDetails = new JsonObject();
		bookDetails.add("id", new JsonPrimitive(book.getId()));
		bookDetails.add("type", new JsonPrimitive(book.getType()));
		bookDetails.add("title", new JsonPrimitive(book.getTitle()));
		JsonArray authorArr = new JsonArray();
		book.getAuthors().forEach(author -> authorArr.add(author));
		bookDetails.add("authors", authorArr);
		JsonObject bookObject = new JsonObject();
		bookObject.add("book", bookDetails);
		booksArray.add(bookObject);
	}

	private void editBookAsDocument(JsonArray bookArray) {
		String idEdit = "BN-4";
		for (JsonElement bookElement : bookArray) {
			JsonObject bookObject = bookElement.getAsJsonObject().get("book").getAsJsonObject();
			String bookId = bookObject.get("id").getAsString();
			if (bookId.equals(idEdit)) {
				Map<String, JsonElement> bookMap = bookObject.asMap();
				bookMap.put("type", new JsonPrimitive("Наука и техника"));
				JsonArray authorsArr = bookMap.get("authors").getAsJsonArray();
				authorsArr.remove(new JsonPrimitive("Андрей Андреев"));
				authorsArr.add("Петр Петров");
				return;
			}
		}
	}

	private void removeBookAsDocument(JsonArray bookArray) {
		String idRemove = "BN-5";
		int index = -1;
		for (JsonElement bookElement : bookArray) {
			index++;
			JsonObject bookObject = bookElement.getAsJsonObject().get("book").getAsJsonObject();
			String bookId = bookObject.get("id").getAsString();
			if (bookId.equals(idRemove)) {
				break;
			}
		}
		if (index != -1) {
			bookArray.remove(index);
		}
	}

	private void printElement(JsonElement element) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		System.out.println(gson.toJson(element));
	}

	public void printBooksAsStream(File source) {
		List<Book> books = new ArrayList<>();
		try (FileReader fr = new FileReader(source); JsonReader jsonReader = new JsonReader(fr)) {
			String lastReadElementName = "";
			boolean isPrintBook = false;
			while (jsonReader.hasNext()) {
				JsonToken token = jsonReader.peek();
				if (token.equals(JsonToken.BEGIN_OBJECT)) {
					if (isPrintBook) {
						Gson gson = new GsonBuilder().setPrettyPrinting().create();
						Book book = gson.fromJson(jsonReader, Book.class);
						books.add(book);
						isPrintBook = false;
						jsonReader.endObject();
					} else {
						jsonReader.beginObject();
					}
				} else if (token.equals(JsonToken.END_OBJECT)) {
					jsonReader.endObject();
				} else if (token.equals(JsonToken.BEGIN_ARRAY)) {
					jsonReader.beginArray();
				} else if (token.equals(JsonToken.END_ARRAY)) {
					jsonReader.endArray();
				} else if (token.equals(JsonToken.NAME)) {
					lastReadElementName = jsonReader.nextName();
					if ("book".equals(lastReadElementName)) {
						isPrintBook = true;
					}
				} else {
					jsonReader.skipValue();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (books.size() > 0) {
			books.forEach(book -> System.out.println(book));
		} else {
			System.out.println("No book found");
		}
	}

	public <T> void printDocumentAsStream(File source, Class<T> clazz, String keyElelementName) {
		try (FileInputStream fis = new FileInputStream(source);
				InputStreamReader isr = new InputStreamReader(fis);
				JsonReader jsonReader = new JsonReader(isr)) {
			String lastReadElementName = "";
			while (jsonReader.hasNext()) {
				JsonToken token = jsonReader.peek();
				if (token.equals(JsonToken.BEGIN_OBJECT)) {
					if (keyElelementName == null || lastReadElementName.equals(keyElelementName)) {
						Gson gson = new GsonBuilder().setPrettyPrinting().create();
						T obj = gson.fromJson(jsonReader, clazz);
						System.out.println(obj);
					} else {
						jsonReader.beginObject();
					}
				} else if (token.equals(JsonToken.END_OBJECT)) {
					jsonReader.endObject();
				} else if (token.equals(JsonToken.BEGIN_ARRAY)) {
					jsonReader.beginArray();
				} else if (token.equals(JsonToken.END_ARRAY)) {
					jsonReader.endArray();
				} else if (token.equals(JsonToken.NAME)) {
					lastReadElementName = jsonReader.nextName();
				} else {
					jsonReader.skipValue();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
