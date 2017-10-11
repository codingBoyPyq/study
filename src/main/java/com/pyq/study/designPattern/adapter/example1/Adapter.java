package com.pyq.study.designPattern.adapter.example1;

/**
 * Created by pangyueqiang on 16/2/15.
 */
public class Adapter implements Target{
    /**
     * 持有需要被适配的接口对象
     *
     */
    private  Adaptee adaptee;

    /**
     * 构造方法，传入需要被适配的对象
     * @param adaptee 需要被适配的对象
     */
    public Adapter(Adaptee adaptee){
       this.adaptee = adaptee;
    }
    @Override
    public void request() {
        //可能转调已经实现了的方法进行适配
        adaptee.specificRequest();
    }
}
