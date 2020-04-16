package patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    private Object object;

    public DynamicProxy(Object o) {
        this.object = o;
    }

    public Object getProxyInstance() {
        return  Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("这是动态代理模式");
                        Object invoke = method.invoke(object, args);
                        return invoke;
                    }
                });
    }
}

class TestDynamicProxy {
    public static void main(String[] args) {
        IteacherDao teacherDao = new TeacherDao();
        DynamicProxy dynamicProxy = new DynamicProxy(teacherDao);
        IteacherDao instance = (IteacherDao) dynamicProxy.getProxyInstance();
        instance.teach();
    }
}