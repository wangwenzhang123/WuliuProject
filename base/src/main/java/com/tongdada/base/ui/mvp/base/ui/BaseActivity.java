package com.tongdada.base.ui.mvp.base.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.noober.background.BackgroundLibrary;
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
