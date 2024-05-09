package jdk8.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAndThen {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Consumer<List<Integer>> squareNum = (it) -> {
            for (int i = 0; i < it.size(); i++) {
                it.set(i, it.get(i) * it.get(i));
            }
        };
        Consumer<List<Integer>> printNum = (list) -> {
            list.forEach(System.out::println);
        };

        squareNum.andThen(printNum).accept(num);
    }
}
