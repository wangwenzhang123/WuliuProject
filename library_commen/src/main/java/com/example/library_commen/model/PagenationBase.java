package com.example.library_commen.model;

import android.text.TextUtils;

import com.tongdada.base.net.bean.ExBaseEntity;

/**
 * Created by wangshen on 2019/5/25.
 */

public class PagenationBase<T> implements ExBaseEntity {
    private boolean success;
    private String code;
    private String message;
    private T pagenation;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public boolean isExpireLogin() {
        return false;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean isSuccessful() {
        return TextUtils.equals("0", code);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPagenation() {
        return pagenation;
    }

    public void setPagenation(T pagenation) {
        this.pagenation = pagenation;
    }
}
