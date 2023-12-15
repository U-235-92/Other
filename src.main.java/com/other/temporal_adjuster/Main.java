package com.other.temporal_adjuster;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.of(2022, 12, 30);
		System.out.println("Today: " + currentDate);
		LocalDate nextWorkDay = currentDate.with(new NextWorkingDay());
		System.out.println("Next work date: " + nextWorkDay);
	}
}
