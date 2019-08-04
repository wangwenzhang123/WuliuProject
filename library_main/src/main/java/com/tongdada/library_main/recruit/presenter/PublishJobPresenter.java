package com.tongdada.library_main.recruit.presenter;

import android.text.TextUtils;

import com.example.library_commen.event.EventJobBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.RecuritListBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApi;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;
import com.tongdada.library_main.recruit.respose.ResumeBean;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;

public class PublishJobPresenter extends BasePresenter<PublishJobContract.View> implements PublishJobContract.Presenter {

    @Override
    public void publishJob(RecuritListBean publishJobRequestBean) {
        if (TextUtils.isEmpty(publishJobRequestBean.getId())){
            MainApiUtils.getMainApi().publishPosition(UserMapUtils.getPublishJobMap(publishJobRequestBean))
                    .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                        @Override
                        public void accept(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                            EventBus.getDefault().post(new EventJobBean());
                            getView().finishActivity();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getView().showToast(throwable.getMessage());
                        }
                    });
        }else {
            MainApiUtils.getMainApi().editPosition(UserMapUtils.getPublishJobMap(publishJobRequestBean))
                    .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                    .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                        @Override
                        public void accept(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                            EventBus.getDefault().post(new EventJobBean());
                            getView().finishActivity();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getView().showToast(throwable.getMessage());
                        }
                    });
        }

    }

    @Override
    public void cancelJob(String id) {
        MainApiUtils.getMainApi().cancelPosition(id)
                .compose(this.<PagenationBase<RecruitmentBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<RecruitmentBean>>() {
                    @Override
                    public void accept(PagenationBase<RecruitmentBean> recruitmentBeanPagenationBase) throws Exception {
                        EventBus.getDefault().post(new EventJobBean());
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void applyJob(String id) {
        MainApiUtils.getMainApi().applyPosition(id, CommenUtils.getIncetance().getUserBean().getId())
                .compose(this.<PagenationBase<ResumeBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<ResumeBean>>() {
                    @Override
                    public void accept(PagenationBase<ResumeBean> resumeBeanPagenationBase) throws Exception {
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
