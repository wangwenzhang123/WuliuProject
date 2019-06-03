package com.tongdada.library_main.user.respose;

import android.text.TextUtils;

import com.tongdada.base.net.bean.ExBaseEntity;

import java.util.List;

/**
 * Created by wangshen on 2019/5/20.
 */

public class MessageBean implements ExBaseEntity {

    /**
     * code : 0
     * message : 获取成功!
     * model : null
     * pagenation : {"exportAllData":true,"firstResult":0,"fullListSize":2,"list":[{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123","messageContent":"你说实话看看","readStatus":"Y","sendTime":"2019-05-16 10:19:16","updateTime":null,"updateUserID":""},{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123231","messageContent":"sdasd1饿肚肚","readStatus":"N","sendTime":"2019-05-17 10:19:16","updateTime":null,"updateUserID":""}],"listOfObject":[{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123","messageContent":"你说实话看看","readStatus":"Y","sendTime":"2019-05-16 10:19:16","updateTime":null,"updateUserID":""},{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123231","messageContent":"sdasd1饿肚肚","readStatus":"N","sendTime":"2019-05-17 10:19:16","updateTime":null,"updateUserID":""}],"objectsPerPage":10,"pageNumber":1,"pageSize":10,"searchId":"","sortCriterion":"","sortDirection":{"code":2,"name":"ascending"},"sortType":"ascending","totalCount":2}
     * success : true
     */

    private String code;
    private String message;
    private Object model;
    private PagenationBean pagenation;
    private boolean success;

    public String getCode() {
        return code;
    }

    @Override
    public boolean isExpireLogin() {
        return false;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean isSuccessful() {
        return TextUtils.equals("0", code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public PagenationBean getPagenation() {
        return pagenation;
    }

    public void setPagenation(PagenationBean pagenation) {
        this.pagenation = pagenation;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class PagenationBean {
        /**
         * exportAllData : true
         * firstResult : 0
         * fullListSize : 2
         * list : [{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123","messageContent":"你说实话看看","readStatus":"Y","sendTime":"2019-05-16 10:19:16","updateTime":null,"updateUserID":""},{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123231","messageContent":"sdasd1饿肚肚","readStatus":"N","sendTime":"2019-05-17 10:19:16","updateTime":null,"updateUserID":""}]
         * listOfObject : [{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123","messageContent":"你说实话看看","readStatus":"Y","sendTime":"2019-05-16 10:19:16","updateTime":null,"updateUserID":""},{"appUserId":"4028830d6abe6beb016abe6fc92c0002","createTime":null,"createUserID":"","delFlag":0,"deptId":"","id":"123231","messageContent":"sdasd1饿肚肚","readStatus":"N","sendTime":"2019-05-17 10:19:16","updateTime":null,"updateUserID":""}]
         * objectsPerPage : 10
         * pageNumber : 1
         * pageSize : 10
         * searchId :
         * sortCriterion :
         * sortDirection : {"code":2,"name":"ascending"}
         * sortType : ascending
         * totalCount : 2
         */

        private boolean exportAllData;
        private int firstResult;
        private int fullListSize;
        private int objectsPerPage;
        private int pageNumber;
        private int pageSize;
        private String searchId;
        private String sortCriterion;
        private SortDirectionBean sortDirection;
        private String sortType;
        private int totalCount;
        private List<ListBean> list;
        private List<ListOfObjectBean> listOfObject;

        public boolean isExportAllData() {
            return exportAllData;
        }

        public void setExportAllData(boolean exportAllData) {
            this.exportAllData = exportAllData;
        }

        public int getFirstResult() {
            return firstResult;
        }

        public void setFirstResult(int firstResult) {
            this.firstResult = firstResult;
        }

        public int getFullListSize() {
            return fullListSize;
        }

        public void setFullListSize(int fullListSize) {
            this.fullListSize = fullListSize;
        }

        public int getObjectsPerPage() {
            return objectsPerPage;
        }

        public void setObjectsPerPage(int objectsPerPage) {
            this.objectsPerPage = objectsPerPage;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String getSearchId() {
            return searchId;
        }

        public void setSearchId(String searchId) {
            this.searchId = searchId;
        }

        public String getSortCriterion() {
            return sortCriterion;
        }

        public void setSortCriterion(String sortCriterion) {
            this.sortCriterion = sortCriterion;
        }

        public SortDirectionBean getSortDirection() {
            return sortDirection;
        }

        public void setSortDirection(SortDirectionBean sortDirection) {
            this.sortDirection = sortDirection;
        }

        public String getSortType() {
            return sortType;
        }

        public void setSortType(String sortType) {
            this.sortType = sortType;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<ListOfObjectBean> getListOfObject() {
            return listOfObject;
        }

        public void setListOfObject(List<ListOfObjectBean> listOfObject) {
            this.listOfObject = listOfObject;
        }

        public static class SortDirectionBean {
            /**
             * code : 2
             * name : ascending
             */

            private int code;
            private String name;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListBean {
            /**
             * appUserId : 4028830d6abe6beb016abe6fc92c0002
             * createTime : null
             * createUserID :
             * delFlag : 0
             * deptId :
             * id : 123
             * messageContent : 你说实话看看
             * readStatus : Y
             * sendTime : 2019-05-16 10:19:16
             * updateTime : null
             * updateUserID :
             */

            private String appUserId;
            private Object createTime;
            private String createUserID;
            private int delFlag;
            private String deptId;
            private String id;
            private String messageContent;
            private String readStatus;
            private String sendTime;
            private Object updateTime;
            private String updateUserID;

            public String getAppUserId() {
                return appUserId;
            }

            public void setAppUserId(String appUserId) {
                this.appUserId = appUserId;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public String getCreateUserID() {
                return createUserID;
            }

            public void setCreateUserID(String createUserID) {
                this.createUserID = createUserID;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMessageContent() {
                return messageContent;
            }

            public void setMessageContent(String messageContent) {
                this.messageContent = messageContent;
            }

            public String getReadStatus() {
                return readStatus;
            }

            public void setReadStatus(String readStatus) {
                this.readStatus = readStatus;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateUserID() {
                return updateUserID;
            }

            public void setUpdateUserID(String updateUserID) {
                this.updateUserID = updateUserID;
            }
        }

        public static class ListOfObjectBean {
            /**
             * appUserId : 4028830d6abe6beb016abe6fc92c0002
             * createTime : null
             * createUserID :
             * delFlag : 0
             * deptId :
             * id : 123
             * messageContent : 你说实话看看
             * readStatus : Y
             * sendTime : 2019-05-16 10:19:16
             * updateTime : null
             * updateUserID :
             */

            private String appUserId;
            private Object createTime;
            private String createUserID;
            private int delFlag;
            private String deptId;
            private String id;
            private String messageContent;
            private String readStatus;
            private String sendTime;
            private Object updateTime;
            private String updateUserID;

            public String getAppUserId() {
                return appUserId;
            }

            public void setAppUserId(String appUserId) {
                this.appUserId = appUserId;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public String getCreateUserID() {
                return createUserID;
            }

            public void setCreateUserID(String createUserID) {
                this.createUserID = createUserID;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMessageContent() {
                return messageContent;
            }

            public void setMessageContent(String messageContent) {
                this.messageContent = messageContent;
            }

            public String getReadStatus() {
                return readStatus;
            }

            public void setReadStatus(String readStatus) {
                this.readStatus = readStatus;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateUserID() {
                return updateUserID;
            }

            public void setUpdateUserID(String updateUserID) {
                this.updateUserID = updateUserID;
            }
        }
    }
}
