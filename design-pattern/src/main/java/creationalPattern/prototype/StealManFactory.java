package creationalPattern.prototype;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 10:42
 * @Description: 工厂类，用于客户端中复制对象
 */
public class StealManFactory {
    private HeroSkill heroSkill;

    public StealManFactory(HeroSkill heroSkill) {
        this.heroSkill = heroSkill;
    }

    public StealManFactory() {

    }

    public void setHeroSkill(HeroSkill heroSkill) {
        this.heroSkill = heroSkill;
    }

    public HeroSkill cloneHeroSkill() {
        return heroSkill.clone();
    }
}
