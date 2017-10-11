package com.pyq.study.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pangyueqiang on 17/8/3.
 */
public class ThreadTest {
    private static final AtomicInteger INDEX = new AtomicInteger(1);
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2, r -> {
        Thread thread = new Thread(r);
        thread.setName("thread-pool-test-"+INDEX.getAndIncrement());
        return thread;
    });

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors() * 2);
//        for(int j = 0;j<9;j++) {
//            EXECUTOR_SERVICE.submit(() -> {
//                        //for (int i = 1; i <= 20; i++) {
//                            System.out.println(Thread.currentThread().getName() + ":第1次");
//                        //}
//                    }
//            );
//        }

//        String b = "hahaha.ydoc";
//        System.out.println(b.endsWith("."+"ydoc"));

        int index= 0;
        for(int i=0;i<100;i++){
            System.out.println("第几个公司："+i);
            outer:
            {
                if(index >=20)
                    break;
                int count = 0;
                while(true){
                    if(++count == 3){
                        index++;
                        System.out.println("发送短信成功：tenantid:"+i);
                        break outer;
                    }
                }

            }
        }
    }
}
