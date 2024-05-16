package jdk8.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        System.out.println("Supplier Test class");
        supplierTest(() -> {
            List<Integer> vars = Arrays.asList(1, 2, 3, 4, 5);
            Optional<Integer> res = vars.stream().reduce(Integer::max);
            return res.get();
        });
        System.out.println("Supplier Test class");
    }

    /**
     * 传入一个supplier接口，写入一个lambda表达式，然后通过 xxx.get() 方法获取返回值
     * @param supplier
     */
    private static void supplierTest(Supplier<Integer> supplier) {
        System.out.println(supplier.get());
    }
}
