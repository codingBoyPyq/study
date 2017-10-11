package com.pyq.study.designPattern.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by pangyueqiang on 17/2/23.
 * 抽象并实现被观察对象的通用操作
 */

public abstract class AbstractSubject implements Subject{
    public Vector<Observer> observers = new Vector<>();
    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = observers.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }
}
