package com.tongdada.base.view.empty;

import android.view.View;

/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/9/3 18:22
 * <p>
 */
public interface IStateLayout<V> {

    /**
     * 是否启用状态切换
     *
     * @param enabled 是否启用
     */
    void setEnableStateLayout(boolean enabled);

    /**
     * 设置空状态
     */
    V showEmptyView();

    /**
     * 设置空状态
     */
    V showEmptyView(View view);

    /**
     * 设置空状态
     *
     * @param msgId 空提示
     */
    V showEmptyView(int msgId);

    /**
     * 设置空状态
     *
     * @param msgId 空提示
     * @param imgId 空图标
     */
    V showEmptyView(int msgId, int imgId);

    /**
     * 设置空状态
     *
     * @param msg 空提示
     */
    V showEmptyView(String msg);

    /**
     * 设置空状态
     *
     * @param msg   空提示
     * @param imgId 空图标
     */
    V showEmptyView(String msg, int imgId);

    /**
     * 设置空状态时显示Button
     */
    V showEmptyViewButton(View.OnClickListener listener);

    /**
     * 设置空状态显示Button
     *
     * @param resId btn内容
     */
    V showEmptyViewButton(int resId, View.OnClickListener listener);

    /**
     * 设置空状态显示Button
     *
     * @param btnText btn内容
     */
    V showEmptyViewButton(String btnText, View.OnClickListener listener);


    /**
     * 获取控件元素
     */
    StateLayout.EmptyViewHolder getEmptyViewHolder();


    /**
     * 设置网络错误状态
     */
    V showErrorView();

    /**
     * 设置网络错误状态
     */
    V showErrorView(View view);

    /**
     * 设置网络错误状态
     *
     * @param msgId 错误提示
     */
    V showErrorView(int msgId);

    /**
     * 设置网络错误状态
     *
     * @param msgId 错误提示
     * @param imgId 错误图标
     */
    V showErrorView(int msgId, int imgId);

    /**
     * 设置网络错误状态
     *
     * @param msg 错误提示
     */
    V showErrorView(String msg);

    /**
     * 设置网络错误状态
     *
     * @param msg   错误提示
     * @param imgId 错误图标
     */
    V showErrorView(String msg, int imgId);

    /**
     * 设置网络错误状态
     */
    V showErrorViewButton(View.OnClickListener listener);

    /**
     * 设置网络错误状态
     *
     * @param btnText btn内容
     */
    V showErrorViewButton(String btnText, View.OnClickListener listener);

    /**
     * 设置网络错误状态
     *
     * @param resId btn内容
     */
    V showErrorViewButton(int resId, View.OnClickListener listener);

    /**
     * 获取控件元素
     */
    StateLayout.ErrorViewHolder getErrorViewHolder();


    /**
     * 设置loading状态
     */
    V showLoadingView();

    /**
     * 设置loading状态
     */
    V showLoadingView(View view);

    /**
     * 设置loading状态
     */
    V showLoadingView(String msg);

    /**
     * 获取控件元素
     */
    StateLayout.LoadingViewHolder getLoadingViewHolder();


    /**
     * 设置隐藏
     */
    V hideStateView();
}
