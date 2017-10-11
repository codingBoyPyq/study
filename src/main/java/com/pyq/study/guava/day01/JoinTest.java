package com.pyq.study.guava.day01;

import com.google.common.base.Joiner;

import java.util.HashSet;

/**
 * Created by pangyueqiang on 16/9/18.
 */
public class JoinTest {
    public static void main(String[] args) {
        HashSet<Long> set = new HashSet<>();
        Joiner joiner = Joiner.on(",").skipNulls();
        System.out.println("***|"+joiner.join(set)+"|***");
        /*
        2016-09-18 16:43:04,585 | WARN  | Thread-36        | KafkaAppender                    | 29 - kafka - 1.2.34 | Can't send event to Kafka broker
org.apache.kafka.common.errors.RecordTooLargeException: The message is 5937305 bytes when serialized which is larger than the maximum request size you have configured with the max.request.size configuration
         */
    }
}
