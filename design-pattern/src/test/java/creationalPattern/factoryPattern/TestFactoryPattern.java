package creationalPattern.factoryPattern;

import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:36
 * @Description:
 */
public class TestFactoryPattern {
    @Test
    public void testFactory() {
        USBFactory usbFactory = USBGoodsFactoryMap.getInstance(2);
        USBGoods usbGoods = usbFactory.getInstance();
        usbGoods.sendData();
    }
}
