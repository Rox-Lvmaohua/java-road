package jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * @Author : 吕茂华
 * @Date: 2024/5/17 上午11:04
 * @Description:
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 通过stream过滤空字符串
        // 通过stream生成流
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        System.out.println(strings);

        // 打印10个随机数字
        // Stream 提供了新的方法 ‘forEach’ 来迭代流中的每个数据。
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // map 方法用于映射每个元素到对应的结果
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        // filter 方法用于通过设置的条件过滤出元素。
        // 获取空字符串的数量
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println(count);

        // limit 方法用于获取指定数量的流。
        // sorted 方法用于对流进行排序
        random.ints().limit(10).sorted().forEach(System.out::println);

        // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }
}
