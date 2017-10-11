package com.pyq.study.designPattern.simpleFactory.example3;

/**
 * Created by pangyueqiang on 16/2/15.
 * 静态工厂
 */
public  class Factory {
    private Factory(){}
    private static int count = 0;

    public static Api creatApi(){
        //主要用来选择合适的实现类，来创建具体的实现对象
        //选择===》如何选？===》选择的参数==》参数从何而来？

        //3参数来源于系统自身，比如运行期件的某个值
        Api api = null;
            if(count%2==0){
                api = new ImplA();
                count++;
                return api;
            }
        else{
                 api = new ImplB();
                count++;
                return api;
            }




    }
}
