package com.tongdada.library_main.user.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.event.EventModificationLogicBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/6/5.
 */
@Route(path = ArouterKey.USER_MAINTENANCELOGICACTIVITY)
public class MaintenanceLogicActivity extends BaseMvpActivity<BasePresenter> {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.regeist_conten)
    FrameLayout regeistConten;

    @Override
    public int getView() {
        return R.layout.activity_maintence_logic;
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
        Fragment fragment= (Fragment) ARouter.getInstance().build(ArouterKey.LOGIN_LOGICREGISTERFRAGMENT).navigation();
        getSupportFragmentManager().beginTransaction().add(R.id.regeist_conten,fragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().post(new EventModificationLogicBean());
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
