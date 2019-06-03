package com.tongdada.base.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.tongdada.base.R;
import com.tongdada.base.dialog.base.BaseDialog;

/**
 * Created by wangshen on 2019/5/23.
 */

public class LoadingDialog extends BaseDialog {
    public LoadingDialog(@NonNull Context context) {
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
        return R.layout.loading_dialog;
    }
}
