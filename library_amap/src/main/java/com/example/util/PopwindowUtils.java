package com.example.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.library_amap.R;
import com.example.library_commen.model.OrderBean;

/**
 * Created by wangshen on 2019/5/22.
 */

public class PopwindowUtils {
    private static PopwindowUtils popwindowUtils;
    private PopupWindow orderPop;
    private PopwindowUtils() {
    }
    public static PopwindowUtils getIncetance(){
        synchronized (PopwindowUtils.class){
            if (popwindowUtils == null){
                synchronized (PopwindowUtils.class){
                    popwindowUtils=new PopwindowUtils();
                }
            }
        }
        return popwindowUtils;
    }
    public void initOrderPop(Context context,OrderBean orderBean){
        View contentView= LayoutInflater.from(context).inflate(R.layout.fragment_order_detail, null, false);
        orderPop=new PopupWindow(contentView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
        orderPop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        orderPop.setOutsideTouchable(true);
        orderPop.setTouchable(true);
        orderPop.setAnimationStyle(R.style.mypopwindow_anim_style);
        ImageView back=contentView.findViewById(R.id.back_iv);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderPop.dismiss();
            }
        });
    }
    public void showOrderPop(View view){
        orderPop.showAtLocation(view, Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL, 0, 0);
    }
}
