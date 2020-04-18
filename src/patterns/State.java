package patterns;

import java.util.Random;

/**
 * 状态模式
 */
public abstract class State {

    //扣除积分方法
    abstract void dedeuctPoints();

    //是否中奖
    abstract boolean winning();

    //领取奖品
    abstract void awards();
}

class AwardActivity {

    State state;//当前状态
    int count;//奖品数量
    NoAwardState noAwardState = new NoAwardState(this);
    CanAwardState canAwardState = new CanAwardState(this);
    DispenseAwardState dispenseAwardState = new DispenseAwardState(this);
    DispenseOutAwardState dispenseOutAwardState = new DispenseOutAwardState(this);

    public AwardActivity(int count) {
        this.count = count;
        this.state = noAwardState;
    }

    public void dedeuctPoints() {
        state.dedeuctPoints();
    }

    public void winning() {
        if (state.winning()) {
            state.awards();
            count--;
        }
    }

    public NoAwardState getNoAwardState() {
        return noAwardState;
    }

    public void setNoAwardState(NoAwardState noAwardState) {
        this.noAwardState = noAwardState;
    }

    public CanAwardState getCanAwardState() {
        return canAwardState;
    }

    public void setCanAwardState(CanAwardState canAwardState) {
        this.canAwardState = canAwardState;
    }

    public DispenseAwardState getDispenseAwardState() {
        return dispenseAwardState;
    }

    public void setDispenseAwardState(DispenseAwardState dispenseAwardState) {
        this.dispenseAwardState = dispenseAwardState;
    }

    public DispenseOutAwardState getDispenseOutAwardState() {
        return dispenseOutAwardState;
    }

    public void setDispenseOutAwardState(DispenseOutAwardState dispenseOutAwardState) {
        this.dispenseOutAwardState = dispenseOutAwardState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

//不能抽奖的状态
class NoAwardState extends State {

    AwardActivity activity;

    public NoAwardState(AwardActivity activity) {
        this.activity = activity;
    }

    @Override
    void dedeuctPoints() {
        System.out.println("扣除50积分可以抽奖了");
        activity.state = activity.getCanAwardState();
    }

    @Override
    boolean winning() {
        System.out.println("扣了积分才可以抽奖");
        return false;
    }

    @Override
    void awards() {
        System.out.println("不能发放奖品");
    }
}

//可以抽奖状态
class CanAwardState extends State {

    AwardActivity activity;

    public CanAwardState(AwardActivity activity) {
        this.activity = activity;
    }

    @Override
    void dedeuctPoints() {
        System.out.println("===已经扣取过积分了===");
    }

    @Override
    boolean winning() {
        System.out.println("===正在抽奖===");

        Random random = new Random();
        int val = random.nextInt(10);
        if (val == 1) {
            activity.state = activity.getDispenseAwardState();
            return true;
        } else {
            System.out.println("==很遗憾未中奖== "+val);
            activity.state = activity.getNoAwardState();
            return false;
        }

    }

    @Override
    void awards() {
        System.out.println("===不能领取奖品===");
    }
}

//发奖状态
class DispenseAwardState extends State {

    AwardActivity activity;

    public DispenseAwardState(AwardActivity activity) {
        this.activity = activity;
    }

    @Override
    void dedeuctPoints() {
        System.out.println("==不能扣除积分==");
    }

    @Override
    boolean winning() {
        System.out.println("==不能抽奖==");
        return false;
    }

    @Override
    void awards() {
        if(activity.getCount()>0){
            System.out.println("==恭喜中奖==");
            activity.setCount(activity.getCount()-1);
            activity.setState(activity.getNoAwardState());
        }else{
            System.out.println("====抱歉,奖品发放完毕===");
            activity.state = activity.getDispenseOutAwardState();
        }
    }
}

//奖品发放完毕状态
class DispenseOutAwardState extends State {

    AwardActivity activity;

    public DispenseOutAwardState(AwardActivity activity) {
        this.activity = activity;
    }

    @Override
    void dedeuctPoints() {
        System.out.println("不能扣除积分");
    }

    @Override
    boolean winning() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    void awards() {
        System.out.println("抱歉，奖品已经发放完毕");
    }
}

class TestState{
    public static void main(String[] args) {

        AwardActivity awardActivity = new AwardActivity(1);
        int flag = 10;
        while(flag>0){
            //扣除积分
            awardActivity.dedeuctPoints();
            //开始抽奖
            awardActivity.winning();
            flag--;
        }

    }
}