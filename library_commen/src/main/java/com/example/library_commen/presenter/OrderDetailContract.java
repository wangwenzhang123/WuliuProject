package com.example.library_commen.presenter;

import com.example.library_commen.model.DetailCarListBean;
import com.example.library_commen.model.DriverOrderDetailBean;
import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

import java.util.List;

/**
 * Created by wangshen on 2019/5/30.
 */

public class OrderDetailContract {
    public interface View extends BaseView{
        void setOrderDetail(OrderBean orderDetail);
        void setOrderCarList(List<DetailCarListBean> carList);
        void cancelOrderSuccess();
    }
    public interface Presenter{
        void getOrderById(String id);
        void getOrderCarsList(String id);
        void cancelOrder(String id);
    }
}
