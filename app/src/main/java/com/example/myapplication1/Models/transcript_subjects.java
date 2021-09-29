package com.example.myapplication1.Models;

public class transcript_subjects {

    private  String semester_cd;
    private  String subject_cd;
    private  String subject_name_ar;
    private  String subject_hour;
    private  String total_mark;
    private  String subjectgrad;
    //"semester_cd",
    //"subject_cd",
    //"subject_name_ar",
    //"subject_hour",
    //"total_mark",
    // "subjectgrad"


    public String getSemester_cd() {
        return semester_cd;
    }

    public void setSemester_cd(String semester_cd) {
        this.semester_cd = semester_cd;
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

    public String getSubject_hour() {
        return subject_hour;
    }

    public void setSubject_hour(String subject_hour) {
        this.subject_hour = subject_hour;
    }

    public String getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(String total_mark) {
        this.total_mark = total_mark;
    }

    public String getSubjectgrad() {
        return subjectgrad;
    }

    public void setSubjectgrad(String subjectgrad) {
        this.subjectgrad = subjectgrad;
    }

    public transcript_subjects(String subject_cd, String subject_name_ar, String subject_hour, String total_mark) {
        this.subject_cd = subject_cd;
        this.subject_name_ar = subject_name_ar;
        this.subject_hour = subject_hour;
        this.total_mark = total_mark;
    }
}
