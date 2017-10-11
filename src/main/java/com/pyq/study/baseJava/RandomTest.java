package com.pyq.study.baseJava;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * Created by pangyueqiang on 17/4/21.
 */
public class RandomTest {
    public static void main(String[] args) {
//       String str = "/api/activity/historical/bd42117818ddb3f5";
//        System.out.println(str.lastIndexOf("/"));


        FastDateFormat fdf = FastDateFormat.getInstance("yyyy年MM月dd日");
        System.out.println(fdf.format(-7894567997690l));
    }
}
