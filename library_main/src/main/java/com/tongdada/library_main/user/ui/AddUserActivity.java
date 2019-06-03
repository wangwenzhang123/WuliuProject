package com.tongdada.library_main.user.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.utils.CheckUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.AddUserConstract;
import com.tongdada.library_main.user.presenter.AddUserPresenter;
import com.winfo.photoselector.PhotoSelector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/22.
 */
@Route(path = ArouterKey.USER_ADDUSERACTIVITY)
public class AddUserActivity extends BaseMvpActivity<AddUserPresenter> implements AddUserConstract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.user_ico)
    ImageView userIco;
    @BindView(R2.id.user_name)
    EditText userName;
    @BindView(R2.id.user_phone)
    EditText userPhone;
    @BindView(R2.id.user_position)
    EditText userPosition;
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
    private static final int IVLEGALPOSITIVE_CODE = 1;
    private static final int IVLEGALREVERSE_CODE = 2;
    private static final int USERICON_CODE = 3;
    @BindView(R2.id.back_tv)
    TextView backTv;
    private UserBean requestBean = new UserBean();

    @Override
    public int getView() {
        return R.layout.activity_adduser;
    }

    @Override
    public AddUserPresenter getPresenter() {
        return new AddUserPresenter();
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

    @OnClick(R2.id.ll_legal_positive)
    public void onLlLegalPositiveClicked() {
        selectPic(IVLEGALPOSITIVE_CODE);
    }

    @OnClick(R2.id.ll_legal_reverse)
    public void onLlLegalReverseClicked() {
        selectPic(IVLEGALREVERSE_CODE);
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
        if (TextUtils.isEmpty(userName.getText().toString().trim())){
            showToast("名称不能为空！");
            return;
        }
        if (TextUtils.isEmpty(userPhone.getText().toString().trim())){
            showToast("手机号不能为空！");
            return;
        }
        if (TextUtils.isEmpty(userPosition.getText().toString().trim())){
            showToast("职务不能为空！");
            return;
        }
        if (!CheckUtils.isChinaPhoneLegal(userPhone.getText().toString().trim())){
            showToast("请输入正确的手机号！");
            return;
        }
        requestBean.setUserName(userName.getText().toString().trim());
        requestBean.setUserContacts(userPhone.getText().toString().trim());
        requestBean.setUserDuty(userPosition.getText().toString().trim());
        requestBean.setStationId(CommenUtils.getIncetance().getUserBean().getStationId());
        presenter.addStationUser(requestBean);
    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(AddUserActivity.this, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case IVLEGALPOSITIVE_CODE:
                    //单选的话 images就只有一条数据直接get(0)即可
                    List<String> images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Log.e(TGA, "1=" + images.get(0));
                    Glide.with(mContext).load(images.get(0)).into(ivLegalPositive);
                    presenter.upload(images.get(0), IVLEGALPOSITIVE_CODE);
                    break;
                case IVLEGALREVERSE_CODE:
                    //images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    List<String> images2 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images2.get(0)).into(ivLegalReverse);
                    Log.e(TGA, "2=" + images2.get(0));
                    presenter.upload(images2.get(0), IVLEGALREVERSE_CODE);
                    break;
                case USERICON_CODE:
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(userIco);
                    presenter.upload(images3.get(0), USERICON_CODE);
                    Log.e(TGA, "3=" + images3.get(0));
                    break;
            }
        }
    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case IVLEGALPOSITIVE_CODE:
                Glide.with(mContext).load(path).into(ivLegalPositive);
                requestBean.setBackPic(url);
                break;
            case IVLEGALREVERSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalReverse);
                requestBean.setFrontPic(url);
                break;
            case USERICON_CODE:
                RequestOptions requestOptions = new RequestOptions()
                        .error(R.mipmap.user_hpyfy)
                        .placeholder(R.mipmap.user_hpyfy)
                        .circleCrop()
                        .diskCacheStrategy(DiskCacheStrategy.DATA);
                Glide.with(mContext).load(path).apply(requestOptions).into(userIco);
                requestBean.setIconPic(url);
                break;
        }
    }

    @Override
    public void addStationUserSuccess() {
        finish();
    }



    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }
}
