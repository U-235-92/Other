package com.other.sort;

public class Bubble {

	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					swap(arr, j);
				}
			}
		}
	}

	private static void swap(int[] arr, int j) {
		int tmp = arr[j + 1];
		arr[j + 1] = arr[j];
		arr[j] = tmp;
	}
}
