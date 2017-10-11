package com.pyq.study.designPattern.Facade.example1;

/**
 * Created by pangyueqiang on 16/2/15.
 */
public class AModuleImpl implements AModuleApi{
    @Override
    public void test() {
        System.out.println("进入A模块");
    }
}
