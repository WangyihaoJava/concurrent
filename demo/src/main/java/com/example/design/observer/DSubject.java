package com.example.design.observer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyihao
 * @ClassName DSubject
 * @date 2021/6/23 18:10
 * @Description
 */
public class DSubject implements Subject {

    List<Observer> observers = new ArrayList<>();

    private String msg;

    @Override
    public void registerObserver(Observer observer) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register();

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
