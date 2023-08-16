package com.other.xml_test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMLibraryParser {

	static final String JAXP_SCHEMA_LANGUAGE ="http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	
	private File source;
	private boolean xsdValidate = false;
	
	public DOMLibraryParser(File source, boolean xsdValidate) {
		if(source == null) {
			throw new NullPointerException("The source of a XML document is null");
		}
		this.source = source;
		this.xsdValidate = xsdValidate;
	}
	
	public void editLibrary() {
		
	}
	
	public void makeLibrary() {
		
	}
	
	public void parseBooks() {
		try {
			Document domDocument = initialize();
			getBooks0(domDocument);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Document initialize() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		domFactory.setValidating(true);
		if(xsdValidate) {			
			domFactory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
		}
		DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
		Document domDocument = docBuilder.parse(source);
		return domDocument;
	}
	
	private void getBooks0(Document domDocument) throws ParserConfigurationException, SAXException, IOException {
		List<Book> bookList = new ArrayList<>();
		NodeList bookNodes = domDocument.getDocumentElement().getElementsByTagName("book");
		for (int i = 0; i < bookNodes.getLength(); i++) {
			Node bookNode = bookNodes.item(i);
			if(bookNode.getNodeType() == Node.ELEMENT_NODE) {
				String title = ((Element) bookNode).getElementsByTagName("title").item(0).getTextContent();
				NodeList authorNodes = ((Element) bookNode).getElementsByTagName("author");
				List<String> authorList = new ArrayList<>();
				for (int j = 0; j < authorNodes.getLength(); j++) {
					Node authorNode = authorNodes.item(j);
					String author = authorNode.getTextContent();
					authorList.add(author);
				}
				Book book = new Book();
				book.setTitle(title);
				book.setAuthors(authorList);
				bookList.add(book);
			}
		}
		bookList.stream().forEach(book -> System.out.println(book));
	}
}
