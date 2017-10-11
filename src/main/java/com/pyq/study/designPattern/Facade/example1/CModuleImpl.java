package com.pyq.study.designPattern.Facade.example1;

/**
 * Created by pangyueqiang on 16/2/15.
 */
public class CModuleImpl implements CModuleApi {
    @Override
    public void test() {
        System.out.println("进入C模块");
    }
}
