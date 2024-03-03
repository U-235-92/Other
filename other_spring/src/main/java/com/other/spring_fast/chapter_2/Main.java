package com.other.spring_fast.chapter_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		/* chapter_2 part 2.2.1
		 * AnnotationConfigApplicationContext context = new
		 * AnnotationConfigApplicationContext(ProjectConfig.class); Parrot p =
		 * context.getBean("kesha", Parrot.class); System.out.println(p.getName());
		 * String s = context.getBean(String.class); System.out.println(s); Integer n =
		 * context.getBean(Integer.class); System.out.println(n);
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Parrot p1 = context.getBean(Parrot.class);
		System.out.println(p1.getName());
		Parrot p2 = context.getBean(Parrot.class);
		System.out.println(p2.getName());
	}
}
