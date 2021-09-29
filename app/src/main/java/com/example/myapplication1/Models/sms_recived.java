package com.example.myapplication1.Models;

public class sms_recived {

    private String receive_no;
    private String text_ar;
    private String msg_code;
    private String status_cd;
    private String status_name_ar;
    private String group_cd;
    private String date_to_order;
    private String send_dt;
    private String notify;

    public sms_recived(String text_ar, String msg_code) {
        this.text_ar = text_ar;
        this.msg_code = msg_code;
    }

    public String getReceive_no() {
        return receive_no;
    }

    public void setReceive_no(String receive_no) {
        this.receive_no = receive_no;
    }

    public String getText_ar() {
        return text_ar;
    }

    public void setText_ar(String text_ar) {
        this.text_ar = text_ar;
    }

    public String getMsg_code() {
        return msg_code;
    }

    public void setMsg_code(String msg_code) {
        this.msg_code = msg_code;
    }

    public String getStatus_cd() {
        return status_cd;
    }

    public void setStatus_cd(String status_cd) {
        this.status_cd = status_cd;
    }

    public String getStatus_name_ar() {
        return status_name_ar;
    }

    public void setStatus_name_ar(String status_name_ar) {
        this.status_name_ar = status_name_ar;
    }

    public String getGroup_cd() {
        return group_cd;
    }

    public void setGroup_cd(String group_cd) {
        this.group_cd = group_cd;
    }

    public String getDate_to_order() {
        return date_to_order;
    }

    public void setDate_to_order(String date_to_order) {
        this.date_to_order = date_to_order;
    }

    public String getSend_dt() {
        return send_dt;
    }

    public void setSend_dt(String send_dt) {
        this.send_dt = send_dt;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }
}
