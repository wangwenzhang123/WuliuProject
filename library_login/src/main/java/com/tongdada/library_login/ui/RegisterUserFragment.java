package com.tongdada.library_login.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.utils.CheckUtils;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_login.R;
import com.tongdada.library_login.R2;
import com.tongdada.library_login.presenter.RegisterContact;
import com.tongdada.library_login.presenter.RegisterPresenter;
import com.winfo.photoselector.PhotoSelector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/6/3.
 */

public class RegisterUserFragment extends BaseMvpFragment<RegisterPresenter> implements RegisterContact.View {
    @BindView(R2.id.et_contact)
    EditText etContact;
    @BindView(R2.id.et_address)
    EditText etAddress;
    @BindView(R2.id.et_registered_capital)
    EditText etRegisteredCapital;
    @BindView(R2.id.et_enterprise_number)
    EditText etEnterpriseNumber;
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
    @BindView(R2.id.iv_add1)
    ImageView ivAdd1;
    @BindView(R2.id.ll_legal_positive1)
    LinearLayout llLegalPositive1;
    @BindView(R2.id.iv_legal_positive1)
    ImageView ivLegalPositive1;
    @BindView(R2.id.ll_legal_reverse1)
    LinearLayout llLegalReverse1;
    @BindView(R2.id.iv_legal_reverse1)
    ImageView ivLegalReverse1;
    @BindView(R2.id.et_contact_phone)
    EditText etContactPhone;
    @BindView(R2.id.register_register_bt)
    Button registerRegisterBt;
    Unbinder unbinder;
    private static final int IVLEGALPOSITIVE_CODE = 1;
    private static final int IVLEGALREVERSE_CODE = 2;
    private static final int IVBUSINESSLICENSE_CODE = 3;
    @BindView(R2.id.et_driver_age)
    EditText etDriverAge;
    private DriverRequest requestRegisterBean = new DriverRequest();

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(mContext, code);
    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case IVLEGALPOSITIVE_CODE:
                Glide.with(mContext).load(path).into(ivLegalPositive);
                //requestRegisterBean.setBackPic(url);
                break;
            case IVLEGALREVERSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalReverse);
                //requestRegisterBean.setFrontPic(url);
                break;
            case IVBUSINESSLICENSE_CODE:
                //Glide.with(mContext).load(path).into(ivBusinessLicense);
                //requestRegisterBean.setLicensePic(url);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case IVLEGALPOSITIVE_CODE:
                    //单选的话 images就只有一条数据直接get(0)即可
                    List<String> images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images.get(0)).into(ivLegalPositive);
                    presenter.upload(images.get(0), IVLEGALPOSITIVE_CODE);
                    break;
                case IVLEGALREVERSE_CODE:
                    //images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    List<String> images2 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images2.get(0)).into(ivLegalReverse);
                    presenter.upload(images2.get(0), IVLEGALREVERSE_CODE);
                    break;
                case IVBUSINESSLICENSE_CODE:
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    //Glide.with(mContext).load(images3.get(0)).into(ivBusinessLicense);
                    presenter.upload(images3.get(0), IVBUSINESSLICENSE_CODE);
                    break;
            }
        }
    }

    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_register_user;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R2.id.ll_legal_positive)
    public void onLlLegalPositiveClicked() {

    }

    @OnClick(R2.id.ll_legal_reverse)
    public void onLlLegalReverseClicked() {

    }

    @OnClick(R2.id.ll_legal_positive1)
    public void onLlLegalPositive1Clicked() {

    }

    @OnClick(R2.id.ll_legal_reverse1)
    public void onLlLegalReverse1Clicked() {

    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
        String contact = etContact.getText().toString().trim();
        String contactPhone = etContactPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String registeredCapital = etRegisteredCapital.getText().toString().trim();
        String age=etDriverAge.getText().toString().trim();
        if (TextUtils.isEmpty(contact)) {
            showToast("请输入联系人！");
            return;
        }
        if (TextUtils.isEmpty(contactPhone)) {
            showToast("请输入联系人电话！");
            return;
        }
        if (TextUtils.isEmpty(address)) {
            showToast("请输入地址！");
            return;
        }
        if (TextUtils.isEmpty(registeredCapital)) {
            showToast("请输入车牌号1");
            return;
        }
        if (!CheckUtils.isChinaPhoneLegal(contactPhone)) {
            showToast("请输入正确的手机号！");
            return;
        }
        requestRegisterBean.setDriverName(contact);
        requestRegisterBean.setDriverMobile(contactPhone);
        requestRegisterBean.setDriverIdNo(registeredCapital);
        requestRegisterBean.setDriverAddress(address);
        requestRegisterBean.setDriveringAge(age);
        presenter.registerUser(requestRegisterBean);
    }
}
