package com.tongdada.sample.presenter;

import com.tongdada.base.net.base.ExBaseObserver;
import com.tongdada.base.net.bean.BaseAppEntity;

import com.tongdada.base.net.exception.KRetrofitException;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerListPresenter;

import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.sample.SampleBean;
import com.tongdada.sample.data.SampleDataSource;

import io.reactivex.functions.Consumer;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:04
 * @change
 */
public class SampleListPresenterImp extends BaseRecyclerListPresenter<SampleListContact.View,SampleBean.ResultBean> implements SampleContact.Presenter{
    private SampleDataSource sampleDataSource;
    public SampleListPresenterImp() {
        sampleDataSource=new SampleDataSource();
    }

    @Override
    public void getSampleData(String m) {
      /*  sampleDataSource.sampleRequest(m)
                .compose(this.<BaseAppEntity<SampleBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<SampleBean>>() {
                    @Override
                    public void accept(BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) throws Exception {
                        getCallback().onSuccess(sampleBeanBaseAppEntity.getContent().getResult());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getCallback().onFail(throwable.getMessage());
                    }
                });*/
        sampleDataSource.sampleRequest(m)
                .compose(this.<BaseAppEntity<SampleBean>>handleEverythingResult()).subscribe(new Consumer<BaseAppEntity<SampleBean>>() {
            @Override
            public void accept(BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
        sampleDataSource.sampleRequest(m)
                .compose(this.<BaseAppEntity<SampleBean>>handleEverythingResult())
                .subscribe(new ExBaseObserver<BaseAppEntity<SampleBean>>() {
                    @Override
                    public void onSuccess(BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) {
                        getCallback().onSuccess(sampleBeanBaseAppEntity.getContent().getResult());
                    }

                    @Override
                    public void onCodeError(BaseAppEntity<SampleBean> sampleBeanBaseAppEntity) {
                        getCallback().onFail(sampleBeanBaseAppEntity.getMessage());
                    }

                    @Override
                    public String getExpireLoginCode() {
                        return null;
                    }

                    @Override
                    public void onFailure(KRetrofitException e) {
                        getCallback().onFail(e.getMessage());
                    }

                    @Override
                    public void onExpireLogin() {

                    }
                });
    }

}
