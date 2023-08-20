package com.other.xml_test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.xpath.XPathException;

import org.w3c.dom.Element;

public class LibraryDocumentHandlerSTAX extends LibraryDocumentHandler {

	private String currentElementName;
	private String endElementName;
	private Book book;
	private List<Book> bookList = new ArrayList<>();
	private List<String> authorList = new ArrayList<>();
	
	public LibraryDocumentHandlerSTAX() {
		super();
	}
	
	private XMLEventReader getEventReader(File sourceDocumentXML) throws XMLStreamException, FileNotFoundException {
		FileInputStream fis = new FileInputStream(sourceDocumentXML);
		BufferedInputStream bis = new BufferedInputStream(fis);
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = inputFactory.createXMLEventReader(bis);
		return eventReader;
	}
	
	private XMLStreamWriter getStreamWriter(File destinationDocumentXML) throws XMLStreamException, FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(destinationDocumentXML);
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(fos);
		return streamWriter;
	}
	
	@Override
	protected void printBooksOfLibrary(File source) {
		try {
			printBooksLibrary0(getEventReader(source));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private void printBooksLibrary0(XMLEventReader reader) throws XMLStreamException {
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				handlePrintBookStartElementEvent(event);
			} else if(event.isEndElement()) {
				handlePrintBookEndElementEvent(event);
			} else if(event.isCharacters()) {
				handlePrintBookCharactersElementEvent(event);
			} 
		}
		printBooks(bookList);
	}

	private void handlePrintBookStartElementEvent(XMLEvent event) {
		StartElement element = event.asStartElement();
		currentElementName = element.getName().getLocalPart();
		if(currentElementName.equals("book")) {
			book = new Book();
		}
		handlePrintBookAttributeEvent(element);
	}
	
	private void handlePrintBookAttributeEvent(StartElement element) {
		if(element.getName().getLocalPart().equals("book")) {			
			Attribute attributeID = element.getAttributeByName(new QName("id"));
			String id = attributeID.getValue();
			Attribute attributeType = element.getAttributeByName(new QName("type"));
			String type = attributeType.getValue();
			book.setId(id);
			book.setType(type);
		}
	}

	private void handlePrintBookEndElementEvent(XMLEvent event) {
		currentElementName = "";
		EndElement element = event.asEndElement();
		endElementName = element.getName().getLocalPart();
		if(endElementName.equals("book")) {
			book.setAuthors(new ArrayList<>(authorList));
			bookList.add(book);
			authorList.clear();
		}
	}

	private void handlePrintBookCharactersElementEvent(XMLEvent event) {
		Characters characters = event.asCharacters();
		if(currentElementName.equals("title")) {
			String titleBook = characters.getData();
			book.setTitle(titleBook);
		} else if(currentElementName.equals("author")) {
			String author = characters.getData();
			authorList.add(author);
		}
	}
	
	@Override
	protected void addBook(File source, File destination, Book book) {
		try {
			addBook0(source, destination, book);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private void addBook0(File source, File destination, Book book) throws FileNotFoundException, XMLStreamException {
		XMLStreamWriter straemtWriter = getStreamWriter(destination);
		XMLEventReader eventReader = getEventReader(source);
		while(eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			if(event.isStartElement()) {
				StartElement element = event.asStartElement();
				if(element.getName().getLocalPart().equals("library")) {					
					handleAddBook(straemtWriter, book);
					break;
				}
			}
		}
	}

	private void handleAddBook(XMLStreamWriter streamWriter, Book book) throws XMLStreamException {
		streamWriter.writeStartElement("book");
		streamWriter.writeAttribute("id", book.getId());
		streamWriter.writeAttribute("type", book.getType());
		streamWriter.writeStartElement("title");
		streamWriter.writeCharacters(book.getTitle());
		streamWriter.writeEndElement();
		for(String author : book.getAuthors()) {
			streamWriter.writeStartElement("author");
			streamWriter.writeCharacters(author);
			streamWriter.writeEndElement();
		}
		streamWriter.writeEndElement();
	}

	@Override
	protected void editBook(File source, File destination, String id, String typeEdit, String titleEdit,
			List<String> authorsEdit) {
		
	}

	@Override
	protected void removeBook(File source, File destination, String id) {
		
	}

	@Override
	protected void makeLibrary(File destination, List<Book> books) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Element searchBookElement(File source, String id) throws XPathException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Book> searchBookByAuthor(File source, String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Book> searchBookByTitle(File source, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void transformDoument(File documentXML, File documentXSLT, File destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isValidate(File document, File schema) {
		// TODO Auto-generated method stub
		return false;
	}
}
