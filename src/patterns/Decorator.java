package patterns;

/**
 * 装饰者模式
 */
public class Decorator extends Drink {

    Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double coast() {
        return super.getPrice() + drink.coast();
    }
}

class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        this.des = "牛奶";
        this.price = 1;
    }

    @Override
    public double coast() {
        return super.coast();
    }
}

class Choolate extends Decorator {

    public Choolate(Drink drink) {
        super(drink);
        this.des = "巧克力";
        this.price = 2;

    }

    @Override
    public double coast() {
        return super.coast();
    }
}

abstract class Drink {

    String des;
    double price;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    abstract public double coast();
}

class Coffee extends Drink {

    @Override
    public double coast() {
        return super.getPrice();
    }
}

class ShortBlack extends Coffee {

    public ShortBlack() {
        this.des = "拿铁";
        this.price = 5;
    }

    @Override
    public double coast() {
        return super.coast();
    }
}

class LongBlack extends Coffee {

    public LongBlack() {
        this.des = "美式";
        this.price = 3;
    }

    @Override
    public double coast() {
        return super.coast();
    }
}

class TestDecrator {
    public static void main(String[] args) {

        //单点
        Decorator decorator = new Decorator(new ShortBlack());
        System.out.println("订单：" + decorator.drink.getDes() + " 价格为：" + decorator.coast());

        //加牛奶
        Milk milk = new Milk(decorator);
        System.out.println("订单：" + decorator.drink.getDes() + "加" + milk.getDes() + " 价格为：" + milk.coast());

        //再加巧克力
        Choolate choolate = new Choolate(milk);
        System.out.println("订单：" + decorator.drink.getDes() + "加" + milk.getDes() + "加" + choolate.getDes() + " 价格为：" + choolate.coast());

    }
}