package com.pyq.study.baseJava;

import com.pyq.study.Enum.ActivityStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestIdea {
    protected static final Map<Integer,ActivityStatus> enumMap = new HashMap<>();
    static {
        Arrays.stream(ActivityStatus.values()).forEach(e ->enumMap.put(e.id,e));
    }
}
