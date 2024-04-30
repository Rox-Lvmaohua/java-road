package structual.facade;

import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 11:09
 * @Description:
 */
public class TestFacade {
    @Test
    public void testFacade() {
        TravelFacade travelFacade = new TravelFacadeImpl();
        travelFacade.depart();
        System.out.println("------------------------出发------------------------");
    }
}
