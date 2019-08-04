package com.tongdada.library_main.recruit.ui;


import android.widget.TextView;

import com.example.library_commen.model.RecuritListBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpFragment;
import com.tongdada.library_main.recruit.presenter.PublishJobContract;
import com.tongdada.library_main.recruit.presenter.PublishJobPresenter;

import butterknife.BindView;

public class PublishJobFragment extends BaseMvpFragment<PublishJobPresenter> implements PublishJobContract.View {

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
    private RecuritListBean requestBean;

    public RecuritListBean getRequestBean() {
        return requestBean;
    }

    public void setRequestBean(RecuritListBean requestBean) {
        this.requestBean = requestBean;
    }

    @Override
    public PublishJobPresenter getPresenter() {
        return new PublishJobPresenter();
    }
    
    @Override
    public int getViewId() {
        return R.layout.fragment_publishjob;
    }

    @Override
    public void initView() {
        refrshUi();
    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

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
