package com.tongdada.library_main.resume.presenter;

import com.example.library_commen.model.OrderBean;
import com.example.library_commen.model.RecuritListBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 12:43
 * @change
 */
public class SearchJobContract {
    public interface View extends BaseView {
        void setSearchOrderList(List<RecuritListBean> list);
    }
    public interface Presenter{
        void getSearchOrder(String result);
    }
}
