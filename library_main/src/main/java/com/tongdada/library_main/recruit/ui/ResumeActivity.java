package com.tongdada.library_main.recruit.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.user.presenter.UserContract;
import com.tongdada.library_main.user.presenter.UserInfoContract;
import com.tongdada.library_main.user.presenter.UserInfoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@Route(path = ArouterKey.RECUIT_RESUMEACTIVITY)
public class ResumeActivity extends BaseMvpActivity<UserInfoPresenter> implements UserInfoContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.issue_back_rl)
    RelativeLayout issueBackRl;
    @BindView(R2.id.resume_name)
    TextView resumeName;
    @BindView(R2.id.resume_age)
    EditText resumeAge;
    @BindView(R2.id.age_nan)
    RadioButton ageNan;
    @BindView(R2.id.age_nv)
    RadioButton ageNv;
    @BindView(R2.id.native_place)
    EditText nativePlace;
    @BindView(R2.id.level_of_education)
    EditText levelOfEducation;
    @BindView(R2.id.contract_phone)
    TextView contractPhone;
    @BindView(R2.id.resume_address)
    TextView resumeAddress;
    @BindView(R2.id.marriage_wei)
    RadioButton marriageWei;
    @BindView(R2.id.marriage_yi)
    RadioButton marriageYi;
    @BindView(R2.id.working_state_zai)
    RadioButton workingStateZai;
    @BindView(R2.id.working_state_wei)
    RadioButton workingStateWei;
    @BindView(R2.id.political_landscape)
    EditText politicalLandscape;
    @BindView(R2.id.religious_beliefs)
    EditText religiousBeliefs;
    @BindView(R2.id.working_years)
    EditText workingYears;
    @BindView(R2.id.expected_salary)
    EditText expectedSalary;
    @BindView(R2.id.work_experience)
    EditText workExperience;
    @BindView(R2.id.release_order)
    TextView releaseOrder;
    UserBean userBean;
    @Override
    public UserInfoPresenter getPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    public void initView() {
        try {
            userBean= (UserBean) CommenUtils.getIncetance().getUserBean().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        contractPhone.setText(CommenUtils.getIncetance().getUserBean().getUserContacts());
        resumeName.setText(CommenUtils.getIncetance().getUserBean().getUserName());
        resumeAddress.setText(CommenUtils.getIncetance().getUserBean().getUserAddress());
        workExperience.setText(userBean.getWorkExperience());
        levelOfEducation.setText(userBean.getEducationInfo());
        workingYears.setText(userBean.getWorkAge());
        politicalLandscape.setText(userBean.getPloticsInfo());
        expectedSalary.setText(userBean.getExpectSalary());
        if (!TextUtils.isEmpty(userBean.getUserSex())){
            if (userBean.getUserSex().equals("男")){
                ageNan.setChecked(true);
            }else {
                ageNv.setChecked(true);
            }
        }
        if (!TextUtils.isEmpty(userBean.getMarriageInfo())){
            if (userBean.getMarriageInfo().equals("未婚")){
                marriageWei.setChecked(true);
            }else {
                marriageYi.setChecked(true);
            }
        }
        if (!TextUtils.isEmpty(userBean.getWorkInfo())){
            if (userBean.getWorkInfo().equals("在职")){
                workingStateZai.setChecked(true);
            }else {
                workingStateWei.setChecked(true);
            }
        }

    }

    @Override
    public int getView() {
        return R.layout.activity_resume;
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

    @OnClick(R2.id.age_nan)
    public void onAgeNanClicked() {
        userBean.setUserSex("男");
    }

    @OnClick(R2.id.age_nv)
    public void onAgeNvClicked() {
        userBean.setUserSex("女");
    }

    @OnClick(R2.id.marriage_wei)
    public void onMarriageWeiClicked() {
        userBean.setMarriageInfo("未婚");
    }

    @OnClick(R2.id.marriage_yi)
    public void onMarriageYiClicked() {
        userBean.setMarriageInfo("已婚");
    }

    @OnClick(R2.id.working_state_zai)
    public void onWorkingStateZaiClicked() {
        userBean.setWorkInfo("在职");
    }

    @OnClick(R2.id.working_state_wei)
    public void onWorkingStateWeiClicked() {
        userBean.setWorkInfo("离职");
    }

    @OnClick(R2.id.release_order)
    public void onReleaseOrderClicked() {
        userBean.setWorkExperience(workExperience.getText().toString());
        userBean.setEducationInfo(levelOfEducation.getText().toString());
        userBean.setWorkAge(workingYears.getText().toString());
        userBean.setPloticsInfo(politicalLandscape.getText().toString());
        userBean.setExpectSalary(expectedSalary.getText().toString());
        userBean.setUserOrigin(nativePlace.getText().toString());
        presenter.editUser(userBean);
    }


    @Override
    public void editUserSuccess() {
        finish();
    }

    @Override
    public void selectPic(int code) {

    }

    @Override
    public void uploadSuccess(String path, String url, int dex) {

    }
}
