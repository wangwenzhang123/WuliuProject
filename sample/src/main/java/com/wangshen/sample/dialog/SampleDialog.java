package com.tongdada.sample.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.sample.R;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 15:33
 * @change
 */
public class SampleDialog extends BaseDialog {
    public SampleDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getView() {
        return R.layout.dialog_sample;
    }
}
