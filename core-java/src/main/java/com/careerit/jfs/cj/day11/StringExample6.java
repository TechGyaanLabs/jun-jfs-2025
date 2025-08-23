package com.careerit.jfs.cj.day11;

public class StringExample6 {

    public static void main(String[] args) {

        // String : Immutable
        // StringBuffer, StringBuilder : Mutable
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");

        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("<html>").
                append("\n").
                append("<body>").
                append("\n").
                append("    <h1>Heading</h1>").
                append("\n").
                append("    <p>Paragraph</p>").
                append("\n").
                append("</body>").
                append("\n").
                append("</html>");
        System.out.println(sb3);

    }
}
