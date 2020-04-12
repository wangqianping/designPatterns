package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 */
public class Composite {
    public static void main(String[] args) {
        University university = new University("天津科技大学");
        Colleage computerColleage = new Colleage("软件学院");
        Colleage infoColleage = new Colleage("信息技术学院");

        computerColleage.add(new Department("计算机专业"));
        computerColleage.add(new Department("软件工程专业"));

        infoColleage.add(new Department("信息工程专业"));
        infoColleage.add(new Department("通讯工程专业"));

        university.add(computerColleage);
        university.add(infoColleage);

//      university.print();
        computerColleage.print();

    }
}


abstract class Organization {

    String name;

    public void add(Organization organization) {
        throw new UnsupportedOperationException();
    }

    public void remove(Organization organization) {
        throw new UnsupportedOperationException();
    }

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void print();
}

class University extends Organization {

    List<Organization> colleages = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    @Override
    public void add(Organization organization) {
        colleages.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        colleages.remove(organization);
    }

    @Override
    void print() {
        System.out.println("=======" + super.getName() + "=======");
        for (Organization colleage : colleages) {
            colleage.print();
        }
    }
}

class Colleage extends Organization {

    List<Organization> departments = new ArrayList<>();

    public Colleage(String name) {
        super(name);
    }

    @Override
    public void add(Organization organization) {
        departments.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        departments.remove(organization);
    }

    @Override
    void print() {
        System.out.println("======" + super.getName() + "=====");
        for (Organization depeatment : departments) {
            depeatment.print();
        }
    }
}

class Department extends Organization {

    public Department(String name) {
        super(name);
    }

    @Override
    void print() {
        System.out.println(super.getName());
    }
}


