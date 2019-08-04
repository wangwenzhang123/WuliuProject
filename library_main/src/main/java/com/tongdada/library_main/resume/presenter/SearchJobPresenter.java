package com.tongdada.library_main.resume.presenter;

import android.os.Handler;

import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.order.presenter.SearchOrderContract;
import com.tongdada.library_main.order.respose.OrderListBean;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/6/2.
 */

public class SearchJobPresenter extends BasePresenter<SearchJobContract.View> implements SearchJobContract.Presenter {
    @Override
    public void getSearchOrder(String resul) {
        MainApiUtils.getMainApi().listPosition(resul,"", "",1)
                .compose(this.<PagenationBase<RecruitmentBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<RecruitmentBean>>() {
                    @Override
                    public void accept(final PagenationBase<RecruitmentBean> sampleBeanBaseAppEntity) throws Exception {
                        if (sampleBeanBaseAppEntity.getPagenation().getList() == null || sampleBeanBaseAppEntity.getPagenation().getList().size() == 0){
                            getView().showToast("未搜索到相关内容！");
                        }else {
                            getView().setSearchOrderList(sampleBeanBaseAppEntity.getPagenation().getList());
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
