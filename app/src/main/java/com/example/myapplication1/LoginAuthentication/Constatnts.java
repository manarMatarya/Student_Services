package com.example.myapplication1.LoginAuthentication;

public class Constatnts {
    public static final String BASE_URL = "http://10.100.1.10/";
    public static final String LOGIN_URL = "public/android/students/v1/login";
    public static final String BASIC_INFO = "public/android/students/v1/basicinfo?act=all&sortPassport_no=asc&rowCount=1000";
    public static final String ACADEMIC_INFO = "public/android/students/v1/acadmic?act=acadmic&sortPlan_no=asc";
    public static final String AGENDA_INFO = "public/android/students/v1/ajenda?act=ajenda&sortSemester_no=asc&searchPhrase={\"semester_no|=\":160}";
    public static final String REGISTERED_SEMESTERS = "public/android/students/v1/filter?act=semesterreg";
    public static final String LOGING_OUT = "public/android/students/v1/logout";
    public static final String SMS_RECIEVED = "public/android/students/v1/smsrecive?act=all&sortDate_to_order=desc";
    //    public static final String ALL_SUBJECTS = "public/android/students/v1/semestertable?act=allsubjects&sortReg_subject_cd=asc&searchPhrase={\"semester_no|=\":159}";
//    public static final String SEMESTER_TABLE = "public/android/students/v1/semestertable?act=semestertable&sortSubject_cd=asc&searchPhrase={\"semester_no|=\":159}";
    public static final String ALL_SUBJECTS = "public/android/students/v1/semestertable";
    public static final String test = "public/android/students/v1/semestertable?act=semestertable&sortSubject_cd=asc&searchPhrase={semester_no|=:159,day_we|<>:null}";
    public static final String SEMESTER_TABLE = "public/android/students/v1/semestertable?act=semestertable&sortSubject_cd=asc&searchPhrase={\"semester_no|=\":159}";

    public String id = "159";
    public String where = "?act=allsubjects&sortReg_subject_cd=asc&searchPhrase={\"semester_no|=\":" + id + "}";


    public static final String STUDYPLAN_MAIN = "public/android/students/v1/studyplan?act=studyplanmain&sortPlan_subject_type_cd=asc";
    //        public static final String STUDYPLAN_INFO = "public/android/students/v1/studyplan?act=studyplansubjects&sortSubject_cd=asc";
    public static final String STUDYPLAN_INFO = "public/android/students/v1/studyplan?act=studyplansubjects&sortSubject_cd=asc&searchPhrase={\"plan_subject_type_cd|=\":7}";
    //    public static final String STUDYPLAN_INFO = "public/android/students/v1/studyplan?act=studyplansubjects&sortSubject_cd=asc&searchPhrase={\"plan_subject_type_cd|=\":{plan_subject_type_cd}}";
    public static final String TRANSCRIPT_SEMESTERS = "public/android/students/v1/transcript?act=transcriptsemesters&sortSemester_no=asc";
//    public static final String TRANSCRIPT_SUBJECTS = "public/android/students/v1/transcript?act=transcriptsubjects&sortSubject_cd=asc";
    public static final String TRANSCRIPT_SUBJECTS = "public/android/students/v1/transcript?act=transcriptsubjects&sortSubject_cd=asc";

}
