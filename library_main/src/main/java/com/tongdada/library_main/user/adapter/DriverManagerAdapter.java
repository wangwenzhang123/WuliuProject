package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tongdada.library_main.widget.CarSlidingMenu;
import com.tongdada.library_main.widget.DriverSlidingMenu;

import java.util.List;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:30
 * @change
 */
public class DriverManagerAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public DriverManagerAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
    private DriverSlidingMenu mOpenMenu;

    public void holdOpenMenu(DriverSlidingMenu slidingMenu) {
        mOpenMenu = slidingMenu;
    }

    public void closeOpenMenu() {
        if (mOpenMenu != null && mOpenMenu.isOpen()) {
            mOpenMenu.closeMenu();
        }
    }
}
