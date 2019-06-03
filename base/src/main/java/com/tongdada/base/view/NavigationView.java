package com.tongdada.base.view;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @name Base
 * @class describe
 * @anthor 王文章
 * @time 2018/12/28 10:20
 * @change
 */
public class NavigationView extends RadioGroup{
    List<String> contentList=new ArrayList<>();
    List<Integer> drwableList=new ArrayList<>();
    public NavigationView(Context context) {
        super(context);
    }

    public void setContentList(List<String> contentList,List<Integer> drwableList) {
        this.contentList = contentList;
        this.drwableList = drwableList;
        addChild();
        invalidate();
    }

    public void addChild(){
        for (int i=0;i<contentList.size();i++){
            RadioButton radioButton=new RadioButton(getContext());
            radioButton.setText(contentList.get(i));
            if (i < drwableList.size()){
                radioButton.setButtonDrawable(drwableList.get(i));
                addView(radioButton);
            }
        }
    }

    class Builder{
        NavigationView navigationView;

        NavigationView creat(){
            return navigationView;
        }
    }
}
