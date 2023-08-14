package com.other.date_and_time;

import java.time.LocalDate;

public class HowDoesItWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		LocalDate with = ld.withDayOfYear(10);
		System.out.println(with);
	}

}
