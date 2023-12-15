package com.other.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamToCoupleNumbersArr {

	public static void main(String[] args) {
		List<Integer> listA = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> listB = new ArrayList<>(Arrays.asList(3, 4));
		printCoupleNumbersOfLists(listA, listB);
		System.out.println();
		printCoupleNumbersOfLists0(listA, listB);
		System.out.println();
		printTheSameTaskBeforeJava8(listA, listB);
	}

	private static void printCoupleNumbersOfLists(List<Integer> listA, List<Integer> listB) {
		List<Integer[]> result = listA.stream().flatMap(numA -> listB.stream().map(numB -> new Integer[]{numA, numB})).toList();
		result.forEach(arr -> System.out.print(Arrays.toString(arr)));
	}
	
	private static void printCoupleNumbersOfLists0(List<Integer> listA, List<Integer> listB) {
		List<Integer[]> result = listA.stream().
				flatMap(numA -> listB.stream().filter(numB -> (numA + numB) % 3 == 0).map(numB -> new Integer[]{numA, numB})).toList();
		result.forEach(arr -> System.out.print(Arrays.toString(arr)));
	}
	
	private static void printTheSameTaskBeforeJava8(List<Integer> listA, List<Integer> listB) {
		List<Integer[]> result = new ArrayList<>();
		for(int i = 0; i < listA.size(); i++) {
			for(int j = 0; j < listB.size(); j++) {
				Integer[] arr = new Integer[] {listA.get(i), listB.get(j)};
				result.add(arr);
			}
		}
		for(Integer[] arr : result) {
			System.out.print(Arrays.toString(arr));
		}
	}
}
