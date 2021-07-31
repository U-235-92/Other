package com.other.string;

public class RefString {

	public static void changeStr(String s)  {
		
		String ss = "aa";
		
		s += ss;
		
		String res = s + ss;
		
		s = res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("Test");
		changeStr(s);
		System.out.println(s);
	}

}
