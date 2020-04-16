package patterns;

/**
 * 备忘录模式
 */
public class Memento {
    int attack;
    int defend;

    public Memento(int attack, int defend) {
        this.attack = attack;
        this.defend = defend;
    }
}

class Caretaker{
    Memento memento;

    public Caretaker(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

class GameRole{

    int attack;
    int defend;

    public GameRole(int attack, int defend) {
        this.attack = attack;
        this.defend = defend;
    }

    public Memento creatMemento(){
        return new Memento(attack,defend);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public void display(){
        System.out.println("攻击力："+attack+" 防御力："+defend);
    }

    public void recover(Memento memento){
        this.attack = memento.attack;
        this.defend = memento.defend;
    }
}

class TestMemento{
    public static void main(String[] args) {
        GameRole gameRole = new GameRole(100, 100);
        //备份
        Memento memento = gameRole.creatMemento();
        Caretaker caretaker = new Caretaker(memento);
        System.out.println("战斗结束以后");
        gameRole.setAttack(30);
        gameRole.setDefend(30);
        System.out.println("恢复");
        gameRole.recover(caretaker.getMemento());
        gameRole.display();
    }

}