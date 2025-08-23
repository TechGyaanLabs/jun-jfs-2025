package com.careerit.jfs.cj.day29;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringSubstitutor {

    public static void main(String[] args) {

        String body = """
                Dear {{name}},
                    Invoice number {{invoiceNumber}}, invoice date {{invoiceDate}} 
                    and total amount {{totalAmount}}.
                    
                    Please pay on or before {{dueDate}}
                    
                    Regards,
                    {{companyName}}
                """;

        List<Map<String,Object>> invoiceMap  = List.of(
                Map.of("name","Krish","invoiceNumber",
                        1001,"invoiceDate","2023-06-01",
                        "totalAmount",45000.0,"dueDate",
                        "2023-06-30","companyName",
                        "ABC Company"),
                Map.of("name","Manoj","invoiceNumber",
                        1002,"invoiceDate","2023-06-02",
                        "totalAmount",50000.0,"dueDate",
                        "2023-06-30","companyName",
                        "ABC Company"),
                Map.of("name","Praveen","invoiceNumber",
                        1003,"invoiceDate","2023-06-03",
                        "totalAmount",55000.0,"dueDate",
                        "2023-06-30","companyName",
                        "ABC Company"));
        List<String> tokens = extractTokens(body);
        for(Map<String,Object> map : invoiceMap) {

               String message = body;
               for(String token : tokens) {
                   message = message.replace("{{"+token+"}}",map.get(token).toString());
               }
               System.out.println(message);
               System.out.println("-".repeat(100));
        }
    }
    public static List<String> extractTokens(String message) {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{\\{(\\w+)\\}\\}");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            tokens.add(matcher.group(1)); // group(1) captures the token inside {{ }}
        }
        return tokens;
    }
}
