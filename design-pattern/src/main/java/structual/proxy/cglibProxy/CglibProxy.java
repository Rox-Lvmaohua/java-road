package structual.proxy.cglibProxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 10:25
 * @Description:
 */
public class CglibProxy implements MethodInterceptor {
    /**
     * 目标对象
     */

    private final Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        // 1. 工具类
        Enhancer en = new Enhancer();
        // 2. 设置父类
        en.setSuperclass(target.getClass());
        // 3. 设置回调函数
        en.setCallback(this);
        // 4. 创建子类
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("[Cglib代理]交中介费");
        method.invoke(target, objects);
        System.out.println("[Cglib代理]中介负责维修管理");
        return null;
    }
}
