package com.other.xml_test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//TEST
//		testDOM();
//		testSTAX();
		testJAXB();
	}
	
	@SuppressWarnings("unused")
	private static void testDOM() {
		File sourceDocumentXML = Paths.get("src/com/other/xml_test/LibraryDocument.xml").toFile(); 
		File copyDocumentXML = Paths.get("src/com/other/xml_test/LibraryDocumentCopy.xml").toFile();
		File newDocumentXML = Paths.get("src/com/other/xml_test/LibraryDocumentNEW.xml").toFile();
		File documentXSD = Paths.get("src/com/other/xml_test/LibraryXSD.xsd").toFile();
		File documentHTML = Paths.get("src/com/other/xml_test/LibraryHTML.html").toFile();
		File documentXSLT = Paths.get("src/com/other/xml_test/LibraryXSLT.xsl").toFile();
		LibraryDocumentHandler domHandler = new LibraryDocumentHandlerDOM(true, true);
//		domHandler.addBook(sourceDocumentXML, destination, initBook());
//		domHandler.editBook(copyDocumentXML, copyDocumentXML, "BN-99", null, "Вечный зов. Том 1", null);
//		domHandler.removeBook(copyDocumentXML, copyDocumentXML, "BN-99");
//		domHandler.printBooks(domHandler.searchBookByAuthor(sourceDocumentXML, "Джеймс Клавелл"));
//		domHandler.printBooks(domHandler.searchBookByTitle(sourceDocumentXML, "Война и мир"));
//		domHandler.makeLibrary(newDocumentXML, new ArrayList<Book>());
//		domHandler.isValidate(newDocumentXML, documentXSD);
//		domHandler.transformDoument(sourceDocumentXML, documentXSLT, documentHTML);
	}
	
	@SuppressWarnings("unused")
	private static Book initBook() {
		Book book = new Book();
		List<String> authorList = new ArrayList<>();
		authorList.add("Анатолий Иваноов");
		book.setAuthors(authorList);
		book.setId("BN-99");
		book.setTitle("Вечный зов");
		book.setType("Роман-эпопея");
		return book;
	}
	
	@SuppressWarnings("unused")
	private static void testSTAX() {
		File sourceDocumentXML = Paths.get("src/com/other/xml_test/LibraryDocument.xml").toFile(); 
		File copyDocumentXML = Paths.get("src/com/other/xml_test/LibraryDocumentCopySTAX.xml").toFile();
		File newDocumentXML = Paths.get("src/com/other/xml_test/LibraryDocumentNEW_STAX.xml").toFile();
		File documentXSD = Paths.get("src/com/other/xml_test/LibraryXSD.xsd").toFile();
		File documentHTML = Paths.get("src/com/other/xml_test/LibraryHTML.html").toFile();
		File documentXSLT = Paths.get("src/com/other/xml_test/LibraryXSLT.xsl").toFile();
		LibraryDocumentHandler staxHandler = new LibraryDocumentHandlerSTAX();
//		staxHandler.printBooksOfLibrary(sourceDocumentXML);
		staxHandler.addBook(sourceDocumentXML, copyDocumentXML, initBook());
		staxHandler.editBook(copyDocumentXML, copyDocumentXML, "BN-99", null, "Вечный зов. Том 1", null);
	}
	
	@SuppressWarnings("unused")
	private static void testJAXB() {
		List<Car> cars = new ArrayList<>();
		Car bmwM5 = new Car("BMV", "M5", CarType.SPORT, 100);
		Car mercedessMclaren = new Car("Mercedess", "Mclaren", CarType.SPORT, 250);
		cars.add(bmwM5);
		cars.add(mercedessMclaren);
		CarShop carShop = new CarShop("My car shop", "89995558822", cars);
		File carDocumentXML = Paths.get("src/com/other/xml_test/CarDocument.xml").toFile();
		File carShopDocumentXML = Paths.get("src/com/other/xml_test/CarShopDocument.xml").toFile();
		TestJAXB testJAXB = new TestJAXB();
//		testJAXB.testMarshalCarShop(carShop, carShopDocumentXML);
//		testJAXB.testMarshalCar(mercedessMclaren, carDocumentXML);
//		testJAXB.testUnmarshalCar(carDocumentXML);
		testJAXB.testUnmarshalCarShop(carShopDocumentXML);
	}
}
