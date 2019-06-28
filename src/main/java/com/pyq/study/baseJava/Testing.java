package com.pyq.study.baseJava;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.pyq.study.Student;
import com.pyq.study.serialization.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * static 是通过静态绑定的方式，使用类的信息进行绑定的，所以null 能引用。
 */
public class Testing {

    public static void main(String args[]) {
//        Testing myObject = null;
//        myObject.iAmStaticMethod();
//        ((Testing)null).iAmStaticMethod();

        List<Student> list = new ArrayList<>();
        list.add(new Student(1));
        list.add(new Student(2));
        list.add(new Student(1));







    }

    private static void iAmStaticMethod() {
        System.out.println("I am static method, can be called by null reference");
    }

    private void iAmNonStaticMethod() {
        System.out.println("I am NON static method, don't date to call me by null");
    }
}