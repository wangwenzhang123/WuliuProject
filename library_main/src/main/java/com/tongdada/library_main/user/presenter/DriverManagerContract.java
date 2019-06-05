package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.DriverRequest;
import com.tongdada.base.ui.mvp.base.view.BaseView;

import java.util.List;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:15
 * @change
 */
public class DriverManagerContract {
    public interface View extends BaseView{
        void setDriverList(List<DriverRequest> list);
    }
    public interface Presenter{
        void driverList();
        void deleteDriver(String id);
    }
}
