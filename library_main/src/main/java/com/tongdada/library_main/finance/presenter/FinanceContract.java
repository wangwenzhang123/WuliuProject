package com.tongdada.library_main.finance.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.example.library_commen.model.TransportCarBean;
import com.tongdada.library_main.finance.net.respose.FinaceBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 12:43
 * @change
 */
public class FinanceContract {
    public interface View extends BaseView{
        void setOrderList(List<FinaceBean> list);
    }
    public interface Presenter{
        void detailOrderList();
        void batchUpdateDetailOrders(String id,String state);
    }
}
