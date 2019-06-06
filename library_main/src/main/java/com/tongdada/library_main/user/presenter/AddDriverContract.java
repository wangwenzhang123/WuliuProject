package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.DriverRequest;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:15
 * @change
 */
public class AddDriverContract {
    public interface View extends BaseView{
        void selectPic(int  code);
        void uploadSuccess(String path,String url,int dex);
    }
    public interface Presenter{
        void addDriver(DriverRequest request);
        void upload(String path,int dex);
    }
}
