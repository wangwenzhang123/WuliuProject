package com.tongdada.library_main.resume.presenter;

import android.os.Handler;

import com.example.library_commen.model.PagenationBase;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.recruit.presenter.RecruitmentContract;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

import io.reactivex.functions.Consumer;

public class ResumeApplymentPresenter extends BasePresenter<RecruitmentContract.View> implements RecruitmentContract.Presenter {
    private int index=1;
    @Override
    public void getData(boolean is) {

    }

    @Override
    public void getData(String userid, final boolean is) {
        if (is){
            index=1;
        }else {
            index++;
        }
       MainApiUtils.getMainApi().listPostionsOfUser(userid,index)
               .compose(this.<PagenationBase<RecruitmentBean>>handleEverythingResult())
               .subscribe(new Consumer<PagenationBase<RecruitmentBean>>() {
                   @Override
                   public void accept(final PagenationBase<RecruitmentBean> recruitmentBeanPagenationBase) throws Exception {
                       new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               if (is){
                                   getView().getAdapter().setNewData(recruitmentBeanPagenationBase.getPagenation().getList());
                                   getView().getRefrshView().finishRefresh();
                               }else {
                                   getView().getAdapter().addData(recruitmentBeanPagenationBase.getPagenation().getList());
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

}
