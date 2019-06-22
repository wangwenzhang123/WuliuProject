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
    public static String getBangName(String type){
        String name="";
        switch (type){
            case "B1":
                name="汽车泵37米";
                break;
            case "B2":
                name="汽车泵42-53米";
                break;
            case "B3":
                name="汽车泵56-62米";
                break;
            case "B4":
                name="普通固定泵";
                break;
            case "B5":
                name="高压固定泵";
                break;
        }
        return name;
    }
}
