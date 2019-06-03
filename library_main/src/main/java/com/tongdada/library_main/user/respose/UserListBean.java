package com.tongdada.library_main.user.respose;

import android.text.TextUtils;

import com.example.library_commen.model.UserBean;
import com.tongdada.base.net.bean.ExBaseEntity;

import java.util.List;

/**
 * Created by wangshen on 2019/5/24.
 */

public class UserListBean implements ExBaseEntity {
    /**
     * code : 0
     * message : 获取成功!
     * model : null
     * pagenation : {"exportAllData":true,"firstResult":0,"fullListSize":2,"list":[{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"123123","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18912345678","userName":"大苏打","userPassword":"777777","userStatus":"Y"},{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"4028830d6abe6beb016abe6fc92c0002","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18932341238","userName":"张丰","userPassword":"8888","userStatus":"N"}],"listOfObject":[{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"123123","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18912345678","userName":"大苏打","userPassword":"777777","userStatus":"Y"},{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"4028830d6abe6beb016abe6fc92c0002","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18932341238","userName":"张丰","userPassword":"8888","userStatus":"N"}],"objectsPerPage":10,"pageNumber":1,"pageSize":10,"searchId":"","sortCriterion":"","sortDirection":{"code":2,"name":"ascending"},"sortType":"ascending","totalCount":2}
     * success : true
     */

    private String code;
    private String message;
    private Object model;
    private PagenationBean pagenation;
    private boolean success;

    @Override
    public boolean isSuccessful() {
        return TextUtils.equals("0", code);
    }

    @Override
    public boolean isExpireLogin() {
        return false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
         * list : [{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"123123","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18912345678","userName":"大苏打","userPassword":"777777","userStatus":"Y"},{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"4028830d6abe6beb016abe6fc92c0002","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18932341238","userName":"张丰","userPassword":"8888","userStatus":"N"}]
         * listOfObject : [{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"123123","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18912345678","userName":"大苏打","userPassword":"777777","userStatus":"Y"},{"companyId":"","createTime":{"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverId":"","iconPic":"","id":"4028830d6abe6beb016abe6fc92c0002","regTime":"2019-05-16 10:19:16","stationId":"4028830d6abe6beb016abe6f84300001","stationRemarks":"","updateTime":null,"updateUserID":"","userAddress":"","userContacts":"18932341238","userName":"张丰","userPassword":"8888","userStatus":"N"}]
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
        private List<UserBean> list;
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

        public List<UserBean> getList() {
            return list;
        }

        public void setList(List<UserBean> list) {
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


        public static class ListOfObjectBean {
            /**
             * companyId :
             * createTime : {"date":16,"day":4,"hours":10,"minutes":19,"month":4,"nanos":0,"seconds":18,"time":1557973158000,"timezoneOffset":-480,"year":119}
             * createUserID :
             * delFlag : 0
             * deptId :
             * driverId :
             * iconPic :
             * id : 123123
             * regTime : 2019-05-16 10:19:16
             * stationId : 4028830d6abe6beb016abe6f84300001
             * stationRemarks :
             * updateTime : null
             * updateUserID :
             * userAddress :
             * userContacts : 18912345678
             * userName : 大苏打
             * userPassword : 777777
             * userStatus : Y
             */

            private String companyId;
            private CreateTimeBeanX createTime;
            private String createUserID;
            private int delFlag;
            private String deptId;
            private String driverId;
            private String iconPic;
            private String id;
            private String regTime;
            private String stationId;
            private String stationRemarks;
            private Object updateTime;
            private String updateUserID;
            private String userAddress;
            private String userContacts;
            private String userName;
            private String userPassword;
            private String userStatus;

            public String getCompanyId() {
                return companyId;
            }

            public void setCompanyId(String companyId) {
                this.companyId = companyId;
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

            public String getDriverId() {
                return driverId;
            }

            public void setDriverId(String driverId) {
                this.driverId = driverId;
            }

            public String getIconPic() {
                return iconPic;
            }

            public void setIconPic(String iconPic) {
                this.iconPic = iconPic;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRegTime() {
                return regTime;
            }

            public void setRegTime(String regTime) {
                this.regTime = regTime;
            }

            public String getStationId() {
                return stationId;
            }

            public void setStationId(String stationId) {
                this.stationId = stationId;
            }

            public String getStationRemarks() {
                return stationRemarks;
            }

            public void setStationRemarks(String stationRemarks) {
                this.stationRemarks = stationRemarks;
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

            public String getUserAddress() {
                return userAddress;
            }

            public void setUserAddress(String userAddress) {
                this.userAddress = userAddress;
            }

            public String getUserContacts() {
                return userContacts;
            }

            public void setUserContacts(String userContacts) {
                this.userContacts = userContacts;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPassword() {
                return userPassword;
            }

            public void setUserPassword(String userPassword) {
                this.userPassword = userPassword;
            }

            public String getUserStatus() {
                return userStatus;
            }

            public void setUserStatus(String userStatus) {
                this.userStatus = userStatus;
            }

            public static class CreateTimeBeanX {
                /**
                 * date : 16
                 * day : 4
                 * hours : 10
                 * minutes : 19
                 * month : 4
                 * nanos : 0
                 * seconds : 18
                 * time : 1557973158000
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
}
