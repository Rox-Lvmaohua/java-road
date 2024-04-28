package creationalPattern.abstractFactoryPattern;

import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 16:04
 * @Description:
 */
public class TestAbstractFactory {
    @Test
    public void testAbstractFactory() {
        ClientSeasoning client = new ClientSeasoning(new HaDayFactory());
        Soy soy = client.getSoy();
        OysterSauce oysterSauce = client.getOysterSauce();
        soy.displaySauce();
        oysterSauce.displayOysterSauce();
    }
}
