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
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.DriverRequest;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.AddDriverContract;
import com.tongdada.library_main.user.presenter.AddDriverPresenter;
import com.winfo.photoselector.PhotoSelector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:07
 * @change
 */
@Route(path = ArouterKey.USER_ADDDRIVERACTIVITY)
public class AddDriverActivity extends BaseMvpActivity<AddDriverPresenter> implements AddDriverContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.user_logo)
    ImageView userLogo;
    @BindView(R2.id.et_user_name)
    EditText etUserName;
    @BindView(R2.id.et_driver_phone)
    EditText etDriverPhone;
    @BindView(R2.id.et_identity_card)
    EditText etIdentityCard;
    @BindView(R2.id.et_driving_years)
    EditText etDrivingYears;
    @BindView(R2.id.et_driver_age)
    EditText etDriverAge;
    @BindView(R2.id.driver_address)
    EditText driverAddress;
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
    DriverRequest request = new DriverRequest();
    private static final int IVLEGALPOSITIVE_CODE = 1;
    private static final int IVLEGALREVERSE_CODE = 2;
    private static final int DRIVINGLICENSE_CODE = 3;
    @BindView(R2.id.ll_driving_license)
    LinearLayout llDrivingLicense;
    @BindView(R2.id.iv_driving_license)
    ImageView ivDrivingLicense;
    @BindView(R2.id.add_driver_title)
    TextView addDriverTitle;
    private boolean isAdd=true;
    @Override
    public int getView() {
        return R.layout.activity_add_driver;
    }

    @Override
    public AddDriverPresenter getPresenter() {
        return new AddDriverPresenter();
    }

    @Override
    public void getData() {
        if (getIntent().getSerializableExtra(IntentKey.DRIVER_BEAN) != null) {
            request = (DriverRequest) getIntent().getSerializableExtra(IntentKey.DRIVER_BEAN);
            addDriverTitle.setText("修改司机");
            registerRegisterBt.setText("确认修改");
            upDateUi();
            isAdd=false;
        }
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
        finishActivity();
    }

    @OnClick(R2.id.user_logo)
    public void onUserLogoClicked() {

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
        String name = etUserName.getText().toString().trim();
        String address = driverAddress.getText().toString();
        String age = etDriverAge.getText().toString().trim();
        String phone = etDriverPhone.getText().toString().trim();
        String driverYear = etDrivingYears.getText().toString();
        String card = etIdentityCard.getText().toString().trim();
        request.setDriveringAge(driverYear);
        request.setDriverName(name);
        request.setDriverMobile(phone);
        request.setDriverIdNo(card);
        request.setDriverAddress(address);
        request.setDriAge(age);
        request.setCompanyId(CommenUtils.getIncetance().getRequestBean().getId());
        request.setCompanyName(CommenUtils.getIncetance().getRequestBean().getCompanyName());
        if (isAdd){
            presenter.addDriver(request);
        }else {
            presenter.updateDriver(request);
        }

    }

    @Override
    public void selectPic(int code) {
        PhotoSelector.builder()
                .setSingle(true)
                .start(AddDriverActivity.this, code);
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
                case DRIVINGLICENSE_CODE:
                    //images = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    List<String> images3 = data.getStringArrayListExtra(PhotoSelector.SELECT_RESULT);
                    Glide.with(mContext).load(images3.get(0)).into(ivDrivingLicense);
                    Log.e(TGA, "2=" + images3.get(0));
                    presenter.upload(images3.get(0), DRIVINGLICENSE_CODE);
                    break;
            }
        }
    }


    @Override
    public void uploadSuccess(String path, String url, int dex) {
        switch (dex) {
            case IVLEGALPOSITIVE_CODE:
                Glide.with(mContext).load(path).into(ivLegalPositive);
                request.setIdFront(url);
                break;
            case IVLEGALREVERSE_CODE:
                Glide.with(mContext).load(path).into(ivLegalReverse);
                request.setIdBack(url);
                break;
            case DRIVINGLICENSE_CODE:
                Glide.with(mContext).load(path).into(ivDrivingLicense);
                request.setDriverLicense(url);
                break;
        }
    }

    @Override
    public void upDateUi() {
        etDriverAge.setText(request.getDriveringAge());
        etDriverPhone.setText(request.getDriverMobile());
        etDrivingYears.setText(request.getDriAge());
        driverAddress.setText(request.getDriverAddress());
        etUserName.setText(request.getDriverName());
        etIdentityCard.setText(request.getDriverIdNo());
        RequestOptions requestOptions=new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        if (!TextUtils.isEmpty(request.getIdBack())){
            Glide.with(mContext).load(BaseUrl.BASEURL+"/"+request.getIdBack()).apply(requestOptions).into(ivLegalReverse);
        }
        if (!TextUtils.isEmpty(request.getIdFront())){
            Glide.with(mContext).load(BaseUrl.BASEURL+"/"+request.getIdFront()).apply(requestOptions).into(ivLegalPositive);
        }
        if (!TextUtils.isEmpty(request.getDriverIdNo())){
            Glide.with(mContext).load(BaseUrl.BASEURL+"/"+request.getDriverIdNo()).apply(requestOptions).into(ivDrivingLicense);
        }
    }

    @Override
    public void addSuccess() {
        finish();
    }

    @OnClick(R2.id.ll_driving_license)
    public void onViewClicked() {
        selectPic(DRIVINGLICENSE_CODE);
    }
}
