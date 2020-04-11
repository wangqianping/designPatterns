package principles;

/**
 * 适配器模式
 * 1.类适配器模式
 * 2.对象适配器模式
 * 3.接口适配器模式
 */
public class ClassAdapter extends Volatege220 implements Volatege5V {

    @Override
    public int output5V() {
        System.out.println("===正在使用类适配器模式===");
        int src = output220V();
        int target = src / 44;
        return target;
    }
}


class Volatege220 {
    public int output220V() {
        int src = 220;
        return src;
    }
}

interface Volatege5V {
    int output5V();
}

class Phone {

    public void charging(Volatege5V v) {
        if (v.output5V() == 5) {
            System.out.println("正在充电");
        } else {
            System.out.println("无法充电");
        }
    }
}

//上面是类适配器模式，但是因为用到继承，所以也存在一定的局限性

//下面演示的是对象适配器模式,这种模式和类适配器其实思想是一样的，只是为了解耦。用聚合的方式代替继承
class ObjectAdapter implements Volatege5V {

    Volatege220 volatege220;

    public ObjectAdapter(Volatege220 volatege220) {
        this.volatege220 = volatege220;
    }

    @Override
    public int output5V() {

        if (volatege220 != null) {
            System.out.println("===正在使用对象适配器模式===");
            int src = volatege220.output220V();
            int target = src / 44;
            return target;
        }

        return 0;
    }
}

//接口适配器模式：当不需要实现一个接口的所有方法时，可以设计成一个抽象类，然后让该抽象类的实例有选择的去重写方法
interface Demo{
    void m1();
    void m2();
    void m3();
}

abstract class InterfaceAdapter implements Demo{

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}


class AdapterTest{

    public static void main(String[] args) {

        //测试类适配器
        Phone phone = new Phone();
        phone.charging(new ClassAdapter());
        //测试对象适配器
        phone.charging(new ObjectAdapter(new Volatege220()));
        //测试接口适配器
        InterfaceAdapter interfaceAdapter = new InterfaceAdapter() {
            @Override
            public void m1() {
                System.out.println("正在使用接口适配器模式，可以自己选择要重写的方法");
            }
        };
        interfaceAdapter.m1();
    }
}