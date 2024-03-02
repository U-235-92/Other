package com.other.sort;

import java.util.Arrays;

public class Merge {

	public static void sort(int[] arr) {
		sort0(arr);
	}

	private static int[] sort0(int[] arr) {
		if (arr.length < 2) {
			return arr;
		}
		int[] arrA = Arrays.copyOf(arr, arr.length / 2);
		int[] arrB = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
		sort0(arrA);
		sort0(arrB);
		return merge(arrA, arrB);
	}

	private static int[] merge(int[] arrA, int[] arrB) {
		int a = 0, b = 0, c = 0;
		int[] arrC = new int[arrA.length + arrB.length];
		while(a < arrA.length && b < arrB.length) {
			if(arrA[a] < arrB[b]) {
				arrC[c] = arrA[a];
				c++; a++;
			} else {
				arrC[c] = arrB[b];
				c++; b++;
			}
		}
		while(a < arrA.length) {
			arrC[c] = arrA[a];
			a++; c++;
		}
		while(b < arrB.length) {
			arrC[c] = arrB[b];
			a++; b++;
		}
		return arrC;
	}
}
