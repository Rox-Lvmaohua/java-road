package creationalPattern.singleton;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 14:31
 * @Description: 不支持延迟加载，获取实例对象的速度比较快，但是如果对象比较大，而且一直没使用会造成内存的浪费。
 */
public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}
