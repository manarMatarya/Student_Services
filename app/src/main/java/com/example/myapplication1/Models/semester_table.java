package com.example.myapplication1.Models;

public class semester_table {
    private String student_no;
    private String semester_no;
    private String subject_cd; //
    private String lect_cd; //
    private String subject_name_ar; //
    private String subject_hour;
    private String main_lect_cd;
    private String dt_exam;
    private String period;
    private String period_name;
    private String lect_type_cd;
    private String lecturer_no;
    private String lect_type_name;
    private String day_sa;
    private String day_su;
    private String day_mo;
    private String day_tu;
    private String day_we; //
    private String day_th;

    public semester_table(String subject_cd,String subject_name_ar,String lect_cd,String day_we){
        this.subject_cd = subject_cd;
        this.subject_name_ar = subject_name_ar;
        this.lect_cd = lect_cd;
        this.day_we = day_we;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getSemester_no() {
        return semester_no;
    }

    public void setSemester_no(String semester_no) {
        this.semester_no = semester_no;
    }

    public String getSubject_cd() {
        return subject_cd;
    }

    public void setSubject_cd(String subject_cd) {
        this.subject_cd = subject_cd;
    }

    public String getLect_cd() {
        return lect_cd;
    }

    public void setLect_cd(String lect_cd) {
        this.lect_cd = lect_cd;
    }

    public String getSubject_name_ar() {
        return subject_name_ar;
    }

    public void setSubject_name_ar(String subject_name_ar) {
        this.subject_name_ar = subject_name_ar;
    }

    public String getSubject_hour() {
        return subject_hour;
    }

    public void setSubject_hour(String subject_hour) {
        this.subject_hour = subject_hour;
    }

    public String getMain_lect_cd() {
        return main_lect_cd;
    }

    public void setMain_lect_cd(String main_lect_cd) {
        this.main_lect_cd = main_lect_cd;
    }

    public String getDt_exam() {
        return dt_exam;
    }

    public void setDt_exam(String dt_exam) {
        this.dt_exam = dt_exam;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getLect_type_cd() {
        return lect_type_cd;
    }

    public void setLect_type_cd(String lect_type_cd) {
        this.lect_type_cd = lect_type_cd;
    }

    public String getLecturer_no() {
        return lecturer_no;
    }

    public void setLecturer_no(String lecturer_no) {
        this.lecturer_no = lecturer_no;
    }

    public String getLect_type_name() {
        return lect_type_name;
    }

    public void setLect_type_name(String lect_type_name) {
        this.lect_type_name = lect_type_name;
    }

    public String getDay_sa() {
        return day_sa;
    }

    public void setDay_sa(String day_sa) {
        this.day_sa = day_sa;
    }

    public String getDay_su() {
        return day_su;
    }

    public void setDay_su(String day_su) {
        this.day_su = day_su;
    }

    public String getDay_mo() {
        return day_mo;
    }

    public void setDay_mo(String day_mo) {
        this.day_mo = day_mo;
    }

    public String getDay_tu() {
        return day_tu;
    }

    public void setDay_tu(String day_tu) {
        this.day_tu = day_tu;
    }

    public String getDay_we() {
        return day_we;
    }

    public void setDay_we(String day_we) {
        this.day_we = day_we;
    }

    public String getDay_th() {
        return day_th;
    }

    public void setDay_th(String day_th) {
        this.day_th = day_th;
    }
}
