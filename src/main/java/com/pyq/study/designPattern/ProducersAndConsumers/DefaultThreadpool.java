package com.pyq.study.designPattern.ProducersAndConsumers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by pangyueqiang on 17/10/11.
 */
public class DefaultThreadpool<Job extends Runnable> implements ThreadPool<Job> {
    private static final int MAX_THREAD_WORKER_NUM = 20;
    private static final int MIN_THREAD_WORKER_NUM = 5;
    private static final int DEFAULT_THREAD_WORKER_NUM = 10;
    private final LinkedList<Job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    private AtomicLong threadNum = new AtomicLong();

    private int workCount = DEFAULT_THREAD_WORKER_NUM;

    public DefaultThreadpool() {
        init(DEFAULT_THREAD_WORKER_NUM);
    }

    public DefaultThreadpool(int initThreadNum) {
        this.workCount = initThreadNum > MAX_THREAD_WORKER_NUM ? MAX_THREAD_WORKER_NUM : initThreadNum < MIN_THREAD_WORKER_NUM ? MIN_THREAD_WORKER_NUM : initThreadNum;
        init(workCount);
    }

    public void init(int num) {
        synchronized (jobs) {
            for (int i = 0; i < num; i++) {
                Worker worker = new Worker<>(jobs);
                Thread thread = new Thread(worker, "Thread-pool-Worker-" + threadNum.getAndIncrement());
                thread.start();
            }
        }
    }

    @Override
    public void Execute(Job job) {
        if (jobs != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public Integer getWaitJobsSize() {
        if (jobs != null) {
            synchronized (jobs) {
                return jobs.size();
            }
        }
        return 0;
    }

    @Override
    public void addWorker(int num) {
        synchronized (jobs) {
            if (this.workCount + num > MAX_THREAD_WORKER_NUM) {
                num = MAX_THREAD_WORKER_NUM - this.workCount;
            }
            init(num);
            this.workCount += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num > this.workCount) {
                num = this.workCount - MIN_THREAD_WORKER_NUM;
            }else if(this.workCount - num <MIN_THREAD_WORKER_NUM){
                num = this.workCount - MIN_THREAD_WORKER_NUM;
            }
           for(int i =0;i<num;i++){
                Worker worker = workers.get(i);
                worker.shutdown();
           }
            this.workCount -= num;
        }
    }

    @Override
    public void shutdown() {
        if (!workers.isEmpty()) {
            for (Worker worker : workers) {
                worker.shutdown();
            }
        }
    }
}
