package com.example.design.observer;

/**
 * @author wangyihao
 * @ClassName ObserverOne
 * @date 2021/6/23 18:15
 * @Description
 */
public class ObserverTwo implements Observer {

    private Subject subject;

    public ObserverTwo(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("ObserverTwo提交新的消息" + msg);
    }
}
