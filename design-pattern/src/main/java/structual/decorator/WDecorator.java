package structual.decorator;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:23
 * @Description:
 */
public class WDecorator implements SkillDecorator{
    private Hero hero;
    private String name;

    public WDecorator(Hero hero, String name) {
        this.hero = hero;
        this.name = name;
    }

    private void learnW() {
        System.out.println("习得技能" + this.name);
    }

    @Override
    public void learnSkill() {
        hero.learnSkill();
        learnW();
    }
}
