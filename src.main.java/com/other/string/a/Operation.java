package com.other.string.a;

import java.util.regex.*;

public class Operation {

	/**
	 * Задание 1, вариант А
	 * 
	 * В каждом слове текста k-ю букву заменть заданным символом. Если k больше длины слова, корректировку не выполнять.
	 */
	public static void task1(String text, int k, char c) {
		
		String[] words = text.split("\\s");
		String result =  "";
		
		for(int i = 0; i < words.length; i++) {
				
			if(k < words[i].length()) {
				
				char[] chrs = words[i].toCharArray();
				chrs[k] = c;
				words[i] = String.valueOf(chrs);
				result += words[i] + " ";
			} else {
				
				result += words[i] + " ";
			}
		}
		
		System.out.println(result);
	}
	
	/**
	 * Задание 7, вариант А
	 * 
	 * Из текста удалить все символы, кроме пробелов, не являющиеся буквами. Между последовательностями
	 * подряд идущих букв оставить хотя бы один пробел.
	 */
	public static void task2(String text) {
		
		String result = "";
		Pattern pattern = Pattern.compile("\\p{Punct}+");
		String[] words = text.split(pattern.pattern());
		for(String word : words) {
			
			char[] chrs = word.toCharArray();
			char  ch = chrs[0];
			for(int i = 1; i < chrs.length; i++) {
				
				if(chrs[i] == ch) {
					
					String bef = word.substring(0, i);
					String aft = word.substring(i);
					word = bef + " " + aft;
				} else {
					
					ch = chrs[i];
				}
			}
			
			result += word;
		}
		
		System.out.println(result);
	}
}
