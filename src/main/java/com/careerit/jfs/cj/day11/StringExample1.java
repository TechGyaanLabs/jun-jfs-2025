package com.careerit.jfs.cj.day11;

public class StringExample1 {

    public static void main(String[] args) {

        String data = "Krish-Bangalore-iPhone16 Pro Max,Manoj-Bangalore-iPhone16 Pro,Praveen-Chennai-iPhone15, Ramesh-Mumbai-iPhone14";

        /*
        Hi {Krish}
           Your order is placed for "{iPhone16 Pro Max}" and it will be delivered to "{Bangalore}".
        */

        String[] arr = data.split(",");
        String[] messageArr = new String[arr.length];
        int index = 0;
        for(String str : arr) {
            String[] details = str.split("-");
            String message = """
                    Hi %s,
                    	Your order is placed for "%s" and it will be delivered to "%s".
                    """.formatted(details[0], details[2], details[1]);
            messageArr[index++] = message;
        }

        for (String message : messageArr) {
            System.out.println(message);
            System.out.println("-".repeat(100));
        }
    }
}
