package com.other.xml_test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DOMParseTest {

	static final String JAXP_SCHEMA_LANGUAGE =
		    "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
		static final String W3C_XML_SCHEMA =
		    "http://www.w3.org/2001/XMLSchema";
	
	public static void testParse() {
		try {
			testParse0();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testParse0() throws ParserConfigurationException, SAXException, IOException {
//		https://docs.oracle.com/javase/tutorial/jaxp/dom/validating.html [read this article there is some information about constants above]
		File docFile = Paths.get("C:\\Users\\LENOVO\\Documents\\OxygenXMLEditor\\samples\\SimpleDocumentShemaXML.xml").toFile();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setErrorHandler(new ErrorHandler() {
			
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
			}
			
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
			}
			
			@Override
			public void error(SAXParseException exception) throws SAXException {
				exception.printStackTrace();
			}
		});
		Document doc = builder.parse(docFile);
		NodeList goodsList = doc.getElementsByTagName("goods");
		for(int i = 0; i < goodsList.getLength(); i++) {
			Node child = goodsList.item(i);
			System.out.println(child.getTextContent());
		}
	}
}
