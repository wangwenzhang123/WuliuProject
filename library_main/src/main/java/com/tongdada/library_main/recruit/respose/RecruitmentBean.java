package com.tongdada.library_main.recruit.respose;

import com.example.library_commen.model.RecuritListBean;

import java.util.List;

public class RecruitmentBean {

    /**
     * exportAllData : true
     * firstResult : 0
     * fullListSize : 1
     * list : [{"companyAddress":"汉中门","companyId":"","companyName":"中央建材","contacts":"测试账户","createTime":{"date":3,"day":6,"hours":17,"minutes":48,"month":7,"nanos":0,"seconds":58,"time":1564825738000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","endTime":"","id":"2c91808c6c516527016c56e1db220001","phoneNo":"18913986006","positionName":"运输公司","positionRemarks":"南京上班","positionSalary":"8K-20K","publishTime":"2019-08-03 17:48:57","stationId":"2c91808c6b96b642016b9b7bd2720004","updateTime":null,"updateUserID":""}]
     * listOfObject : [{"companyAddress":"汉中门","companyId":"","companyName":"中央建材","contacts":"测试账户","createTime":{"date":3,"day":6,"hours":17,"minutes":48,"month":7,"nanos":0,"seconds":58,"time":1564825738000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","endTime":"","id":"2c91808c6c516527016c56e1db220001","phoneNo":"18913986006","positionName":"运输公司","positionRemarks":"南京上班","positionSalary":"8K-20K","publishTime":"2019-08-03 17:48:57","stationId":"2c91808c6b96b642016b9b7bd2720004","updateTime":null,"updateUserID":""}]
     * objectsPerPage : 10
     * pageNumber : 1
     * pageSize : 10
     * searchId :
     * sortCriterion :
     * sortDirection : {"code":2,"name":"ascending"}
     * sortType : ascending
     * totalCount : 1
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
    private List<RecuritListBean> list;
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

    public List<RecuritListBean> getList() {
        return list;
    }

    public void setList(List<RecuritListBean> list) {
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

   /* public static class ListBean {
        *//**
         * companyAddress : 汉中门
         * companyId :
         * companyName : 中央建材
         * contacts : 测试账户
         * createTime : {"date":3,"day":6,"hours":17,"minutes":48,"month":7,"nanos":0,"seconds":58,"time":1564825738000,"timezoneOffset":-480,"year":119}
         * createUserID :
         * delFlag : 0
         * deptId :
         * endTime :
         * id : 2c91808c6c516527016c56e1db220001
         * phoneNo : 18913986006
         * positionName : 运输公司
         * positionRemarks : 南京上班
         * positionSalary : 8K-20K
         * publishTime : 2019-08-03 17:48:57
         * stationId : 2c91808c6b96b642016b9b7bd2720004
         * updateTime : null
         * updateUserID :
         *//*

        private String companyAddress;
        private String companyId;
        private String companyName;
        private String contacts;
        private CreateTimeBean createTime;
        private String createUserID;
        private int delFlag;
        private String deptId;
        private String endTime;
        private String id;
        private String phoneNo;
        private String positionName;
        private String positionRemarks;
        private String positionSalary;
        private String publishTime;
        private String stationId;
        private Object updateTime;
        private String updateUserID;

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
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

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getPositionName() {
            return positionName;
        }

        public void setPositionName(String positionName) {
            this.positionName = positionName;
        }

        public String getPositionRemarks() {
            return positionRemarks;
        }

        public void setPositionRemarks(String positionRemarks) {
            this.positionRemarks = positionRemarks;
        }

        public String getPositionSalary() {
            return positionSalary;
        }

        public void setPositionSalary(String positionSalary) {
            this.positionSalary = positionSalary;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getStationId() {
            return stationId;
        }

        public void setStationId(String stationId) {
            this.stationId = stationId;
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

        public static class CreateTimeBean {
            *//**
             * date : 3
             * day : 6
             * hours : 17
             * minutes : 48
             * month : 7
             * nanos : 0
             * seconds : 58
             * time : 1564825738000
             * timezoneOffset : -480
             * year : 119
             *//*

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }*/

    public static class ListOfObjectBean {
        /**
         * companyAddress : 汉中门
         * companyId :
         * companyName : 中央建材
         * contacts : 测试账户
         * createTime : {"date":3,"day":6,"hours":17,"minutes":48,"month":7,"nanos":0,"seconds":58,"time":1564825738000,"timezoneOffset":-480,"year":119}
         * createUserID :
         * delFlag : 0
         * deptId :
         * endTime :
         * id : 2c91808c6c516527016c56e1db220001
         * phoneNo : 18913986006
         * positionName : 运输公司
         * positionRemarks : 南京上班
         * positionSalary : 8K-20K
         * publishTime : 2019-08-03 17:48:57
         * stationId : 2c91808c6b96b642016b9b7bd2720004
         * updateTime : null
         * updateUserID :
         */

        private String companyAddress;
        private String companyId;
        private String companyName;
        private String contacts;
        private CreateTimeBeanX createTime;
        private String createUserID;
        private int delFlag;
        private String deptId;
        private String endTime;
        private String id;
        private String phoneNo;
        private String positionName;
        private String positionRemarks;
        private String positionSalary;
        private String publishTime;
        private String stationId;
        private Object updateTime;
        private String updateUserID;

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public CreateTimeBeanX getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBeanX createTime) {
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

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getPositionName() {
            return positionName;
        }

        public void setPositionName(String positionName) {
            this.positionName = positionName;
        }

        public String getPositionRemarks() {
            return positionRemarks;
        }

        public void setPositionRemarks(String positionRemarks) {
            this.positionRemarks = positionRemarks;
        }

        public String getPositionSalary() {
            return positionSalary;
        }

        public void setPositionSalary(String positionSalary) {
            this.positionSalary = positionSalary;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getStationId() {
            return stationId;
        }

        public void setStationId(String stationId) {
            this.stationId = stationId;
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

        public static class CreateTimeBeanX {
            /**
             * date : 3
             * day : 6
             * hours : 17
             * minutes : 48
             * month : 7
             * nanos : 0
             * seconds : 58
             * time : 1564825738000
             * timezoneOffset : -480
             * year : 119
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
