package com.example.library_commen.model;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/15 15:43
 * @change
 */
public class RequestRegisterBean {
    private String stationName="";//搅拌站名称
    private String stationAddress="";//搅拌站地址
    private String stationContacts="";//搅拌站联系人
    private String legalPersion="";//搅拌站法人
    private String contactsPhone="";//搅拌站联系电话
    private String registerCapita="";//搅拌站注册资金
    private String stationRemarks="";//搅拌站备注信息
    private String licensePic="";//搅拌站营业执照
    private String frontPic="";//搅拌站身份证正面
    private String backPic="";//搅拌站身份证反面
    /**
     * bengPrice :
     * createTime : {"date":25,"day":6,"hours":10,"minutes":46,"month":4,"seconds":54,"time":1558752414399,"timezoneOffset":-480,"year":119}
     * createUserID :
     * delFlag : 0
     * deptId :
     * id : 2c91808c6aea409d016aece24abf0005
     * registerCapital :
     * tongPrice :
     * updateTime : {"date":25,"day":6,"hours":10,"minutes":46,"month":4,"seconds":54,"time":1558752414415,"timezoneOffset":-480,"year":119}
     * updateUserID :
     * verifyStatus : N
     */
    private String logoPic="";
    private String bengPrice="";
    private CreateTimeBean createTime=new CreateTimeBean();
    private String createUserID="";
    private int delFlag=0;
    private String deptId="";
    private String id="";
    private String registerCapital="";
    private String tongPrice="";
    private UpdateTimeBean updateTime=new UpdateTimeBean();
    private String updateUserID="";
    private String verifyStatus="";

    public String getLogoPic() {
        return logoPic;
    }

    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
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

    public String getLegalPersion() {
        return legalPersion;
    }

    public void setLegalPersion(String legalPersion) {
        this.legalPersion = legalPersion;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getRegisterCapita() {
        return registerCapita;
    }

    public void setRegisterCapita(String registerCapita) {
        this.registerCapita = registerCapita;
    }

    public String getStationRemarks() {
        return stationRemarks;
    }

    public void setStationRemarks(String stationRemarks) {
        this.stationRemarks = stationRemarks;
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    public String getFrontPic() {
        return frontPic;
    }

    public void setFrontPic(String frontPic) {
        this.frontPic = frontPic;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(String registerCapital) {
        this.registerCapital = registerCapital;
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
         * date : 25
         * day : 6
         * hours : 10
         * minutes : 46
         * month : 4
         * seconds : 54
         * time : 1558752414399
         * timezoneOffset : -480
         * year : 119
         */

        private int date;
        private int day;
        private int hours;
        private int minutes;
        private int month;
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
         * date : 25
         * day : 6
         * hours : 10
         * minutes : 46
         * month : 4
         * seconds : 54
         * time : 1558752414415
         * timezoneOffset : -480
         * year : 119
         */

        private int date;
        private int day;
        private int hours;
        private int minutes;
        private int month;
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
