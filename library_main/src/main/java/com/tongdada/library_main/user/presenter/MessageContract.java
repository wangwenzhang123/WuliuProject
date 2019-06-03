package com.tongdada.library_main.user.presenter;

import com.tongdada.base.ui.mvp.base.view.BaseView;
import com.tongdada.library_main.user.respose.MessageBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/23.
 */

public class MessageContract {
    public interface View extends BaseView{
        void setMessgeList(List<MessageBean.PagenationBean.ListBean> list);
    }
    public interface Presenter{
        void getMessageList();
        void readMessage(String  id);
        void deleteMessage(String id);
    }
}
