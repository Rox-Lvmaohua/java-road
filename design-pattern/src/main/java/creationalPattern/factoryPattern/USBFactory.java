package creationalPattern.factoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:31
 * @Description: 抽象工厂，用来创建USB接口的工厂
 */
public interface USBFactory {
    USBGoods getInstance();
}
