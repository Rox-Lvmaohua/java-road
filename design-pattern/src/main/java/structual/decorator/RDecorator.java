package structual.decorator;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:26
 * @Description: 具体装饰器
 */
public class RDecorator implements SkillDecorator{
    private Hero hero;
    private String name;

    public RDecorator(Hero hero, String name) {
        this.hero = hero;
        this.name = name;
    }

    private void learnR() {
        System.out.println("习得技能" + this.name);
    }

    @Override
    public void learnSkill() {
        hero.learnSkill();
        learnR();
    }
}
