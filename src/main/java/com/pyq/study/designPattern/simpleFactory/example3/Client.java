package com.pyq.study.designPattern.simpleFactory.example3;

/**
 * Created by pangyueqiang on 16/2/15.
 */
public class Client {
    public static void main (String[] args)
    {
        //1参数来源于client,client 客户端必须知道每个参数的含义
        for(int i =0;i<10;i++)
        {
            Api api = Factory.creatApi();
            api.option();
        }
    }
}
