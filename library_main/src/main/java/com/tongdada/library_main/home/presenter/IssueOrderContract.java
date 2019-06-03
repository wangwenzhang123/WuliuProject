package com.tongdada.library_main.home.presenter;

import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.example.library_commen.model.IssueOrderBean;

/**
 * Created by wangshen on 2019/5/18.
 */

public class IssueOrderContract {
    public interface View extends BaseView{
        void publishSuccess();
        void selectPic(int  code);
        void uploadSuccess(String path,String urlx);
        void initUi();
    }
    public interface Presenter{
        void publishOrder(OrderBean issueOrderBean);
        void upload(String path);
        void editOrder(OrderBean issueOrderBean);
    }
}
