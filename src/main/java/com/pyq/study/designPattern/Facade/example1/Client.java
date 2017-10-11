package com.pyq.study.designPattern.Facade.example1;

/**
 * Created by pangyueqiang on 16/2/15.
 */
public class Client {
    public static void main (String[] args){
        //不用外观模式
        /*
        AModuleApi a = new AModuleImpl();
        a.test();
        BModuleApi b = new BModuleImpl();
        b.test();
        CModuleApi c = new CModuleImpl();
        c.test();
        */
        new Facade().test();
    }

}
