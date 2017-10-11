package com.pyq.study.guava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by pangyueqiang on 17/3/13.
 */
public class Observer1 {
    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     * @param msg
     */
    @Subscribe
    public void ob1Mthod1(String msg) {
        System.out.println(msg + " test1!");
    }
    @Subscribe
    public void ob1Mthod3(Obj obj) {
        System.out.println(obj.getList().toString() + " testobj!");
    }

    @Subscribe
    public void ob1Method2(String msg) {
        System.out.println(msg + " test2!");
    }

}
