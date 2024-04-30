package structual.proxy;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import structual.proxy.cglibProxy.CglibProxy;
import structual.proxy.cglibProxy.Landlord3Service;
import structual.proxy.jdkProxy.JDKProxy;
import structual.proxy.jdkProxy.Landlord2Service;
import structual.proxy.jdkProxy.Tenant1Impl;
import structual.proxy.jdkProxy.Tenant2Impl;
import structual.proxy.staticProxy.ProxyImpl;
import structual.proxy.staticProxy.TenantImpl;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 9:57
 * @Description:
 */


public class TestProxy {

    private static final Logger log = LoggerFactory.getLogger(TestProxy.class);
    private TenantImpl tenant = new TenantImpl();

    private ProxyImpl proxy = new ProxyImpl(tenant);

    @Test
    public void testStaticProxy() {
        tenant.rent(1200);
        System.out.println();
        proxy.rent(1800);
    }


    Tenant1Impl tenant1 = new Tenant1Impl();
    Tenant2Impl tenant2 = new Tenant2Impl();

    @Test
    public void testJDKProxy() {
        Landlord2Service proxyInstance1 = (Landlord2Service) new JDKProxy(tenant1).getInstance();
        proxyInstance1.rent(1200);
        System.out.println();
        Landlord2Service proxyInstance2 = (Landlord2Service) new JDKProxy(tenant2).getInstance();
        proxyInstance2.rent(1400);
    }

    private Landlord3Service landlord3Service = new Landlord3Service();

    @Test
    public void TestCglibProxy() {
        Landlord3Service proxyInstance = (Landlord3Service) new CglibProxy(landlord3Service).getProxyInstance();
        proxyInstance.rent(2000);
    }
}
