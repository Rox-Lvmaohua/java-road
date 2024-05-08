package org.capslv;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Map<String, String> hash = System.getenv();
        for (String key : hash.keySet()) {
            System.out.println(key + " : " + hash.get(key));
        }
    }
}