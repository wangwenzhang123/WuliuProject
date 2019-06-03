package com.tongdada.base.util;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: Liujunyong .
 * date:  2018/9/4.
 */
public class RxUtils {

    private static <T> ObservableTransformer<T, T> schedulerTransformer(final Scheduler scheduler) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(scheduler)
                        //第二个参数控制当发生error时候是否清空数据流 true不清空
                        .observeOn(AndroidSchedulers.mainThread(), false);
            }
        };
    }

    public static <T> ObservableTransformer<T, T> io() {
        return schedulerTransformer(Schedulers.io());
    }

    private static <T> FlowableTransformer<T, T> schedulerTransformerF(final Scheduler scheduler) {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> flowable) {
                return flowable
                        .subscribeOn(scheduler)
                        .observeOn(AndroidSchedulers.mainThread(), false);
            }
        };
    }

    public static <T> FlowableTransformer<T, T> ioF() {
        return schedulerTransformerF(Schedulers.io());
    }
}
