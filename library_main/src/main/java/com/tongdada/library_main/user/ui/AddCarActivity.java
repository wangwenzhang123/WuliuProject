package com.tongdada.library_main.user.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.AddCarContract;
import com.tongdada.library_main.user.presenter.AddCarPresenter;
import com.tongdada.library_main.widget.datepicker.CustomDatePicker;
import com.tongdada.library_main.widget.datepicker.DateFormatUtils;
import com.winfo.photoselector.PhotoSelector;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    @BindView(R2.id.issue_vehicle_type_tv)
    TextView issueVehicleTypeTv;
    @BindView(R2.id.et_car_brand)
    EditText etCarBrand;
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
    @BindView(R2.id.et_shop_time)
    TextView etShopTime;
    @BindView(R2.id.add_car_title)
    TextView addCarTitle;
    @BindView(R2.id.driver_name)
    TextView driverName;
    @BindView(R2.id.select_driver_ll)
    LinearLayout selectDriverLl;
    private boolean isAdd = true;
    private CarRequestBean requestBean = new CarRequestBean();
    private static final int DRIVINGLICENSE_CODE = 3;
    private CustomDatePicker mTimerPicker;
    private boolean isShopTime = false;

    @Override
    public int getView() {
        return R.layout.activity_addcar;
    }

    @Override
    public AddCarPresenter getPresenter() {
        return new AddCarPresenter();
    }

    @Override
    public void getData() {
        if (TextUtils.isEmpty(CommenUtils.getIncetance().getUserBean().getCompanyId())) {
            selectDriverLl.setVisibility(View.GONE);
            requestBean.setDriverId(CommenUtils.getIncetance().getUserBean().getDriverId());
        }
        requestBean.setCarType("T16");
        if (getIntent().getSerializableExtra(IntentKey.CAR_BEAN) != null) {
            requestBean = (CarRequestBean) getIntent().getSerializableExtra(IntentKey.CAR_BEAN);
            addCarTitle.setText("修改车辆");
            registerRegisterBt.setText("确认修改");
            upDateUi();
            isAdd = false;
        }

    }

    private void initTimerPicker() {
        String beginTime = DateFormatUtils.long2Str(System.currentTimeMillis() - 315360000000L, true);
        String endTime = DateFormatUtils.long2Str(System.currentTimeMillis() + 315360000000L, true);
        carTime.setText(beginTime);
        etShopTime.setText(beginTime);
        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                if (isShopTime) {
                    etShopTime.setText(DateFormatUtils.long2Str(timestamp, false));
                } else {
                    carTime.setText(DateFormatUtils.long2Str(timestamp, false));
                }
            }
        }, beginTime, endTime);
        mTimerPicker.setCancelable(true);
        mTimerPicker.setCanShowPreciseTime(true);
        mTimerPicker.setScrollLoop(true);
        mTimerPicker.setCanShowAnim(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initTimerPicker();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventDriver(DriverRequest driverRequest) {
        driverName.setText(driverRequest.getDriverName());
        requestBean.setDriverId(driverRequest.getId());
        requestBean.setDriverName(driverRequest.getDriverName());
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
        String carName = etCarBrand.getText().toString().trim();
        String carNo = etCarNo.getText().toString().trim();
        String mileages = etTravlledDistance.getText().toString().trim();
        String carLoad = etCarLoad.getText().toString().trim();
        String shopTime = etShopTime.getText().toString().trim();
        String cartime = carTime.getText().toString().trim();
        requestBean.setBuyTime(shopTime);
        requestBean.setInsuranceDate(cartime);
        requestBean.setCarLoad(carLoad);
        requestBean.setCarNo(carNo);
        requestBean.setCarName(carName);
        requestBean.setCompanyId(CommenUtils.getIncetance().getRequestBean().getId());
        requestBean.setMileages(mileages);
        if (isAdd) {
            presenter.addCar(requestBean);
        } else {
            requestBean.setDelFlag("0");
            presenter.updateCar(requestBean);
        }
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

    @Override
    public void upDateUi() {
        if (TextUtils.isEmpty(CommenUtils.getIncetance().getUserBean().getCompanyId())) {
            selectDriverLl.setVisibility(View.GONE);
            requestBean.setDriverId(CommenUtils.getIncetance().getUserBean().getDriverId());
        }
        etCarBrand.setText(requestBean.getCarName());
        etCarLoad.setText(requestBean.getCarLoad());
        etCarNo.setText(requestBean.getCarNo());
        etTravlledDistance.setText(requestBean.getMileages());
        carTime.setText(requestBean.getInsuranceDate());
        etShopTime.setText(requestBean.getBuyTime());
        driverName.setText(requestBean.getDriverName());
        RequestOptions requestOptions = new RequestOptions().centerCrop()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult);
        if (!TextUtils.isEmpty(requestBean.getDriveLicense())) {
            Glide.with(mContext).load(BaseUrl.BASEURL + "/" + requestBean.getDriveLicense()).into(ivBusinessLicense);
        }
        if (requestBean.getCarType().equals("B")) {
            rbBeng.setChecked(true);
        } else {
            rbTong.setChecked(true);
            switch (requestBean.getCarType()) {
                case "T16":
                    rg16.setChecked(true);
                    break;
                case "T18":
                    rg18.setChecked(true);
                    break;
                case "T20":
                    rg20.setChecked(true);
                    break;
            }
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

    @OnClick(R2.id.et_shop_time)
    public void onViewClicked() {

    }

    @OnClick(R2.id.driver_name)
    public void onViewDriverClicked() {
        ARouter.getInstance().build(ArouterKey.USER_SELECTDRIVER).navigation(mContext);
    }

    @OnClick(R2.id.et_shop_time)
    public void onEtShopTimeClicked() {
        mTimerPicker.show(etShopTime.getText().toString());
        isShopTime = true;
    }

    @OnClick(R2.id.car_time)
    public void onCarTimeClicked() {
        mTimerPicker.show(carTime.getText().toString());
        isShopTime = false;
    }
}
