package jdk8.lambda;

import java.util.function.Consumer;

/**
 * @Author : 吕茂华
 * @Date: 2024/5/16 下午2:27
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行");
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + "执行"), "匿名线程").start();


        // 形式一
        getShow(() -> {
            System.out.println("用户接口的无参无返回值方法");
        });

        // 形式二
        getShow(() -> System.out.println("用户接口的无参无返回方法实现形式二"));

        // 无参有返回值形式一
        getName(() -> {
            return "无参有返回值实现形式一";
        });
        getName(() -> "无参有返回值实现形式二");

        // 有参无返回值
        getConsumer(s -> System.out.println(s));
    }

    public static void getShow(User user) {
        user.show();
    }

    public static void getName(Person person) {
        String name = person.getName();
        System.out.println(name);
    }

    public static void getConsumer(Consumer<String> consumer) {
        consumer.accept("有参无返回值方法");
    }
}
