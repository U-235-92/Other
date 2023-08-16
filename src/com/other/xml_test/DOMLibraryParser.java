package com.other.xml_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMLibraryParser {

	static final String JAXP_SCHEMA_LANGUAGE ="http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	
	private boolean xsdValidate = false;
	
	public DOMLibraryParser(boolean xsdValidate) {
		this.xsdValidate = xsdValidate;
	}
	
	public void editLibrary(File source) {
		try {
			editLibrary0(source);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editLibrary0(File source) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Document document = initialize(source);
		editBook(document);
		addBook(document);
		deleteBook(document);
		saveChanges(document);
	}

	private void editBook(Document document) {
		Element root = document.getDocumentElement();
		NodeList books = root.getElementsByTagName("book");
		for (int i = 0; i < books.getLength(); i++) {
			if(books.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element book = (Element) books.item(i);
				String id = book.getAttribute("id");
				if(id.equals("BN-3")) {
					Element titleElement = (Element) book.getElementsByTagName("title").item(0);
					titleElement.setTextContent("");
					titleElement.setTextContent("Король крыс");
				}
			}
		}
	}

	private void addBook(Document document) {
		// TODO Auto-generated method stub
		
	}

	private void deleteBook(Document document) {
		// TODO Auto-generated method stub
		
	}

	private void saveChanges(Document document) throws FileNotFoundException, TransformerException {
		File copy = new File("src/com/other/xml_test/LibraryDocumentCopy.xml");
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new FileOutputStream(copy));
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.transform(domSource, streamResult);
		showBooks(copy);
	}
	
	public void makeLibrary() {
		
	}
	
	public void showBooks(File source) {
		try {
			Document domDocument = initialize(source);
			getBooks0(domDocument);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Document initialize(File source) throws ParserConfigurationException, SAXException, IOException {
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
