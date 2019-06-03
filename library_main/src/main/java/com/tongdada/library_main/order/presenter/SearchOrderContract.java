package com.tongdada.library_main.order.presenter;

import com.example.library_commen.model.OrderBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.order.respose.OrderListBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 12:43
 * @change
 */
public class SearchOrderContract {
    public interface View extends BaseView {
        void setSearchOrderList(List<OrderBean> list);
    }
    public interface Presenter{
        void getSearchOrder(String result);
    }
}
