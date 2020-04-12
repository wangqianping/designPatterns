package patterns;

/**
 * 桥接模式
 */
public interface Bridge {
    void open();

    void call();

    void close();
}

class XiaoMi implements Bridge {

    @Override
    public void open() {
        System.out.println("欢迎使用小米手机");
    }

    @Override
    public void call() {

    }

    @Override
    public void close() {

    }
}

class HuaWei implements Bridge{

    @Override
    public void open() {
        System.out.println("欢迎使用华为手机");
    }

    @Override
    public void call() {

    }

    @Override
    public void close() {

    }
}

abstract class Mobile{

    private Bridge bridge;
    public Mobile(Bridge bridge){
        this.bridge = bridge;
    }

    public void open(){
        bridge.open();
    }

    public void call(){
        bridge.call();
    }

    public void close(){
        bridge.close();
    }

}

class UpRightPhone extends Mobile{

    public UpRightPhone(Bridge bridge) {
        super(bridge);
    }

    public void open(){
        super.open();
    }

    public void call(){
        super.call();
    }

    public void close(){
        super.close();
    }
}

class TestBridgePattern{
    public static void main(String[] args) {
        Mobile xiaoMi = new UpRightPhone(new XiaoMi());
        Mobile huaWei = new UpRightPhone(new HuaWei());
        xiaoMi.open();
        huaWei.open();
    }
}