package com.other.stream;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FibNumbers {

	public static void main(String[] args) {
		UnaryOperator<int[]> fibOperator = arr -> {
			int tmp = arr[0];
			arr[0] = arr[1];
			arr[1] = arr[1] + tmp; 
			return arr;
		};
		Stream.iterate(new int[] {0, 1}, fibOperator).limit(20).forEach(arr -> System.out.println("(" + arr[0] + ", " + arr[1] + ")"));
	}

}
