package com.pyq.study.lambda;

public class Model {

    public Model(int no, Integer dealId) {
        this.no = no;
        this.dealId = dealId;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    private int no;
    private Integer dealId;

    public Model(Integer dealId) {
        this.dealId = dealId;
    }
}
