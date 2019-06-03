package com.tongdada.sample.ui;

import android.content.Intent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tongdada.base.app.AppActivityKey;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerListActivity;
import com.tongdada.sample.R;
import com.tongdada.sample.SampleAdapter;
import com.tongdada.sample.SampleBean;
import com.tongdada.sample.dialog.SampleDialog;
import com.tongdada.sample.presenter.SampleListContact;
import com.tongdada.sample.presenter.SampleListPresenterImp;

import java.util.ArrayList;


/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 16:10
 * @change
 */
@Route(path = AppActivityKey.SAMPLELIST_ACTIVITY)
public class SampleListActivity extends BaseRecyclerListActivity<SampleListPresenterImp> implements SampleListContact.View{
    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }

    @Override
    public BaseDialog getDialog() {
        return new SampleDialog(this);
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {
        presenter.getSampleData("123");
    }

    @Override
    public SampleListPresenterImp getPresenter() {
        return new SampleListPresenterImp();
    }

    @Override
    public void loadData() {
        presenter.getSampleData("123");
    }

    @Override
    public BaseAdapter createRecyclerAdapter() {
        return new SampleAdapter(R.layout.item_sample,new ArrayList<SampleBean.ResultBean>());
    }

}
