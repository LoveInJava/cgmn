package com.pre.utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WorkingDaysRange {
    static List<LocalDate> listHolidays = null;
    static List<LocalDate> listCurrentLeaves = null;
    static List<LocalDate> listNextLeaves = null;
    final static int MANDATORY_DAYS = 12;

    public static void main(String[] args) {
        // Given: Current month starting from 1st Oct 2025

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Date in format(dd-mm-yyyy) : ");
        String fromDate = scanner.next();
        scanner.nextLine();

        DateTimeFormatter holidayFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

        System.out.println("Date of Leaves in current Month separated by ',' : ");
        String currentMonthLeaves = scanner.nextLine(); // Use nextLine to read full line
        String[] currentMonthAllLeaves = currentMonthLeaves.split(",");
        listCurrentLeaves = Arrays.stream(currentMonthAllLeaves)
                .filter(str -> !str.isEmpty())
                .map(str -> LocalDate.parse(str.trim(), holidayFormatter))
                .toList();


        System.out.println("Date for Holidays in both Month separated by ',' : ");
        String monthHolidays = scanner.nextLine(); // Use nextLine to read full line
        String[] holidays = monthHolidays.split(",");
        listHolidays = Arrays.stream(holidays)
                .filter(str -> !str.isEmpty())
                .map(str -> LocalDate.parse(str.trim(), holidayFormatter))
                .toList();


        System.out.println("Date of Leaves in Next Month separated by ',' : ");
        String nextMonthLeaves = scanner.nextLine(); // Use nextLine to read full line
        String[] nextMonthAllLeaves = nextMonthLeaves.split(",");
        listNextLeaves = Arrays.stream(nextMonthAllLeaves)
                .filter(str -> !str.isEmpty())
                .map(str -> LocalDate.parse(str.trim(), holidayFormatter))
                .toList();

        DateTimeFormatter inputDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);

        LocalDate startDate = LocalDate.parse(fromDate, inputDateFormatter);
        // Format date
        String formattedDate = startDate.format(formatter);

        //First day of Next Month
        LocalDate nextMonthDate = startDate.plusMonths(1);
        String nextMonth = nextMonthDate.format(monthFormatter);


        // Step 1: Find the 12th working day from start (Oct 1)
        LocalDate twelfthFromStart = addWorkingDays(startDate, MANDATORY_DAYS);

        // Step 2: Find last day of next month (Nov)
        LocalDate lastDayNextMonth = startDate
                .plusMonths(1)
                .withDayOfMonth(startDate.plusMonths(1).lengthOfMonth());

        // Step 3: Find 12th working day before last day of next month
        LocalDate twelfthFromEnd = subtractWorkingDays(lastDayNextMonth, MANDATORY_DAYS);

        // Print results
        System.out.println("Start Date '" + formattedDate + "' : " + startDate);
        System.out.println("12th working day from start: " + twelfthFromStart);
        System.out.println("Last day of next month '"+ nextMonth+"' : " + lastDayNextMonth);
        System.out.println("12th working day for '"+nextMonth+"' from end: " + twelfthFromEnd);
    }

    // ✅ Utility: add working days (Mon–Fri)
    public static LocalDate addWorkingDays(LocalDate date, int days) {
        LocalDate result = date;
        int added = 0;
        boolean firstIteration = true;
        while (added < days) {

            if (!firstIteration) {
                result = result.plusDays(1);
            }
            if (isWorkingDay(result, "CURRENT")) {
                added++;
            }
            firstIteration = false;
        }
        return result;
    }

    // ✅ Utility: subtract working days (Mon–Fri)
    public static LocalDate subtractWorkingDays(LocalDate date, int days) {
        LocalDate result = date;
        int subtracted = 0;
        boolean firstIteration = true;

        while (subtracted < days) {

            if (!firstIteration) {
                result = result.minusDays(1);
            }
            if (isWorkingDay(result, "NEXT")) {
                subtracted++;
            }
            firstIteration = false;
        }

        return result;
    }

    // ✅ Helper: working days = Mon–Fri
    private static boolean isWorkingDay(LocalDate date, String comeFrom) {
        DayOfWeek day = date.getDayOfWeek();
        boolean isCurrentMonthApplyLeave = listCurrentLeaves.stream().anyMatch(date1 -> date1.isEqual(date));
        if(isCurrentMonthApplyLeave && "CURRENT".equals(comeFrom)){
            return false;
        }

        boolean isNextMonthApplyLeave = listNextLeaves.stream().anyMatch(date1 -> date1.isEqual(date));
        if(isNextMonthApplyLeave&& "NEXT".equals(comeFrom)){
            return false;
        }
        boolean isHoliday = listHolidays.stream().anyMatch(date1 -> date1.isEqual(date));
        return day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY && !isHoliday;
    }
}
