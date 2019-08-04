package com.tongdada.library_main.resume.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.RecuritListBean;
import com.example.library_main.R;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;

import java.util.List;

public class ResumeRecruitAdapter extends BaseAdapter<RecuritListBean> {
    public ResumeRecruitAdapter(int layoutResId, @Nullable List<RecuritListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecuritListBean item) {
        super.convert(helper, item);
        helper.setText(R.id.job_name,item.getPositionName());
        //helper.setText(R.id.job_people,item.get)
        helper.setText(R.id.job_money,item.getPositionSalary());
        helper.setText(R.id.job_gongsi,item.getCompanyName());
        helper.setText(R.id.job_time,item.getPublishTime());
    }
}
