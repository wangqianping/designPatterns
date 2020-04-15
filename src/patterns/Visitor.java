package patterns;

import java.util.LinkedList;
import java.util.List;

/**
 * 访问者模式
 */
public class Visitor {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        Success success = new Success();
        Fail fail = new Fail();
        objectStructure.attach(new Man("张三",success));
        objectStructure.attach(new Man("李四",fail));
        objectStructure.attach(new Woman("张红",success));
        objectStructure.attach(new Woman("丽丽",fail));
        objectStructure.display();

    }
}

abstract class Action {
    abstract void getManResult(Man man);

    abstract void getWonmanResult(Woman woman);
}

class Success extends Action {

    @Override
    void getManResult(Man man) {
        System.out.println(man.name + "对歌手的评价是成功");
    }

    @Override
    void getWonmanResult(Woman woman) {
        System.out.println(woman.name + "对歌手的评价是成功");
    }
}

class Fail extends Action {

    @Override
    void getManResult(Man man) {
        System.out.println(man.name + "对歌手的评价是失败");

    }

    @Override
    void getWonmanResult(Woman woman) {
        System.out.println(woman.name + "对歌手的评价是失败");

    }
}

abstract class Person {
    String name;
    Action action;

    public Person(String name,Action action) {
        this.name = name;
        this.action = action;
    }

    abstract void accept(Action action);
}

class Man extends Person {


    public Man(String name, Action action) {
        super(name, action);
    }

    @Override
    void accept(Action action) {
        action.getManResult(this);
    }
}

class Woman extends Person {

    public Woman(String name, Action action) {
        super(name, action);
    }

    @Override
    void accept(Action action) {
        action.getWonmanResult(this);
    }

}

class ObjectStructure {

    List<Person> personList = new LinkedList<>();

    public void attach(Person person) {
        personList.add(person);
    }

    public void detach(Person person) {
        personList.remove(person);
    }

    public void display() {
        for (Person p :
                personList) {
            p.accept(p.action);
        }
    }

}
