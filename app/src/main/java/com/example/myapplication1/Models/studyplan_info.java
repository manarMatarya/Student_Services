package com.example.myapplication1.Models;

public class studyplan_info {
    private String studentno;
    private String subject_cd;
    private String subject_name_ar;
    private String plan_subject_type_cd;
    private String total_mark;
    private String flag;
    private String subject_hour;
    private String level_cd;
    private String level_study_name_ar;
    private String subject_status;
    private String prerequest;

    public studyplan_info(String subject_cd, String subject_name_ar, String subject_hour, String subject_status) {
        this.subject_cd = subject_cd;
        this.subject_name_ar = subject_name_ar;
        this.subject_hour = subject_hour;
        this.subject_status = subject_status;
    }

    //    "studentno": "2301171697",
//            "subject_cd": "ITCS1311",/
//            "subject_name_ar": "رياضيات للحاسوب",/
//            "plan_subject_type_cd": "7",/
//            "total_mark": "92",
//            "flag": "1",
//            "subject_hour": "3",
//            "level_cd": "1",
//            "level_study_name_ar": "الأول",
//            "subject_status": "92",/
//            "prerequest": null


    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getSubject_cd() {
        return subject_cd;
    }

    public void setSubject_cd(String subject_cd) {
        this.subject_cd = subject_cd;
    }

    public String getSubject_name_ar() {
        return subject_name_ar;
    }

    public void setSubject_name_ar(String subject_name_ar) {
        this.subject_name_ar = subject_name_ar;
    }

    public String getPlan_subject_type_cd() {
        return plan_subject_type_cd;
    }

    public void setPlan_subject_type_cd(String plan_subject_type_cd) {
        this.plan_subject_type_cd = plan_subject_type_cd;
    }

    public String getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(String total_mark) {
        this.total_mark = total_mark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSubject_hour() {
        return subject_hour;
    }

    public void setSubject_hour(String subject_hour) {
        this.subject_hour = subject_hour;
    }

    public String getLevel_cd() {
        return level_cd;
    }

    public void setLevel_cd(String level_cd) {
        this.level_cd = level_cd;
    }

    public String getLevel_study_name_ar() {
        return level_study_name_ar;
    }

    public void setLevel_study_name_ar(String level_study_name_ar) {
        this.level_study_name_ar = level_study_name_ar;
    }

    public String getSubject_status() {
        return subject_status;
    }

    public void setSubject_status(String subject_status) {
        this.subject_status = subject_status;
    }

    public String getPrerequest() {
        return prerequest;
    }

    public void setPrerequest(String prerequest) {
        this.prerequest = prerequest;
    }
}
