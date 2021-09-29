package com.example.myapplication1.Models;

public class basicinfo {
    public basicinfo(String search_name) {
        this.search_name = search_name;
    }


    private String search_name;
    private String fname_en;
    private String sname_en;
    private String tname_en;
    private String lname_en;
    private String gender_name;
    private String dob;
    private String country_name_pob_ar;
    private String city_name_ob_ar;//
    private String region_name_ar;
    private String citizen_name;//
    private String governorate_name_ar;
    private String city_name_ar;
    private String mobile_key;
    private String mobile_no;
    private String passport_no;
    private String street;
    private String userID;


    public static final String TABLE_NAME = "basicinfo";
    public static final String COL_PASSPORT_NO_ID = "passport_no";//
    public static final String COL_USER_ID = "user_id";//
    public static final String COL_SEARCH_NAME = "search_name";//
    public static final String COL_FNAME_EN = "fname_en";//
    public static final String COL_SNAME_EN = "sname_en";//
    public static final String COL_TNAME_EN = "tname_en";//
    public static final String COL_LNAME_EN = "lname_en";//
    public static final String COL_GENDER_NAME = "gender_name";//
    public static final String COL_DOB = "dob";//
    public static final String COL_COUNTRY_NAME_OB_AR = "country_name_pob_ar";//
    public static final String COL_CITY_NAME_OB_AR = "city_name_ob_ar";//
    public static final String COL_REGION_NAME = "region_name_ar";//
    public static final String COL_CITIZEN_NAME = "citizen_name";//
    public static final String COL_GOVERNORTATE_NAME_AR = "governorate_name_ar";//
    public static final String COL_CITY_NAME_AR = "city_name_ar";//
    public static final String COL_MOBILE_KEY = "mobile_key";//
    public static final String COL_MOBILE_NO = "mobile_no";//
    public static final String COL_STREET_NO = "street";//


    public static final String CREATE_TABLE = "create table " + TABLE_NAME +
            "(" + COL_PASSPORT_NO_ID + " TEXT primary key ," +
            COL_FNAME_EN + " TEXT," +
            COL_USER_ID + " TEXT," +
            COL_SEARCH_NAME + " TEXT," +
            COL_SNAME_EN + " TEXT," +
            COL_TNAME_EN + " TEXT," +
            COL_LNAME_EN + " TEXT," +
            COL_GENDER_NAME + " TEXT," +
            COL_DOB + " TEXT," +
            COL_COUNTRY_NAME_OB_AR + " TEXT," +
            COL_CITY_NAME_OB_AR + " TEXT," +
            COL_REGION_NAME + " TEXT," +
            COL_CITIZEN_NAME + " TEXT," +
            COL_GOVERNORTATE_NAME_AR + " TEXT," +
            COL_CITY_NAME_AR + " TEXT," +
            COL_MOBILE_KEY + " TEXT," +
            COL_MOBILE_NO + " TEXT," +
            COL_STREET_NO + " TEXT" +
            ")";
    public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;

    public basicinfo(String userID,String search_name, String fname_en, String sname_en, String tname_en, String lname_en, String gender_name, String dob, String country_name_pob_ar, String city_name_ob_ar, String region_name_ar, String citizen_name, String governorate_name_ar, String city_name_ar, String mobile_key, String mobile_no, String passport_no, String street) {
        this.search_name = search_name;
        this.userID = userID;
        this.fname_en = fname_en;
        this.sname_en = sname_en;
        this.tname_en = tname_en;
        this.lname_en = lname_en;
        this.gender_name = gender_name;
        this.dob = dob;
        this.country_name_pob_ar = country_name_pob_ar;
        this.city_name_ob_ar = city_name_ob_ar;
        this.region_name_ar = region_name_ar;
        this.citizen_name = citizen_name;
        this.governorate_name_ar = governorate_name_ar;
        this.city_name_ar = city_name_ar;
        this.mobile_key = mobile_key;
        this.mobile_no = mobile_no;
        this.passport_no = passport_no;
        this.street = street;
    }

    public String getSearch_name() {
        return search_name;
    }

    public void setSearch_name(String search_name) {
        this.search_name = search_name;
    }

    public String getFname_en() {
        return fname_en;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setFname_en(String fname_en) {
        this.fname_en = fname_en;
    }

    public String getSname_en() {
        return sname_en;
    }

    public void setSname_en(String sname_en) {
        this.sname_en = sname_en;
    }

    public String getTname_en() {
        return tname_en;
    }

    public void setTname_en(String tname_en) {
        this.tname_en = tname_en;
    }

    public String getLname_en() {
        return lname_en;
    }

    public void setLname_en(String lname_en) {
        this.lname_en = lname_en;
    }

    public String getGender_name() {
        return gender_name;
    }

    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry_name_pob_ar() {
        return country_name_pob_ar;
    }

    public void setCountry_name_pob_ar(String country_name_pob_ar) {
        this.country_name_pob_ar = country_name_pob_ar;
    }

    public String getCity_name_ob_ar() {
        return city_name_ob_ar;
    }

    public void setCity_name_ob_ar(String city_name_ob_ar) {
        this.city_name_ob_ar = city_name_ob_ar;
    }

    public String getRegion_name_ar() {
        return region_name_ar;
    }

    public void setRegion_name_ar(String region_name_ar) {
        this.region_name_ar = region_name_ar;
    }

    public String getCitizen_name() {
        return citizen_name;
    }

    public void setCitizen_name(String citizen_name) {
        this.citizen_name = citizen_name;
    }

    public String getGovernorate_name_ar() {
        return governorate_name_ar;
    }

    public void setGovernorate_name_ar(String governorate_name_ar) {
        this.governorate_name_ar = governorate_name_ar;
    }

    public String getCity_name_ar() {
        return city_name_ar;
    }

    public void setCity_name_ar(String city_name_ar) {
        this.city_name_ar = city_name_ar;
    }

    public String getMobile_key() {
        return mobile_key;
    }

    public void setMobile_key(String mobile_key) {
        this.mobile_key = mobile_key;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColPassportNoId() {
        return COL_PASSPORT_NO_ID;
    }

    public static String getColSearchName() {
        return COL_SEARCH_NAME;
    }

    public static String getColFnameEn() {
        return COL_FNAME_EN;
    }

    public static String getColSnameEn() {
        return COL_SNAME_EN;
    }

    public static String getColTnameEn() {
        return COL_TNAME_EN;
    }

    public static String getColLnameEn() {
        return COL_LNAME_EN;
    }

    public static String getColGenderName() {
        return COL_GENDER_NAME;
    }

    public static String getColDob() {
        return COL_DOB;
    }

    public static String getColCountryNameObAr() {
        return COL_COUNTRY_NAME_OB_AR;
    }

    public static String getColCityNameObAr() {
        return COL_CITY_NAME_OB_AR;
    }

    public static String getColRegionName() {
        return COL_REGION_NAME;
    }

    public static String getColCitizenName() {
        return COL_CITIZEN_NAME;
    }

    public static String getColGovernortateNameAr() {
        return COL_GOVERNORTATE_NAME_AR;
    }

    public static String getColCityNameAr() {
        return COL_CITY_NAME_AR;
    }

    public static String getColMobileKey() {
        return COL_MOBILE_KEY;
    }

    public static String getColMobileNo() {
        return COL_MOBILE_NO;
    }

    public static String getColStreetNo() {
        return COL_STREET_NO;
    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }

    public static String getDropTable() {
        return DROP_TABLE;
    }
}
