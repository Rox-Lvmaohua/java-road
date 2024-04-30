package structual.proxy.staticProxy;

import org.springframework.stereotype.Component;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:50
 * @Description: 租客
 */

public class TenantImpl implements Landlord1Service{
    @Override
    public void rent(Integer money) {
        System.out.println("租下" + money + "元房子");
    }
}
