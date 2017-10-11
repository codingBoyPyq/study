package com.pyq.study.designPattern.observer;

/**
 * Created by pangyueqiang on 17/2/23.
 */
public class ObserverTest {
    public static void main(String[] args) {
        //创建被观察的对象
        Subject mySubect = new MySubject();
        //添加自己的粉丝们
        Observer observer1 = new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();
        mySubect.add(observer1);
        mySubect.add(observer2);
        //被观察的对象自身改变
        mySubect.operation();
    }
}
