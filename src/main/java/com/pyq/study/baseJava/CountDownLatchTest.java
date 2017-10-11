package com.pyq.study.baseJava;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pangyueqiang on 16/8/30.
 */
public class CountDownLatchTest {
    private static final int threadNum = 5;
    private static final AtomicInteger INDEX = new AtomicInteger(1);
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("report-assemble-data-" + INDEX.getAndIncrement());
            return thread;
        }
    });
    public static void  test() throws InterruptedException {
        for (Long i = 1l; i <=200; i++){
            Thread.sleep(180);
            System.out.println(Thread.currentThread().getName() + " || " + i);
        }
    }
    public static void  test01() throws InterruptedException {
        Long dataSize = 20407l;
        Long averageNum = dataSize % threadNum == 0 ? dataSize / threadNum : dataSize / threadNum + 1;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 1; i <= threadNum; i++) {
            final Long offerset = (i - 1) * averageNum;
            EXECUTOR_SERVICE.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (Long i = offerset; i < offerset + averageNum; i++) {
                            Thread.sleep(180);
                            System.out.println(Thread.currentThread().getName() + " || " + i);
                        }
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        test01();
        Long end = System.currentTimeMillis();
        System.out.println("一般耗时:" + (end-start));
    }
}

