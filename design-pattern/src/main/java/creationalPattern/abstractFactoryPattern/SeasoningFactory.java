package creationalPattern.abstractFactoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 16:01
 * @Description:(抽象工厂)：调味品工厂
 */
public interface SeasoningFactory {
    Soy createSoy();
    OysterSauce createOysterSauce();
}
