package jdk8.lambda;

/**
 * @Author : 吕茂华
 * @Date: 2024/5/16 下午2:35
 * @Description:
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        Eatable eatable = (food) -> {
            System.out.println("吃" + food);
            return "吃" + food;
        };
        System.out.println(eatable.eat("牛肉"));
    }

    interface Eatable {
        String eat(String food);
    }
}
