package com.example.library_commen.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by wangshen on 2019/5/19.
 */

public class PhoneCallUtils {
    public static void call(String phoneNum,Context context){

        if (TextUtils.isEmpty(phoneNum)){ //电话号码为空
            return;
        }

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:"+phoneNum);   //设置要操作界面的具体内容  拨打电话固定格式： tel：
        intent.setData(uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
