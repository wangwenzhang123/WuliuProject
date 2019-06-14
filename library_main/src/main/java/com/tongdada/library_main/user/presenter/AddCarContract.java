package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CarRequestBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:15
 * @change
 */
public class AddCarContract {
    public interface View extends BaseView{
        void selectPic(int  code);
        void uploadSuccess(String path,String url,int dex);
        void upDateUi();
        void operationSuccess();
    }
    public interface Presenter{
        void addCar(CarRequestBean carRequestBean);
        void upload(String path,int dex);
        void updateCar(CarRequestBean carRequestBean);
    }
}
