package com.example.library_commen.presenter;

import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/5 14:01
 * @change
 */
public class LogicOrderDetailContract {
    public interface View extends BaseView{
        void cancelOrderSuccess();
        void setOrderDetail(DriverOrderDetailBean orderDetail);
    }
    public interface Presenter{
        void getOrderDetail(String id);
        void batchUpdateDetailOrders(String id,String state);
    }
}
