package com.example.library_amap.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_amap.R;
import com.example.library_amap.model.AdressBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/19.
 */

public class SearchMapAdapter extends BaseQuickAdapter<AdressBean,BaseViewHolder> {
    public SearchMapAdapter(int layoutResId, @Nullable List<AdressBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AdressBean item) {
        CheckBox button=helper.getView(R.id.btn_select);
        button.setOnClickListener(null);
        if (item.isSelect()){
            button.setChecked(true);
        }else {
            button.setChecked(false);
        }
        helper.setText(R.id.adree_name,item.getGeocodeAddress().getDistrict());
        helper.setText(R.id.adree_number,item.getGeocodeAddress().getFormatAddress());
    }
}
