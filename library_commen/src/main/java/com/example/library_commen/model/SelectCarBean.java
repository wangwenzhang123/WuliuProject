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

    public SelectCarBean(String id, String carNo) {
        this.id = id;
        this.carNo = carNo;
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
