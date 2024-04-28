package creationalPattern.singleton;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 14:48
 * @Description: 线程安全的懒汉式单例
 */
public class LazySafeSingleton {
    private static LazySafeSingleton instance;
    private LazySafeSingleton() {

    }
    //由于对getInstance方法加了synchronized同步锁，导致并发量很低
    public static synchronized LazySafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazySafeSingleton();
        }
        return instance;
    }
}
