package util;


import net.datafaker.Faker;

import java.util.*;

public class DataGeneratorUtil {
    private static final Faker faker = new Faker();

    public static <K, V> Map<K, V> generateMap(int size) {
        Map<K, V> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put((K) faker.lorem().word(), (V) faker.lorem().sentence());
        }
        return map;
    }

    public static <T> Set<T> generateSet(int size) {
        Set<T> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add((T) faker.lorem().word());
        }
        return set;
    }

    public static <T> List<T> generateList(int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((T) faker.lorem().word());
        }
        return list;
    }
}
