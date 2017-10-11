package com.pyq.study.designPattern.observer;

/**
 * Created by pangyueqiang on 17/2/23.
 */
public class ObserverImpl1 implements Observer{
    @Override
    public void update() {
        System.out.println("ObserverImpl1 has recived the massage!");
    }
}
