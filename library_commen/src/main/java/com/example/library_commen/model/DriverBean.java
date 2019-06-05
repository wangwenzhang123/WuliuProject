package com.example.library_commen.model;

import java.util.List;

/**
 * Created by wangshen on 2019/6/5.
 */

public class DriverBean {

    /**
     * exportAllData : true
     * firstResult : 0
     * fullListSize : 7
     * list : [{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driverAddress":"南京","driverIdNo":"32082911001203dd","driverLicense":"","driverMobile":"18191132311","driverName":"马桶","driverStatus":"U","driveringAge":"22","id":"12","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":3,"day":1,"hours":21,"minutes":59,"month":5,"nanos":0,"seconds":34,"time":1559570374000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰花园","driverIdNo":"1234568","driverLicense":"","driverMobile":"18119946110","driverName":"王神","driverStatus":"N","driveringAge":"","id":"2c91808c6b1d2314016b1da35d800001","idBack":"","idFront":"","updateTime":{"date":3,"day":1,"hours":21,"minutes":59,"month":5,"nanos":0,"seconds":34,"time":1559570374000,"timezoneOffset":-480,"year":119},"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":3,"day":1,"hours":22,"minutes":3,"month":5,"nanos":0,"seconds":28,"time":1559570608000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰花园","driverIdNo":"1235684","driverLicense":"","driverMobile":"17626021180","driverName":"王神2号","driverStatus":"N","driveringAge":"","id":"2c91808c6b1d2314016b1da6f2cc0004","idBack":"","idFront":"","updateTime":{"date":3,"day":1,"hours":22,"minutes":3,"month":5,"nanos":0,"seconds":28,"time":1559570608000,"timezoneOffset":-480,"year":119},"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"弘扬物流","createTime":{"date":5,"day":3,"hours":21,"minutes":18,"month":5,"nanos":0,"seconds":13,"time":1559740693000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰花园","driverIdNo":"3425565854","driverLicense":"","driverMobile":"1811565882","driverName":"王神","driverStatus":"","driveringAge":"10","id":"2c91808c6b226cf6016b27ca3c2b001e","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":5,"day":3,"hours":21,"minutes":40,"month":5,"nanos":0,"seconds":10,"time":1559742010000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"","driverIdNo":"","driverLicense":"","driverMobile":"","driverName":"","driverStatus":"","driveringAge":"","id":"2c91808c6b226cf6016b27de52900023","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":5,"day":3,"hours":21,"minutes":46,"month":5,"nanos":0,"seconds":47,"time":1559742407000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"","driverIdNo":"","driverLicense":"","driverMobile":"","driverName":"","driverStatus":"","driveringAge":"","id":"2c91808c6b226cf6016b27e464180027","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"弘扬物流","createTime":{"date":5,"day":3,"hours":21,"minutes":59,"month":5,"nanos":0,"seconds":28,"time":1559743168000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰冯路","driverIdNo":"3524568888825","driverLicense":"","driverMobile":"182524588","driverName":"王琪","driverStatus":"","driveringAge":"25","id":"2c91808c6b27eab6016b27efff490001","idBack":"","idFront":"","updateTime":null,"updateUserID":""}]
     * listOfObject : [{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driverAddress":"南京","driverIdNo":"32082911001203dd","driverLicense":"","driverMobile":"18191132311","driverName":"马桶","driverStatus":"U","driveringAge":"22","id":"12","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":3,"day":1,"hours":21,"minutes":59,"month":5,"nanos":0,"seconds":34,"time":1559570374000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰花园","driverIdNo":"1234568","driverLicense":"","driverMobile":"18119946110","driverName":"王神","driverStatus":"N","driveringAge":"","id":"2c91808c6b1d2314016b1da35d800001","idBack":"","idFront":"","updateTime":{"date":3,"day":1,"hours":21,"minutes":59,"month":5,"nanos":0,"seconds":34,"time":1559570374000,"timezoneOffset":-480,"year":119},"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":3,"day":1,"hours":22,"minutes":3,"month":5,"nanos":0,"seconds":28,"time":1559570608000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰花园","driverIdNo":"1235684","driverLicense":"","driverMobile":"17626021180","driverName":"王神2号","driverStatus":"N","driveringAge":"","id":"2c91808c6b1d2314016b1da6f2cc0004","idBack":"","idFront":"","updateTime":{"date":3,"day":1,"hours":22,"minutes":3,"month":5,"nanos":0,"seconds":28,"time":1559570608000,"timezoneOffset":-480,"year":119},"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"弘扬物流","createTime":{"date":5,"day":3,"hours":21,"minutes":18,"month":5,"nanos":0,"seconds":13,"time":1559740693000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰花园","driverIdNo":"3425565854","driverLicense":"","driverMobile":"1811565882","driverName":"王神","driverStatus":"","driveringAge":"10","id":"2c91808c6b226cf6016b27ca3c2b001e","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":5,"day":3,"hours":21,"minutes":40,"month":5,"nanos":0,"seconds":10,"time":1559742010000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"","driverIdNo":"","driverLicense":"","driverMobile":"","driverName":"","driverStatus":"","driveringAge":"","id":"2c91808c6b226cf6016b27de52900023","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"","createTime":{"date":5,"day":3,"hours":21,"minutes":46,"month":5,"nanos":0,"seconds":47,"time":1559742407000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"","driverIdNo":"","driverLicense":"","driverMobile":"","driverName":"","driverStatus":"","driveringAge":"","id":"2c91808c6b226cf6016b27e464180027","idBack":"","idFront":"","updateTime":null,"updateUserID":""},{"companyId":"2c91808c6b226cf6016b27abe989001b","companyName":"弘扬物流","createTime":{"date":5,"day":3,"hours":21,"minutes":59,"month":5,"nanos":0,"seconds":28,"time":1559743168000,"timezoneOffset":-480,"year":119},"createUserID":"","delFlag":0,"deptId":"","driverAddress":"润泰冯路","driverIdNo":"3524568888825","driverLicense":"","driverMobile":"182524588","driverName":"王琪","driverStatus":"","driveringAge":"25","id":"2c91808c6b27eab6016b27efff490001","idBack":"","idFront":"","updateTime":null,"updateUserID":""}]
     * objectsPerPage : 10
     * pageNumber : 1
     * pageSize : 10
     * searchId :
     * sortCriterion :
     * sortDirection : {"code":2,"name":"ascending"}
     * sortType : ascending
     * totalCount : 7
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
    private List<DriverRequest> list;
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

    public List<DriverRequest> getList() {
        return list;
    }

    public void setList(List<DriverRequest> list) {
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
         * companyId : 2c91808c6b226cf6016b27abe989001b
         * companyName :
         * createTime : null
         * createUserID :
         * delFlag : 0
         * deptId :
         * driverAddress : 南京
         * driverIdNo : 32082911001203dd
         * driverLicense :
         * driverMobile : 18191132311
         * driverName : 马桶
         * driverStatus : U
         * driveringAge : 22
         * id : 12
         * idBack :
         * idFront :
         * updateTime : null
         * updateUserID :
         */

        private String companyId;
        private String companyName;
        private Object createTime;
        private String createUserID;
        private int delFlag;
        private String deptId;
        private String driverAddress;
        private String driverIdNo;
        private String driverLicense;
        private String driverMobile;
        private String driverName;
        private String driverStatus;
        private String driveringAge;
        private String id;
        private String idBack;
        private String idFront;
        private Object updateTime;
        private String updateUserID;

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

        public String getDriverAddress() {
            return driverAddress;
        }

        public void setDriverAddress(String driverAddress) {
            this.driverAddress = driverAddress;
        }

        public String getDriverIdNo() {
            return driverIdNo;
        }

        public void setDriverIdNo(String driverIdNo) {
            this.driverIdNo = driverIdNo;
        }

        public String getDriverLicense() {
            return driverLicense;
        }

        public void setDriverLicense(String driverLicense) {
            this.driverLicense = driverLicense;
        }

        public String getDriverMobile() {
            return driverMobile;
        }

        public void setDriverMobile(String driverMobile) {
            this.driverMobile = driverMobile;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getDriverStatus() {
            return driverStatus;
        }

        public void setDriverStatus(String driverStatus) {
            this.driverStatus = driverStatus;
        }

        public String getDriveringAge() {
            return driveringAge;
        }

        public void setDriveringAge(String driveringAge) {
            this.driveringAge = driveringAge;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdBack() {
            return idBack;
        }

        public void setIdBack(String idBack) {
            this.idBack = idBack;
        }

        public String getIdFront() {
            return idFront;
        }

        public void setIdFront(String idFront) {
            this.idFront = idFront;
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
