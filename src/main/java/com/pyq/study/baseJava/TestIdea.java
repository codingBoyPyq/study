package com.pyq.study.baseJava;

public class TestIdea {

    public static void main(String[] args) {
        Integer a = false ? new Integer(3) : test();
        System.out.println(a);
    }
    public static Integer test(){
        return null;
    }
}
