package com.tongdada.sample.ui;

import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tongdada.base.app.AppActivityKey;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshActivity;
import com.tongdada.sample.R;
import com.tongdada.sample.SampleAdapter;
import com.tongdada.sample.SampleBean;
import com.tongdada.sample.dialog.SampleDialog;
import com.tongdada.sample.presenter.SampleRefreshPresenterImp;

import java.util.ArrayList;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/26 9:14
 * @change
 */
@Route(path = AppActivityKey.SAMPLEREFESH_ACTIVITY)
public class SampleRefreshActivity extends BaseRecyclerRefreshActivity<SampleRefreshPresenterImp> {
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

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public SampleRefreshPresenterImp getPresenter() {
        return new SampleRefreshPresenterImp();
    }

    @Override
    public BaseAdapter createRecyclerAdapter() {
        return new SampleAdapter(R.layout.item_sample,new ArrayList<SampleBean.ResultBean>());
    }
}
