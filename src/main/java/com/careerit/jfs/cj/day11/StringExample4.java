package com.careerit.jfs.cj.day11;

import java.time.LocalDate;

public class StringExample4 {

    public static void main(String[] args) {

        StringBuilder idData = new StringBuilder();
        LocalDate currentDate = LocalDate.now();
        for (int i = 1001; i <= 1100; i++) {
            idData.append("CI" + i + currentDate.getYear()).append(",");
        }
        String data = idData.substring(0, idData.length() - 1);
        System.out.println(data);
    }
}
