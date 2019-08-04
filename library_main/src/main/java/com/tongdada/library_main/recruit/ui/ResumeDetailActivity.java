package com.tongdada.library_main.recruit.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_commen.utils.PhoneCallUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@Route(path = ArouterKey.RECUIT_RESUMEDETAILACTIVITY)
public class ResumeDetailActivity extends BaseActivity {

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
    TextView resumeAge;
    @BindView(R2.id.age_nan)
    RadioButton ageNan;
    @BindView(R2.id.age_nv)
    RadioButton ageNv;
    @BindView(R2.id.native_place)
    TextView nativePlace;
    @BindView(R2.id.level_of_education)
    TextView levelOfEducation;
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
    TextView politicalLandscape;
    @BindView(R2.id.religious_beliefs)
    TextView religiousBeliefs;
    @BindView(R2.id.working_years)
    TextView workingYears;
    @BindView(R2.id.expected_salary)
    TextView expectedSalary;
    @BindView(R2.id.work_experience)
    TextView workExperience;

    @Override
    public int getView() {
        return R.layout.activity_resumedtail;
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
        contractPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneCallUtils.call(contractPhone.getText().toString(),mContext);
            }
        });
    }

    @Override
    public void getData() {
        UserBean userBean= (UserBean) getIntent().getSerializableExtra(IntentKey.USER_DETAIL);
        contractPhone.setText(userBean.getUserContacts());
        resumeName.setText(userBean.getUserName());
        resumeAddress.setText(userBean.getUserAddress());
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
}
