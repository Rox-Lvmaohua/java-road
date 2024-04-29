package creationalPattern.builderPattern;

import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 9:01
 * @Description:
 */
public class TestBuilder {

    @Test
    public void testBuilder() {
        // 创建指导者
        MealDirector director = new MealDirector();

        // 指导者创建牛肉套餐
        director.setMealBuilder(new BeefBurgerMealBuilder());
        director.createMeal();
        Meal meal = director.getMeal();
        System.out.println("牛肉套餐：" + meal.toString());

        // 指导者创建鸡肉套餐
        director.setMealBuilder(new ChickenMealBuilder());
        director.createMeal();
        meal = director.getMeal();
        System.out.println("鸡肉套餐：" + meal.toString());

        // 指导者创建虾肉套餐
        director.setMealBuilder(new ShrimpMealBuilder());
        director.createMeal();
        meal = director.getMeal();
        System.out.println("虾肉套餐：" + meal.toString());
    }
}
