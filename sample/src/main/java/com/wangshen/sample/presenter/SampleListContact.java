package com.tongdada.sample.presenter;

import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerListContact;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.sample.SampleBean;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 14:05
 * @change
 */
public class SampleListContact {
   public interface Presenter{
        void getSampleData(String m);
    }
   public interface View extends BaseRecyclerListContact.View{
        //void getSampleData(SampleBean sampleBean);
    }
}
