package creationalPattern.prototype;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 10:39
 * @Description: 具体原型类
 */
public class HeroSkill implements Cloneable{
    private String name;
    private String bigMove;
    public HeroSkill() {

    }

    public HeroSkill(String name, String bigMove) {
        this.name = name;
        this.bigMove = bigMove;
    }

    @Override
    protected HeroSkill clone() {
        HeroSkill clone = null;
        try {
            clone = (HeroSkill) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("偷取" + name + "技能: " + bigMove);
        return clone;
    }

    public void show() {
        System.out.println(name + "的技能：" + bigMove);
    }
}
