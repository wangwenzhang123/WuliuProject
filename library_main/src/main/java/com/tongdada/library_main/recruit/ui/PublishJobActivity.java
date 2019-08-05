package com.tongdada.library_main.recruit.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;

import com.example.library_commen.model.RecuritListBean;
import com.example.library_commen.utils.CommenUtils;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.recruit.presenter.PublishJobContract;
import com.tongdada.library_main.recruit.presenter.PublishJobPresenter;
import com.tongdada.library_main.widget.datepicker.CustomDatePicker;
import com.tongdada.library_main.widget.datepicker.DateFormatUtils;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = ArouterKey.RECRUIT_PUBLISHJOBACTIVITY)
public class PublishJobActivity extends BaseMvpActivity<PublishJobPresenter> implements PublishJobContract.View {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.issue_back_rl)
    RelativeLayout issueBackRl;
    @BindView(R2.id.job_name)
    EditText jobName;
    @BindView(R2.id.salary_range)
    Spinner salaryRange;
    @BindView(R2.id.qualifications)
    EditText qualifications;
    @BindView(R2.id.work_name)
    EditText workName;
    @BindView(R2.id.work_address)
    EditText workAddress;
    @BindView(R2.id.work_contact)
    EditText workContact;
    @BindView(R2.id.contact_phone)
    EditText contactPhone;
    @BindView(R2.id.job_end_time)
    TextView jobEndTime;
    @BindView(R2.id.release_job)
    TextView releaseJob;
    @BindView(R2.id.cancel_tv)
    TextView cancelTv;
    @BindView(R2.id.job_detail_tv)
    TextView jobDetailTv;
    private RecuritListBean requestBean;

    @Override
    public PublishJobPresenter getPresenter() {
        return new PublishJobPresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_publishjob;
    }

    @Override
    public void getData() {
        initTimerPicker();
        requestBean = (RecuritListBean) getIntent().getSerializableExtra(IntentKey.RECUIRT_BEAN);
        if (requestBean == null) {
            requestBean = new RecuritListBean();
            cancelTv.setVisibility(View.GONE);
            jobDetailTv.setVisibility(View.GONE);
            workAddress.setText(CommenUtils.getIncetance().getRequestBean().getCompanyAddress());
            workContact.setText(CommenUtils.getIncetance().getRequestBean().getCompanyContacts());
            workName.setText(CommenUtils.getIncetance().getRequestBean().getCompanyName());
            contactPhone.setText(CommenUtils.getIncetance().getRequestBean().getContactsPhone());
        } else {
            refrshUi();
        }

    }
    String[] spinnerItems;
    @Override
    public void initLinsenterner() {
        spinnerItems =getResources().getStringArray(R.array.gongzi);
        salaryRange.setDropDownHorizontalOffset(100);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);
        //下拉的样式res
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        salaryRange.setAdapter(spinnerAdapter);
        //选择监听
        salaryRange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {


                ((TextView)view).setGravity(Gravity.CENTER);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

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



    @OnClick(R2.id.job_end_time)
    public void onJobEndTimeClicked() {
        mTimerPicker.show(jobEndTime.getText().toString());
    }

    @Override
    public void finishActivity() {
        finish();
    }
    private CustomDatePicker mTimerPicker;

    private void initTimerPicker() {

        String beginTime = DateFormatUtils.long2Str(System.currentTimeMillis(), true);
        String endTime = DateFormatUtils.long2Str(System.currentTimeMillis() + 31536000000L, true);
        jobEndTime.setText(DateFormatUtils.long2Str(System.currentTimeMillis()+(86400000*30),true));
        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                jobEndTime.setText(DateFormatUtils.long2Str(timestamp, true));
            }
        }, beginTime, endTime);
        // 允许点击屏幕或物理返回键关闭
        mTimerPicker.setCancelable(true);
        // 显示时和分
        mTimerPicker.setCanShowPreciseTime(false);
        // 允许循环滚动
        mTimerPicker.setScrollLoop(true);
        // 允许滚动动画
        mTimerPicker.setCanShowAnim(true);
    }
    @OnClick(R2.id.release_job)
    public void onReleaseJobClicked() {
        String jobNameStr = jobName.getText().toString();
        String salaryRangeStr = salaryRange.getSelectedItem().toString();
        String qualificationsStr = qualifications.getText().toString();
        String workNameStr = workName.getText().toString();
        String workAddressStr = workAddress.getText().toString();
        String workContactStr = workContact.getText().toString();
        String contactPhoneStr = contactPhone.getText().toString();
        String jobEndTimeStr = jobEndTime.getText().toString();
        if (TextUtils.isEmpty(jobNameStr) || TextUtils.isEmpty(salaryRangeStr) || TextUtils.isEmpty(qualificationsStr)
            || TextUtils.isEmpty(workNameStr)|| TextUtils.isEmpty(workAddressStr)|| TextUtils.isEmpty(workContactStr)
                || TextUtils.isEmpty(contactPhoneStr)){
            ToastUtils.showToast(mContext,"请将招聘信息完善后再点发布");
            return;
        }
        requestBean.setStationId(CommenUtils.getIncetance().getUserBean().getStationId());
        requestBean.setCompanyId(CommenUtils.getIncetance().getUserBean().getCompanyId());
        requestBean.setCompanyAddress(workAddressStr);
        requestBean.setPhoneNo(contactPhoneStr);
        requestBean.setEndTime(jobEndTimeStr);
        requestBean.setContacts(workContactStr);
        requestBean.setCompanyName(workNameStr);
        requestBean.setPositionRemarks(qualificationsStr);
        requestBean.setPositionSalary(salaryRangeStr);
        requestBean.setPositionName(jobNameStr);
        presenter.publishJob(requestBean);
    }

    @OnClick(R2.id.cancel_tv)
    public void onViewClicked() {
        presenter.cancelJob(requestBean.getId());
    }

    @Override
    public void refrshUi() {
        jobName.setText(requestBean.getPositionName());
        jobEndTime.setText(requestBean.getEndTime());
        int positon = Arrays.binarySearch(spinnerItems, requestBean.getPositionSalary());
        //salaryRange.set(requestBean.getPositionSalary());
        salaryRange.setSelection(positon);
        qualifications.setText(requestBean.getPositionRemarks());
        workAddress.setText(requestBean.getCompanyAddress());
        workContact.setText(requestBean.getContacts());
        workName.setText(requestBean.getCompanyName());
        contactPhone.setText(requestBean.getPhoneNo());
    }

    @OnClick(R2.id.job_detail_tv)
    public void onJobDetailClicked() {
        ARouter.getInstance().build(ArouterKey.RECRUIT_JOBDETAILSACTIVITY).withSerializable(IntentKey.RECUIRT_BEAN, requestBean).navigation(mContext);
    }
}
