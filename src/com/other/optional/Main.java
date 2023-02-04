package com.other.optional;

import java.util.Optional;
import java.util.Properties;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("a", "5");
		props.put("b", "true");
		props.put("c", "-3");
		System.out.println(readDuration(props, "d"));
	}
	
	private static int readDuration(Properties props, String name) {
		Function<String, Integer> func = num -> {
			try {
				return Integer.valueOf(num);
			} catch(NumberFormatException e) {
				return 0;
			}
		};
		return Optional.ofNullable((String)props.get(name)).map(func).filter(num -> num > 0).orElse(0);
	}
}
