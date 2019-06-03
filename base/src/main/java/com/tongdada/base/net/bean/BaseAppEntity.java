package com.tongdada.base.net.bean;

import android.text.TextUtils;



/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/7/30 19:03
 * <p>
 */
public class BaseAppEntity<T> implements ExBaseEntity {
    //todo 每一个系统对应的数据模型，都有一个独立的泛型类，统一处理基础的数据 都必须实现接口类ExBaseEntity
    /**
     * success : true
     * code : 0
     * msg :
     * content : {}
     */

    private boolean success;
    private String code;
    private String message;
    private T model;

    @Override
    public boolean isSuccessful() {
        return TextUtils.equals("0", code);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public boolean isExpireLogin() {
        return TextUtils.equals(BaseExpireLoginCode.CODE_APP, code);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public T getContent() {
        return model;
    }

    public void setContent(T model) {
        this.model = model;
    }
}
