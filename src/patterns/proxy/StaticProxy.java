package patterns.proxy;

/**
 * 静态代理
 */
public class StaticProxy implements IteacherDao{

    IteacherDao target;

    public StaticProxy(IteacherDao target){
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理模式的好处是可以对方法进行扩展");
        target.teach();
        System.out.println("对于那些无法修改的方法，后期如果想扩展最好用代理模式");
    }
}

interface IteacherDao{
    void teach();
}
class TeacherDao implements IteacherDao{
    @Override
    public void teach() {
        System.out.println("老师正在讲解静态代理模式");
    }
}

class TestStaticProxy{
    public static void main(String[] args) {
        TeacherDao target = new TeacherDao();
        StaticProxy staticProxy = new StaticProxy(target);
        staticProxy.teach();
    }
}