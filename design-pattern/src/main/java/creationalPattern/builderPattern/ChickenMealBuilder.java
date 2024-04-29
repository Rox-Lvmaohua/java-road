package creationalPattern.builderPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 8:53
 * @Description: 具体构建者
 */
public class ChickenMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("坤肉汉堡");
    }

    @Override
    public void buildFries() {
        meal.setFries("中份薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("大杯果汁");
    }
}
