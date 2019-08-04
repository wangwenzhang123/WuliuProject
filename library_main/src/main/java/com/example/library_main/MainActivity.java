package com.example.library_main;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.example.library_commen.event.EventMainFinishBean;
import com.example.library_commen.utils.CommenUtils;
import com.tongdada.base.util.ToastUtils;
import com.tongdada.library_main.finance.ui.FinanceFragment;
import com.tongdada.library_main.home.ui.HomeFragment;
import com.tongdada.library_main.order.ui.OrderFragment;
import com.tongdada.library_main.recruit.ui.RecruitFragment;
import com.tongdada.library_main.resume.ui.ReSumeFragment;
import com.tongdada.library_main.statistics.ui.StatisticsFragment;
import com.tongdada.library_main.user.ui.UserFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tongdada.library_main.utils.LoginUtils.isLogin;

@Route(path = ArouterKey.MAIN_MAINACTIVITY)
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R2.id.main_vp)
    NoScrollViewPager mainVp;
    @BindView(R2.id.main_rg)
    RadioGroup mainRg;
    private List<Fragment> fragments=new ArrayList<>();
    private MyViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        EventBus.getDefault().register(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.E06E38));
        }
        ARouter.getInstance().inject(this);
        ButterKnife.bind(this);
        getData();
        initView();
        initLinsenterner();
    }


    public int getView() {
        return R.layout.activity_main;
    }

    public void initView() {
        mainVp.setAdapter(adapter);
        mainVp.setNoScroll(true);
        mainVp.setCurrentItem(2);
        mainRg.setOnCheckedChangeListener(this);
    }


    public void initLinsenterner() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventFinish(EventMainFinishBean eventMainFinishBean){
        finish();
    }

    public void getData() {
        fragments.add(new OrderFragment());
        fragments.add(new FinanceFragment());

        fragments.add(new HomeFragment());
        if (CommenUtils.LOGIN_TYPE == 0){
            fragments.add(new RecruitFragment());
        }else {
            fragments.add(new ReSumeFragment());
        }
        fragments.add(new UserFragment());
        adapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragments);
        mainVp.setOffscreenPageLimit(4);
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        ToastUtils.showToast(this,"再点一次退出程序！");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int currentFragment=0;
        if (i == R.id.main_rb_finance) {
            currentFragment = 1;
        } else if (i == R.id.main_rb_order) {
            currentFragment = 0;
        } else if (i == R.id.main_rb_home) {
            currentFragment = 2;

        } else if (i == R.id.main_rb_statistics) {
            currentFragment = 3;

        } else if (i == R.id.main_rb_user) {
            currentFragment = 4;
        }

        if (!isLogin()) {
           if (currentFragment == 1 || currentFragment == 0 || currentFragment == 3 || currentFragment == 4){
               ARouter.getInstance().build(ArouterKey.LOGIN_LOGINACTIVITY).navigation(this);
           }
           return;
        }
        mainVp.setCurrentItem(currentFragment);
    }
}
