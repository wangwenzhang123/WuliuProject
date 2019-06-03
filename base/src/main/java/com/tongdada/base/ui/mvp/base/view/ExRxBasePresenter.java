package com.tongdada.base.ui.mvp.base.view;


import com.tongdada.base.net.bean.ExBaseEntity;

import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/4 14:06
 * <p>
 */
public interface ExRxBasePresenter {

    /**
     * 管理订阅关系
     */
    void addDisposable(Disposable subscription);

    /**
     * 取消订阅关系
     */
    void unDisposable();

    /**
     * 统一处理所有异常，报错接口异常和业务异常
     */
    <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult();

    /**
     * 统一处理所有异常，报错接口异常和业务异常
     */
    <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult(String loadingMessage);


    /**
     * 统一处理所有异常，报错接口异常和业务异常
     */
    <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult(boolean showLoading);

    /**
     * 处理报错接口，业务异常不处理
     */
    <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult();

    /**
     * 处理报错接口，业务异常不处理
     */
    <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult(String loadingMessage);

    /**
     * 统一处理所有异常，报错接口异常和业务异常
     */
    <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult(boolean showLoading);
    /**
     * 异常提示统一处理入口
     *
     * @param defaultErrorInfo 默认文案
     * @return
     */
    Consumer<Throwable> handleThrowableConsumer(String defaultErrorInfo);
}
