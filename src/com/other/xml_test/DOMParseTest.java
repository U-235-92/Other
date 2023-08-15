package com.other.xml_test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMParseTest {

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
		File docFile = Paths.get("C:\\Users\\LENOVO\\Documents\\OxygenXMLEditor\\samples\\SimpleDocumentDTDXML.xml").toFile();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(docFile);
		Node root = doc.getDocumentElement();
		System.out.println(root);
	}
}
