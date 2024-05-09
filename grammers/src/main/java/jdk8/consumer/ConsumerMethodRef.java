package jdk8.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerMethodRef {
    public static void main(String[] args) {
        Map<String, String> person = new HashMap<>();
        person.put("name", "Tom");
        person.put("age", "20");

        Consumer<Map<String, String>> updateData = Util::updateData;
        Consumer<Map<String, String>> printData = Util::printData;
        updateData.accept(person);
        printData.accept(person);
    }
}
