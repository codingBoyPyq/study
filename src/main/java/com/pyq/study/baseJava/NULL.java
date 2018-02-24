package com.pyq.study.baseJava;

public class NULL {

    public static void print() {
        System.out.println("MTDP");
    }

    public static void main(String[] args) {
        boolean result = false ? false : true == false ? true : false;
        System.out.println("" + result + "");
        try {
            ((NULL) null).print();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }
}