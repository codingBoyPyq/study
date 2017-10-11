package com.pyq.study.baseJava;

/**
 * Created by pangyueqiang on 17/3/21.
 */
public class ClassInitTest {
    private String a = null;
    private static String b = "b";
    static{
        System.out.println("static 静态代码块");
        System.out.println("b="+b);
    }
    public ClassInitTest(){
        System.out.println("构造方法");
        System.out.println("a="+a);
        a = "a";
        test1();
    }
    public void test1(){
        System.out.println("成员方法，test1");
    }

    public static void main(String[] args) {
        ClassInitTest x = new ClassInitTest();
    }
}
