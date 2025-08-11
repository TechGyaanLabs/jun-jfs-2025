package com.careerit.jfs.cj.exception;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryWithResourceHanding {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader(TryWithResourceHanding.class.getResource("/sampledata.txt").getPath());
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
