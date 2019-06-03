package com.tongdada.base.ui.mvp.base.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 9:54
 * @change
 */
public abstract class BaseAdapter<Model> extends BaseQuickAdapter<Model,BaseViewHolder> {
    public BaseAdapter(int layoutResId, @Nullable List<Model> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Model item) {

    }
}
