package com.tongdada.library_main.resume.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.RecuritListBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseActivity;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.library_main.recruit.presenter.PublishJobContract;
import com.tongdada.library_main.recruit.presenter.PublishJobPresenter;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@Route(path = ArouterKey.RECRUIT_RESUMEJOBDETAILACTIVITY)
public class ResumeJobDetailActivity extends BaseMvpActivity<PublishJobPresenter> implements PublishJobContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.job_detail_tv)
    TextView jobDetailTv;
    @BindView(R2.id.issue_back_rl)
    RelativeLayout issueBackRl;
    @BindView(R2.id.job_name)
    TextView jobName;
    @BindView(R2.id.salary_range)
    TextView salaryRange;
    @BindView(R2.id.qualifications)
    TextView qualifications;
    @BindView(R2.id.work_name)
    TextView workName;
    @BindView(R2.id.work_address)
    TextView workAddress;
    @BindView(R2.id.work_contact)
    TextView workContact;
    @BindView(R2.id.contact_phone)
    TextView contactPhone;
    @BindView(R2.id.job_end_time)
    TextView jobEndTime;
    @BindView(R2.id.release_job)
    TextView releaseJob;
    private RecuritListBean requestBean;
    @Override
    public int getView() {
        return R.layout.activity_resume_jobdetail;
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
    public PublishJobPresenter getPresenter() {
        return new PublishJobPresenter();
    }

    @Override
    public void getData() {
        requestBean = (RecuritListBean) getIntent().getSerializableExtra(IntentKey.RECUIRT_BEAN);
        refrshUi();
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

    @OnClick(R2.id.release_job)
    public void onReleaseJobClicked() {
        presenter.applyJob(requestBean.getId());
    }

    @Override
    public void refrshUi() {
        jobName.setText(requestBean.getPositionName());
        jobEndTime.setText(requestBean.getEndTime());
        salaryRange.setText(requestBean.getPositionSalary());
        qualifications.setText(requestBean.getPositionRemarks());
        workAddress.setText(requestBean.getCompanyAddress());
        workContact.setText(requestBean.getContacts());
        workName.setText(requestBean.getCompanyName());
        contactPhone.setText(requestBean.getPhoneNo());
    }
}
