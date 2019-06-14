package com.tongdada.library_main.finance.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.example.library_commen.model.TransportCarBean;
import com.tongdada.library_main.finance.net.respose.FinaceBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/21.
 */

public class FinaceCompleteAdapter extends BaseQuickAdapter<FinaceBean,BaseViewHolder>{
    public FinaceCompleteAdapter(int layoutResId, @Nullable List<FinaceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FinaceBean item) {
        helper.setText(R.id.transport_carnumber,item.getCarNo());
        helper.setText(R.id.driver_name,item.getDriverName());
        helper.setText(R.id.order_accept_time,item.getAcceptTime());
        helper.setText(R.id.distance_text,item.getTotalDistance()+"km");
    }
}
