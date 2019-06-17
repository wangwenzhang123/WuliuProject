package com.tongdada.base.ui.mvp.base.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.noober.background.BackgroundLibrary;
import com.tongdada.base.R;
import com.tongdada.base.dialog.LoadingDialog;
import com.tongdada.base.dialog.base.BaseDialog;

import butterknife.ButterKnife;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:23
 * @change
 */
public abstract class BaseActivity extends AppCompatActivity{
    protected BaseDialog dialog;
    protected Context mContext=this;
    protected String TGA=getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getView());
        ButterKnife.bind(this);
        if (getDialog() == null){
            dialog=new LoadingDialog(this);
        }else {
            dialog=getDialog();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.E06E38));
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initView();
        initLinsenterner();
        getData();
    }

    public abstract int getView();
    public abstract BaseDialog getDialog();
    public abstract void initView();
    public abstract void initLinsenterner();
    public abstract void getData();
}
