package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public interface Observer {
    void update(double temparatrue);

    void show();
}

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notice();
}

class CurrentCondition implements Observer {

    String name;
    private double temparatrue;

    public CurrentCondition(String name) {
        this.name = name;
    }

    @Override
    public void update(double temparatrue) {
        this.temparatrue = temparatrue;
    }
    @Override
    public void show(){
        System.out.println(name+"显示的温度是 "+temparatrue+"度");
    }
}

class WeatherData implements Subject {

    double tempartrue;
    List<Observer> observerList;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    public void setTempartrue(double tempartrue) {
        this.tempartrue = tempartrue;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notice() {
        for (Observer observer : observerList) {
            observer.update(tempartrue);
        }
    }
}

class TestObserver{
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer currentCondition = new CurrentCondition("天气网");
        weatherData.registerObserver(currentCondition);
        weatherData.setTempartrue(32);
        weatherData.notice();
        currentCondition.show();

        System.out.println("===当天气有更新的时候====");
        weatherData.setTempartrue(33);
        weatherData.notice();
        currentCondition.show();
    }
}