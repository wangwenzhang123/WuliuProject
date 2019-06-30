package com.example.library_commen.model;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/31 10:25
 * @change
 */
public class DriverOrderDetailBean {

    /**
     * acceptTime : 2019-05-24 22:29:54
     * carId : 3
     * carNo : 苏A123452
     * createTime : null
     * createUserID :
     * delFlag : 0
     * deptId :
     * driverId : 12
     * driverName : dasd
     * id : 2334
     * orderAmount : 123
     * orderId : 2334232
     * orderPrice : 2
     * orderRemark : 阿达阿达
     * orderStatus : A
     * psCar : {"buyTime":"2011-11-22","carLatitude":"32.154348","carLoad":"16","carLongitude":"118.784997","carName":"打他那个车","carNo":"苏B232112","carRemarks":"sa","carStatus":"U","carType":"T16","companyId":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driveLicense":"","driverId":"","id":"3","updateTime":null,"updateUserID":""}
     * psDriver : {"companyId":"","createTime":null,"createUserID":"","delFlag":0,"deptId":"","driverAddress":"南京","driverIdNo":"32082911001203dd","driverLicense":"","driverMobile":"18191132311","driverName":"马桶","driverStatus":"U","driveringAge":"22","id":"12","idBack":"","idFront":"","updateTime":null,"updateUserID":""}
     * psTotalOrder : {"carType":"T20","createTime":null,"createUserID":"","delFlag":0,"deptId":"","destinationPlace":"200米2","dstLatitude":"","dstLongitude":"","id":"2334232","orderAmount":"12","orderName":"测试订单001","orderNo":"001","orderPic":"","orderRemark":"zheg 要老司机","orderStatus":"F","perPrice":"5元/方/公里","publishTime":"2019-05-29 00:19:14","startLatitude":"","startLongitude":"","startPlace":"南京","stationId":"4028830d6abe6beb016abe6f84300001","totalDistance":"200公里","updateTime":null,"updateUserID":""}
     * station : {"backPic":"","bengPrice":"","contactsPhone":"12312","createTime":{"date":15,"day":3,"hours":20,"minutes":44,"month":4,"nanos":0,"seconds":45,"time":1557924285000,"timezoneOffset":-480,"year":119},"createUserID":"402880e92db726b5012db729f65f0001","delFlag":0,"deptId":"402880e92db5d2ee012db601b2220004","frontPic":"","id":"4028830d6abb5115016abb860c110005","legalPersion":"","licensePic":"","logoPic":"","registerCapital":"","stationAddress":"23123","stationContacts":"","stationName":"1231","stationRemarks":"3","tongPrice":"","updateTime":{"date":15,"day":3,"hours":20,"minutes":44,"month":4,"nanos":0,"seconds":45,"time":1557924285000,"timezoneOffset":-480,"year":119},"updateUserID":"402880e92db726b5012db729f65f0001","verifyStatus":""}
     * stationId : 4028830d6abb5115016abb860c110005
     * stationName : s22s
     * totalDistance : 3
     * updateTime : null
     * updateUserID :
     */

    private String acceptTime;
    private String carId;
    private String carNo;
    private Object createTime;
    private String createUserID;
    private int delFlag;
    private String deptId;
    private String driverId;
    private String driverName;
    private String id;
    private String orderAmount;
    private String orderId;
    private String orderPrice;
    private String orderRemark;
    private String orderStatus;
    private PsCarBean psCar;
    private PsDriverBean psDriver;
    private PsTotalOrderBean psTotalOrder;
    private StationBean station;
    private String stationId;
    private String stationName;
    private String totalDistance;
    private Object updateTime;
    private String updateUserID;
    private String loadLicense;
    private String unloadLicense;
    private String signTime;

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getLoadLicense() {
        return loadLicense;
    }

    public void setLoadLicense(String loadLicense) {
        this.loadLicense = loadLicense;
    }

    public String getUnloadLicense() {
        return unloadLicense;
    }

    public void setUnloadLicense(String unloadLicense) {
        this.unloadLicense = unloadLicense;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
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

    public PsCarBean getPsCar() {
        return psCar;
    }

    public void setPsCar(PsCarBean psCar) {
        this.psCar = psCar;
    }

    public PsDriverBean getPsDriver() {
        return psDriver;
    }

    public void setPsDriver(PsDriverBean psDriver) {
        this.psDriver = psDriver;
    }

    public PsTotalOrderBean getPsTotalOrder() {
        return psTotalOrder;
    }

    public void setPsTotalOrder(PsTotalOrderBean psTotalOrder) {
        this.psTotalOrder = psTotalOrder;
    }

    public StationBean getStation() {
        return station;
    }

    public void setStation(StationBean station) {
        this.station = station;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
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

    public static class PsCarBean {
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

    public static class PsDriverBean {
        /**
         * companyId :
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

    public static class PsTotalOrderBean {
        /**
         * carType : T20
         * createTime : null
         * createUserID :
         * delFlag : 0
         * deptId :
         * destinationPlace : 200米2
         * dstLatitude :
         * dstLongitude :
         * id : 2334232
         * orderAmount : 12
         * orderName : 测试订单001
         * orderNo : 001
         * orderPic :
         * orderRemark : zheg 要老司机
         * orderStatus : F
         * perPrice : 5元/方/公里
         * publishTime : 2019-05-29 00:19:14
         * startLatitude :
         * startLongitude :
         * startPlace : 南京
         * stationId : 4028830d6abe6beb016abe6f84300001
         * totalDistance : 200公里
         * updateTime : null
         * updateUserID :
         */

        private String carType;
        private Object createTime;
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
        private String orderPic;
        private String orderRemark;
        private String orderStatus;
        private String perPrice;
        private String publishTime;
        private String startLatitude="31.985562554090762";
        private String startLongitude="118.82025068383825";
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

        public String getOrderPic() {
            return orderPic;
        }

        public void setOrderPic(String orderPic) {
            this.orderPic = orderPic;
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
    }

    public static class StationBean {
        /**
         * backPic :
         * bengPrice :
         * contactsPhone : 12312
         * createTime : {"date":15,"day":3,"hours":20,"minutes":44,"month":4,"nanos":0,"seconds":45,"time":1557924285000,"timezoneOffset":-480,"year":119}
         * createUserID : 402880e92db726b5012db729f65f0001
         * delFlag : 0
         * deptId : 402880e92db5d2ee012db601b2220004
         * frontPic :
         * id : 4028830d6abb5115016abb860c110005
         * legalPersion :
         * licensePic :
         * logoPic :
         * registerCapital :
         * stationAddress : 23123
         * stationContacts :
         * stationName : 1231
         * stationRemarks : 3
         * tongPrice :
         * updateTime : {"date":15,"day":3,"hours":20,"minutes":44,"month":4,"nanos":0,"seconds":45,"time":1557924285000,"timezoneOffset":-480,"year":119}
         * updateUserID : 402880e92db726b5012db729f65f0001
         * verifyStatus :
         */

        private String backPic;
        private String bengPrice;
        private String contactsPhone;
        private CreateTimeBean createTime;
        private String createUserID;
        private int delFlag;
        private String deptId;
        private String frontPic;
        private String id;
        private String legalPersion;
        private String licensePic;
        private String logoPic;
        private String registerCapital;
        private String stationAddress;
        private String stationContacts;
        private String stationName;
        private String stationRemarks;
        private String tongPrice;
        private UpdateTimeBean updateTime;
        private String updateUserID;
        private String verifyStatus;

        public String getBackPic() {
            return backPic;
        }

        public void setBackPic(String backPic) {
            this.backPic = backPic;
        }

        public String getBengPrice() {
            return bengPrice;
        }

        public void setBengPrice(String bengPrice) {
            this.bengPrice = bengPrice;
        }

        public String getContactsPhone() {
            return contactsPhone;
        }

        public void setContactsPhone(String contactsPhone) {
            this.contactsPhone = contactsPhone;
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

        public String getFrontPic() {
            return frontPic;
        }

        public void setFrontPic(String frontPic) {
            this.frontPic = frontPic;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLegalPersion() {
            return legalPersion;
        }

        public void setLegalPersion(String legalPersion) {
            this.legalPersion = legalPersion;
        }

        public String getLicensePic() {
            return licensePic;
        }

        public void setLicensePic(String licensePic) {
            this.licensePic = licensePic;
        }

        public String getLogoPic() {
            return logoPic;
        }

        public void setLogoPic(String logoPic) {
            this.logoPic = logoPic;
        }

        public String getRegisterCapital() {
            return registerCapital;
        }

        public void setRegisterCapital(String registerCapital) {
            this.registerCapital = registerCapital;
        }

        public String getStationAddress() {
            return stationAddress;
        }

        public void setStationAddress(String stationAddress) {
            this.stationAddress = stationAddress;
        }

        public String getStationContacts() {
            return stationContacts;
        }

        public void setStationContacts(String stationContacts) {
            this.stationContacts = stationContacts;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getStationRemarks() {
            return stationRemarks;
        }

        public void setStationRemarks(String stationRemarks) {
            this.stationRemarks = stationRemarks;
        }

        public String getTongPrice() {
            return tongPrice;
        }

        public void setTongPrice(String tongPrice) {
            this.tongPrice = tongPrice;
        }

        public UpdateTimeBean getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBean updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateUserID() {
            return updateUserID;
        }

        public void setUpdateUserID(String updateUserID) {
            this.updateUserID = updateUserID;
        }

        public String getVerifyStatus() {
            return verifyStatus;
        }

        public void setVerifyStatus(String verifyStatus) {
            this.verifyStatus = verifyStatus;
        }

        public static class CreateTimeBean {
            /**
             * date : 15
             * day : 3
             * hours : 20
             * minutes : 44
             * month : 4
             * nanos : 0
             * seconds : 45
             * time : 1557924285000
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

        public static class UpdateTimeBean {
            /**
             * date : 15
             * day : 3
             * hours : 20
             * minutes : 44
             * month : 4
             * nanos : 0
             * seconds : 45
             * time : 1557924285000
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
