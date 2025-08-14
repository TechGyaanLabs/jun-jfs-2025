package HomeWork;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String,String> map = new HashMap<>();
    public void addDetails(String phoneno , String name) {
        map.put(phoneno, name);
        System.out.println("Entry added : " +phoneno+ "->" +name);
    }

    public String getName(String phoneno) {
        if (map.containsKey(phoneno)) {
            return map.get(phoneno);

        }else {
            return "sorry! no person found with given number ";
        }
    }

}
