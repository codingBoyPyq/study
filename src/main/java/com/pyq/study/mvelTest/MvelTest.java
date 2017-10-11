package com.pyq.study.mvelTest;

import com.pyq.study.serialization.JsonUtils;
import org.apache.commons.collections.map.HashedMap;
import org.mvel2.MVEL;

import java.util.Map;

/**
 * Created by pangyueqiang on 17/6/13.
 */
public class MvelTest {

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();
        ClassC classC = new ClassC();

        classA.setAAge(1);
        classA.setAName("a");

        classB.setBAge(2);
        classB.setBName("你好");

        classA.setClassB(classB);

        String json = "{\"enterprise_id\":47772,\"page_from_url\":\"https://www.baidu.com/baidu.php?sc.1aYK00jK79maElCNtvGrgvMU8hfM-iTsIApqZ_jPs9FyUlLZlkGSHq28oQmAQZno9Tx22G2CYSOdGQE84GuG6NtSc5m1xxYUsVxayeEz-RU3r8SfUUsnf8vq-2RF8f0adcnh8IgOnShz0NMx-0lp6B3TqqCrUkMbhk_rHRwtf9sbKZtV70.7D_aWA41MrTBKPva7h6qYyHz_t_-TALMLEiO2OPzL_EkstVvKhQw64I---hOFy_HZW__eQ2Sh1-zI5QWdQjPakbtxZI8R0.U1Yd0ZDq8xJtYoSJVtyYtqAMdQp11QLnYOY0IjLRVo5nET1HOfKGUHYznWR0u1dsTLFMUhFJ0ZNG5yF9pywdUAY0TA-b5HD0mv-b5Hn3P6KVIjYknjDLg1DsnH-xn1msnfKopHYs0ZFY5HTkn0K-pyfq0AFG5HcsP7tkPHR0UynqPjm3PWczrHRYg1Kxn0KkTA-b5H00TyPGujYs0ZFMIA7M5H00ULu_5fK9mWYsg100ugFM5H00TZ0qPj6sn1mzPH6v0A4vTjYsQW0snj0snj0s0AdYTjYs0AwbUL0qn0KzpWYs0Aw-IWdsmsKhIjYs0ZKC5H00ULnqn0KBI1Ykn0K8IjYs0ZPl5fKYIgnqnHfkPWDYPHfkPjTvrHmLPj61nsKzug7Y5HDYrHcvPHmknW01rHc0Tv-b5yDYPymsPWK-nj0snj9bnvn0mLPV5H7DrRckPDNKPH97rjcdwRf0mynqnfKsUWYs0Z7VIjYs0Z7VT1Ys0ZGY5H00UyPxuMFEUHYsg1Kxn0Kbmy4dmhNxTAk9Uh-bT1Ysg1Kxn0KbIA-b5H00ugwGujYVnfK9TLKWm1Ys0ZNspy4Wm1Ys0Z7VuWYs0AuWIgfqn0KhXh6qn0Khmgfqn0KlTAkdT1Ys0A7buhk9u1Yk0Akhm1Ys0APzm1YYrHmkr0&ck=1036.8.96.336.601.229.152.561&shh=www.baidu.com&sht=78040160_26_pg&us=5.24870.2.0.1.302.0.13&wd=国家开放大学远程教育&issp=1&f=8&ie=utf-8&rqlang=cn&tn=78040160_26_pg&inputT=10020&bc=110101\",\"page_land_url\":\"http://www.lsoooooo.com/education2.0.21/index.html?beijing_baipc_duanyu_8000921\",\"page_land_title\":\"联硕教育\",\"page_conv_url\":\"http://www.lsoooooo.com/education2.0.21/index.html?beijing_baipc_duanyu_8000921\",\"page_conv_title\":\"联硕教育\",\"search_engine_name\":\"baidu\",\"search_engine_kw\":\"国家开放大学远程教育\",\"visitor_ip\":\"125.33.211.64\",\"visitor_location\":\"北京\",\"visitor_os\":\"Windows XP\",\"visitor_browser\":\"Chrome\",\"visitor_tags\":[],\"client_id\":50716743,\"client_info\":{\"_m_track_id\":\"0145b730257311e78ba402fa39e25136\",\"visitor_name\":\"#79253\"},\"agent_account\":\"907710020@qq.com\",\"agent_name\":\"倩倩\",\"agent_ID\":\"100006\",\"conv_id\":68067008,\"conv_start_tm\":\"2017-04-20 10:42:33.465659\",\"conv_end_tm\":\"2017-04-20 10:43:05.976460\",\"conv_content\":[{\"from\":\"agent\",\"timestamp\":\"2017-04-20 10:42:35.494490\",\"content\":\"[推广消息]\"}],\"conv_agent_msg_count\":0,\"conv_visitor_msg_count\":0}";
        Map<String,Object> map = new HashedMap();

        map = JsonUtils.unformatJSON(json,Map.class);

        System.out.println(MVEL.eval("client_info.visitor_name==\"#79253\"",map));

        System.out.println(MVEL.eval("client_info[qq]==\"#79253\"",map));

    }
}
