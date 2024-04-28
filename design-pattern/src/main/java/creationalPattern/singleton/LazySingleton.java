package creationalPattern.singleton;


/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 14:24
 * @Description: 支持懒加载，只有调用 getInstance的时候才会创建对象。线程不安全
 */
public class LazySingleton {
    // 1、在类中创建私有静态的全局对象
    private static LazySingleton lazySingleton;

    private LazySingleton() {

    }
    // 3、提供一个全局访问点，供外部获取对象
    public static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            // 有可能还没实例化时就有多个线程走到这行注释这边
            // 一个实例化了之后，还有其他几个线程继续实例化，就会产生多实例
            lazySingleton = new LazySingleton();    // 多线程会创建多个实例，造成instance不唯一
        }
        return lazySingleton;
    }
}
