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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    @BindView(R2.id.rb_tong)
    RadioButton rbTong;
    @BindView(R2.id.rb_beng)
    RadioButton rbBeng;
    @BindView(R2.id.rg_16)
    RadioButton rg16;
    @BindView(R2.id.rg_18)
    RadioButton rg18;
    @BindView(R2.id.rg_20)
    RadioButton rg20;
    @BindView(R2.id.rg_type)
    RadioGroup rgType;
    @BindView(R2.id.tong_ll)
    FrameLayout tongLl;
    @BindView(R2.id.rb_beng_qi)
    RadioButton rbBengQi;
    @BindView(R2.id.rb_beng_gu)
    RadioButton rbBengGu;
    @BindView(R2.id.beng_carType_ll)
    LinearLayout bengCarTypeLl;
    @BindView(R2.id.beng_1)
    RadioButton beng1;
    @BindView(R2.id.beng_2)
    RadioButton beng2;
    @BindView(R2.id.beng_3)
    RadioButton beng3;
    @BindView(R2.id.beng_type)
    RadioGroup bengType;
    @BindView(R2.id.beng_qi_ll)
    LinearLayout bengQiLl;
    @BindView(R2.id.gu_1)
    RadioButton gu1;
    @BindView(R2.id.gu_2)
    RadioButton gu2;
    @BindView(R2.id.beng_gu_type)
    RadioGroup bengGuType;
    @BindView(R2.id.beng_gu_ll)
    LinearLayout bengGuLl;
    @BindView(R2.id.bang_ll)
    LinearLayout bangLl;
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
                requestRegisterBean.setIdFront(url);
                break;
            case IVLEGALREVERSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalReverse);
                requestRegisterBean.setIdBack(url);
                break;
            case IVBUSINESSLICENSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalPositive1);
                requestRegisterBean.setDriverLicense(url);
                break;
        }
    }

    @Override
    public void updateUi() {

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
                    Glide.with(mContext).load(images3.get(0)).into(ivLegalPositive1);
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
        selectPic(IVLEGALPOSITIVE_CODE);
    }

    @OnClick(R2.id.ll_legal_reverse)
    public void onLlLegalReverseClicked() {
        selectPic(IVLEGALREVERSE_CODE);
    }

    @OnClick(R2.id.ll_legal_positive1)
    public void onLlLegalPositive1Clicked() {
        selectPic(IVBUSINESSLICENSE_CODE);
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
        String contact = etContact.getText().toString().trim();
        String contactPhone = etContactPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String registeredCapital = etRegisteredCapital.getText().toString().trim();
        String age = etDriverAge.getText().toString().trim();
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
            showToast("请输入车牌号");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getIdFront())) {
            showToast("请先上传身份证正面照片");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getIdBack())) {
            showToast("请先上传身份证反面照片");
            return;
        }
        if (TextUtils.isEmpty(requestRegisterBean.getDriverLicense())) {
            showToast("请先上传驾照");
            return;
        }
        if (!CheckUtils.isChinaPhoneLegal(contactPhone)) {
            showToast("请输入正确的手机号！");
            return;
        }
        if (rbTong.isChecked()) {
            getCheckTong();
        } else {
            getCheckBang();
        }
        requestRegisterBean.setDriverName(contact);
        requestRegisterBean.setDriverMobile(contactPhone);
        requestRegisterBean.setCarNo(registeredCapital);
        requestRegisterBean.setDriverAddress(address);
        requestRegisterBean.setDriveringAge(age);
        presenter.registerUser(requestRegisterBean);
    }

    @OnClick(R2.id.rb_tong)
    public void onRbTongClicked() {
        tongLl.setVisibility(View.VISIBLE);
        bangLl.setVisibility(View.GONE);
    }

    @OnClick(R2.id.rb_beng)
    public void onRbBengClicked() {
        tongLl.setVisibility(View.GONE);
        bangLl.setVisibility(View.VISIBLE);
    }
    private void getCheckTong() {
        String caType = null;
        String load=null;
        if (rg16.isChecked()) {
            caType = "T16";
            load="16";
        }
        if (rg18.isChecked()) {
            caType ="T18";
            load="18";
        }
        if (rg20.isChecked()) {
            caType = "T20";
            load="20";
        }
        requestRegisterBean.setCarLoad(load);
        requestRegisterBean.setCarType(caType);
    }
    private void getCheckBang() {
        if (rbBengQi.isChecked()) {
            int id = bengType.getCheckedRadioButtonId();
            if (id == R.id.beng_1) {
                requestRegisterBean.setCarType("B1");
            } else if (id == R.id.beng_2) {
                requestRegisterBean.setCarType("B2");
            } else {
                requestRegisterBean.setCarType("B3");
            }
        } else {
            int id = bengGuType.getCheckedRadioButtonId();
            if (id == R.id.gu_1) {
                requestRegisterBean.setCarType("B4");
            } else {
                requestRegisterBean.setCarType("B5");
            }
        }
        requestRegisterBean.setCarType("");
    }
    @OnClick(R2.id.rg_16)
    public void onRg16Clicked() {

    }

    @OnClick(R2.id.rg_18)
    public void onRg18Clicked() {
    }

    @OnClick(R2.id.rg_20)
    public void onRg20Clicked() {
    }

    @OnClick(R2.id.rg_type)
    public void onRgTypeClicked() {
    }

    @OnClick(R2.id.tong_ll)
    public void onTongLlClicked() {
    }
    @OnClick(R2.id.rb_beng_qi)
    public void onRbBengQiClicked() {
        bengQiLl.setVisibility(View.VISIBLE);
        bengGuLl.setVisibility(View.GONE);
    }

    @OnClick(R2.id.rb_beng_gu)
    public void onRbBengGuClicked() {
        bengQiLl.setVisibility(View.GONE);
        bengGuLl.setVisibility(View.VISIBLE);
    }


    @OnClick(R2.id.beng_carType_ll)
    public void onBengCarTypeLlClicked() {
    }

    @OnClick(R2.id.beng_1)
    public void onBeng1Clicked() {
    }

    @OnClick(R2.id.beng_2)
    public void onBeng2Clicked() {
    }

    @OnClick(R2.id.beng_3)
    public void onBeng3Clicked() {
    }

    @OnClick(R2.id.beng_type)
    public void onBengTypeClicked() {
    }

    @OnClick(R2.id.beng_qi_ll)
    public void onBengQiLlClicked() {
    }

    @OnClick(R2.id.gu_1)
    public void onGu1Clicked() {
    }

    @OnClick(R2.id.gu_2)
    public void onGu2Clicked() {
    }

    @OnClick(R2.id.beng_gu_type)
    public void onBengGuTypeClicked() {
    }

    @OnClick(R2.id.beng_gu_ll)
    public void onBengGuLlClicked() {
    }

    @OnClick(R2.id.bang_ll)
    public void onBangLlClicked() {
    }
}
