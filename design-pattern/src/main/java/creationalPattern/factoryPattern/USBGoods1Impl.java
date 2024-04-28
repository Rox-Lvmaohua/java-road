package creationalPattern.factoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:29
 * @Description: 具体产品，实现USB产品1
 */
public class USBGoods1Impl extends USBGoods{
    @Override
    public void sendData() {
        System.out.println("USB 产品1 发生数据");
    }
}
