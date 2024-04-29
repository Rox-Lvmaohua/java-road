package creationalPattern.builderPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 8:57
 * @Description: 具体构造者
 */
public class ShrimpMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("虾肉汉堡");
    }

    @Override
    public void buildFries() {
        meal.setFries("小份薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("大份芬达");
    }
}
