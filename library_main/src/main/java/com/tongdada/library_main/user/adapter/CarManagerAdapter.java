package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_main.R;

import java.util.List;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:30
 * @change
 */
public class CarManagerAdapter extends BaseQuickAdapter<CarRequestBean,BaseViewHolder> {
    public CarManagerAdapter(int layoutResId, @Nullable List<CarRequestBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarRequestBean item) {
        helper.addOnClickListener(R.id.item_slide);
        helper.setText(R.id.car_carnumber,item.getCarNo());
        helper.setText(R.id.user_name,item.getDriverName());
        helper.setText(R.id.user_position,item.getCarName());
        helper.setText(R.id.user_position1,"保险到期时间；"+item.getInsuranceDate());

    }
}
