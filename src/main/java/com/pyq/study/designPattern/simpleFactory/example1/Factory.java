package com.pyq.study.designPattern.simpleFactory.example1;

/**
 * Created by pangyueqiang on 16/2/15.
 * 静态工厂
 */
public  class Factory {
    private Factory(){}
    public static Api creatApi(int type){
        //主要用来选择合适的实现类，来创建具体的实现对象
        //选择===》如何选？===》选择的参数==》参数从何而来？
        //1参数来源于client,client 客户端必须知道每个参数的含义
        //2参数来源于配置文件
        //3参数来源于系统自身，比如运行期件的某个值
        if(type==1)
        {
            Api api = new ImplA();
            return api;
        }else
        {
            Api api = new ImplB();
            return api;
        }
    }
}
