package jdk8.lambda;

/**
 * @Author : 吕茂华
 * @Date: 2024/5/16 下午2:32
 * @Description:
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        Drinkable drinkable = () -> {
            System.out.println("喝水");
        };
//        Drinkable drinkable = new Drinkable() {
//            @Override
//            public void drink() {
//                System.out.println("喝水");
//            }
//        };

        drinkable.drink();
    }

    interface Drinkable {
        void drink();
    }
}
