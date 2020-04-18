package patterns;

/**
 * 策略模式
 */
public class Strategy {
    public static void main(String[] args) {
        PekingDuck pekingDuck = new PekingDuck("北京鸭",new NoFlyBehavior());
        pekingDuck.fly();
        WildDuck wildDuck = new WildDuck("野鸭", new GoodFlyBehavior());
        wildDuck.fly();
    }
}

class Duck {
    String name;
    FlyBehavior flyBehavior;
}

class PekingDuck extends Duck {

    public PekingDuck(String name, FlyBehavior flyBehavior) {
        this.name = name;
        this.flyBehavior = flyBehavior;
    }

    public void fly() {
        System.out.print(name);
        flyBehavior.fly();
    }
}

class WildDuck extends Duck {

    public WildDuck(String name, FlyBehavior flyBehavior) {
        this.name = name;
        this.flyBehavior = flyBehavior;
    }

    public void fly() {
        System.out.print(name);
        flyBehavior.fly();
    }
}


interface FlyBehavior {
    void fly();
}

class NoFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}

class GoodFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("擅长飞");
    }
}