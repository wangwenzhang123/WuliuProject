package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.AddDriverContract;
import com.tongdada.library_main.user.presenter.AddDriverPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:07
 * @change
 */
@Route(path = ArouterKey.USER_ADDDRIVERACTIVITY)
public class AddDriverActivity extends BaseMvpActivity<AddDriverPresenter> implements AddDriverContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.user_logo)
    ImageView userLogo;
    @BindView(R2.id.et_user_name)
    EditText etUserName;
    @BindView(R2.id.et_driver_phone)
    EditText etDriverPhone;
    @BindView(R2.id.et_identity_card)
    EditText etIdentityCard;
    @BindView(R2.id.et_driving_years)
    EditText etDrivingYears;
    @BindView(R2.id.et_driver_age)
    EditText etDriverAge;
    @BindView(R2.id.driver_address)
    TextView driverAddress;
    @BindView(R2.id.iv_add)
    ImageView ivAdd;
    @BindView(R2.id.ll_legal_positive)
    LinearLayout llLegalPositive;
    @BindView(R2.id.iv_legal_positive)
    ImageView ivLegalPositive;
    @BindView(R2.id.ll_legal_reverse)
    LinearLayout llLegalReverse;
    @BindView(R2.id.iv_legal_reverse)
    ImageView ivLegalReverse;
    @BindView(R2.id.register_register_bt)
    Button registerRegisterBt;

    @Override
    public int getView() {
        return R.layout.activity_add_driver;
    }

    @Override
    public AddDriverPresenter getPresenter() {
        return new AddDriverPresenter();
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

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
    }

    @OnClick(R2.id.user_logo)
    public void onUserLogoClicked() {
    }

    @OnClick(R2.id.ll_legal_positive)
    public void onLlLegalPositiveClicked() {
    }

    @OnClick(R2.id.ll_legal_reverse)
    public void onLlLegalReverseClicked() {
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
    }
}
