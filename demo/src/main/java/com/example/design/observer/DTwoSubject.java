package com.example.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyihao
 * @ClassName DTwoObserver
 * @date 2021/6/23 18:28
 * @Description
 */
public class DTwoSubject implements Subject{
    List<Observer> observers = new ArrayList<>();

    private String msg;

    @Override
    public void registerObserver(Observer observer) {

        observers.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {

        observers.remove(observer);

    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObserverAll();
    }

    @Override
    public void notifyObserverAll() {

        for (Observer observer : observers){
            observer.update(msg);
        }

    }
}
