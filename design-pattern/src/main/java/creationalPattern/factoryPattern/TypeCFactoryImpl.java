package creationalPattern.factoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:33
 * @Description: 具体工程；具体实现 USBFactory，完成Type-C类型USB产品的实现，专门用来生产Type-C对象。
 */
public class TypeCFactoryImpl implements USBFactory {
    @Override
    public USBGoods getInstance() {
        return new USBGoods2Impl();
    }
}
