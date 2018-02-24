package com.pyq.study.baseJava;

/**
 * static 是通过静态绑定的方式，使用类的信息进行绑定的，所以null 能引用。
 */
public class Testing {

    public static void main(String args[]) {
        Testing myObject = null;
        myObject.iAmStaticMethod();
        ((Testing)null).iAmStaticMethod();

    }

    private static void iAmStaticMethod() {
        System.out.println("I am static method, can be called by null reference");
    }

    private void iAmNonStaticMethod() {
        System.out.println("I am NON static method, don't date to call me by null");
    }
}