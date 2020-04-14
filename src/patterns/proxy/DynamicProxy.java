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
//        return new Proxy.newProxyInstance(
//                object.getClass().getClassLoader(),
//                object.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("这是动态代理模式");
//                        Object invoke = method.invoke(proxy, args);
//                        return invoke;
//                    }
//                });
        return null;
    }
}

class TestDynamicProxy {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        DynamicProxy dynamicProxy = new DynamicProxy(teacherDao);
        TeacherDao instance = (TeacherDao) dynamicProxy.getProxyInstance();
        instance.teach();
    }
}