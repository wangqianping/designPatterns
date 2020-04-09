package principles.factory;

/**
 * 工厂方法模式
 */
public abstract class FactoryMethod {
    public abstract Pizza creat(String type);
}

class PizzaStoreForC extends FactoryMethod {

    @Override
    public Pizza creat(String type) {
        Pizza pizza = null;
        if (type.equals("A")) {
            pizza = new PizzaForA1();
        } else if (type.equals("b")) {
            pizza = new PizzaForA2();
        }
        return pizza;
    }
}

class PizzaStoreForD extends FactoryMethod {

    @Override
    public Pizza creat(String type) {
        Pizza pizza = null;
        if (type.equals("A")) {
            pizza = new PizzaForB1();
        } else if (type.equals("b")) {
            pizza = new PizzaForB2();
        }
        return pizza;
    }
}


//下面的这种写法，我们发现PizzaStoreForA和PizzaStoreForB除了create方法不一样其他的都一样，
// 这个时候我们可以考虑用工厂方法设计模式来优化

//使用工厂方法模式来编码单纯从代码看仿佛并没有带来可见的好处，但是却满足了依赖抽象的方式编码
class PizzaStoreForA {

    public Pizza creat(String type) {
        Pizza pizza = null;
        if (type.equals("A")) {
            pizza = new PizzaForA1();
        } else if (type.equals("b")) {
            pizza = new PizzaForA2();
        }
        return pizza;
    }
}

class PizzaStoreForB {
    public Pizza creat(String type) {
        Pizza pizza = null;
        if (type.equals("A")) {
            pizza = new PizzaForB1();
        } else if (type.equals("b")) {
            pizza = new PizzaForB2();
        }
        return pizza;
    }
}

class PizzaForA1 extends Pizza {

}

class PizzaForA2 extends Pizza {

}

class PizzaForB1 extends Pizza {

}

class PizzaForB2 extends Pizza {

}












