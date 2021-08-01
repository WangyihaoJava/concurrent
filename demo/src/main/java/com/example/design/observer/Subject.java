package com.example.design.observer;

/**
 * @author wangyihao
 * @ClassName Subject
 * @date 2021/6/23 18:06
 * @Description
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void delObserver(Observer observer);

    public void notifyObserverAll();

}
