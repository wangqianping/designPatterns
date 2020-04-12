package patterns.factory;

/**
 * 简单工厂模式
 */
public class SimpleFactory {
    public Pizza creatPizza(String type){
        Pizza pizza = null;
        if(type.equals("A")){
            pizza = new PizzaA();
        }else if(type.equals("b")){
            pizza = new PizzaB();
        }
        return pizza;
    }
}

class PizzaStoreC{

    SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    public Pizza creatPizza(String type){
        Pizza pizza = simpleFactory.creatPizza(type);
        return pizza;
    }

    public void cutA(){}
    public void boxA(){};

}

class PizzaStoreD{

    SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    public Pizza creatPizza(String type){
        Pizza pizza = simpleFactory.creatPizza(type);
        return pizza;
    }

    public void cutB(){}
    public void boxB(){}

}


//下面的这种写法有一个问题，即当新加一种类型时，PizzaStoreA和PizzaStoreB都需要修改
class PizzaStoreA{
    public Pizza creatPizza(String type){
        Pizza pizza = null;
        if(type.equals("A")){
            pizza = new PizzaA();
        }else if(type.equals("b")){
            pizza = new PizzaB();
        }
        return pizza;
    }
    public void cutA(){}
    public void boxA(){};
}

class PizzaStoreB{

    public Pizza creatPizza(String type){
        Pizza pizza = null;
        if(type.equals("A")){
            pizza = new PizzaA();
        }else if(type.equals("b")){
            pizza = new PizzaB();
        }
        return pizza;
    }
    public void cutB(){}
    public void boxB(){}
}



class Pizza{
    String name;
}

class PizzaA extends Pizza{

}

class PizzaB extends Pizza{

}