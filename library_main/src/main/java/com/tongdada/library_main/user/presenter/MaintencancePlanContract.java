package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.MixStationBean;
import com.example.library_commen.model.RequestRegisterBean;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/5/25.
 */

public class MaintencancePlanContract {
    public interface View extends BaseView{
        void selectPic(int  code);
        void uploadSuccess(String path,String url,int dex);
        void setMixStationData(RequestRegisterBean mixStationData);
        void updataSuccess();
    }
    public interface Presenter{
        void register(RequestRegisterBean requestRegisterBean);
        void upload(String path,int dex);
        void getMixStationById();
    }
}
