package jdk8.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambda {
    public static void main(String[] args) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        Consumer<Integer> consumer = (i) -> {
            if (i % 2 == 0) {
                evenList.add(i);
            } else {
                oddList.add(i);
            }
        };

        Consumer<List<Integer>> printConsumer = (list) -> {
            list.forEach(System.out::println);
        };

        consumer.accept(10);
        consumer.accept(5);
        consumer.accept(3);
        consumer.accept(8);
        consumer.accept(12);
        consumer.accept(6);

        System.out.println("----------------Odd List----------------");
        printConsumer.accept(oddList);
        System.out.println("----------------Even List----------------");
        printConsumer.accept(evenList);
    }
}
