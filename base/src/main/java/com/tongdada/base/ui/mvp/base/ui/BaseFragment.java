package com.tongdada.base.ui.mvp.base.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.tongdada.base.dialog.LoadingDialog;
import com.tongdada.base.dialog.base.BaseDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @name ProjectBase
 * @class describe
 * @anthor 王文章
 * @time 2018/10/31 10:24
 * @change
 */
public abstract class BaseFragment extends Fragment{
    protected BaseDialog dialog;
    protected Activity mContext;
    private Unbinder unBinder;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext=activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = getView();
        if (rootView == null) {
            rootView = inflater.inflate(getViewId(), null);
        } else {
            final ViewParent parent = rootView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(rootView);
            }
        }
        unBinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (getDialog()==null){
            dialog=new LoadingDialog(mContext);
        }else {
            dialog=getDialog();
        }
        initLinsenterner();
        getData();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public abstract int getViewId();
    public abstract BaseDialog getDialog();
    public abstract void initView();
    public abstract void initLinsenterner();
    public abstract void getData();
}
