package com.other.temporal_adjuster;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextWorkingDay implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		Temporal nextWorkDay = null;
		if(isFriday(temporal)) {
			nextWorkDay = temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		} else {
			nextWorkDay = temporal.plus(1, ChronoUnit.DAYS);
		}
		return nextWorkDay;
	}
	
	private boolean isFriday(Temporal temporal) {
		return temporal.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.FRIDAY.getValue();
	}
}
