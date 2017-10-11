package com.pyq.study.baseJava;




import com.mysql.jdbc.TimeUtil;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pangyueqiang on 16/7/18.
 */
public class EqualsTest {
    protected static FastDateFormat fastDateFormat;
    private final static String PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static void main (String[] args) throws Exception
    {
//        //longEquals();
//        String a = "abcd";
//        String b = "你好";
//        System.out.println(a.getBytes("utf-8").length);
//        System.out.println(b.getBytes("utf-8").length);

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2017-04-11"));
//        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
//        String monday = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
//        System.out.println(monday);

//        Double o = true ? new Integer(1) : new Double(2.0);
//        System.out.println(o);
//
//        List<Long> list = new ArrayList<>();
//        list.add(123l);
//        list.add(1234567l);
//        list.add(345261l);

//        Long userId = 345261l;
//        System.out.println(list.remove(userId));
//        System.out.println(list.get(0));
        System.out.println(formatDate(new Date()));
    }
    public static void stringEquals(){
        String a = "";
        String b = null;
        String c = "avc";
        String d = "";
        System.out.println("".equals(b));
        System.out.println("".equals(d));
        System.out.println(a.equals(d));
    }
    public static void longEquals(){
        Double a = 0d;
        System.out.println(0==a);
        System.out.println(a.equals(0));
    }

    protected static String formatDate(Date parameter) {
        if (fastDateFormat == null) {
            fastDateFormat = FastDateFormat.getInstance(PATTERN);
        }
        StringBuffer buf = new StringBuffer();
        buf.append(fastDateFormat.format(parameter));
        int nanos = (int) ((parameter.getTime() % 1000) * 1000000);
        if (nanos != 0) {
            buf.append('.');
            //官方驱动这里是通过版本去format的,mysql版本大于5.6.4才取毫秒
            buf.append(TimeUtil.formatNanos(nanos, true, true));
        }
        return buf.toString();
    }


}
