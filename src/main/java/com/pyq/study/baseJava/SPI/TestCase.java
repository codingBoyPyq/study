package com.pyq.study.baseJava.SPI;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
public class TestCase {
    public static void main(String[] args) throws Exception{

         //jdk 服务发现器
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
           Search search =  iterator.next();
           search.searchDoc("hello world");
        }
        //自定义服务发现器
            test(Search.class);

    }

    public static void test(Class xclass) throws Exception{
        List<Search> list = CustomServiceLoader.loade(xclass);
        for(Search search : list)
        {
            search.searchDoc("hello word");
        }
    }
}