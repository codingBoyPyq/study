package com.pyq.study.time;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        int minutes = (LocalTime.now().getMinute() / 3) * 3;
//        long seed = LocalDate.now().atStartOfDay().plusHours(LocalDateTime.now().getHour()).plusMinutes(minutes)
//                .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        System.out.println(seed);
//        List<Integer> list = Lists.newArrayList(new Integer(10),new Integer(13));
//        System.out.println(getSecKillEndTime(大牌疯抢list));
        System.out.println(String.format("nihao %s,%s me ",123.00,"345"));
    }


    public static long getSecKillEndTime(List<Integer> mccTimeList) {
        LocalDateTime nowTime = LocalDateTime.now(ZoneId.systemDefault());
        LocalDateTime secondBeginTime = LocalDate.now(ZoneId.systemDefault()).atTime(mccTimeList.get(1), 0, 0);
        if (nowTime.isBefore(secondBeginTime)) {
            return secondBeginTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() - 1;
        }
        return LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli() - 1;
    }

}
