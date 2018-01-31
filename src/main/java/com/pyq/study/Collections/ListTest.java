package com.pyq.study.Collections;

import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static final List<Integer> testData = Arrays.asList(1,2,3,45,56);

    public static void main(String[] args) {
        test1();
    }





    public static void test1(){

        System.out.println(testData);

        testData.set(1,testData.set(2,testData.get(1)));

        System.out.println(testData);
    }

}

