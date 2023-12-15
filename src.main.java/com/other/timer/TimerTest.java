package com.other.timer;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

	private int t = 0;
	private static int y = 0;
	private static final int T = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TimerPrinter timerPrinter = new TimerPrinter();
//		Timer timer = new Timer(1000, timerPrinter);
//		timer.start();
//		JOptionPane.showConfirmDialog(null, "Quit programm?");
//		System.exit(0);
		
//		int[][] arr = new int[4][8];
//		System.out.println(arr.length);
//		
//		for(int i = 10; i < 0; i++) {
//			System.out.println("test");
//		}
		new TimerTest() {
			public void test() {
				
			}
		}.test();
		
		TimerTest.Test test = new TimerTest().new Test();
		test.privateInt  = 15;
		System.out.println(test.privateInt);
		int r = Test.TEST;
		
	}
	
	public void f() {
		Test t = new Test();
	}
	
	public static <T extends Number> T getNumber(T number) {
		return number;
	}
	
	class Test {
		public static final int TEST = 5;
		private int privateInt = 10;
		
		Test(){}
		
		static void test() {
			
		}
		
		void test2() {
			
			t = 11;
			int t = TimerTest.this.t;
			y = 11;
			int k = T;
		}
	}
}
