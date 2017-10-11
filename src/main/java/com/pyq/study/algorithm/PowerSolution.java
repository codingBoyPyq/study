package com.pyq.study.algorithm;

/**
 * Created by pangyueqiang on 17/8/29.
 */
public class PowerSolution {
    public double Power(double base, int exponent) {
        if(exponent==0)
            return 1;
        else if(exponent<0){
            return 1/ powerUnsigned(base,-exponent);
        }
        else{
            return powerUnsigned(base,exponent);
        }
    }
    public double powerUnsigned(double base, int exponent){
        if(exponent==1)
            return base;
        if(exponent==2)
            return base*base;
        double temp = Power(base,exponent>>>1);
        double sum = temp*temp;
        return ((exponent&1)==0)?sum:sum*base;
    }
}
