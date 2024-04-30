package structual.decorator;

import lombok.Data;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:17
 * @Description: 具体构件
 */
@Data
public class BlindMonk implements Hero{
    private String name;
    public BlindMonk(String name) {
        this.name = name;
    }
    @Override
    public void learnSkill() {
        System.out.println(getName());
    }
}
