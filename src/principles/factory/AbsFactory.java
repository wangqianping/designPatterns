package principles.factory;

/**
 * 抽象工厂设计模式
 */
public interface AbsFactory {

    Pizza creatPizza(String type);
}

class AFactory implements AbsFactory {

    @Override
    public Pizza creatPizza(String type) {
        Pizza pizza = null;
        if (type.equals("A")) {
            pizza = new PizzaForA1();
        } else if (type.equals("b")) {
            pizza = new PizzaForA2();
        }
        return pizza;
    }

    //其他方法
}

class BFactory implements AbsFactory {

    @Override
    public Pizza creatPizza(String type) {
        Pizza pizza = null;
        if (type.equals("A")) {
            pizza = new PizzaForB1();
        } else if (type.equals("b")) {
            pizza = new PizzaForB2();
        }
        return pizza;
    }

    //其他方法
}

class PizzaStore{

    public Pizza creat(AbsFactory absFactory,String type){
        Pizza pizza = absFactory.creatPizza(type);
        return pizza;
    }

}