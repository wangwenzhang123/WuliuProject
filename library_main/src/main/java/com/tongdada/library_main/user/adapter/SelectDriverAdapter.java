package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_commen.model.CarRequestBean;
import com.example.library_commen.model.DriverRequest;
import com.example.library_main.R;

import java.util.List;

/**
 * Created by wangshen on 2019/6/7.
 */

public class SelectDriverAdapter extends BaseQuickAdapter<DriverRequest,BaseViewHolder> {
    public SelectDriverAdapter(int layoutResId, @Nullable List<DriverRequest> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DriverRequest item) {
        helper.setText(R.id.name,item.getDriverName());
    }
}
