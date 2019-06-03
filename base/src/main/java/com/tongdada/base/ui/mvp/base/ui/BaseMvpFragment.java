package com.tongdada.base.ui.mvp.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.base.util.ToastUtils;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/24 10:06
 * @change
 */
public abstract class BaseMvpFragment <P extends BasePresenter> extends BaseFragment implements BaseView{
    protected P presenter;
    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        presenter=getPresenter();
        presenter.attchView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void hideLoadingDialog() {
        mContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && dialog.isShowing() && !mContext.isFinishing()){
                    dialog.dismiss();
                }
            }
        });
    }

    @Override
    public BaseDialog getDialog() {
        return null;
    }

    @Override
    public void showMessage(String msg) {
        ToastUtils.showToast(mContext,msg);
    }

    @Override
    public void showToast(String ms) {
        ToastUtils.showToast(mContext,ms);
    }

    @Override
    public void showLoadingDialog() {
        mContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && !dialog.isShowing() && !mContext.isFinishing()){
                    dialog.show();
                }
            }
        });
    }
    public abstract P getPresenter();

    @Override
    public void routerIntent(String path, Bundle bundle) {
        ARouter.getInstance().build(path).with(bundle).navigation(mContext);
    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void finishActivityForResult(int resultCode, Intent data) {

    }
}
