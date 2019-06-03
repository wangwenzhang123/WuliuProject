package com.example.library_commen.model;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/31 17:38
 * @change
 */
public class DetailCarBean {

    /**
     * exportAllData : true
     * firstResult : 0
     * fullListSize : 0
     * list : [{"buyTime":"2011-11-22","carLatitude":"32.154348","carLoad":"16","carLongitude":"118.784997","carName":"打他那个车","carNo":"苏B232112","carRemarks":"sa","carStatus":"U","carType":"T16","companyId":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driveLicense":"","driverId":"","id":"3","updateTime":null,"updateUserID":""},{"buyTime":"2001-11-22","carLatitude":"32.1544","carLoad":"18","carLongitude":"118.784927","carName":"大车","carNo":"苏A123456","carRemarks":"sass","carStatus":"U","carType":"B","companyId":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driveLicense":"","driverId":"","id":"4","updateTime":null,"updateUserID":""}]
     * listOfObject : [{"buyTime":"2011-11-22","carLatitude":"32.154348","carLoad":"16","carLongitude":"118.784997","carName":"打他那个车","carNo":"苏B232112","carRemarks":"sa","carStatus":"U","carType":"T16","companyId":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driveLicense":"","driverId":"","id":"3","updateTime":null,"updateUserID":""},{"buyTime":"2001-11-22","carLatitude":"32.1544","carLoad":"18","carLongitude":"118.784927","carName":"大车","carNo":"苏A123456","carRemarks":"sass","carStatus":"U","carType":"B","companyId":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driveLicense":"","driverId":"","id":"4","updateTime":null,"updateUserID":""}]
     * objectsPerPage : 10
     * pageNumber : 1
     * pageSize : 10
     * searchId :
     * sortCriterion :
     * sortDirection : {"code":2,"name":"ascending"}
     * sortType : ascending
     * totalCount : 0
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
    private List<DetailCarListBean> list;
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

    public List<DetailCarListBean> getList() {
        return list;
    }

    public void setList(List<DetailCarListBean> list) {
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
         * buyTime : 2011-11-22
         * carLatitude : 32.154348
         * carLoad : 16
         * carLongitude : 118.784997
         * carName : 打他那个车
         * carNo : 苏B232112
         * carRemarks : sa
         * carStatus : U
         * carType : T16
         * companyId :
         * createTime : null
         * createUserID :
         * delFlag : 0
         * deptId :
         * driveLicense :
         * driverId :
         * id : 3
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
        private Object createTime;
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
    }
}
