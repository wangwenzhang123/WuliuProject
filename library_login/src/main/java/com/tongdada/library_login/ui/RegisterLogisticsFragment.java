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

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.event.EventModificationLogicBean;
import com.example.library_commen.model.LogisticsRequestBean;
import com.example.library_commen.utils.CheckUtils;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_login.R;
import com.tongdada.library_login.R2;
import com.tongdada.library_login.presenter.RegisterContact;
import com.tongdada.library_login.presenter.RegisterPresenter;
import com.winfo.photoselector.PhotoSelector;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangshen on 2019/6/3.
 */
@Route(path = ArouterKey.LOGIN_LOGICREGISTERFRAGMENT)
public class RegisterLogisticsFragment extends BaseMvpFragment<RegisterPresenter> implements RegisterContact.View {
    @BindView(R2.id.et_unit_name)
    EditText etUnitName;
    @BindView(R2.id.et_contact)
    EditText etContact;
    @BindView(R2.id.et_legal_person)
    EditText etLegalPerson;
    @BindView(R2.id.et_contact_phone)
    EditText etContactPhone;
    @BindView(R2.id.et_address)
    EditText etAddress;
    @BindView(R2.id.et_registered_capital)
    EditText etRegisteredCapital;
    @BindView(R2.id.ll_legal_positive1)
    LinearLayout llLegalPositive1;
    @BindView(R2.id.iv_legal_positive1)
    ImageView ivLegalPositive1;
    @BindView(R2.id.ll_legal_reverse1)
    LinearLayout llLegalReverse1;
    @BindView(R2.id.iv_legal_reverse1)
    ImageView ivLegalReverse1;
    @BindView(R2.id.register_register_bt)
    Button registerRegisterBt;
    Unbinder unbinder;
    private boolean isRegister=true;
    private static final int IVBUSINESSLICENSE_CODE=3;
    private static final int ROADRUNNING_CODE=4;
    private LogisticsRequestBean requestRegisterBean=new LogisticsRequestBean();
    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(mContext, code);
    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex){
            case IVBUSINESSLICENSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalPositive1);
                requestRegisterBean.setLicensePath(url);
                break;
            case ROADRUNNING_CODE:
                Glide.with(mContext).load(path).into(ivLegalReverse1);
                requestRegisterBean.setRoadLicensePath(url);
                break;
        }
    }

    @Override
    public void updateUi() {
        etAddress.setText(requestRegisterBean.getCompanyAddress());
        etContact.setText(requestRegisterBean.getCompanyContacts());
        etContactPhone.setText(requestRegisterBean.getContactsPhone());
        etLegalPerson.setText(requestRegisterBean.getLegalPersion());
        etUnitName.setText(requestRegisterBean.getCompanyName());
        etRegisteredCapital.setText(requestRegisterBean.getRegisterCapital());
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        if (!TextUtils.isEmpty(requestRegisterBean.getLicensePath())){
            Glide.with(mContext).load(BaseUrl.BASEURL + "/" + requestRegisterBean.getLicensePath()).apply(requestOptions).into(ivLegalPositive1);
        }
        if (!TextUtils.isEmpty(requestRegisterBean.getRoadLicensePath())){
            Glide.with(mContext).load(BaseUrl.BASEURL + "/" + requestRegisterBean.getRoadLicensePath()).apply(requestOptions).into(ivLegalReverse1);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case IVBUSINESSLICENSE_CODE:
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(ivLegalPositive1);
                    presenter.upload(images3.get(0),IVBUSINESSLICENSE_CODE);
                    break;
                case ROADRUNNING_CODE:
                    List<String> images4 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images4.get(0)).into(ivLegalReverse1);
                    presenter.upload(images4.get(0),ROADRUNNING_CODE);
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
        return R.layout.fragment_register_logistics;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        EventBus.getDefault().register(this);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void addUser(EventModificationLogicBean eventAddBean){
        isRegister=false;
        try {
            requestRegisterBean= (LogisticsRequestBean) CommenUtils.getIncetance().getRequestBean().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        updateUi();
    }
    @OnClick(R2.id.ll_legal_positive1)
    public void onLlLegalPositive1Clicked() {
        selectPic(IVBUSINESSLICENSE_CODE);
    }

    @OnClick(R2.id.ll_legal_reverse1)
    public void onLlLegalReverse1Clicked() {
        selectPic(ROADRUNNING_CODE);
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
        String contact=etContact.getText().toString().trim();
        String contactPhone=etContactPhone.getText().toString().trim();
        String address=etAddress.getText().toString().trim();
        String registeredCapital=etRegisteredCapital.getText().toString().trim();
        String name=etUnitName.getText().toString().trim();
        String legalPersion=etLegalPerson.getText().toString().trim();
        if (TextUtils.isEmpty(contact)){
            showToast("请输入联系人！");
            return;
        }
        if (TextUtils.isEmpty(contactPhone)){
            showToast("请输入联系人电话！");
            return;
        }
        if (TextUtils.isEmpty(address)){
            showToast("请输入公司地址！");
            return;
        }
        if (TextUtils.isEmpty(registeredCapital)){
            showToast("请输入公司注册资金！");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getLicensePath())){
            showToast("请先上传营业执照");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getRoadLicensePath())){
            showToast("请先上传道路营运许可证");
            return;
        }
        if (!CheckUtils.isChinaPhoneLegal(contactPhone)){
            showToast("请输入正确的手机号！");
            return;
        }
        requestRegisterBean.setCompanyName(name);
        requestRegisterBean.setCompanyContacts(contact);
        requestRegisterBean.setCompanyAddress(address);
        requestRegisterBean.setContactsPhone(contactPhone);
        requestRegisterBean.setLegalPersion(legalPersion);
        requestRegisterBean.setRegisterCapital(registeredCapital);
        if (isRegister){
            presenter.registerLogistics(requestRegisterBean);
        }else {
            presenter.updateLogi(requestRegisterBean);
        }
    }
}
