package patterns;

/**
 * 外观模式
 */
public class Facade {

   private DVDPlayer dvdPlayer;
   private Projector projector;
   private Speaker speaker;
   private Light light;

    public Facade() {
        this.dvdPlayer = DVDPlayer.getInstance();
        this.projector = Projector.getInstance();
        this.speaker = Speaker.getInstance();
        this.light = Light.getInstance();
    }

    public void ready(){
        dvdPlayer.on();
        projector.down();
        projector.focus();
        speaker.on();
        light.off();
    }

    public void play(){
        dvdPlayer.play();
    }

    public void pause(){
        dvdPlayer.pause();
    }

    public void off(){
        dvdPlayer.off();
        projector.up();
        speaker.off();
        light.on();
    }

}
class DVDPlayer {

    private DVDPlayer() {

    }

    public void on() {
        System.out.println("打开播放器");
    }

    public void play(){
        System.out.println("开始播放");
    }

    public void pause() {
        System.out.println("暂停播放器");
    }

    public void off() {
        System.out.println("关闭播放器");
    }

    private static final DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

}

class Projector {

    private Projector() {

    }

    public void up() {
        System.out.println("上升投影");
    }

    public void down() {
        System.out.println("下降投影");
    }

    public void focus() {
        System.out.println("聚焦投影");
    }

    private static final Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }
}

class Speaker {
    private Speaker() {
    }

    public void on() {
        System.out.println("打开音响");
    }

    public void off() {
        System.out.println("关闭音响");
    }

    private static final Speaker instance = new Speaker();

    public static Speaker getInstance() {
        return instance;
    }
}

class Light {
    private Light() {
    }

    public void on() {
        System.out.println("打开灯光");
    }

    public void off() {
        System.out.println("关闭灯光");
    }

    private static final Light instance = new Light();

    public static Light getInstance() {
        return instance;
    }
}

class TestFacade{
    public static void main(String[] args) {
        Facade facade = new Facade();
        //流程可控
        facade.ready();
        facade.play();
        facade.pause();
        facade.off();
    }
}