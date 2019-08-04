package com.tongdada.library_main.recruit.presenter;

import com.example.library_commen.model.RecuritListBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

public class PublishJobContract {
    public interface View extends BaseView {
        void refrshUi();
    }
    public interface Presenter{
        void publishJob(RecuritListBean publishJobRequestBean);
        void cancelJob(String id);
        void applyJob(String id);
    }
}
