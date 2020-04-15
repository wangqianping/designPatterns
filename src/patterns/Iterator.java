package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 */
public class Iterator {
    public static void main(String[] args) {
        List<Colleages> colleages = new ArrayList<>();
        ComputerColleage computerColleage = new ComputerColleage();
        computerColleage.addDepart(new Depart("java专业"));
        computerColleage.addDepart(new Depart("PHP专业"));
        computerColleage.addDepart(new Depart("Pyphon专业"));
        colleages.add(computerColleage);
        OutputIml outputIml = new OutputIml(colleages);
        outputIml.print();
    }
}

class ComputerColleageIterator implements java.util.Iterator {

    List<Depart> computerColleageList;
    int position;

    public ComputerColleageIterator(List<Depart> computerColleageList) {
        this.computerColleageList = computerColleageList;
    }


    @Override
    public boolean hasNext() {
        if (position >= computerColleageList.size()) {
            return false;
        } else {
            position += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return computerColleageList.get(position - 1);
    }

    @Override
    public void remove() {

    }
}

interface Colleages {
    void addDepart(Depart department);

    java.util.Iterator createIterator();

    String getName();
}

class ComputerColleage implements Colleages {

    List<Depart> computerColleageList;

    public ComputerColleage() {
        computerColleageList = new ArrayList<>();
    }


    @Override
    public void addDepart(Depart department) {
        computerColleageList.add(department);
    }

    @Override
    public java.util.Iterator createIterator() {
        return new ComputerColleageIterator(computerColleageList);
    }

    @Override
    public String getName() {
        return "计算机学院";
    }
}

class Depart {
    String name;

    public Depart(String name) {
        this.name = name;
    }
}

class OutputIml {

    List<Colleages> colleages;

    public OutputIml(List<Colleages> colleages) {
        this.colleages = colleages;
    }

    public void print() {
        java.util.Iterator<Colleages> iterator = colleages.iterator();
        while (iterator.hasNext()) {
            Colleages colleage = iterator.next();
            System.out.println("====" + colleage.getName() + "======");
            java.util.Iterator iterator1 = colleage.createIterator();
            printDepart(iterator1);
        }
    }


    public void printDepart(java.util.Iterator iterator) {
        while (iterator.hasNext()) {
            Depart next = (Depart) iterator.next();
            System.out.println(next.name);
        }
    }
}