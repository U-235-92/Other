package com.other.xml_test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class STAXLibraryParser {

	private File source;
	private String currentElementName;
	private String endElementName;
	private String titleBook;
	private List<Book> bookList = new ArrayList<>();
	private List<String> authorList = new ArrayList<>();
	
	public STAXLibraryParser(File source) {
		this.source = source;
	}
	
	public void editLibrary() {
		
	}
	
	public void makeLibrary() {
		
	}
	
	public void parseBooks() {
		try {
			XMLEventReader reader = initialize();
			parseBooks0(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	private XMLEventReader initialize() throws XMLStreamException, FileNotFoundException {
		FileInputStream fis = new FileInputStream(source);
		BufferedInputStream bis = new BufferedInputStream(fis);
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = inputFactory.createXMLEventReader(bis);
		return eventReader;
	}
	
	private void parseBooks0(XMLEventReader reader) throws XMLStreamException {
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				handleStartElementEvent(event);
			} else if(event.isEndElement()) {
				handleEndElementEvent(event);
			} else if(event.isCharacters()) {
				handleCharactersElementEvent(event);
			}
		}
		bookList.stream().forEach(book -> System.out.println(book));
	}

	private void handleStartElementEvent(XMLEvent event) {
		StartElement element = event.asStartElement();
		currentElementName = element.getName().getLocalPart();
	}

	private void handleEndElementEvent(XMLEvent event) {
		currentElementName = "";
		EndElement element = event.asEndElement();
		endElementName = element.getName().getLocalPart();
		if(endElementName.equals("book")) {
			Book book = new Book();
			book.setTitle(titleBook);
			book.setAuthors(new ArrayList<>(authorList));
			bookList.add(book);
			authorList.clear();
		}
	}

	private void handleCharactersElementEvent(XMLEvent event) {
		Characters characters = event.asCharacters();
		if(currentElementName.equals("title")) {
			titleBook = characters.getData();
		} else if(currentElementName.equals("author")) {
			String author = characters.getData();
			authorList.add(author);
		}
	}
}
