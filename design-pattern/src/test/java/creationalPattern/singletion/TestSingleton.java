package creationalPattern.singletion;

import creationalPattern.singleton.*;
import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 14:33
 * @Description:
 */

public class TestSingleton {
    @Test
    public void testHungry() {
        System.out.println("==========饥饿单例==========");
        HungrySingleton instance1 = HungrySingleton.getHungrySingleton();
        HungrySingleton instance2 = HungrySingleton.getHungrySingleton();
        HungrySingleton instance3 = HungrySingleton.getHungrySingleton();
        System.out.println(instance1 == instance2);
        System.out.println(instance3 == instance2);
        System.out.println(instance1 == instance3);
    }

    @Test
    public void testLazy() {
        System.out.println("==========测试懒汉单例==========");
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "------>" + LazySingleton.getLazySingleton());
            }).start();
        }
    }

    @Test
    public void testLazySafe() {
        System.out.println("==========测试安全版懒汉单例==========");
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "------>" + LazySafeSingleton.getInstance());
            }).start();
        }
    }

    @Test
    public void testLazyDoubleCheck() {
        System.out.println("==========测试双重验证懒汉单例==========");
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "------>" + LazyDoubleCheckSingleton.getInstance());
            }).start();
        }
    }

    @Test
    public void testLazyStaticInnerClass() {
        System.out.println("==========测试静态内部类单例==========");
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "------>" + LazyStaticInnerClass.getInstance());
            }).start();
        }
    }


}
