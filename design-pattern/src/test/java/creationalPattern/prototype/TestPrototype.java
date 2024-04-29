package creationalPattern.prototype;

import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 10:45
 * @Description:
 */
public class TestPrototype {
    @Test
    public void testPrototype() {
        HeroSkill heroSkill = new HeroSkill("瞎子", "踢");
        StealManFactory stealManFactory = new StealManFactory(heroSkill);

        // 复制的对象
        HeroSkill newHeroSkill = stealManFactory.cloneHeroSkill();
        newHeroSkill.show();
        System.out.println("============原角色技能============");
        heroSkill.show();
    }
}
