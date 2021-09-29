package com.example.myapplication1.Models;

public class acadmic_info {

    private String balancing_hour;
    private String exec_hour;
    private String reg_hour;
    private String gpa;
    private String application_type_name;
    private String certificate_type_name_ar;
    private String hs_date;
    private String hs_avg;
    private String major_name_ar;
    private String college_name_ar;
    private String level_name_ar;
    private String plan_no;
    private String semester_name;

    public acadmic_info(String balancing_hour, String exec_hour, String reg_hour, String gpa,   String major_name_ar, String college_name_ar, String level_name_ar, String plan_no) {
        this.balancing_hour = balancing_hour;
        this.exec_hour = exec_hour;
        this.reg_hour = reg_hour;
        this.gpa = gpa;
        this.major_name_ar = major_name_ar;
        this.college_name_ar = college_name_ar;
        this.level_name_ar = level_name_ar;
        this.plan_no = plan_no;
    }

    public String getBalancing_hour() {
        return balancing_hour;
    }

    public void setBalancing_hour(String balancing_hour) {
        this.balancing_hour = balancing_hour;
    }

    public String getExec_hour() {
        return exec_hour;
    }

    public void setExec_hour(String exec_hour) {
        this.exec_hour = exec_hour;
    }

    public String getReg_hour() {
        return reg_hour;
    }

    public void setReg_hour(String reg_hour) {
        this.reg_hour = reg_hour;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getApplication_type_name() {
        return application_type_name;
    }

    public void setApplication_type_name(String application_type_name) {
        this.application_type_name = application_type_name;
    }

    public String getCertificate_type_name_ar() {
        return certificate_type_name_ar;
    }

    public void setCertificate_type_name_ar(String certificate_type_name_ar) {
        this.certificate_type_name_ar = certificate_type_name_ar;
    }

    public String getHs_date() {
        return hs_date;
    }

    public void setHs_date(String hs_date) {
        this.hs_date = hs_date;
    }

    public String getHs_avg() {
        return hs_avg;
    }

    public void setHs_avg(String hs_avg) {
        this.hs_avg = hs_avg;
    }

    public String getMajor_name_ar() {
        return major_name_ar;
    }

    public void setMajor_name_ar(String major_name_ar) {
        this.major_name_ar = major_name_ar;
    }

    public String getCollege_name_ar() {
        return college_name_ar;
    }

    public void setCollege_name_ar(String college_name_ar) {
        this.college_name_ar = college_name_ar;
    }

    public String getLevel_name_ar() {
        return level_name_ar;
    }

    public void setLevel_name_ar(String level_name_ar) {
        this.level_name_ar = level_name_ar;
    }

    public String getPlan_no() {
        return plan_no;
    }

    public void setPlan_no(String plan_no) {
        this.plan_no = plan_no;
    }

    public String getSemester_name() {
        return semester_name;
    }

    public void setSemester_name(String semester_name) {
        this.semester_name = semester_name;
    }
}
