package com.tongdada.library_main.recruit.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.recruit.respose.ResumeBean;

import io.reactivex.functions.Consumer;

public class ResumeCenterPresenter extends BasePresenter<ResumeCenterContract.View> implements ResumeCenterContract.Presenter {
    private String positionId="";
    private int index=1;
    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    @Override
    public void getData() {
        index =1;
        if (TextUtils.isEmpty(positionId)){
            MainApiUtils.getMainApi().listUsersOfPostion(positionId,"", CommenUtils.getIncetance().getUserBean().getCompanyId(),index)
                    .compose(this.<PagenationBase<ResumeBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<ResumeBean>>() {
                        @Override
                        public void accept(final PagenationBase<ResumeBean> carOrderBeanPagenationBase) throws Exception {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    getView().getAdapter().setNewData(carOrderBeanPagenationBase.getPagenation().getList());
                                    getView().getRefrshView().finishRefresh();
                                }
                            },2000);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getView().showToast(throwable.getMessage());
                            getView().getRefrshView().finishRefresh();
                        }
                    });
        }else {
            MainApiUtils.getMainApi().listUsersOfPostion(positionId,"","",index)
                    .compose(this.<PagenationBase<ResumeBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<ResumeBean>>() {
                        @Override
                        public void accept(final PagenationBase<ResumeBean> carOrderBeanPagenationBase) throws Exception {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    getView().getAdapter().setNewData(carOrderBeanPagenationBase.getPagenation().getList());
                                    getView().getRefrshView().finishRefresh();
                                }
                            },2000);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getView().showToast(throwable.getMessage());
                            getView().getRefrshView().finishRefresh();
                        }
                    });
        }

    }

    @Override
    public void loadMore() {
        index++;
        if (TextUtils.isEmpty(positionId)){
            MainApiUtils.getMainApi().listUsersOfPostion(positionId,"", CommenUtils.getIncetance().getUserBean().getCompanyId(),index)
                    .compose(this.<PagenationBase<ResumeBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<ResumeBean>>() {
                        @Override
                        public void accept(final PagenationBase<ResumeBean> carOrderBeanPagenationBase) throws Exception {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    getView().getAdapter().addData(carOrderBeanPagenationBase.getPagenation().getList());
                                    getView().getRefrshView().finishRefresh();
                                }
                            },2000);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getView().showToast(throwable.getMessage());
                            getView().getRefrshView().finishLoadMore();
                        }
                    });
        }else {
            MainApiUtils.getMainApi().listUsersOfPostion(positionId,"","",index)
                    .compose(this.<PagenationBase<ResumeBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<ResumeBean>>() {
                        @Override
                        public void accept(final PagenationBase<ResumeBean> carOrderBeanPagenationBase) throws Exception {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    getView().getAdapter().addData(carOrderBeanPagenationBase.getPagenation().getList());
                                    getView().getRefrshView().finishLoadMore();
                                }
                            },2000);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getView().showToast(throwable.getMessage());
                            getView().getRefrshView().finishLoadMore();
                        }
                    });
        }

    }
}
