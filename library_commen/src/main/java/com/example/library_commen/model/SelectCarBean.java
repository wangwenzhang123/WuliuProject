package com.example.library_commen.model;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/5 16:12
 * @change
 */
public class SelectCarBean {
    private String id;
    private String carNo;
    private String amount;
    public SelectCarBean(String id, String carNo,String amount) {
        this.id = id;
        this.carNo = carNo;
        this.amount=amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
}
