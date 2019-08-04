package com.tongdada.library_main.recruit.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.UserBean;
import com.example.library_main.R;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;

import java.util.List;

public class ResumeAdapter extends BaseAdapter<UserBean> {
    public ResumeAdapter(int layoutResId, @Nullable List<UserBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserBean item) {
        super.convert(helper, item);
        helper.setText(R.id.user_name,item.getUserName());
        helper.setText(R.id.user_money,item.getExpectSalary());
        helper.setText(R.id.user_info,item.getUserSex()+" "+item.getMarriageInfo()+" 工作"+item.getWorkAge()+"年 "+item.getWorkInfo());
        helper.setText(R.id.user_phone,item.getUserContacts());
    }
}
