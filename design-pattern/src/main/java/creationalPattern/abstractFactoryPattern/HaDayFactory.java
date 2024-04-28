package creationalPattern.abstractFactoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 16:02
 * @Description:(具体工厂)：海天工厂
 */
public class HaDayFactory implements SeasoningFactory{
    @Override
    public Soy createSoy() {
        return new HaDaySoy();
    }

    @Override
    public OysterSauce createOysterSauce() {
        return new HaDayOysterSauce();
    }
}
