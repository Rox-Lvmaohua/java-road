package creationalPattern.builderPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 8:51
 * @Description: 抽象构建者
 */
public abstract class MealBuilder {
    protected Meal meal = new Meal();

    public abstract void buildBurger();

    public abstract void buildFries();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
