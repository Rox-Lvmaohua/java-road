package structual.proxy.staticProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:51
 * @Description: 中介
 */
public class ProxyImpl implements Landlord1Service{
    /**
     * 多套房子出租
     */
    private Landlord1Service target;
    public ProxyImpl(Landlord1Service target) {
        this.target = target;
    }

    // 缺点：原有接口增加方法，实现类也需要实现新的方法
    @Override
    public void rent(Integer money) {
        System.out.println("[静态代理]交中介费");
        target.rent(money);
        System.out.println("[静态代理]中介负责维修管理");
    }
}
