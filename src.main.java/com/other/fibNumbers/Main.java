package com.other.fibNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Integer> fibNumbersWithLoop = getFibNumbersWithLoop(20);
		System.out.println(fibNumbersWithLoop);
		
		List<Integer> fibNumbersWithStream = getFibNumbersWithStream(20);
		System.out.println(fibNumbersWithStream);
	}

	private static List<Integer> getFibNumbersWithLoop(int limit) {
		List<Integer> result = new ArrayList<>(List.of(0, 1));
		if(limit > 2) {
			for(int i = 1; i < limit; i++) {
				int next = result.get(i) + result.get(i - 1);
				result.add(next);
			}
		}
		return result;
	}
	
	private static List<Integer> getFibNumbersWithStream(int limit) {
		var result = new ArrayList<Integer>(List.of(0, 1));
		if(limit > 2) {
			return Stream.iterate(new int[]{0, 1}, arr -> new int[] {arr[1], arr[0] + arr[1]}).limit(limit + 1).
					map(arr -> arr[0]).toList();
		}
		return result;
	}
}
