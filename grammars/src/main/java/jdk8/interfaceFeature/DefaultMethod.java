package jdk8.interfaceFeature;

/**
 * @Author : 吕茂华
 * @Date: 2024/5/16 下午3:18
 * @Description:
 */
public class DefaultMethod {
    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();
        a1.test3();
        a2.test3();
    }

    interface A {
        void test0();
        void test1();
        public default void test3() {
            System.out.println("默认方法");
        }
    }

    private static class B implements A {
        @Override
        public void test0() {

        }

        @Override
        public void test1() {

        }
    }

    private static class C implements A {
        @Override
        public void test0() {

        }

        @Override
        public void test1() {

        }

        @Override
        public void test3() {
            System.out.println("默认方法修改");
        }
    }
}
