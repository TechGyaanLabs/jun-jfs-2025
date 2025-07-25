package com.careerit.jfs.cj.day28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample2 {

    public static void main(String[] args) {

        String data = "John-CS-55000,Charan-CS-55000,Naidu-IS-45000,Ramesh-EC-35000,Krishna-IS-55000,Manoj-CS-55000,Praveen-CS-55000,Jagan-CS-55000,Pavan-CS-55000";
        Map<String, List<String>> deptAndEmpMap = new HashMap<>();

        String[] arr = data.split(",");

        for (String str : arr) {
            String[] empData = str.split("-");
            String name = empData[0];
            String dept = empData[1];
            deptAndEmpMap.computeIfAbsent(dept, k -> new ArrayList<>()).add(name);
        }
        System.out.println(deptAndEmpMap);

    }
}
