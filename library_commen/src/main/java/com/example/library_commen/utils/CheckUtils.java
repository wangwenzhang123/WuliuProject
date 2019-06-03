package com.example.library_commen.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangshen on 2019/5/30.
 */

public class CheckUtils {
    public static boolean isChinaPhoneLegal(String str) {
        Matcher m = null;
        try {
            String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
            Pattern p = Pattern.compile(regExp);
            m = p.matcher(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return m.matches();
    }
}
