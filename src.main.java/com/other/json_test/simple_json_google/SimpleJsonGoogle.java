package com.other.json_test.simple_json_google;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.other.json_test.obj.Book;

public class SimpleJsonGoogle {

	@SuppressWarnings("unchecked")
	public void printBooks(File source) {
		JSONParser parser = new JSONParser();
		try(FileReader fr = new FileReader(source)) {
			var books = new ArrayList<Book>();
			Object parseObj = parser.parse(fr);
			JSONObject rootObj = (JSONObject) parseObj;
			JSONObject libraryObj = (JSONObject) rootObj.get("library");
			JSONArray booksArr = (JSONArray) libraryObj.get("books");
			booksArr.forEach(obj -> {
				JSONObject bookObj = (JSONObject) ((JSONObject) obj).get("book");
				String id = (String) bookObj.get("id");
				String type = (String) bookObj.get("type");
				String title = (String) bookObj.get("title");
				var authors = new ArrayList<String>();
				JSONArray authorsArr = (JSONArray) bookObj.get("authors");
				Iterator<Object> iterator = authorsArr.iterator();
				while(iterator.hasNext()) {
					String author = (String) iterator.next();
					authors.add(author);
				}
				Book book = new Book(id, type, title, authorsArr);
				books.add(book);
			});
			books.forEach(book -> System.out.println(book));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void printDocument(File source) {
		JSONParser parser = new JSONParser();
		try(FileReader fr = new FileReader(source);
				PrintWriter pw = new PrintWriter(System.out)) {
			JSONObject rootObj = (JSONObject) parser.parse(fr);
			pw.write(rootObj.toJSONString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject makeJson() {
		JSONObject studentObj = new JSONObject();
		studentObj.put("name", "Nikolai");
		studentObj.put("stage", "5");
		JSONArray gradeArr = new JSONArray();
		gradeArr.add(100);
		gradeArr.add(90);
		gradeArr.add(80);
		studentObj.put("grades", gradeArr);
		return studentObj;
	}
	
	public void printJsonObject(JSONObject obj) {
		System.out.println(obj.toJSONString());
	}
}
