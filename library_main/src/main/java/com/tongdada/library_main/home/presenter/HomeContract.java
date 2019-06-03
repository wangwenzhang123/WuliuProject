package com.tongdada.library_main.home.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.home.respose.BannerBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 12:43
 * @change
 */
public class HomeContract {
    public interface View extends BaseView {
        void setBannerData(List<BannerBean.RowsBean> bannerData);
    }
    public interface Presenter{
        void shuffling();
        void getMixStationById();
    }
}
