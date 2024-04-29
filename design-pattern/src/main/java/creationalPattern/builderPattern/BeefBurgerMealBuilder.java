package creationalPattern.builderPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 8:56
 * @Description: 具体构建者
 */
public class BeefBurgerMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("牛肉汉堡");
    }

    @Override
    public void buildFries() {
        meal.setFries("大份薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("中杯可乐");
    }
}
