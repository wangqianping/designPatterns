package patterns;

/**
 * 单例模式
 * 1.饿汉式和懒汉式
 */
public class Singleton {

    //1.构造器私有化
    private Singleton(){
    }
    //2.本类内部创建对象(项目启动的时候就创建了)
    private final static Singleton instance = new Singleton();
    //3.对外提供一个公有的静态方法
    public static Singleton getInstance(){
        return instance;
    }

}

class Singleton2{

    //1.构造器私有化
    private Singleton2(){

    }

    private static Singleton2 instance;

    //调用的时候创建
    public static Singleton2 getInstance(){

        if(instance==null){
            instance = new Singleton2();
        }

        return instance;
    }

}

class Singleton3{

    private Singleton3(){

    }

    private static volatile Singleton3 instance;

    public static Singleton3 getInstance(){

        if(instance==null){
            synchronized (Singleton3.class){
                if(instance==null){
                    instance= new Singleton3();
                }
            }
        }
        return instance;
    }
}

class Singleton4{

    private Singleton4(){

    }

    private static class SingletonInstance{
       private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return SingletonInstance.instance;
    }
}

enum Singleton5{
    INSTANCE;
}