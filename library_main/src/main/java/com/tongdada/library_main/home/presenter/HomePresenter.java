package com.tongdada.library_main.home.presenter;

import com.example.library_commen.model.LogisticsRequestBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.model.RequestRegisterBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.respose.BannerBean;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangshen on 2019/5/17.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{


    @Override
    public void getMixStationById() {
        MainApiUtils.getMainApi().getLogiById(CommenUtils.getIncetance().getUserBean().getCompanyId())
                .compose(this.<BaseAppEntity<LogisticsRequestBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<LogisticsRequestBean>>() {
                    @Override
                    public void accept(BaseAppEntity<LogisticsRequestBean> objectBaseAppEntity) throws Exception {
                        if (objectBaseAppEntity != null && objectBaseAppEntity.getContent() != null){
                            CommenUtils.getIncetance().setRequestBean(objectBaseAppEntity.getContent());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
    @Override
    public void shuffling() {
        MainApiUtils.getMainApi().shuffling().
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        if (bannerBean != null && bannerBean.getRows() != null && bannerBean.getRows().size() > 0){
                            getView().setBannerData(bannerBean.getRows());
                        }else {
                            getView().showToast("暂无数据");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

}
