package com.careerit.jfs.cj.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionExample2 {

    public static void main(String[] args) {
        System.out.println("Reading data from the file");
        FileReader fr = null;
        BufferedReader br = null;
        List<String> names = new ArrayList<>();
        try {
            String filePath = ExceptionExample2.class.getResource("/sample_data.txt").getPath();
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                names.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("File not found " + e);
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                System.out.println("While closing the resources " + e);
            }
        }
        System.out.println(names);
        System.out.println("End reading data from the file");
    }
}
