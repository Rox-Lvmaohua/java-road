package creationalPattern.abstractFactoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:59
 * @Description:(具体产品)：海天耗油
 */
public class HaDayOysterSauce implements OysterSauce{
    @Override
    public void displayOysterSauce() {
        System.out.println("海天耗油");
    }
}
