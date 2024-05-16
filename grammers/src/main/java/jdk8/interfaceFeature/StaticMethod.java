package jdk8.interfaceFeature;

/**
 * @Author : 吕茂华
 * @Date: 2024/5/16 下午3:23
 * @Description:
 */
public class StaticMethod {
    public static void main(String[] args) {
        A.test3();
        A a1 = new B();
        A a2 = new C();
        a1.test1();
        a2.test1();
    }

    interface A {
        void test0();
        public default void test1() {
            System.out.println("接口中的默认方法");
        }
        public static void test3() {
            System.out.println("接口中的静态方法");
        }
    }

    private static class B implements A {
        @Override
        public void test0() {

        }

        @Override
        public void test1() {
            System.out.println("类B中的默认方法");
        }
    }

    private static class C implements A {
        @Override
        public void test0() {

        }
    }
}
