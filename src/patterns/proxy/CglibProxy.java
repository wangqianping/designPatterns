package patterns.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CglibProxy implements MethodInterceptor {

    private Object object;

    public CglibProxy(Object o) {
        this.object = o;
    }

    //获得一个代理对象
    public Object getProxyInstance() {
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(object.getClass());
        //设置回掉函数
        enhancer.setCallback(this);
        //创建子类对象，即代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理模式开始");
        Object invoke = method.invoke(object, objects);
        return invoke;
    }
}

class TeacherService {

    public void teach() {
        System.out.println(" Cglib 代理模式");
    }
}

class TestCglibProxy {
    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        CglibProxy cglibProxy = new CglibProxy(teacherService);
        TeacherService instance = (TeacherService) cglibProxy.getProxyInstance();
        instance.teach();
    }
}