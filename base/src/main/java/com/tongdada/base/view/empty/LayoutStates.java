package com.tongdada.base.view.empty;

/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/9/3 18:22
 * <p>
 */
public interface LayoutStates {
    /**
     * 加载
     */
    int STATE_LOADING = 1;
    /**
     * 空数据
     */
    int STATE_EMPTY = 2;
    /**
     * 错误
     */
    int STATE_ERROR = 3;

    /**
     * 隐藏
     */
    int STATE_HIDE = 4;
}
