package ait.time.utils;/*
 * Copyright (c) 2023.
 * Igor Volotovskyi
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {
//    public static int getAge(String birthDate) {
//        long age = 0;
//        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;
//        if (birthDate.contains("/")) {
//            df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        }
//        if (birthDate.contains("-")) {
//            df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        }
//        String date = String.format(birthDate, df);
//        age = ChronoUnit.YEARS.between(LocalDate.parse(date, df), LocalDate.now());
//        return (int) age;
//    }

    public static int getAge(String birthDate) {
        LocalDate date = mapStringToLocalDate(birthDate);
        return (int) ChronoUnit.YEARS.between(date, LocalDate.now());
    }

    public static String[] sortStringDates(String[] dates) {
        String[] res = Arrays.copyOf(dates, dates.length);
        Arrays.sort(res, (d1, d2) -> mapStringToLocalDate(d1).compareTo(mapStringToLocalDate(d2)));
        return res;
    }
    private static LocalDate mapStringToLocalDate(String stringDate) {
        LocalDate res = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
//		if (stringDate.contains("-")) {
//			res = LocalDate.parse(stringDate, DateTimeFormatter.ISO_LOCAL_DATE);
//		} else {
//			res = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		}
        return res;
    }
}
