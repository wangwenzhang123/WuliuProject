package com.tongdada.library_main.home.request;

import java.io.Serializable;

/**
 * Created by wangshen on 2019/6/1.
 */

public class MessageIntentBean implements Serializable{
    private String title;
    private String pic;
    private String conten;
    private String time;

    public MessageIntentBean(String title, String pic, String conten, String time) {
        this.title = title;
        this.pic = pic;
        this.conten = conten;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getConten() {
        return conten;
    }

    public void setConten(String conten) {
        this.conten = conten;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
