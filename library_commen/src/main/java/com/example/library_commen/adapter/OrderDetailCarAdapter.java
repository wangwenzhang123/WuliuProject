package com.example.library_commen.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.example.library_commen.R;
import com.example.library_commen.model.DetailCarListBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/31.
 */

public class OrderDetailCarAdapter extends BaseQuickAdapter<DetailCarListBean,BaseViewHolder> {
    public OrderDetailCarAdapter(int layoutResId, @Nullable List<DetailCarListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailCarListBean item) {
        helper.setText(R.id.car_number,item.getCarNo());
    }
}
