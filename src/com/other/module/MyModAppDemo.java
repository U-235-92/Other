package com.other.module;

public class MyModAppDemo {

	public static void main(String[] args) {
		
		if(SimpleMathFuncs.isFactor(2, 10)) {
			
			System.out.println("2 - ��������� 10");
		}
		
		System.out.println("���������� ����� ��������� 35 � 105 - " + SimpleMathFuncs.lcf(35, 105));
		System.out.println("���������� ����� ��������� 35 � 105 - " + SimpleMathFuncs.gcf(35, 105));
	}

}
