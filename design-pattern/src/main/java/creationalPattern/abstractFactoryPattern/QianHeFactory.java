package creationalPattern.abstractFactoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 16:03
 * @Description:(具体工厂)：千禾工厂
 */
public class QianHeFactory implements SeasoningFactory {
    @Override
    public Soy createSoy() {
        return new QianHeSoys();
    }

    @Override
    public OysterSauce createOysterSauce() {
        return new QianHeOysterSauce();
    }
}
