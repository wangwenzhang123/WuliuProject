package com.tongdada.library_main.user.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.AddCarContract;
import com.tongdada.library_main.user.presenter.AddCarPresenter;
import com.winfo.photoselector.PhotoSelector;

import java.util.List;

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
    @BindView(R2.id.et_car_brand)
    EditText etCarBrand;
    @BindView(R2.id.et_contact_phone)
    TextView etContactPhone;
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
    private CarRequestBean requestBean = new CarRequestBean();
    private static final int DRIVINGLICENSE_CODE = 3;

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
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }

    @OnClick(R2.id.user_logo)
    public void onUserLogoClicked() {

    }

    @OnClick(R2.id.ll_business_license)
    public void onLlBusinessLicenseClicked() {
        selectPic(DRIVINGLICENSE_CODE);
    }

    @OnClick(R2.id.register_register_bt)
    public void onRegisterRegisterBtClicked() {
        String  carName=etCarBrand.getText().toString().trim();
        String  carNo=etCarNo.getText().toString().trim();
        String  mileages=etTravlledDistance.getText().toString().trim();
        String  carLoad=etTravlledDistance.getText().toString().trim();
        requestBean.setCarLoad(carLoad);
        requestBean.setCarNo(carNo);
        requestBean.setCarName(carName);
        requestBean.setCompanyId(CommenUtils.getIncetance().getRequestBean().getId());
        requestBean.setMileages(mileages);
        presenter.addCar(requestBean);
    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(AddCarActivity.this, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode) {
                case DRIVINGLICENSE_CODE:
                    //images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(ivBusinessLicense);
                    Log.e(TGA, "2=" + images3.get(0));
                    presenter.upload(images3.get(0), DRIVINGLICENSE_CODE);
                    break;
            }
        }
    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case DRIVINGLICENSE_CODE:
                Glide.with(mContext).load(path).into(ivBusinessLicense);
                requestBean.setDriveLicense(url);
                break;
        }
    }

    @OnClick(R2.id.rb_tong)
    public void onRbTongClicked() {
        rgType.setVisibility(View.VISIBLE);
        int id = rgType.getCheckedRadioButtonId();
        if (id == R.id.rg_16) {
            requestBean.setCarType("T16");
        } else if (id == R.id.rg_18) {
            requestBean.setCarType("T18");
        } else if (id == R.id.rg_20) {
            requestBean.setCarType("T20");
        }
    }

    @OnClick(R2.id.rb_beng)
    public void onRbBengClicked() {
        rgType.setVisibility(View.INVISIBLE);
        requestBean.setCarType("B");
    }

    @OnClick(R2.id.rg_16)
    public void onRg16Clicked() {
        requestBean.setCarType("T16");
    }

    @OnClick(R2.id.rg_18)
    public void onRg18Clicked() {
        requestBean.setCarType("T18");
    }

    @OnClick(R2.id.rg_20)
    public void onRg20Clicked() {
        requestBean.setCarType("T20");
    }
}
