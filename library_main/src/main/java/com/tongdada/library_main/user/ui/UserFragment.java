package com.tongdada.library_main.user.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.event.EventUpdateUser;
import com.example.library_commen.model.CommenUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.config.BaseUrl;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.user.presenter.UserContract;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/14 9:47
 * @change
 */
public class UserFragment extends BaseMvpFragment implements UserContract.View {
    @BindView(R2.id.user_tv)
    TextView userTv;
    @BindView(R2.id.user_ll)
    LinearLayout userLl;
    @BindView(R2.id.user_info)
    LinearLayout userInfo;
    @BindView(R2.id.change_password)
    LinearLayout changePassword;
    @BindView(R2.id.user_manager)
    LinearLayout userManager;
    @BindView(R2.id.message_management)
    LinearLayout messageManagement;
    @BindView(R2.id.messege_m)
    LinearLayout messegeM;
    @BindView(R2.id.setting)
    LinearLayout setting;
    Unbinder unbinder;
    @BindView(R2.id.plant_maintenace)
    LinearLayout plantMaintenace;
    @BindView(R2.id.user_ico)
    ImageView userIco;
    @BindView(R2.id.user_name)
    TextView userName;
    @BindView(R2.id.user_phone)
    TextView userPhone;
    @BindView(R2.id.about_app)
    LinearLayout aboutApp;
    @BindView(R2.id.out_login)
    LinearLayout outLogin;

    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_user;
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void initView() {
        updateUi();
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
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void update(EventUpdateUser eventUpdateUser) {
        updateUi();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R2.id.user_info)
    public void onUserInfoClicked() {
        routerIntent(ArouterKey.USER_USERINFOACTIVITY, null);
    }

    @OnClick(R2.id.change_password)
    public void onChangePasswordClicked() {
        routerIntent(ArouterKey.USER_CHANGEPASSWORDACTIVITY, null);
    }

    @OnClick(R2.id.user_manager)
    public void onUserManagerClicked() {
        routerIntent(ArouterKey.USER_USERMANAGERACTIVITY, null);
    }

    @OnClick(R2.id.message_management)
    public void onMessageManagementClicked() {
        routerIntent(ArouterKey.USER_MESSAGEACTIVITY, null);
    }

    @OnClick(R2.id.messege_m)
    public void onMessegeMClicked() {
        routerIntent(ArouterKey.USER_INFORMATIONACTIVITY, null);
    }

    @OnClick(R2.id.setting)
    public void onSettingClicked() {
        routerIntent(ArouterKey.USER_SETORDER, null);
    }

    @OnClick(R2.id.plant_maintenace)
    public void onViewClicked() {
        routerIntent(ArouterKey.USER_MAINTENANCEPLANTACTIVITY, null);
    }

    @Override
    public void updateUi() {
        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.user_hpyfy)
                .placeholder(R.mipmap.user_hpyfy)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(this).load(BaseUrl.BASEURL + "/" + CommenUtils.getIncetance().getUserBean().getIconPic())
                .apply(requestOptions).into(userIco);
        userName.setText(CommenUtils.getIncetance().getUserBean().getUserName());
        userPhone.setText(CommenUtils.getIncetance().getUserBean().getUserContacts());
    }

    @OnClick(R2.id.about_app)
    public void onViewAboutClicked() {
        ARouter.getInstance().build(ArouterKey.USER_ABOUTACTIVITY).navigation(mContext);
    }

    @OnClick(R2.id.out_login)
    public void onViewOutClicked() {
        ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(mContext);
        if (getActivity() != null){
            getActivity().finish();
        }
    }
}
