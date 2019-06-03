package com.tongdada.library_login.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.utils.CheckUtils;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_login.R;
import com.tongdada.library_login.R2;
import com.tongdada.library_login.presenter.ForgotContract;
import com.tongdada.library_login.presenter.ForgotPresenter;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ArouterKey.LOGIN_FORGOTPASSWORDACTIVITY)
public class ForgotPasswordActivity extends BaseMvpActivity<ForgotPresenter> implements ForgotContract.View {

    @BindView(R2.id.resetpassword_back)
    ImageView resetpasswordBack;
    @BindView(R2.id.top_rl)
    RelativeLayout topRl;
    @BindView(R2.id.et_contact_phone)
    EditText etContactPhone;
    @BindView(R2.id.retrieve_password)
    TextView retrievePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public ForgotPresenter getPresenter() {
        return new ForgotPresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_forgot_password;
    }

    @OnClick(R2.id.resetpassword_back)
    public void onResetpasswordBackClicked() {
        finish();
    }

    @OnClick(R2.id.retrieve_password)
    public void onRetrievePasswordClicked() {
        String phone=etContactPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)){
            showToast("手机号不能为空！");
            return;
        }
        if (CheckUtils.isChinaPhoneLegal(phone)){
            presenter.getForgotPassword(etContactPhone.getText().toString().trim());
        }else {
            showToast("请输入正确的手机号！");
        }
    }
}
