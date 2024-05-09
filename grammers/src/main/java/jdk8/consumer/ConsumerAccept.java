package jdk8.consumer;

import java.util.function.Consumer;

public class ConsumerAccept {
    public static void main(String[] args) {
        // Consumer<T> : 消费型接口
        // void accept(T t);
        Consumer<String> consumer = (s) -> System.out.println(s);

        consumer.accept("Hello World");
        consumer.accept("Hello Java");

        // Consumer<T> : 消费型接口, 方法引用
        // void accept(T t);
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hello World");
        consumer2.accept("Hello Java");
    }
}
