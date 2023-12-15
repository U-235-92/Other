package com.other.traiderAndTransaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
		
		System.out.printf("All transactins by %d are: " + getAllTransactionsByYearASCByValue(2011, transactions) + "%n", 2011);
		System.out.println("Distinct cities by trader: ");
		getDistinctCitiesByTrader(raoul, mario, alan, brian);
		System.out.printf("All traders by city %s%n",  "Cambridge");
		getTraderByCityASCbyName("Cambridge", raoul, mario, alan, brian);
		System.out.printf("All traders names: %s%n", getTraderNamesASC(raoul, mario, alan, brian));
		System.out.println("Has trader in Milan: " + hasTraderInCity("Milan", raoul, mario, alan, brian));
		System.out.printf("Total transaction in %s is: %d%n", "Cambridge", getTotalTransactionsByCity("Cambridge", transactions));
		System.out.printf("Max transaction is: %d%n", getMaxTransaction(transactions));
		System.out.printf("Min transaction is: %d%n", getMinTransaction(transactions));
		
	}
	
	private static List<Transaction> getAllTransactionsByYearASCByValue(int year, List<Transaction> transactions) {
		return transactions.stream().filter(transaction -> transaction.getYear() == year).
				sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
	}

	private static void getDistinctCitiesByTrader(Trader...traders) {
		Arrays.stream(traders).map(Trader::getCity).distinct().forEach(System.out::println);
	}
	
	private static void getTraderByCityASCbyName(String city, Trader...traders) {
		Arrays.stream(traders).filter(trader -> trader.getCity().equals(city)).sorted(Comparator.comparing(Trader::getName)).map(Trader::getName).
				forEach(System.out::println);
	}
	
	private static String getTraderNamesASC(Trader...traders) {
		return Arrays.stream(traders).sorted((trader1, trader2) -> trader1.getName().compareTo(trader2.getName())).
				distinct().map(Trader::getName).reduce((name1, name2) -> name1 + " " + name2).get();
	}
	
	private static boolean hasTraderInCity(String city, Trader...traders) {
		return Arrays.stream(traders).anyMatch(trader -> trader.getCity().equals(city));
	}
	
	private static int getTotalTransactionsByCity(String city, List<Transaction> transactions) {
		return transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals(city)).
				map(Transaction::getValue).reduce(0, Integer::sum);
	}
	
	private static int getMaxTransaction(List<Transaction> transactions) {
		return transactions.stream().map(Transaction::getValue).reduce(Integer::max).get();
	}
	
	private static int getMinTransaction(List<Transaction> transactions) {
		return transactions.stream().map(Transaction::getValue).reduce(Integer::min).get();
	}
}
