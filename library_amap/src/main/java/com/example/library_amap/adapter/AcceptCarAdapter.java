package com.example.library_amap.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_amap.R;
import com.example.library_amap.model.AdressBean;
import com.example.library_commen.model.SelectCarBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/19.
 */

public class AcceptCarAdapter extends BaseQuickAdapter<SelectCarBean,BaseViewHolder> {
    public AcceptCarAdapter(int layoutResId, @Nullable List<SelectCarBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectCarBean item) {
        helper.setText(com.example.library_commen.R.id.car_number,item.getCarNo());
    }
}
