package com.pyq.study.designPattern.adapter.example1;

/**
 * Created by pangyueqiang on 16/2/15.
 */
public class Client {
    public static void main(String[] args)
    {
        //先定义要适配的类
        Adaptee adaptee = new Adaptee();
        //传入适配器中
        Adapter adapter = new Adapter(adaptee);
        //客户端通过调用适配器中的实现方法，转调解接口方法
        adapter.request();
    }
}
