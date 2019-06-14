package com.tongdada.library_main.home.adapter;

import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_main.R;

import java.util.List;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/5 16:11
 * @change
 */
public class SelectCarAdapter extends BaseQuickAdapter<CarRequestBean,BaseViewHolder> {
    public SelectCarAdapter(int layoutResId, @Nullable List<CarRequestBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarRequestBean item) {
        ConstraintLayout ll=helper.getView(R.id.item_select_ll);
        ImageView imageView=helper.getView(R.id.car_pic);
        helper.setText(R.id.car_no,item.getCarNo());
        helper.setText(R.id.car_loading,"最多装载"+item.getCarLoad()+"方");
        if (item.isCheck()){
            imageView.setImageResource(R.mipmap.select_car_true);
            ll.setBackgroundResource(R.drawable.shape_select_car_bg_true);
        }else {
            imageView.setImageResource(R.mipmap.select_car_false);
            ll.setBackgroundResource(R.drawable.shape_select_car_bg_false);
        }
    }
}
