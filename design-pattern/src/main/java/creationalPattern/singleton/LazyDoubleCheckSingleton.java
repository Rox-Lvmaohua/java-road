package creationalPattern.singleton;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 14:55
 * @Description:
 */
public class LazyDoubleCheckSingleton {
    private static volatile LazyDoubleCheckSingleton instance;  // 通过volatile保证可见性，同时禁止JVM重排序
    private LazyDoubleCheckSingleton() {

    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) { // 再次校验以避免其他线程已创建，但当前线程不知道
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
