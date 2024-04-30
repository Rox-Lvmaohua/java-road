package structual.decorator;

import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:28
 * @Description:
 */
public class TestDecorator {

    @Test
    public void testDecorator() {
        QDecorator q = new QDecorator(new BlindMonk("李青"), "Q: 天音波/回音击");
        WDecorator w = new WDecorator(q, "W: 金钟罩/铁布衫");
        EDecorator e = new EDecorator(w, "E: 天雷波/崔筋断骨");
        RDecorator r = new RDecorator(e, "R: 猛龙摆尾");
        r.learnSkill();
    }
}
