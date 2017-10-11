package com.pyq.study.designPattern.ProducersAndConsumers;

/**
 * Created by pangyueqiang on 17/10/11.
 */
public class Test {
    private static final DefaultThreadpool<DefaultJob> threadpool = new DefaultThreadpool<>();

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            DefaultJob defaultJob = new DefaultJob("job-"+i);
            threadpool.Execute(defaultJob);
            if(i%50==0){
                System.out.println("is wait job size:"+threadpool.getWaitJobsSize());
            }
            if(i==500){
                threadpool.addWorker(7);
            }
        }

    }
}
