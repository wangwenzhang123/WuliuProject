package com.tongdada.library_main.home.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.order.ui.OrderListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/6/7.
 */
@Route(path = ArouterKey.HOME_MOREORDERACTIVITY)
public class MoreOrderActivity extends BaseMvpActivity<BasePresenter> {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.add_driver_title)
    TextView addDriverTitle;
    @BindView(R2.id.order_conten)
    FrameLayout orderConten;

    @Override
    public int getView() {
        return R.layout.activity_more_order;
    }

    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        getSupportFragmentManager()    //
                .beginTransaction()
                .add(R.id.order_conten, new OrderListFragment("F"))
                .commit();
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }
}
