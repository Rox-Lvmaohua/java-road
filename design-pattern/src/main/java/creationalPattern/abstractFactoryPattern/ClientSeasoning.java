package creationalPattern.abstractFactoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 16:10
 * @Description:
 */
public class ClientSeasoning {
    SeasoningFactory seasoningFactory;
    public ClientSeasoning(SeasoningFactory seasoningFactory){
        this.seasoningFactory = seasoningFactory;
    }

    public Soy getSoy() {
        return this.seasoningFactory.createSoy();
    }

    public OysterSauce getOysterSauce() {
        return this.seasoningFactory.createOysterSauce();
    }
}
