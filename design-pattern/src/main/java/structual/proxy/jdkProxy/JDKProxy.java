package structual.proxy.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 10:16
 * @Description:
 */
public class JDKProxy {
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成代理对象
     * @return 代理生成的对象
     */
    public Object getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("[JDK动态代理]交中介费");
                    method.invoke(target, args);
                    System.out.println("[JDK动态代理]中介负责维修管理");
                    return null;
                });
    }
}
