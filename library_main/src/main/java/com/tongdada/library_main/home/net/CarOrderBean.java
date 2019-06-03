package com.tongdada.library_main.home.net;

import java.util.List;

/**
 * Created by wangshen on 2019/5/28.
 */

public class CarOrderBean {

    /**
     * exportAllData : true
     * firstResult : 0
     * fullListSize : 2
     * list : [["撤诉",null,"苏A123456","2019-05-21 22:29:54","232","南京","200米2","B","22","测试订单001","2019-05-29 00:19:14","H","12222","312312"],["马桶",null,"苏B232112","2019-05-22 22:29:54","22","南京","200米2","T16","as","测试订单001","2019-05-29 00:19:14","H","22","31"]]
     * listOfObject : [["撤诉",null,"苏A123456","2019-05-21 22:29:54","232","南京","200米2","B","22","测试订单001","2019-05-29 00:19:14","H","12222","312312"],["马桶",null,"苏B232112","2019-05-22 22:29:54","22","南京","200米2","T16","as","测试订单001","2019-05-29 00:19:14","H","22","31"]]
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
    private List<List<String>> list;
    private List<List<String>> listOfObject;

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

    public List<List<String>> getList() {
        return list;
    }

    public void setList(List<List<String>> list) {
        this.list = list;
    }

    public List<List<String>> getListOfObject() {
        return listOfObject;
    }

    public void setListOfObject(List<List<String>> listOfObject) {
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
}
