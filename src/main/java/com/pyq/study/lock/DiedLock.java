package com.pyq.study.lock;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * Created by pangyueqiang on 17/9/27.
 */
public class DiedLock {
    private static Object locka = new Object();
    private static Object lockb = new Object();


    public void method() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locka) {
                    try {
                        System.out.println(Thread.currentThread().getName()+" get locka ing!");
                        java.lang.Thread.sleep(500l);
                    } catch (InterruptedException e) {

                    }
                    System.out.println(Thread.currentThread().getName()+" need lockb!Just waiting!");
                    synchronized (lockb) {
                        try {
                            System.out.println(Thread.currentThread().getName()+" get lockb ing!");
                            java.lang.Thread.sleep(500l);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }
        }, "threadA");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockb) {
                    System.out.println(Thread.currentThread().getName()+" get lockb ing!");
                    try {
                        java.lang.Thread.sleep(500l);
                    } catch (InterruptedException e) {

                    }
                    System.out.println(Thread.currentThread().getName()+" need locka!Just waiting!");
                    synchronized (locka) {
                        System.out.println(Thread.currentThread().getName()+" get locka ing!");
                        try {
                            java.lang.Thread.sleep(500l);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }
        }, "threadB");
        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        DiedLock diedLock = new DiedLock();
        diedLock.method();
    }

}

