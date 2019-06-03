package com.tongdada.sample;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;

import java.util.List;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 16:20
 * @change
 */
public class SampleAdapter extends BaseAdapter<SampleBean.ResultBean> {
    public SampleAdapter(int layoutResId, @Nullable List<SampleBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SampleBean.ResultBean item) {
        super.convert(helper, item);
        helper.setText(R.id.item_sample_tv,item.getPaymentName());
    }
}
