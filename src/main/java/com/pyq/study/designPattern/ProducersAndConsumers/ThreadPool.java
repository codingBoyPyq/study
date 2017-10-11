package com.pyq.study.designPattern.ProducersAndConsumers;

/**
 * Created by pangyueqiang on 17/10/11.
 */
public interface ThreadPool<Job extends Runnable> {

    void Execute(Job job);

    Integer getWaitJobsSize();

    //扩容
    void addWorker(int num);

    //缩容
    void removeWorker(int num);

    void shutdown();

}
