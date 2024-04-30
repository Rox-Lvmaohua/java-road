package structual.decorator;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:25
 * @Description:
 */
public class EDecorator implements SkillDecorator{
    private Hero hero;
    private String name;

    public EDecorator(Hero hero, String name) {
        this.hero = hero;
        this.name = name;
    }

    private void learnE() {
        System.out.println("习得技能" + this.name);
    }

    @Override
    public void learnSkill() {
        hero.learnSkill();
        learnE();
    }
}
