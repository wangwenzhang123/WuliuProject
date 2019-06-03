package com.tongdada.library_login.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.library_login.R;
import com.tongdada.library_login.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@Route(path = ArouterKey.LOGIN_SUBMITAUDITACTIVITY)
public class SubmitAuditActivity extends BaseActivity {


    @BindView(R2.id.submit_back)
    LinearLayout submitBack;
    @BindView(R2.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R2.id.submit_iv)
    ImageView submitIv;
    @BindView(R2.id.contan)
    ConstraintLayout contan;

    @Override
    public int getView() {
        return R.layout.activity_submit_audit;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.submit_back)
    public void onViewClicked() {
        finish();
    }
}
