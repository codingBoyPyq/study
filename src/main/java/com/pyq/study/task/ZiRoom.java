package com.pyq.study.task;

import com.alibaba.fastjson.JSON;
import com.pyq.study.mailServer.SentMail;
import com.pyq.study.serialization.JsonUtils;
import com.sun.javafx.collections.MappingChange;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZiRoom {
    public static void main(String[] args) {
        while(true) {
            String result = "";
            BufferedReader in = null;
            try {
                String urlNameString = "http://www.ziroom.com/detail/info?id=62365221&house_id=60373276";
                URL realUrl = new URL(urlNameString);
                // 打开和URL之间的连接
                URLConnection connection = realUrl.openConnection();
                // 设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("Host", "www.ziroom.com");
                connection.setRequestProperty("Referer", "http://www.ziroom.com/z/vr/62365221.html");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
                connection.setRequestProperty("Cookie", "detailauth=8995308ac7cd7a31149b863af7f584ab%7C1560665040; CURRENT_CITY_CODE=110000; __utm_source=pinzhuan; __utm_medium=baidu; ZIROOM_PHONE=9; CURRENT_CITY_NAME=%E5%8C%97%E4%BA%AC; gr_user_id=2e08541c-96d4-4e6e-964c-9b57dc4a3489; mapType=%20; PHPSESSID=ldcih89gco8je7d4qm6btlmqc2; passport_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiJjODNkNjdmMy04OGMyLTQ3YzYtOWM1Mi0xYWU2OTk3MzYwOWMiLCJ0eXBlIjoyLCJsZW5ndGgiOjEyMCwidG9rZW4iOiIwNjkxMzc0YS1mMjI1LTRhMDYtYjY5OS00NTRjN2UzZmIyM2QiLCJjcmVhdGVUaW1lIjoxNTYwNjYwMzEyNTcyfQ.Iw36sdeEqU7s_udhL4WjmlsdpTwvJ_xdjShKSWG2EwQ; meeta=0; gr_session_id_8da2730aaedd7628=fcfb6401-990b-43c3-9b9d-7d7c00a9817e; Hm_lvt_4f083817a81bcb8eed537963fc1bbf10=1560660083,1560665000; gr_session_id_8da2730aaedd7628_fcfb6401-990b-43c3-9b9d-7d7c00a9817e=true; Hm_lpvt_4f083817a81bcb8eed537963fc1bbf10=1560665014; BJ_nlist=%7B%2262365221%22%3A%7B%22id%22%3A%2262365221%22%2C%22sell_price%22%3A3090%2C%22title%22%3A%22%5Cu6d77%5Cu6dc0%5Cu7530%5Cu67516%5Cu53f7%5Cu7ebf%5Cu7530%5Cu6751%5Cu4e2d%5Cu56fd%5Cu623f%5Cu5b504%5Cu5c45%5Cu5ba4-%5Cu5357%5Cu5367%22%2C%22add_time%22%3A1560665040%2C%22usage_area%22%3A22.7%2C%22floor%22%3A%225%22%2C%22floor_total%22%3A%229%22%2C%22room_photo%22%3A%22g2m2%5C%2FM00%5C%2F15%5C%2FB3%5C%2FCtgFCFz-WruAIi8-AAsR252a4Bo268.JPG%22%2C%22city_name%22%3A%22%5Cu5317%5Cu4eac%22%7D%2C%2261729948%22%3A%7B%22id%22%3A%2261729948%22%2C%22sell_price%22%3A2030%2C%22title%22%3A%22%5Cu623f%5Cu5c71%5Cu957f%5Cu9633%5Cu623f%5Cu5c71%5Cu7ebf%5Cu7bf1%5Cu7b06%5Cu623f%5Cu82ad%5Cu857e%5Cu96e8%5Cu60a6%5Cu90fd%5Cu5357%5Cu533a3%5Cu5c45%5Cu5ba4-%5Cu5357%5Cu5367%22%2C%22add_time%22%3A1560660376%2C%22usage_area%22%3A13.6%2C%22floor%22%3A%227%22%2C%22floor_total%22%3A%229%22%2C%22room_photo%22%3A%22g2m2%5C%2FM00%5C%2F0E%5C%2F75%5C%2FCtgFCVz9DU6ATSxKAAwQdfgBm9g721.jpg%22%2C%22city_name%22%3A%22%5Cu5317%5Cu4eac%22%7D%2C%22216150%22%3A%7B%22id%22%3A%22216150%22%2C%22sell_price%22%3A3290%2C%22title%22%3A%22%5Cu6d77%5Cu6dc0%5Cu7530%5Cu67516%5Cu53f7%5Cu7ebf%5Cu7530%5Cu6751%5Cu4e2d%5Cu56fd%5Cu623f%5Cu5b504%5Cu5c45%5Cu5ba4-%5Cu5357%5Cu5367%22%2C%22add_time%22%3A1560660237%2C%22usage_area%22%3A24.64%2C%22floor%22%3A%226%22%2C%22floor_total%22%3A%229%22%2C%22room_photo%22%3A%22g2m2%5C%2FM00%5C%2F34%5C%2F6F%5C%2FCtgFCF0EewSAJEFVAAH25Dl5EtY16.jpeg%22%2C%22city_name%22%3A%22%5Cu5317%5Cu4eac%22%7D%7D");

                connection.setRequestProperty("user-agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                // 建立实际的连接
                connection.connect();
                // 定义 BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } catch (Exception e) {
                System.out.println("发送GET请求出现异常！" + e);
                e.printStackTrace();
            }
            // 使用finally块来关闭输入流
            finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Map<String, Object> map = JSON.parseObject(result, Map.class);
            ((Map) map.get("data")).get("air_part");
            Object airPart = ((Map) map.get("data")).get("air_part");
            String status = (String) ((Map) (((Map) airPart).get("vanancy"))).get("status");
            System.out.println("time:"+ System.currentTimeMillis() +" status:"+status);
            if (!"可约看".equals(status)) {
                try {
                    SentMail.sent("自如房子可预订", "手慢无");
                } catch (Exception e) {

                }
            }
            try {
                Thread.sleep(10000);
            }catch (Exception e){

            }
        }
    }
}
