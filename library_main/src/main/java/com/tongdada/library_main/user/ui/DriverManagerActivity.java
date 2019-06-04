package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.DriverManagerContract;
import com.tongdada.library_main.user.presenter.DriverManagerPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:43
 * @change
 */
@Route(path = ArouterKey.USER_DRIVERMANAGERACTIVITY)
public class DriverManagerActivity extends BaseMvpActivity<DriverManagerPresenter> implements DriverManagerContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.add_driver_tv)
    TextView addDriverTv;
    @BindView(R2.id.driver_manager_recycle)
    RecyclerView driverManagerRecycle;

    @Override
    public int getView() {
        return R.layout.activity_driver_manager;
    }

    @Override
    public DriverManagerPresenter getPresenter() {
        return new DriverManagerPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
    }

    @OnClick(R2.id.add_driver_tv)
    public void onAddDriverTvClicked() {
    }
}