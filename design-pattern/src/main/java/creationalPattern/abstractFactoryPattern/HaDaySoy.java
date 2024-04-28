package creationalPattern.abstractFactoryPattern;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:58
 * @Description:(具体产品)：海天酱油
 */
public class HaDaySoy implements Soy {
    @Override
    public void displaySauce() {
        System.out.println("海天酱油");
    }
}
