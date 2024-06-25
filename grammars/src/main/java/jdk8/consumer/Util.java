package jdk8.consumer;

import java.util.Map;

public class Util {
    static void updateData(Map<String, String> hash) {
        hash.replaceAll((k, v) -> v + "1");
    }

    static void printData(Map<String, String> hash) {
        hash.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
