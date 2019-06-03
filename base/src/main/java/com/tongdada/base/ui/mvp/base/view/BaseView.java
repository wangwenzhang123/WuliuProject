package com.tongdada.base.ui.mvp.base.view;

import android.content.Intent;
import android.os.Bundle;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:22
 * @change
 */
public interface BaseView {
    /**
     * 显示加载框
     */
    void showLoadingDialog();

    /**
     * 隐藏加载框
     */
    void hideLoadingDialog();

    /**
     * 提示信息
     * @param msg
     */
    void showMessage(String msg);
    /**
     * 关闭页面
     */
    void finishActivity();

    /**
     * 关闭页面并返回结果
     */
    void finishActivityForResult(int resultCode, Intent data);
    /**
     * 跳转界面
     */
    void routerIntent(String path, Bundle bundle);

    /**
     * show Toast
     * @param ms
     */
    void showToast(String ms);
}
