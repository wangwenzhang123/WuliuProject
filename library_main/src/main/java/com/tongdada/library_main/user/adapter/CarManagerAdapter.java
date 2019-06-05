package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library_main.R;
import com.tongdada.library_main.widget.CarSlidingMenu;
import com.tongdada.library_main.widget.MessageSlidingMenu;

import java.util.List;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/4 16:30
 * @change
 */
public class CarManagerAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public CarManagerAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.item_slide);
    }
    private CarSlidingMenu mOpenMenu;

    public void holdOpenMenu(CarSlidingMenu slidingMenu) {
        mOpenMenu = slidingMenu;
    }

    public void closeOpenMenu() {
        if (mOpenMenu != null && mOpenMenu.isOpen()) {
            mOpenMenu.closeMenu();
        }
    }
}
