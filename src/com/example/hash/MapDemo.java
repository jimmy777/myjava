package com.example.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, Map<String, String>> classes = new HashMap<>();

        Map<String, String> names = null;

        for (int i = 1; i <=10; i++) {
            names = new HashMap<>();
            classes.put(i, names);
            for (int j = 1; j < 20; j++) {
                names.put(i+","+j, "tom");
            }
        }

        for (Entry<Integer, Map<String, String>> entry:classes.entrySet()) {
            Integer key = entry.getKey();
            Map<String, String> value = entry.getValue();

            for (Entry<String, String> entry1:value.entrySet()
                 ) {
                String stuNo = entry1.getKey();
                String stuName = entry1.getValue();
                System.out.println(key + " ===> " + stuNo + " ===> " + stuName);
            }
        }

        for (Integer k:classes.keySet()
             ) {
            Map<String, String> map = classes.get(k);

            for (String stuNo :map.keySet()
                 ) {
                String stuName = map.get(stuNo);

                System.out.println(k + " ---> " + stuNo + " ---> " + stuName);
            }
        }
    }
}
