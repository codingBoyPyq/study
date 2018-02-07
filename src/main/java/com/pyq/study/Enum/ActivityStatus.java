package com.pyq.study.Enum;

public enum ActivityStatus {
    one(1),
    two(2);
    public Integer id;
    ActivityStatus(Integer id){
        this.id = id;
    }
}
