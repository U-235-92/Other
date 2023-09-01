package com.other.json_test.gson;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import com.other.json_test.obj.Book;
import com.other.json_test.obj.Cat;
import com.other.json_test.obj.Ticket;
import com.other.json_test.obj.TicketType;

@SuppressWarnings("unused")
public class MainSimpleGson {

	public static void main(String[] args) {
		File originLibFile = Path.of("src/com/other/json_test/files/LibraryJSON.json").toFile();
		File copyLibFile = Path.of("src/com/other/json_test/files/CopyLibraryJSON.json").toFile();
		File customLibFile = Path.of("src/com/other/json_test/files/CustomLibraryJSON.json").toFile();
		File catFile = Path.of("src/com/other/json_test/files/CatJSON.json").toFile();
		SimpleGson simpleGson = new SimpleGson();
//		simpleGson.makeAndPrintStringJson();
//		simpleGson.makeAndPrintBookJson();
//		simpleGson.makeAndPrintStudentJson();
//		simpleGson.makeAndPrintTicketJson(makeTicket());
//		simpleGson.printBooksAsStream(originLibFile);
//		simpleGson.printBooksAsDocument(originLibFile);
		simpleGson.printDocumentAsStream(catFile, Cat.class, null);
//		simpleGson.printDocumentAsStream(originLibFile, Book.class, "book");
//		simpleGson.crudBookAndPrintDocument(copyLibFile, new Book("BN-89", "type", "title", new ArrayList<>()));
	}
	
	@SuppressWarnings("unused")
	private static Ticket makeTicket() {
		String[] sn1 = {"FB", "SN", "GH", "XJ"};
		String[] sn2 = {"101", "585", "858", "492"};
		LocalDateTime localDateTime = LocalDateTime.now();
		TicketType ticketType = TicketType.values()[(int) (Math.random() * TicketType.values().length)];
		String ticketDescription = "Random ticket";
		String ticketSerialNumber = sn1[(int) (Math.random() * sn1.length)] + "-" + sn2[(int) (Math.random() * sn2.length)];
		Currency currency = Currency.getInstance(Locale.getDefault());
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		numberFormat.setCurrency(currency); 
		BigDecimal amount = new BigDecimal((Math.random() * 1000));
		String ticketPrice = numberFormat.format(amount);
		List<Integer> checkCodes = Stream.generate(() -> (int) (Math.random() * 99)).limit(5).toList();
		Ticket ticket = new Ticket(localDateTime, ticketType, ticketDescription, ticketSerialNumber, ticketPrice, checkCodes);
		return ticket;
	}

}
