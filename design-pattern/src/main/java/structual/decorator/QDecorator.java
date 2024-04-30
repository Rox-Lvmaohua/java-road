package structual.decorator;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:21
 * @Description: 具体装饰器
 */
public class QDecorator implements SkillDecorator {
    private Hero hero;

    private String name;

    public QDecorator(Hero hero, String name) {
        this.name = name;
        this.hero = hero;
    }

    private void learnQ() {
        System.out.println("习得技能" + this.name);
    }

    @Override
    public void learnSkill() {
        hero.learnSkill();
        learnQ();
    }
}
