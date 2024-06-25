package jdk8.consumer;

import java.util.function.Consumer;

public class ConsumerLambda2 {
    public static void main(String[] args) {
        Consumer<User> driverUser = (user) -> {
            if (user.getAge() < 18) {
                System.out.println(user.getName() + ", You are not allowed to drive");
            } else {
                System.out.println(user.getName() + ", You are allowed to drive");
            }
        };

        driverUser.accept(new User("Tom", 20));
        driverUser.accept(new User("Jerry", 15));
    }
}
