package com.tongdada.base.ui.mvp.base.presenter;

import android.text.TextUtils;

import com.tongdada.base.net.bean.ExBaseEntity;
import com.tongdada.base.net.exception.KResultException;
import com.tongdada.base.net.transformer.KResponseTransformer;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.base.ui.mvp.base.view.ExRxBasePresenter;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:22
 * @change
 */
public class BasePresenter<V extends BaseView> implements ExRxBasePresenter{
    private CompositeDisposable mCompositeDisposable;
    private WeakReference<V> view;
    public  void attchView(V view) {
        this.view = new WeakReference<>(view);
    }
    public void detachView(){
        if (view != null) {
            view.clear();
            view = null;
        }
        unDisposable();
    }



    public boolean isViewAttached() {
        return view != null && view.get() != null;
    }



    public V getView() {
        return view != null ? view.get() : null;
    }
    @Override
    public void addDisposable(Disposable subscription) {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult() {
        return handleEverythingResult(true);
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult(final boolean showLoading) {
        return handleEverythingResult(showLoading, "");
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult(final String loadingMessage) {
        return handleEverythingResult(true, loadingMessage);
    }

    private <T extends ExBaseEntity> ObservableTransformer<T, T> handleEverythingResult(final boolean showLoading, final String loadingMessage) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return handleCommon(upstream, showLoading, loadingMessage, false);
            }
        };
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult() {
        return handleOnlyNetworkResult(true);
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult(final String loadingMessage) {
        return handleEverythingResult(true, loadingMessage);
    }

    @Override
    public <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult(final boolean showLoading) {
        return handleEverythingResult(showLoading, "");
    }

    private <T extends ExBaseEntity> ObservableTransformer<T, T> handleOnlyNetworkResult(final boolean showLoading, final String loadingMessage) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return handleCommon(upstream, showLoading, loadingMessage, true);
            }
        };
    }

    private <T extends ExBaseEntity> Observable<T> handleCommon(Observable<T> upstream, final boolean showLoading, final String loadingMessage, final boolean handleOnlyNetworkResult) {
        return upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new KResponseTransformer.ErrorResumeFunction<T>())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached() && showLoading) {
                            getView().showLoadingDialog();
                        }
                        addDisposable(disposable);
                    }
                })
                .doOnNext(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        if (isViewAttached() && showLoading) {
                            getView().hideLoadingDialog();
                        }
                        //统一处理登录态失效
                        if (t.isExpireLogin()) {
                            //getView().reLogin();
                        }
                    }
                })
                .doOnNext(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        //是否处理业务异常
                        if (!t.isSuccessful() && !handleOnlyNetworkResult) {
                            throw new KResultException(t.getCode(), t.getMessage());
                        }
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (isViewAttached() && showLoading) {
                            getView().hideLoadingDialog();
                        }
                    }
                });
    }

    @Override
    public Consumer<Throwable> handleThrowableConsumer(final String defaultErrorInfo) {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                handleThrowableMessage(throwable, defaultErrorInfo);
            }
        };
    }

    public void handleThrowableMessage(Throwable throwable, final String defaultErrorInfo) {
        if (isViewAttached()) {
            getView().hideLoadingDialog();
            String message = TextUtils.isEmpty(throwable.getMessage()) ? defaultErrorInfo : throwable.getMessage();
            getView().showToast(message);
        }
    }

}
