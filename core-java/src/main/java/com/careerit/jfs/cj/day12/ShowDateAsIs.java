package com.careerit.jfs.cj.day12;

public class ShowDateAsIs {


    public static void main(String[] args) {
        showDayMessage(DayName.FRIDAY);

    }

    public static void showDayMessage(DayName day) {

        switch (day) {
            case MONDAY -> System.out.println("Mondays are bad");
            case TUESDAY -> System.out.println("Tuesday is little ok");
            case WEDNESDAY -> System.out.println("Weekends are ok");
            case THURSDAY -> System.out.println("Thursday is better");
            case FRIDAY -> System.out.println("Friday is best");
            case SATURDAY -> System.out.println("Saturday is best");
            case SUNDAY -> System.out.println("Sunday is the best");
            default -> System.out.println("Invalid day");
        }

    }
}
