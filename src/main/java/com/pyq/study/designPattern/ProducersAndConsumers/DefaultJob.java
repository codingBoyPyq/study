package com.pyq.study.designPattern.ProducersAndConsumers;

/**
 * Created by pangyueqiang on 17/10/11.
 */
public class DefaultJob implements Job {
    private String name;
    public DefaultJob(String job){
        this.name = job;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"-" + this.name +"  is running");
    }
}
