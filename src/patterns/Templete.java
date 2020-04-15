package patterns;

/**
 * 模板模式
 */
public class Templete {

    public static void main(String[] args) {
        System.out.println("====开始制作红豆豆浆=====");
        SoyMilk redBeanMilk = new RedBeanMilk();
        redBeanMilk.make();
        System.out.println("====开始制作绿豆豆浆=====");
        SoyMilk greenBeanMilk = new GreenBeanMilk();
        greenBeanMilk.make();
        System.out.println("====开始制作黄豆豆浆=====");
        SoyMilk yelloBeanMilk = new YellowBeanMilk();
        yelloBeanMilk.make();

    }

}

abstract class SoyMilk {

    //模版方法
    final void make() {
        select();
        if (ifAdd()) {
            add();
        }
        soak();
        beat();
    }


    void select() {
        System.out.println("挑选豆子");
    }

    abstract void add();

    void soak() {
        System.out.println("浸泡材料");
    }

    void beat() {
        System.out.println("豆浆机搅拌");
    }

    boolean ifAdd() {
        return true;
    }
}

class RedBeanMilk extends SoyMilk {

    @Override
    void add() {
        System.out.println("加入红豆");
    }
}

class GreenBeanMilk extends SoyMilk {

    @Override
    void add() {
        System.out.println("加入绿豆");
    }

}

class YellowBeanMilk extends SoyMilk {

    @Override
    void add() {

    }

    @Override
    boolean ifAdd() {
        return false;
    }
}