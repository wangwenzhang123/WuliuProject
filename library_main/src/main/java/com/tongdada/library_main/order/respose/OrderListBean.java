package com.tongdada.library_main.order.respose;

import com.example.library_commen.model.OrderBean;

import java.util.List;

/**
 * Created by wangshen on 2019/5/25.
 */

public class OrderListBean {

    /**
     * exportAllData : true
     * firstResult : 0
     * fullListSize : 4
     * list : [{"carType":"T20","createTime":{"date":24,"day":5,"hours":22,"minutes":34,"month":4,"nanos":0,"seconds":7,"time":1558708447000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"煌上煌酱鸭(南京南站)","dstLatitude":"31.968628","dstLongitude":"118.797913","id":"2c91808c6aea409d016aea4368f50002","orderAmount":"123","orderName":"123","orderNo":"","orderRemark":"备注","orderStatus":"F","perPrice":"100","publishTime":"","startLatitude":"32.037651","startLongitude":"118.784997","startPlace":"luckin coffee瑞幸咖啡(新街口店)","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"12248","updateTime":null,"updateUserID":""},{"carType":"B","createTime":null,"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"安徽","dstLatitude":"","dstLongitude":"","id":"123","orderAmount":"123","orderName":"测试订单0013","orderNo":"0013","orderRemark":"","orderStatus":"F","perPrice":"","publishTime":"","startLatitude":"","startLongitude":"","startPlace":"南京","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"","updateTime":null,"updateUserID":""},{"carType":"T18","createTime":null,"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"阿萨德","dstLatitude":"","dstLongitude":"","id":"12331","orderAmount":"222","orderName":"测试订单0012","orderNo":"002","orderRemark":"","orderStatus":"F","perPrice":"","publishTime":"","startLatitude":"","startLongitude":"","startPlace":"南京","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"","updateTime":null,"updateUserID":""},{"carType":"T20","createTime":null,"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"200米2","dstLatitude":"","dstLongitude":"","id":"2334232","orderAmount":"12","orderName":"测试订单001","orderNo":"001","orderRemark":"zheg 要老司机","orderStatus":"F","perPrice":"5元/方/公里","publishTime":"","startLatitude":"","startLongitude":"","startPlace":"南京","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"200公里","updateTime":null,"updateUserID":""}]
     * listOfObject : [{"carType":"T20","createTime":{"date":24,"day":5,"hours":22,"minutes":34,"month":4,"nanos":0,"seconds":7,"time":1558708447000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"煌上煌酱鸭(南京南站)","dstLatitude":"31.968628","dstLongitude":"118.797913","id":"2c91808c6aea409d016aea4368f50002","orderAmount":"123","orderName":"123","orderNo":"","orderRemark":"备注","orderStatus":"F","perPrice":"100","publishTime":"","startLatitude":"32.037651","startLongitude":"118.784997","startPlace":"luckin coffee瑞幸咖啡(新街口店)","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"12248","updateTime":null,"updateUserID":""},{"carType":"B","createTime":null,"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"安徽","dstLatitude":"","dstLongitude":"","id":"123","orderAmount":"123","orderName":"测试订单0013","orderNo":"0013","orderRemark":"","orderStatus":"F","perPrice":"","publishTime":"","startLatitude":"","startLongitude":"","startPlace":"南京","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"","updateTime":null,"updateUserID":""},{"carType":"T18","createTime":null,"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"阿萨德","dstLatitude":"","dstLongitude":"","id":"12331","orderAmount":"222","orderName":"测试订单0012","orderNo":"002","orderRemark":"","orderStatus":"F","perPrice":"","publishTime":"","startLatitude":"","startLongitude":"","startPlace":"南京","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"","updateTime":null,"updateUserID":""},{"carType":"T20","createTime":null,"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"200米2","dstLatitude":"","dstLongitude":"","id":"2334232","orderAmount":"12","orderName":"测试订单001","orderNo":"001","orderRemark":"zheg 要老司机","orderStatus":"F","perPrice":"5元/方/公里","publishTime":"","startLatitude":"","startLongitude":"","startPlace":"南京","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"200公里","updateTime":null,"updateUserID":""}]
     * objectsPerPage : 10
     * pageNumber : 1
     * pageSize : 10
     * searchId :
     * sortCriterion :
     * sortDirection : {"code":2,"name":"ascending"}
     * sortType : ascending
     * totalCount : 4
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
    private List<OrderBean> list;
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

    public List<OrderBean> getList() {
        return list;
    }

    public void setList(List<OrderBean> list) {
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
         * carType : T20
         * createTime : {"date":24,"day":5,"hours":22,"minutes":34,"month":4,"nanos":0,"seconds":7,"time":1558708447000,"timezoneOffset":-480,"year":119}
         * createUserID :
         * delFlag : 0
         * deptId :
         * destinationPlace : 煌上煌酱鸭(南京南站)
         * dstLatitude : 31.968628
         * dstLongitude : 118.797913
         * id : 2c91808c6aea409d016aea4368f50002
         * orderAmount : 123
         * orderName : 123
         * orderNo :
         * orderRemark : 备注
         * orderStatus : F
         * perPrice : 100
         * publishTime :
         * startLatitude : 32.037651
         * startLongitude : 118.784997
         * startPlace : luckin coffee瑞幸咖啡(新街口店)
         * stationId : 4028830d6abe6beb016abe6f84300001
         * totalDistance : 12248
         * updateTime : null
         * updateUserID :
         */

        private String carType;
        private CreateTimeBeanX createTime;
        private String createUserID;
        private int delFlag;
        private String deptId;
        private String destinationPlace;
        private String dstLatitude;
        private String dstLongitude;
        private String id;
        private String orderAmount;
        private String orderName;
        private String orderNo;
        private String orderRemark;
        private String orderStatus;
        private String perPrice;
        private String publishTime;
        private String startLatitude;
        private String startLongitude;
        private String startPlace;
        private String stationId;
        private String totalDistance;
        private Object updateTime;
        private String updateUserID;

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
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

        public String getDestinationPlace() {
            return destinationPlace;
        }

        public void setDestinationPlace(String destinationPlace) {
            this.destinationPlace = destinationPlace;
        }

        public String getDstLatitude() {
            return dstLatitude;
        }

        public void setDstLatitude(String dstLatitude) {
            this.dstLatitude = dstLatitude;
        }

        public String getDstLongitude() {
            return dstLongitude;
        }

        public void setDstLongitude(String dstLongitude) {
            this.dstLongitude = dstLongitude;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrderAmount() {
            return orderAmount;
        }

        public void setOrderAmount(String orderAmount) {
            this.orderAmount = orderAmount;
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getOrderRemark() {
            return orderRemark;
        }

        public void setOrderRemark(String orderRemark) {
            this.orderRemark = orderRemark;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getPerPrice() {
            return perPrice;
        }

        public void setPerPrice(String perPrice) {
            this.perPrice = perPrice;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getStartLatitude() {
            return startLatitude;
        }

        public void setStartLatitude(String startLatitude) {
            this.startLatitude = startLatitude;
        }

        public String getStartLongitude() {
            return startLongitude;
        }

        public void setStartLongitude(String startLongitude) {
            this.startLongitude = startLongitude;
        }

        public String getStartPlace() {
            return startPlace;
        }

        public void setStartPlace(String startPlace) {
            this.startPlace = startPlace;
        }

        public String getStationId() {
            return stationId;
        }

        public void setStationId(String stationId) {
            this.stationId = stationId;
        }

        public String getTotalDistance() {
            return totalDistance;
        }

        public void setTotalDistance(String totalDistance) {
            this.totalDistance = totalDistance;
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
             * date : 24
             * day : 5
             * hours : 22
             * minutes : 34
             * month : 4
             * nanos : 0
             * seconds : 7
             * time : 1558708447000
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
