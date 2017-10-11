package com.pyq.study.guava.eventBus;

import com.google.common.eventbus.EventBus;

/**
 * Created by pangyueqiang on 17/3/13.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        eventBus.register(observer1);
        eventBus.register(observer2);

        // 只有注册的参数类型为String的方法会被调用
        //eventBus.post("post string method");
        eventBus.post(new Obj());
        // 注销observer2
        eventBus.unregister(observer2);
        eventBus.post("post string method after unregister");
    }
}
