package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.UserBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.AddUserPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangshen on 2019/5/22.
 */
@Route(path = ArouterKey.USER_ADDUSERDETAILACTIVITY)
public class AddUserDetailActivity extends BaseMvpActivity<AddUserPresenter> {

    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.user_ico)
    ImageView userIco;
    @BindView(R2.id.user_name)
    TextView userName;
    @BindView(R2.id.user_phone)
    TextView userPhone;
    @BindView(R2.id.user_position)
    TextView userPosition;
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
    private UserBean userBean = new UserBean();

    @Override
    public int getView() {
        return R.layout.activity_add_detailuser;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        userBean= (UserBean) getIntent().getSerializableExtra(IntentKey.USER_DETAIL);
        userName.setText(userBean.getUserName());
        userPhone.setText(userBean.getUserContacts());
        userPosition.setText(userBean.getUserDuty());
        RequestOptions requestOptions=new RequestOptions()
                .error(R.mipmap.defult)
                .placeholder(R.mipmap.defult)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        RequestOptions requestOptions1=new RequestOptions()
                .circleCrop()
                .error(R.mipmap.user_hpyfy)
                .placeholder(R.mipmap.user_hpyfy)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                ;
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+userBean.getIconPic()).apply(requestOptions1).into(userIco);
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+userBean.getBackPic()).apply(requestOptions.centerCrop()).into(ivLegalReverse);
        Glide.with(mContext).load(BaseUrl.BASEURL+"/"+userBean.getFrontPic()).apply(requestOptions.centerCrop()).into(ivLegalPositive);
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

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

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }
}
