package com.example.library_main;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.library_commen.appkey.ArouterKey;
import com.tongdada.library_main.finance.ui.FinanceFragment;
import com.tongdada.library_main.home.ui.HomeFragment;
import com.tongdada.library_main.order.ui.OrderFragment;
import com.tongdada.library_main.statistics.ui.StatisticsFragment;
import com.tongdada.library_main.user.ui.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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


    public void getData() {
        fragments.add(new OrderFragment());
        fragments.add(new FinanceFragment());

        fragments.add(new HomeFragment());
        fragments.add(new StatisticsFragment());
        fragments.add(new UserFragment());
        adapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragments);
        mainVp.setOffscreenPageLimit(4);
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
        mainVp.setCurrentItem(currentFragment);
    }
}
