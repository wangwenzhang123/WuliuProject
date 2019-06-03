package com.tongdada.sample.presenter;

import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.sample.SampleBean;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:05
 * @change
 */
public class SampleContact {
   public interface Presenter{
        void getSampleData(String m);
    }
   public interface View extends BaseView{
        void getSampleData(SampleBean sampleBean);
    }
}
