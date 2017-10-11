package com.pyq.study.algorithm;

/**
 * Created by pangyueqiang on 17/8/29.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class NumberOf1 {
    public int sum(int n) {
        int num = 0;
        while(n!=0)
        {
            int i =n & 1;
            if(i==1)
                num++;
            n = n>>>1;
        }
        return num;
    }
}
