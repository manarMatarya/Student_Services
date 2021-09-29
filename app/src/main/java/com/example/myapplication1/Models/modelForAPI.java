package com.example.myapplication1.Models;

public class modelForAPI {
    private studyplan_info[] studyplan_info;
    private studyplan_main[] studyplan_main;
    private transcript_semesters[] transcript_semesters;
    private transcript_subjects[] transcript_subjects;
    private sms_recived[] sms_recived;

    public sms_recived[] getSms_recived() {
        return sms_recived;
    }

    public void setSms_recived(com.example.myapplication1.Models.sms_recived[] sms_recived) {
        this.sms_recived = sms_recived;
    }

    public studyplan_info[] getStudyplan_info() {
        return studyplan_info;
    }

    public void setStudyplan_info(studyplan_info[] studyplan_info) {
        this.studyplan_info = studyplan_info;
    }

    public studyplan_main[] getStudyplan_main() {
        return studyplan_main;
    }

    public void setStudyplan_main(studyplan_main[] studyplan_main) {
        this.studyplan_main = studyplan_main;
    }

    public transcript_semesters[] getTranscript_semesters() {
        return transcript_semesters;
    }

    public void setTranscript_semesters(transcript_semesters[] transcript_semesters) {
        this.transcript_semesters = transcript_semesters;
    }

    public transcript_subjects[] getTranscript_subjects() {
        return transcript_subjects;
    }

    public void setTranscript_subjects(transcript_subjects[] transcript_subjects) {
        this.transcript_subjects = transcript_subjects;
    }
}
