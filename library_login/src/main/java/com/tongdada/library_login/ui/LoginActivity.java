package com.tongdada.library_login.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_login.R;
import com.tongdada.library_login.R2;
import com.tongdada.library_login.presenter.LoginContact;
import com.tongdada.library_login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = ArouterKey.LOGIN_LOGINACTIVITY)
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContact.View {


    @BindView(R2.id.imageView)
    ImageView imageView;
    @BindView(R2.id.rt_phone_login)
    EditText rtPhoneLogin;
    @BindView(R2.id.et_password_login)
    EditText etPasswordLogin;
    @BindView(R2.id.bt_login)
    Button btLogin;
    @BindView(R2.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R2.id.tv_login_register)
    TextView tvLoginRegister;
    @BindView(R2.id.bt_register)
    Button btRegister;

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_login;
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
    public void routerIntent(String path, Bundle bundle) {
        super.routerIntent(path,bundle);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.bt_login)
    public void onBtLoginClicked() {
        presenter.login(rtPhoneLogin.getText().toString(), etPasswordLogin.getText().toString());
    }

    @OnClick(R2.id.tv_forgot_password)
    public void onTvForgotPasswordClicked() {
        routerIntent(ArouterKey.LOGIN_FORGOTPASSWORDACTIVITY, null);
    }

    @OnClick(R2.id.tv_login_register)
    public void onTvLoginRegisterClicked() {

    }

    @OnClick(R2.id.bt_register)
    public void onViewClicked() {
        routerIntent(ArouterKey.LOGIN_REGISTERACTIVITY,null);
    }
}
