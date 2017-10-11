package com.pyq.study.designPattern.observer;

/**
 * Created by pangyueqiang on 17/2/23.
 */
public class MySubject extends AbstractSubject implements Subject{
    @Override
    public void operation() {
        System.out.println("我要变身了！！！！ 观察者注意了！");
        notifyObservers();
    }
}
