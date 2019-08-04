package com.tongdada.library_main.recruit.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.appkey.IntentKey;
import com.example.library_commen.model.RecuritListBean;
import com.example.library_main.R;
import com.example.library_main.R2;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.ui.BaseMvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = ArouterKey.RECRUIT_JOBDETAILSACTIVITY)
public class JobDetailsActivity extends BaseMvpActivity {
    @BindView(R2.id.register_back)
    ImageView registerBack;
    @BindView(R2.id.back_tv)
    TextView backTv;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.issue_back_rl)
    RelativeLayout issueBackRl;
    @BindView(R2.id.resume_list_rg)
    RadioButton resumeListRg;
    @BindView(R2.id.job_detail_rb)
    RadioButton jobDetailRb;
    @BindView(R2.id.job_detail_rg)
    RadioGroup jobDetailRg;
    @BindView(R2.id.content)
    FrameLayout content;
    private ResumeCenterFragment resumeCenterFragment;
    private PublishJobFragment publishJobFragment;
    @Override
    public BasePresenter getPresenter() {
        return new BasePresenter();
    }

    @Override
    public int getView() {
        return R.layout.activity_jobdetail;
    }

    @Override
    public void getData() {
        RecuritListBean recuritListBean= (RecuritListBean) getIntent().getSerializableExtra(IntentKey.RECUIRT_BEAN);
        resumeCenterFragment=new ResumeCenterFragment(recuritListBean.getId());
        publishJobFragment=new PublishJobFragment();
        publishJobFragment.setRequestBean(recuritListBean);
        switchFrament(publishJobFragment,resumeCenterFragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.register_back)
    public void onRegisterBackClicked() {
        finish();
    }

    @OnClick(R2.id.back_tv)
    public void onBackTvClicked() {
        finish();
    }

    @OnClick(R2.id.resume_list_rg)
    public void onResumeListRgClicked() {
        switchFrament(publishJobFragment,resumeCenterFragment);
    }

    @OnClick(R2.id.job_detail_rb)
    public void onJobDetailRbClicked() {
        switchFrament(resumeCenterFragment,publishJobFragment);
    }
    private void switchFrament(Fragment from, Fragment to) {
        if(from != to){ //才切换
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //开启事务
            //判断to有没有被添加
            if(!to.isAdded()){//to没有被添加
                //1.from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //2.添加to
                if(to != null){
                    ft.add(R.id.content,to).show(to).commit();
                }
            }else{ //to已经被添加
                //1.from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //2.显示to
                if(to != null){
                    ft.show(to).commit();
                }
            }
        }
    }
}
