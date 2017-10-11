package com.pyq.study.serialization;

import lombok.Data;

/**
 * Created by pangyueqiang on 17/5/25.
 */
@Data
public class TestClass {
    private Integer num;
    private Integer jobProvicy;
    private Integer provicy;


    public Integer getJobProvicy(){
        if(this.provicy==1)
            this.jobProvicy = 1;
        else if(this.provicy==2)
            this.jobProvicy = 2;
        return  this.jobProvicy;
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.setProvicy(2);
        System.out.println(JsonUtils.formatJSON(tc));
    }
}
