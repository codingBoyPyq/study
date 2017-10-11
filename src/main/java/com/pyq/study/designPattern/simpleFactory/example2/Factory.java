package com.pyq.study.designPattern.simpleFactory.example2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pangyueqiang on 16/2/15.
 * 静态工厂
 */
public  class Factory {
    private Factory(){}
    public static Api creatApi(){
        //主要用来选择合适的实现类，来创建具体的实现对象
        //选择===》如何选？===》选择的参数==》参数从何而来？

        //2参数来源于配置文件
        Properties p = new Properties();
        InputStream in =null;
        try {
            in = Factory.class.getResourceAsStream("Factory.properties");
            p.load(in);
        }
        catch (IOException e)
        {
            System.out.println("装载工厂配置文件出错了，具体的堆栈信息如下：");
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        //用反射去创建
        Api api = null;
        try {
            api = (Api)Class.forName(p.getProperty("ImplClass")).newInstance();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return api;

    }
}
