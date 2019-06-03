package com.example.library_amap.presenter;

import com.example.library_commen.model.DriverOrderDetailBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 10:56
 * @change
 */
public class MapCarDetailContract  {
    public interface View extends BaseView{
        void setDetailOrder(DriverOrderDetailBean detailOrder);
        void updateSuccess();
    }
    public interface Presenter{
        void getDetailOrderById(String orderid);
        void updateDetailOrders(String id,String state);
        void batchUpdateDetailOrders(String id, String state);
    }
}
