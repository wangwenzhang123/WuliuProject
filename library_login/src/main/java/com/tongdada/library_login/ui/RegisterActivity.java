package com.tongdada.library_login.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_login.R;
import com.tongdada.library_login.R2;
import com.tongdada.library_login.presenter.RegisterPresenter;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 21:38
 * @change
 */
@Route(path = ArouterKey.LOGIN_REGISTERACTIVITY)
public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> {

    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.fragment_conten)
    FrameLayout fragmentConten;
    @BindView(R2.id.rb_logistics)
    RadioButton rbLogistics;
    @BindView(R2.id.rb_user)
    RadioButton rbUser;
    private RegisterLogisticsFragment registerLogisticsFragment;
    private RegisterUserFragment registerUserFragment;
    @Override
    public int getView() {
        return R.layout.activity_register;
    }

    private void initFragment() {
        registerLogisticsFragment=new RegisterLogisticsFragment();
        registerUserFragment=new RegisterUserFragment();
        showFragment(registerLogisticsFragment,registerUserFragment);
    }

    @Override
    public void initView() {
        initFragment();
    }
    private void showFragment(Fragment show, Fragment hide){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.hide(hide);
        if(!show.isAdded()){
            ft.add(R.id.fragment_conten,show).show(show);
        }else {
            ft.show(show);
        }
        ft.commit();
    }
    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    /*@OnClick(R2.id.ll_business_license)
    public void onLlBusinessLicenseClicked() {
        selectPic(IVBUSINESSLICENSE_CODE);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (rbLogistics.isChecked()){
            registerLogisticsFragment.onActivityResult(requestCode,resultCode,data);
        }else {
            registerUserFragment.onActivityResult(requestCode,resultCode,data);
        }
    }

    @OnClick(R2.id.rb_logistics)
    public void onRbLogisticsClicked() {
        showFragment(registerLogisticsFragment,registerUserFragment);
    }

    @OnClick(R2.id.rb_user)
    public void onRbUserClicked() {
        showFragment(registerUserFragment,registerLogisticsFragment);
    }
}
