package com.other.delete;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class QWEMain {

	public static void main(String\u005B] args) {
		
		Q qwe = new E();
		((E) qwe).additionMeth();
		
		E e = new E();
		e.additionMeth();
		
		((W) new E()).q();
		
//		System.out.println(finalmeth());
		
		String s1 = "TopJava";
		String s2 = "Java";
		String s3 = "Top" + s2;

		System.out.println((s1 == s3));
		char ch = (char) 11;
		System.out.println(ch);
		
		char ch1 = 90;
		char ch2 = 3;
		char ch3 = ((char) (ch1 + ch2));
		int i = ch1 + ch2;
		char ch4 = (char) i;
		char ch5 = '\u005B';
		byte b = (byte) 12290;
		String beer = "\u005B";
		char be = 0x005B;
		
		System.out.println(ch1 % ch2 + " " + ch3 + " " + i + " " + ch4 + " " + (char) 93);
		System.out.println(b);
		System.out.println(be);
		
		System.out.printf("%s%2$tT, %2$te %2$tB %<tY", "Today: ", new Date());
		System.out.println();
		int enterInt = 1;
//		System.out.println("Enter:");
//		Scanner sc = new Scanner(System.in);
//		while(!sc.hasNextInt()) {
//			
//			System.out.println("Input number!");
//			sc.next();
//		}
//		
//		enterInt = sc.nextInt();
//		System.out.println(enterInt);
//		
//		System.out.println("Input: ");
//		String str = sc.next();
//		sc.close();
//		System.out.println(str);
		
		int[] arr = {1, 2, 3};
		System.out.println(Arrays.toString(arr));
		swapArray(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println(enterInt);
		raiseNumber(enterInt);
		System.out.println(enterInt);
		
		linkToNull(arr);
		System.out.println("After link to null: " + Arrays.toString(arr));
		Object obj = new int[10];
	}
	
	public static void linkToNull(int[] arr) {
		
		arr = null;
	}
	
	public static void raiseNumber(int number) {
		
		number *= 3;
	}
	
	public static boolean finalmeth() {
		
		return meth1() && meth2();
	}

	public static boolean meth1() {
		
		return true;
	}
	
	public static boolean meth2() {
		
		return true;
	}
	
	public static void test(final int p) {

	}
	
	public static void swapArray(int[] arr) {
		
		int tmp = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = tmp;
//		for(int i = 0; i < arr.length; i++) {
//			
//			arr[i]++;
//		}
	}
}
