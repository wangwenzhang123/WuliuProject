package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.AddCarContract;
import com.tongdada.library_main.user.presenter.AddCarPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 15:15
 * @change
 */
@Route(path = ArouterKey.USER_ADDCARACTIVITY)
public class AddCarActivity extends BaseMvpActivity<AddCarPresenter> implements AddCarContract.View {

    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.user_logo)
    ImageView userLogo;
    @BindView(R2.id.et_car_no)
    EditText etCarNo;
    @BindView(R2.id.driver_name)
    TextView driverName;
    @BindView(R2.id.issue_vehicle_type_tv)
    TextView issueVehicleTypeTv;
    @BindView(R2.id.rb_tong)
    RadioButton rbTong;
    @BindView(R2.id.rb_beng)
    RadioButton rbBeng;
    @BindView(R2.id.et_car_brand)
    EditText etCarBrand;
    @BindView(R2.id.et_contact_phone)
    TextView etContactPhone;
    @BindView(R2.id.et_car_type)
    EditText etCarType;
    @BindView(R2.id.et_travlled_distance)
    EditText etTravlledDistance;
    @BindView(R2.id.et_car_load)
    EditText etCarLoad;
    @BindView(R2.id.car_time)
    TextView carTime;
    @BindView(R2.id.ll_business_license)
    LinearLayout llBusinessLicense;
    @BindView(R2.id.iv_business_license)
    ImageView ivBusinessLicense;
    @BindView(R2.id.register_register_bt)
    Button registerRegisterBt;

    @Override
    public int getView() {
        return R.layout.activity_addcar;
    }

    @Override
    public AddCarPresenter getPresenter() {
        return new AddCarPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
    }

    @OnClick(R2.id.user_logo)
    public void onUserLogoClicked() {
    }

    @OnClick(R2.id.ll_business_license)
    public void onLlBusinessLicenseClicked() {
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
    }
}
