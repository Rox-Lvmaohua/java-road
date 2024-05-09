package jdk8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        // Function<T, R> : 函数型接口, T为参数, R为返回值
        // R apply(T t);
        // Function<T, R> : 函数型接口, 可接受 方法引用, Lambda表达式
        // R apply(T t);

        Function<List<Integer>, List<Integer>> square = (list) -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * list.get(i));
            }
            return list;
        };
        System.out.println(square.apply(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
}
