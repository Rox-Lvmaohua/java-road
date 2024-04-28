package creationalPattern.factoryPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:34
 * @Description: 专供对外使用的工厂容器。
 */
public class USBGoodsFactoryMap {
    private static Map<Integer, USBFactory> caches = new HashMap<>();
    static {
        caches.put(1, new TypeAFactoryImpl());
        caches.put(2, new TypeCFactoryImpl());
    }

    public static USBFactory getInstance(Integer key) {
        return caches.get(key);
    }
}
