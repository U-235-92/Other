package com.other.spring_fast_chapter_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Parrot p = context.getBean("kesha", Parrot.class);
		System.out.println(p.getName());
		String s = context.getBean(String.class);
		System.out.println(s);
		Integer n = context.getBean(Integer.class);
		System.out.println(n);
	}
}
