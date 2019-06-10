package com.example.library_amap.presenter;

import com.example.library_amap.model.AcceptRequestBean;
import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/6/8.
 */

public class AcceptOrderContract {
    public interface View extends BaseView{
        void setOrderDetail(OrderBean orderDetail);
    }
    public interface Presenter{
        void getOrderById(String id);
        void acceptOrderOfLogi(AcceptRequestBean acceptRequestBean);
    }
}
