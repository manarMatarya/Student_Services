package com.example.myapplication1.LoginAuthentication;

import com.example.myapplication1.Models.modelForAPI;
import com.example.myapplication1.Models.semester_table;
import com.example.myapplication1.Models.sms_recived;
import com.example.myapplication1.Models.subjects_all;
import com.example.myapplication1.academicInfoResponse;
import com.example.myapplication1.Models.acadmic_info;
import com.example.myapplication1.ajendaInfoResponse;
import com.example.myapplication1.basicinfoModel;
import com.example.myapplication1.semesterRegResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserService {

    @POST(Constatnts.LOGIN_URL)
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @GET(Constatnts.BASIC_INFO)
    Call<basicinfoModel> getBasicInfo();

    @GET(Constatnts.ACADEMIC_INFO)
    Call<academicInfoResponse> getAcademicInfo();

    @GET(Constatnts.AGENDA_INFO)
    Call<ajendaInfoResponse> getAgendaInfo();

    @GET(Constatnts.REGISTERED_SEMESTERS)
    Call<semesterRegResponse> getRegisteredSemesters();

    @POST(Constatnts.LOGING_OUT)
    Call<String> logout();

    @GET(Constatnts.SMS_RECIEVED)
    Call<List<sms_recived>> getSmsReceived();

    @GET(Constatnts.ALL_SUBJECTS)
    Call<List<subjects_all>> getAllSubjects(@QueryMap HashMap<String, String> filter);

    @GET(Constatnts.SEMESTER_TABLE)
    Call<List<semester_table>> getSemesterTable(@Query("searchphrase") String semester_no);

//    @GET(Constatnts.STUDYPLAN_INFO)
//    Call<modelForAPI> getStudyplanInfo(@Query("plan_subject_type_cd") String plan_subject_type_cd);
    @GET(Constatnts.STUDYPLAN_INFO)
    Call<modelForAPI> getStudyplanInfo();

    @GET(Constatnts.TRANSCRIPT_SUBJECTS)
    Call<modelForAPI> getTranscriptSupj(@Query("searchPhrase") String semester_cd);

//    @GET(Constatnts.TRANSCRIPT_SUBJECTS)
//    Call<modelForAPI> getTranscriptSupj();

    @GET(Constatnts.STUDYPLAN_MAIN)
    Call<modelForAPI> getStudyplanMain();

    @GET(Constatnts.TRANSCRIPT_SEMESTERS)
    Call<modelForAPI> getTranscriptSemesters();

    @GET(Constatnts.SEMESTER_TABLE)
    Call<modelForAPI> getSmsReceivd();
}
