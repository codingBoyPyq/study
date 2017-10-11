package com.pyq.study.designPattern.ProducersAndConsumers;

import java.util.LinkedList;

/**
 * Created by pangyueqiang on 17/10/11.
 */
public class Worker<Job extends Runnable> implements Runnable {
    private volatile boolean isAlive = Boolean.TRUE;
    private LinkedList<Job> jobs;

    public Worker(LinkedList<Job> jobs) {
        this.jobs = jobs;
    }
    @Override
    public void run() {
        while (isAlive) {
            Job job = null;
            synchronized (jobs) {
                while (jobs.isEmpty()) {
                    try {
                        jobs.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                job = jobs.removeFirst();

            }

            if (job != null) {
                try {
                    job.run();
                } catch (Exception e) {
                    //任务发生异常，不考虑
                }
            }

        }
        return;
    }
    public void shutdown() {
        this.isAlive = Boolean.FALSE;
    }
}

