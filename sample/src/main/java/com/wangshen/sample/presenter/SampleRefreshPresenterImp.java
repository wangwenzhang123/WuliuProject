package com.tongdada.sample.presenter;

import android.os.Handler;

import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshPresenter;
import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.sample.SampleBean;
import com.tongdada.sample.data.SampleDataSource;

import io.reactivex.functions.Consumer;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/26 9:16
 * @change 由于每个项目的请求刷新的接口参数不同，所以由实现方自己的activity跟prensenter进行传值交互，pager有框架内部维护
 */
public class SampleRefreshPresenterImp extends BaseRecyclerRefreshPresenter<SampleRefreshContact.View,SampleBean.ResultBean> implements SampleRefreshContact.Presenter{
    @Override
    public void onRefresh(final RequestCallback<SampleBean.ResultBean> callback) {
        sampleDataSource.sampleRequest(""+getCurrentPage())
                .compose(this.<BaseAppEntity<SampleBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<SampleBean>>() {
                    @Override
                    public void accept(final BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(sampleBeanBaseAppEntity.getContent().getResult());
                            }
                        },3000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFail(throwable.getMessage());
                            }
                        },3000);

                    }
                });

    }

    @Override
    public void onLoadMore(final RequestCallback<SampleBean.ResultBean> callback) {
        sampleDataSource.sampleRequest(""+getCurrentPage())
                .compose(this.<BaseAppEntity<SampleBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<SampleBean>>() {
                    @Override
                    public void accept(final BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(sampleBeanBaseAppEntity.getContent().getResult());
                            }
                        },3000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFail(throwable.getMessage());
                            }
                        },3000);

                    }
                });
    }
    private SampleDataSource sampleDataSource;
    public SampleRefreshPresenterImp() {
        sampleDataSource=new SampleDataSource();
    }
}
