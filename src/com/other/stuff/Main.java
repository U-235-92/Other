package com.other.stuff;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Car<String> car1 = new Car<>(100, "TEST");
//		Car<String> car2 = new Car<>(300, "BMW");
//		
//		System.out.println(car1);
//		car1 = car2;
//		System.out.println(car1);
//		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		LocalDateTime localDateTime = LocalDateTime.now();
//		String result = formatter.format(localDateTime);
//		System.out.println(result);
//		LocalDate localDateTime2 = LocalDate.parse(result.trim(), formatter);
//		System.out.println(localDateTime2);
		
		List<Integer> intLinkList = new LinkedList<>();
		intLinkList.add(1);
		intLinkList.add(2);
		intLinkList.add(3);
		ListIterator<Integer> iterator = intLinkList.listIterator();
		iterator.next();
		iterator.set(99);
		iterator.add(100);
		iterator.add(1000);
		System.out.println(intLinkList);
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		System.out.println(intLinkList);
		/*
		 * Will throw ConcurrentModificationException
		 * for(Integer i : intLinkList) { intLinkList.remove(i); }
		 */
		Map<String, Integer> map = new HashMap<>();
		map.computeIfAbsent("A", t -> 5);
		map.put("A", null);
		map.computeIfAbsent("A", t -> 58);
		map.merge("B", 34, (oldV, newV) -> oldV + newV);
		System.out.println(map);
	}

}
