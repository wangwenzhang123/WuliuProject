package com.example.library_amap.ui;

import com.example.library_amap.R;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.base.ui.mvp.base.view.BaseView;

/**
 * Created by wangshen on 2019/5/22.
 */

public class OrderDetaiFragment extends BaseMvpFragment<BasePresenter> implements BaseView {
    @Override
    public int getViewId() {
        return R.layout.fragment_order_detail;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
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
    public BasePresenter getPresenter() {
        return null;
    }
}
