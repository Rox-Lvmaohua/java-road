package creationalPattern.factoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:30
 * @Description: 具体产品，实现USB产品2
 */
public class USBGoods2Impl extends USBGoods {
    @Override
    public void sendData() {
        System.out.println("USB 产品 2 发送数据");
    }
}
