package com.pyq.study.algorithm;

/**
 * Created by pangyueqiang on 17/8/24.
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Fibonacci {
    public int find(int n) {
        if(n==1|n==2)
            return 1;
        else{
            int fNum_pre_pre = 1;
            int fNum_pre = 1;
            int fNum_n = 0;
            for(int i = 3;i<=n;i++){
                fNum_n = fNum_pre_pre + fNum_pre;
                fNum_pre_pre=fNum_pre;
                fNum_pre = fNum_n;
            }
            return fNum_n;
        }
    }
}
