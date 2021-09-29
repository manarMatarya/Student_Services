package com.example.myapplication1.Models;

public class studyplan_main {
    private  String plan_subject_type_cd;
    private  String type_name;
    private  String hour_mandatory;
    //"plan_subject_type_cd": "7",
    //"type_name": "متطلب كلية اجبارى",
    //"hour_mandatory": "21"

    public String getPlan_subject_type_cd() {
        return plan_subject_type_cd;
    }

    public void setPlan_subject_type_cd(String plan_subject_type_cd) {
        this.plan_subject_type_cd = plan_subject_type_cd;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getHour_mandatory() {
        return hour_mandatory;
    }

    public void setHour_mandatory(String hour_mandatory) {
        this.hour_mandatory = hour_mandatory;
    }
}
