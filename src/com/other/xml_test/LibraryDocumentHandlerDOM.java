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
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LibraryDocumentHandlerDOM extends LibraryDocumentHandler {
	
	private boolean xsdValidate = false;
	private boolean nameSpaceAware = false;
	
	private DocumentBuilderFactory documentBuilderFactory;
	private DocumentBuilder documentBuilder;
	private Document document;
	
	public LibraryDocumentHandlerDOM(boolean xsdValidate, boolean nameSpaceAware) {
		this.xsdValidate = xsdValidate;
		this.nameSpaceAware = nameSpaceAware;
		try {
			initialize();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() throws ParserConfigurationException, SAXException, IOException {
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(nameSpaceAware);
		if(xsdValidate) {			
			documentBuilderFactory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
		}
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
	}

	@Override
	protected void printBooksOfLibrary(File source) {
		try {
			document = documentBuilder.parse(source);
			printBooksOfLibrary0(document);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printBooksOfLibrary0(Document domDocument) throws ParserConfigurationException, SAXException, IOException {
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
		printBooks(bookList);
	}
	
	@Override
	protected void addBook(File source, File destination, Book book) {
		try {
			addBook0(source, book);
			saveLibraryChanges(document, destination);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addBook0(File source, Book book) throws SAXException, IOException {
		document = documentBuilder.parse(source);
		Element bookElement = document.createElement("book");
		bookElement.setAttribute("id", book.getId());
		bookElement.setAttribute("type", book.getType());
		Element bookTitle = document.createElement("title");
		bookTitle.setTextContent(book.getTitle());
		bookElement.appendChild(bookTitle);
		for(String author : book.getAuthors()) {
			Element bookAuthor = document.createElement("author");
			bookAuthor.setTextContent(author);
			bookElement.appendChild(bookAuthor);
		}
		Element libraryElement = (Element) document.getElementsByTagName("library");
		libraryElement.appendChild(bookElement);
	}

	@Override
	protected void editBook(File source, File destination, String id, String typeEdit, String titleEdit, List<String> authorsEdit) {
		try {
			editBook0(source, id, typeEdit, titleEdit, authorsEdit);
			saveLibraryChanges(document, destination);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void editBook0(File source, String id, String typeEdit, String titleEdit, List<String> authorsEdit) throws SAXException, IOException {
		document = documentBuilder.parse(source);
		Element bookElement = searchBookElement(source, id);
		if(bookElement != null) {
			String oldTypeAttribute = bookElement.getAttribute("type");
			bookElement.setAttribute("type", typeEdit == null ? oldTypeAttribute : typeEdit);
			Element titleElement = (Element) bookElement.getElementsByTagName("title").item(0);
			String oldTitleTextContent = titleElement.getTextContent();
			titleElement.setTextContent(titleEdit == null ? oldTitleTextContent : titleEdit);
			NodeList authorNodes = bookElement.getElementsByTagName("author");
			if(authorNodes.getLength() == authorsEdit.size()) {
				for (int i = 0; i < authorNodes.getLength(); i++) {
					authorNodes.item(i).setTextContent(authorsEdit.get(i));
				}
			} else if(authorNodes.getLength() > authorsEdit.size()) {
				for (int i = 0; i < authorNodes.getLength(); i++) {
					if(i < authorsEdit.size()) {
						authorNodes.item(i).setTextContent(authorsEdit.get(i));
					} else {
						bookElement.removeChild(authorNodes.item(i));
					}
				}
			} else {
				for (int i = 0; i < authorsEdit.size(); i++) {
					if(i < authorNodes.getLength()) {
						authorNodes.item(i).setTextContent(authorsEdit.get(i));
					} else {
						Element authorElement = document.createElement("author");
						authorElement.setTextContent(authorsEdit.get(i));
						bookElement.appendChild(authorElement);
					}
				}
			}
		} else {
			System.out.println("The book id=" + id + " is not exist");
		}
	}

	@Override
	protected void removeBook(File source, File destination, String id) {
		try {
			removeBook0(source, destination, id);
			saveLibraryChanges(document, destination);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	private void removeBook0(File source, File destination, String id) throws SAXException, IOException {
		document = documentBuilder.parse(source);
		Element bookElement = searchBookElement(source, id);
		if(bookElement != null) {
			Element libraryElement = (Element) document.getElementsByTagName("library");
			libraryElement.removeChild(bookElement);
		} else {
			System.out.println("The book id=" + id + " is not exist");
		}
	}
	
	@Override
	protected void makeLibrary(File destination, List<Book> books) {
		// TODO Auto-generated method stub
		
	}

	private void saveLibraryChanges(Document document, File destination) throws FileNotFoundException, TransformerException {
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new FileOutputStream(destination));
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.transform(domSource, streamResult);
	}
	
	@Override
	protected Element searchBookElement(File source, String id) {
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
	protected void transformDoument(File source, File destination) {
		// TODO Auto-generated method stub
		
	}
}
