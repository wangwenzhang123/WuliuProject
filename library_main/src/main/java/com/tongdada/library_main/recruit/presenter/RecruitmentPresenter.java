package com.tongdada.library_main.recruit.presenter;

import android.os.Handler;


import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

import io.reactivex.functions.Consumer;

public class RecruitmentPresenter extends BasePresenter<RecruitmentContract.View> implements RecruitmentContract.Presenter {
    private int index=0;
    @Override
    public void getData(final boolean is) {
        if (is){
            index=1;
        }else {
            index++;
        }
        MainApiUtils.getMainApi().listPosition("",CommenUtils.getIncetance().getRequestBean().getId(), "",index)
                .compose(this.<PagenationBase<RecruitmentBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<RecruitmentBean>>() {
                    @Override
                    public void accept(final PagenationBase<RecruitmentBean> carOrderBeanPagenationBase) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (is){
                                    getView().getAdapter().setNewData(carOrderBeanPagenationBase.getPagenation().getList());
                                    getView().getRefrshView().finishRefresh();
                                }else {
                                    getView().getAdapter().addData(carOrderBeanPagenationBase.getPagenation().getList());
                                    getView().getRefrshView().finishLoadMore();
                                }

                            }
                        },2000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                        getView().getRefrshView().finishRefresh();
                        getView().getRefrshView().finishLoadMore();
                    }
                });
    }

    @Override
    public void getData(String userid,boolean is) {

    }

}
