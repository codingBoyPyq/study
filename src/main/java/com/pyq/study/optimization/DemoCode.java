package com.pyq.study.optimization;

import java.io.*;
import java.util.Locale;
import java.util.Random;
import java.util.Vector;

/**
 * Created by pangyueqiang on 17/7/26.
 */
public class DemoCode {
    public static class HoldCPUTask implements Runnable{
        public static Object[] lock = new Object[100];
        public static Random r = new Random();
        static {
            for(int i=0;i<lock.length;i++){
                lock[i] = new Object();
            }
        }

        @Override
        public void run() {
            int loop = 0;
            while(true){

                //随机占用cpu资源
                int loopNum = (int)(Math.random()*100);
                int a[] = new int[loopNum];
                for(int i=0;i<loopNum;i++){
                    a[i] = (int)(Math.random()*100);
                }

                for(int i = 1;i<loopNum;i++){
                    for(int j=0;j<loopNum-1;j++){
                        if(a[j]>a[j+1]){
                            int temp;
                            temp = a[j];
                            a[j] = a[j+1];
                            a[j+1] = temp;
                        }
                    }
                }

                //随机占用磁盘I/O

                int fileloop = (int)(Math.random()*10000);

                try{
                    FileOutputStream fos = new FileOutputStream((new File("temp")));
                    for(int i= 0;i<fileloop;i++){
                        fos.write(i);
                    }
                    fos.close();
                    FileInputStream fis = new FileInputStream(new File("temp"));
                    while(fis.read()!=-1){
                    }
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }


                //随机开始持有锁

                int x = (int) (Math.random()*100);

                synchronized (lock[x]){
                    if(x%2==0){
                        try{
                            lock[x].wait(r.nextInt(10));
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }else{
                        lock[x].notifyAll();
                    }
                }

                //随机开始占用内存

                int memSize = (int)(Math.random()*100);
                Vector v  = new Vector();
                for(int i = 0;i<memSize;i++){
                    byte[] b = new byte[memSize*memSize];
                    v.add(b);
                }

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = (int)(Math.random()*100);
        System.out.println("线程数:"+threadNum);
        for(int i=0;i<threadNum;i++){
            new Thread(new HoldCPUTask()).start();
        }

    }
}
