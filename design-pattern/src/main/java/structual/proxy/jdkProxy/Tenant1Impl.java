package structual.proxy.jdkProxy;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 10:15
 * @Description:
 */
public class Tenant1Impl implements Landlord2Service{
    @Override
    public void rent(Integer money) {
        System.out.println("tenant1租下" + money + "元房子");
    }
}
