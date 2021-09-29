package com.example.myapplication1.LoginAuthentication;

import com.google.gson.annotations.SerializedName;

public class users {
    public String search_name;
    public String fname_ar;
    public String sname_ar;
    public String tname_ar;
    public String lname_en;
    public String gender_name;
    public String dob;
    public String country_name_pob_ar;
    public String city_name_ob_ar;
    public String religion_name;
    public String citizen_name;
    public String governorate_name_ar;
    public String city_name_ar;
    public String mobile_key;
    public String mobile_no;
    public String nationality_name;
    public String original_city_ar;


    private String major_name;
    @SerializedName("collegename")
    private String collegename;
    private String application_type_name;

    public users(String collegename) {
        this.collegename = collegename;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getApplication_type_name() {
        return application_type_name;
    }

    public void setApplication_type_name(String application_type_name) {
        this.application_type_name = application_type_name;
    }


    public String getSearch_name() {
        return search_name;
    }

    public void setSearch_name(String search_name) {
        this.search_name = search_name;
    }

    public String getFname_ar() {
        return fname_ar;
    }

    public void setFname_ar(String fname_ar) {
        this.fname_ar = fname_ar;
    }

    public String getSname_ar() {
        return sname_ar;
    }

    public void setSname_ar(String sname_ar) {
        this.sname_ar = sname_ar;
    }

    public String getTname_ar() {
        return tname_ar;
    }

    public void setTname_ar(String tname_ar) {
        this.tname_ar = tname_ar;
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

    public String getReligion_name() {
        return religion_name;
    }

    public void setReligion_name(String religion_name) {
        this.religion_name = religion_name;
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

    public String getNationality_name() {
        return nationality_name;
    }

    public void setNationality_name(String nationality_name) {
        this.nationality_name = nationality_name;
    }

    public String getOriginal_city_ar() {
        return original_city_ar;
    }

    public void setOriginal_city_ar(String original_city_ar) {
        this.original_city_ar = original_city_ar;
    }
}
