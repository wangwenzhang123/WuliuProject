package com.tongdada.library_main.user.respose;

import com.example.library_commen.model.CarRequestBean;

import java.util.List;

/**
 * @name WuliuProject
 * @class describe
 * @anthor 王文章
 * @time 2019/6/6 17:17
 * @change
 */
public class CarListBean {

    /**
     * exportAllData : true
     * firstResult : 0
     * fullListSize : 1
     * list : [{"buyTime":"","carLatitude":"","carLoad":"28000","carLongitude":"","carName":"奥迪","carNo":"苏A234677","carRemarks":"","carStatus":"","carType":"","companyId":"2c91808c6b226cf6016b27abe989001b","createTime":{"date":6,"day":4,"hours":17,"minutes":11,"month":5,"nanos":0,"seconds":30,"time":1559812290000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driveLicense":"","driverId":"","id":"2c91808c6b2aab1f016b2c0eb8fd0006","updateTime":null,"updateUserID":""}]
     * listOfObject : [{"buyTime":"","carLatitude":"","carLoad":"28000","carLongitude":"","carName":"奥迪","carNo":"苏A234677","carRemarks":"","carStatus":"","carType":"","companyId":"2c91808c6b226cf6016b27abe989001b","createTime":{"date":6,"day":4,"hours":17,"minutes":11,"month":5,"nanos":0,"seconds":30,"time":1559812290000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driveLicense":"","driverId":"","id":"2c91808c6b2aab1f016b2c0eb8fd0006","updateTime":null,"updateUserID":""}]
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
    private List<CarRequestBean> list;
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

    public List<CarRequestBean> getList() {
        return list;
    }

    public void setList(List<CarRequestBean> list) {
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
         * buyTime :
         * carLatitude :
         * carLoad : 28000
         * carLongitude :
         * carName : 奥迪
         * carNo : 苏A234677
         * carRemarks :
         * carStatus :
         * carType :
         * companyId : 2c91808c6b226cf6016b27abe989001b
         * createTime : {"date":6,"day":4,"hours":17,"minutes":11,"month":5,"nanos":0,"seconds":30,"time":1559812290000,"timezoneOffset":-480,"year":119}
         * createUserID :
         * delFlag : 0
         * deptId :
         * driveLicense :
         * driverId :
         * id : 2c91808c6b2aab1f016b2c0eb8fd0006
         * updateTime : null
         * updateUserID :
         */

        private String buyTime;
        private String carLatitude;
        private String carLoad;
        private String carLongitude;
        private String carName;
        private String carNo;
        private String carRemarks;
        private String carStatus;
        private String carType;
        private String companyId;
        private CreateTimeBeanX createTime;
        private String createUserID;
        private int delFlag;
        private String deptId;
        private String driveLicense;
        private String driverId;
        private String id;
        private Object updateTime;
        private String updateUserID;

        public String getBuyTime() {
            return buyTime;
        }

        public void setBuyTime(String buyTime) {
            this.buyTime = buyTime;
        }

        public String getCarLatitude() {
            return carLatitude;
        }

        public void setCarLatitude(String carLatitude) {
            this.carLatitude = carLatitude;
        }

        public String getCarLoad() {
            return carLoad;
        }

        public void setCarLoad(String carLoad) {
            this.carLoad = carLoad;
        }

        public String getCarLongitude() {
            return carLongitude;
        }

        public void setCarLongitude(String carLongitude) {
            this.carLongitude = carLongitude;
        }

        public String getCarName() {
            return carName;
        }

        public void setCarName(String carName) {
            this.carName = carName;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getCarRemarks() {
            return carRemarks;
        }

        public void setCarRemarks(String carRemarks) {
            this.carRemarks = carRemarks;
        }

        public String getCarStatus() {
            return carStatus;
        }

        public void setCarStatus(String carStatus) {
            this.carStatus = carStatus;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

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

        public String getDriveLicense() {
            return driveLicense;
        }

        public void setDriveLicense(String driveLicense) {
            this.driveLicense = driveLicense;
        }

        public String getDriverId() {
            return driverId;
        }

        public void setDriverId(String driverId) {
            this.driverId = driverId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
             * date : 6
             * day : 4
             * hours : 17
             * minutes : 11
             * month : 5
             * nanos : 0
             * seconds : 30
             * time : 1559812290000
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
