package creationalPattern.singleton;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:01
 * @Description:  在静态内部类中创建单例，在装载内部类的时候，才会创建单例对象
 */
public class LazyStaticInnerClass {
    private static class SingleTonHandler {
        private static LazyStaticInnerClass instance = new LazyStaticInnerClass();
    }
    private LazyStaticInnerClass() {

    }

    public static LazyStaticInnerClass getInstance() {
        return SingleTonHandler.instance;
    }
}
