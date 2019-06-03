package com.tongdada.library_main.user.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.UserBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.UserInfoContract;
import com.tongdada.library_main.user.presenter.UserInfoPresenter;
import com.winfo.photoselector.PhotoSelector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 16:18
 * @change
 */
@Route(path = ArouterKey.USER_USERINFOACTIVITY)
public class UserInfoActivity extends BaseMvpActivity<UserInfoPresenter> implements UserInfoContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.user_ico)
    ImageView userIco;
    @BindView(R2.id.user_name)
    EditText userName;
    @BindView(R2.id.user_phone)
    EditText userPhone;
    @BindView(R2.id.user_age)
    EditText userAge;
    @BindView(R2.id.user_address)
    EditText userAddress;
    @BindView(R2.id.sure_change)
    TextView sureChange;
    @BindView(R2.id.back_tv)
    TextView backTv;
    private UserBean userBean;
    private static final int USERICON_CODE = 0;

    @Override
    public int getView() {
        return R.layout.activity_userinfo;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.user_hpyfy)
                .placeholder(R.mipmap.user_hpyfy)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(this).load(BaseUrl.BASEURL + "/" + CommenUtils.getIncetance().getUserBean().getIconPic())
                .apply(requestOptions).into(userIco);
        userName.setText(CommenUtils.getIncetance().getUserBean().getUserName());
        userPhone.setText(CommenUtils.getIncetance().getUserBean().getUserContacts());
        userAge.setText("28");
        userAddress.setText(CommenUtils.getIncetance().getUserBean().getUserAddress());

        userBean = CommenUtils.getIncetance().getUserBean();
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }

    @Override
    public UserInfoPresenter getPresenter() {
        return new UserInfoPresenter();
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

    @OnClick(R2.id.user_ico)
    public void onUserIcoClicked() {
        selectPic(USERICON_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case USERICON_CODE:
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(userIco);
                    presenter.upload(images3.get(0), USERICON_CODE);
                    Log.e(TGA, "3=" + images3.get(0));
                    break;
            }
        }
    }

    @OnClick(R2.id.sure_change)
    public void onSureChangeClicked() {
        if (TextUtils.isEmpty(userName.getText().toString())){
            showToast("名字不能空!");
            return;
        }
        if (TextUtils.isEmpty(userAddress.getText().toString())){
            showToast("地址不能空!");
            return;
        }
        if (TextUtils.isEmpty(userPhone.getText().toString())){
            showToast("手机号不能空!");
            return;
        }
        userBean.setUserName(userName.getText().toString());
        userBean.setUserAddress(userAddress.getText().toString());
        userBean.setUserContacts(userPhone.getText().toString().trim());
        presenter.editUser(userBean);
    }

    @Override
    public void editUserSuccess() {
        finish();
    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(UserInfoActivity.this, code);
    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case USERICON_CODE:
                Glide.with(mContext).load(path).into(userIco);
                userBean.setIconPic(url);
                break;
        }
    }

    @OnClick(R2.id.back_tv)
    public void onViewClicked() {
        finish();
    }
}
