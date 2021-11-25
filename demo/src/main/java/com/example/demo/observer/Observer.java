package com.example.demo.observer;


public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
