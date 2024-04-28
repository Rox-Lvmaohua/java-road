package creationalPattern.factoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:32
 * @Description: 具体工厂；具体实现 USBFactory，完成Type-A类型USB产品的实现，专门用来生产Type-A对象。
 */
public class TypeAFactoryImpl implements USBFactory {
    @Override
    public USBGoods getInstance() {
        return new USBGoods1Impl();
    }
}
