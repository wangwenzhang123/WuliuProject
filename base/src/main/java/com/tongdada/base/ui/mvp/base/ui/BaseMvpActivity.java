package com.tongdada.base.ui.mvp.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tongdada.base.dialog.LoadingDialog;
import com.tongdada.base.dialog.base.BaseDialog;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.base.util.ToastUtils;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/20 16:57
 * @change
 */
public abstract class BaseMvpActivity <P extends BasePresenter> extends BaseActivity implements BaseView{
    protected P presenter;
    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=getPresenter();
        presenter.attchView(this);
    }

    @Override
    public void showLoadingDialog() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && !dialog.isShowing() && !isFinishing()){
                    dialog.show();
                }
            }
        });

    }

    @Override
    public BaseDialog getDialog() {
        return new LoadingDialog(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void showToast(final String ms) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(mContext,ms);
            }
        });
    }

    @Override
    public void hideLoadingDialog() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && dialog.isShowing() && !isFinishing()){
                    dialog.dismiss();
                }
            }
        });
    }

    public abstract P getPresenter();

    @Override
    public void showMessage(final String msg) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(mContext,msg);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }

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
