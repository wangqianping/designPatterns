package patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 */
public class Flyweight {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        ConcreteWebsite concreteWebsite = webSiteFactory.getConcreteWebsite("微博");
        concreteWebsite.use(new User("新浪"));
        ConcreteWebsite concreteWebsite1 = webSiteFactory.getConcreteWebsite("博客");
        concreteWebsite1.use(new User("CSDN"));
        ConcreteWebsite concreteWebsite2 = webSiteFactory.getConcreteWebsite("微博");
        concreteWebsite2.use(new User("网易"));
        System.out.println("网站池的数量为："+webSiteFactory.getConcreteWebsiteMap().size());//size=2，表示有一个共享了
    }

}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

abstract class Website{
    abstract void use(User user);
}

class ConcreteWebsite extends Website {

    String type;//内部状态

    public ConcreteWebsite(String type) {
        this.type = type;
    }

    @Override
    void use(User user) {
        System.out.println("网站的发布形式为"+type+" 使用者是"+user.name);
    }
}

class WebSiteFactory{

    private Map<String,ConcreteWebsite> concreteWebsiteMap = new HashMap<>();

    public ConcreteWebsite getConcreteWebsite(String type){
        if(concreteWebsiteMap.get(type)==null){
            concreteWebsiteMap.put(type,new ConcreteWebsite(type));
        }
        return concreteWebsiteMap.get(type);
    }

    public Map<String, ConcreteWebsite> getConcreteWebsiteMap() {
        return concreteWebsiteMap;
    }
}