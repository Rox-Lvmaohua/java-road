package creationalPattern.builderPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 8:59
 * @Description: 指导者
 */
public class MealDirector {
    private MealBuilder mealBuilder;
    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }
    public Meal getMeal() {
        return mealBuilder.getMeal();
    }

    public void createMeal() {
        mealBuilder.buildBurger();
        mealBuilder.buildFries();
        mealBuilder.buildDrink();
    }
}
