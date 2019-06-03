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
import com.example.library_commen.model.RequestRegisterBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.MaintencancePlanContract;
import com.tongdada.library_main.user.presenter.MaintencancePlanPresenter;
import com.winfo.photoselector.PhotoSelector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/23 15:20
 * @change
 */
@Route(path = ArouterKey.USER_MAINTENANCEPLANTACTIVITY)
public class MaintenancePlantActivity extends BaseMvpActivity<MaintencancePlanPresenter> implements MaintencancePlanContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
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
    @BindView(R2.id.ll_business_license)
    LinearLayout llBusinessLicense;
    @BindView(R2.id.iv_business_license)
    ImageView ivBusinessLicense;
    @BindView(R2.id.register_register_bt)
    Button registerRegisterBt;
    private static final int IVLEGALPOSITIVE_CODE = 1;
    private static final int IVLEGALREVERSE_CODE = 2;
    private static final int IVBUSINESSLICENSE_CODE = 3;
    private static final int USERLOGO_CODE = 4;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.user_logo)
    ImageView userLogo;
    private RequestRegisterBean requestRegisterBean;

    @Override
    public int getView() {
        return R.layout.activity_mixing_plant;
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
        requestRegisterBean = new RequestRegisterBean();
        presenter.getMixStationById();
    }

    @Override
    public MaintencancePlanPresenter getPresenter() {
        return new MaintencancePlanPresenter();
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

    @OnClick(R2.id.ll_legal_positive)
    public void onLlLegalPositiveClicked() {
        selectPic(IVLEGALPOSITIVE_CODE);
    }

    @OnClick(R2.id.ll_legal_reverse)
    public void onLlLegalReverseClicked() {
        selectPic(IVLEGALREVERSE_CODE);
    }

    @OnClick(R2.id.ll_business_license)
    public void onLlBusinessLicenseClicked() {
        selectPic(IVBUSINESSLICENSE_CODE);
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
        String unitName = etUnitName.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String legalPerson = etLegalPerson.getText().toString().trim();
        String contactPhone = etContactPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String registeredCapital = etRegisteredCapital.getText().toString().trim();
        if (TextUtils.isEmpty(unitName)) {
            showToast("请输入公司名称！");
            return;
        }
        if (TextUtils.isEmpty(contact)) {
            showToast("请输入联系人！");
            return;
        }
        if (TextUtils.isEmpty(legalPerson)) {
            showToast("请输入公司法人！");
            return;
        }
        if (TextUtils.isEmpty(contactPhone)) {
            showToast("请输入联系人电话！");
            return;
        }
        if (TextUtils.isEmpty(address)) {
            showToast("请输入公司地址！");
            return;
        }
        if (TextUtils.isEmpty(registeredCapital)) {
            showToast("请输入公司注册资金！");
            return;
        }
        requestRegisterBean.setContactsPhone(contactPhone);
        requestRegisterBean.setRegisterCapita(registeredCapital);
        requestRegisterBean.setStationAddress(address);
        requestRegisterBean.setLegalPersion(legalPerson);
        requestRegisterBean.setStationName(unitName);
        requestRegisterBean.setStationContacts(contact);
        presenter.register(requestRegisterBean);
    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(MaintenancePlantActivity.this, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case IVLEGALPOSITIVE_CODE:
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
                case IVBUSINESSLICENSE_CODE:
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(ivBusinessLicense);
                    presenter.upload(images3.get(0), IVBUSINESSLICENSE_CODE);
                    Log.e(TGA, "3=" + images3.get(0));
                    break;
                case USERLOGO_CODE:
                    List<String> images4 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images4.get(0)).into(ivBusinessLicense);
                    presenter.upload(images4.get(0), USERLOGO_CODE);
                    Log.e(TGA, "3=" + images4.get(0));
                    break;
            }
        }
    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case IVLEGALPOSITIVE_CODE:
                Glide.with(mContext).load(path).into(ivLegalPositive);
                requestRegisterBean.setBackPic(url);
                break;
            case IVLEGALREVERSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalReverse);
                requestRegisterBean.setFrontPic(url);
                break;
            case IVBUSINESSLICENSE_CODE:
                Glide.with(mContext).load(path).into(ivBusinessLicense);
                requestRegisterBean.setLicensePic(url);
                break;
            case USERLOGO_CODE:
                Glide.with(mContext).load(path).into(userLogo);
                requestRegisterBean.setLogoPic(url);
                break;
        }
    }

    @Override
    public void setMixStationData(RequestRegisterBean mixStationData) {
        etUnitName.setText(mixStationData.getStationName());
        etAddress.setText(mixStationData.getStationAddress());
        etContact.setText(mixStationData.getStationContacts());
        etContactPhone.setText(mixStationData.getContactsPhone());
        etLegalPerson.setText(mixStationData.getLegalPersion());
        etRegisteredCapital.setText(mixStationData.getRegisterCapital());
        requestRegisterBean = mixStationData;

        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + mixStationData.getBackPic()).apply(requestOptions).into(ivLegalReverse);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + mixStationData.getFrontPic()).apply(requestOptions).into(ivLegalPositive);
        Glide.with(mContext).load(BaseUrl.BASEURL + "/" + mixStationData.getLicensePic()).apply(requestOptions).into(ivBusinessLicense);

    }

    @Override
    public void updataSuccess() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onViewBackClicked() {
        finish();
    }

    @OnClick(R2.id.user_logo)
    public void onViewClicked() {
        selectPic(USERLOGO_CODE);
    }
}
