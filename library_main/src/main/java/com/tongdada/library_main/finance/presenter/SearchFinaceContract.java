package com.tongdada.library_main.finance.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.finance.net.respose.FinaceBean;

import java.util.List;

/**
 * Created by wangshen on 2019/6/2.
 */

public class SearchFinaceContract {
    public interface View extends BaseView{
        void setDataList(List<FinaceBean> list);
    }
    public interface Presenter{
       void findDetailList(String result);
    }
}
