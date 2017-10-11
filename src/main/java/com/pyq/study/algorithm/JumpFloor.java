package com.pyq.study.algorithm;

/**
 * Created by pangyueqiang on 17/8/29.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 f(1) = 1
 f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
 f(3) = f(3-1) + f(3-2) + f(3-3) 
 ...
 f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n) 
 */
public class JumpFloor {

    public int JumpFloorII(int target) {
        return power_2(target-1);
    }
    public int power_2(int n){
        if(n==0)
            return 1;
        if(n==1)
            return 2;
        int tempSum = power_2(n/2);
        int sum = tempSum*tempSum;
        return (n%2==0)?sum:sum*2;
    }
}
