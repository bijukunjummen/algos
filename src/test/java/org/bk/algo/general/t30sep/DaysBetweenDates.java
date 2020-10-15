package org.bk.algo.general.t30sep;

import java.time.LocalDate;
import java.time.Period;

class DaysBetweenDates {
    public int daysBetweenDates(String date1, String date2) {
        return Period.between(LocalDate.parse(date1), LocalDate.parse(date2)).getDays();
    }
}