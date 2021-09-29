package com.example.myapplication1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication1.Models.basicinfo;

import java.util.ArrayList;



public class DatabaseHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public DatabaseHandler(@Nullable Context context) {
        super(context, "UniversityDB", null, 1);
        //Get the Data Repository in write mode
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(basicinfo.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL(basicinfo.DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

//    public boolean insertBasicinfo(String users_id,String PASSPORT_NO, String s_name, String Serchname,String fname_ar,  String tname_ar, String lname_en,
//                                String gender_name, String dob, String country_name_pob_ar,
//                                String city_name_ob_ar, String citizen_name,
//                                String governorate_name_ar, String city_name_ar, String mobile_key, String mobile_no,
//                                String street_name)  {
//        ContentValues cv = new ContentValues();
//        cv.put(basicinfo.COL_USER_ID, users_id);
//        cv.put(basicinfo.COL_PASSPORT_NO_ID, PASSPORT_NO);
//        cv.put(basicinfo.COL_SNAME_EN,s_name);
//        cv.put(basicinfo.COL_FNAME_EN,fname_ar);
//        cv.put(basicinfo.COL_SEARCH_NAME,Serchname);
//        cv.put(basicinfo.COL_TNAME_EN,tname_ar);
//        cv.put(basicinfo.COL_LNAME_EN,lname_en);
//        cv.put(basicinfo.COL_GENDER_NAME,gender_name);
//        cv.put(basicinfo.COL_DOB,dob);
//        cv.put(basicinfo.COL_COUNTRY_NAME_OB_AR,country_name_pob_ar);
//        cv.put(basicinfo.COL_CITY_NAME_OB_AR,city_name_ob_ar);
//        cv.put(basicinfo.COL_CITIZEN_NAME,citizen_name);
//        cv.put(basicinfo.COL_GOVERNORTATE_NAME_AR,governorate_name_ar);
//        cv.put(basicinfo.COL_CITY_NAME_AR,city_name_ar);
//        cv.put(basicinfo.COL_MOBILE_KEY,mobile_key);
//        cv.put(basicinfo.COL_MOBILE_NO,mobile_no);
//        cv.put(basicinfo.COL_STREET_NO,street_name);
//
//        long newRowID = db.insert(basicinfo.TABLE_NAME, null, cv);
//        return newRowID > 0;
//    }


    public boolean insertBasicinfo(basicinfo basicinfo)  {
        ContentValues cv = new ContentValues();
        cv.put(basicinfo.COL_PASSPORT_NO_ID, basicinfo.getPassport_no());
        cv.put(basicinfo.COL_FNAME_EN, basicinfo.getFname_en());
        cv.put(basicinfo.COL_USER_ID,basicinfo.getUserID());
        cv.put(basicinfo.COL_SEARCH_NAME,basicinfo.getSearch_name());
        cv.put(basicinfo.COL_SNAME_EN,basicinfo.getSname_en());
        cv.put(basicinfo.COL_TNAME_EN,basicinfo.getTname_en());
        cv.put(basicinfo.COL_LNAME_EN,basicinfo.getLname_en());
        cv.put(basicinfo.COL_GENDER_NAME,basicinfo.getGender_name());
        cv.put(basicinfo.COL_DOB,basicinfo.getDob());
        cv.put(basicinfo.COL_COUNTRY_NAME_OB_AR,basicinfo.getCountry_name_pob_ar());
        cv.put(basicinfo.COL_CITY_NAME_OB_AR,basicinfo.getCity_name_ar());
        cv.put(basicinfo.COL_REGION_NAME,basicinfo.getRegion_name_ar());
        cv.put(basicinfo.COL_CITIZEN_NAME,basicinfo.getCitizen_name());
        cv.put(basicinfo.COL_GOVERNORTATE_NAME_AR,basicinfo.getGovernorate_name_ar());
        cv.put(basicinfo.COL_CITY_NAME_AR,basicinfo.getCity_name_ar());
        cv.put(basicinfo.COL_MOBILE_KEY,basicinfo.getMobile_key());
        cv.put(basicinfo.COL_MOBILE_NO,basicinfo.getMobile_no());
        cv.put(basicinfo.COL_STREET_NO,basicinfo.getStreet());

        long newRowID = db.insert(basicinfo.TABLE_NAME, null, cv);
        return newRowID > 0;
    }

    public String  search(String id){
        String idd="";
        SQLiteDatabase db =getReadableDatabase();
        String sql = "SELECT * FROM " + basicinfo.TABLE_NAME + " WHERE " + basicinfo.COL_PASSPORT_NO_ID + " = ? ";
        String[] selectionArgs = new String[]{id };
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if(cursor !=null && cursor.moveToFirst()){
            int index1 = cursor.getColumnIndex(basicinfo.COL_PASSPORT_NO_ID);
            idd = cursor.getString(index1);
        }
        return idd;
    }

    public String  searchuserid(String id){
        String idd="";
        SQLiteDatabase db =getReadableDatabase();
        String sql = "SELECT * FROM " + basicinfo.TABLE_NAME + " WHERE " + basicinfo.COL_USER_ID + " = ? ";
        String[] selectionArgs = new String[]{id };
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if(cursor !=null && cursor.moveToFirst()){
            int index1 = cursor.getColumnIndex(basicinfo.COL_USER_ID);
            idd = cursor.getString(index1);
        }
        return idd;
    }
    public ArrayList<basicinfo> getall(String userid){
        ArrayList<basicinfo> doc =new ArrayList<>();
            SQLiteDatabase db =this.getReadableDatabase();
            String sql = "SELECT * FROM " + basicinfo.TABLE_NAME + " WHERE " + basicinfo.COL_USER_ID + " = ?";
            String[] selectionArgs = new String[]{userid};
            Cursor c = db.rawQuery(sql, selectionArgs);
            c.moveToFirst();
            while (!c.isLast()) {
                int index1 = c.getColumnIndex(basicinfo.COL_PASSPORT_NO_ID);
                String PASSPORT_NO = c.getString(index1);
                int index2 = c.getColumnIndex(basicinfo.COL_FNAME_EN);
                String FNAME = c.getString(index2);
                int index3 = c.getColumnIndex(basicinfo.COL_USER_ID);
                String USER_ID = c.getString(index3);
                int index4 = c.getColumnIndex(basicinfo.COL_SEARCH_NAME);
                String name = c.getString(index4);
                int index5 = c.getColumnIndex(basicinfo.COL_SNAME_EN);
                String SNAME = c.getString(index5);
                int index6 = c.getColumnIndex(basicinfo.COL_TNAME_EN);
                String TNAME = c.getString(index6);
                int index7 = c.getColumnIndex(basicinfo.COL_LNAME_EN);
                String LNAME = c.getString(index7);
                int index8 = c.getColumnIndex(basicinfo.COL_GENDER_NAME);
                String gender = c.getString(index8);
                int index9= c.getColumnIndex(basicinfo.COL_DOB);
                String DOB = c.getString(index9);
                int index10 = c.getColumnIndex(basicinfo.COL_COUNTRY_NAME_OB_AR);
                String COUNTRY_NAME_OB = c.getString(index10);
                int index11 = c.getColumnIndex(basicinfo.COL_CITY_NAME_OB_AR);
                String CITY_NAME_OB = c.getString(index11);
                int index12 = c.getColumnIndex(basicinfo.COL_REGION_NAME);
                String REGION = c.getString(index12);
                int index13 = c.getColumnIndex(basicinfo.COL_CITIZEN_NAME);
                String CITIZEN = c.getString(index13);
                int index14 = c.getColumnIndex(basicinfo.COL_GOVERNORTATE_NAME_AR);
                String GOVERNORTATE = c.getString(index14);
                int index15 = c.getColumnIndex(basicinfo.COL_CITY_NAME_AR);
                String CITY_NAME = c.getString(index15);
                int index16 = c.getColumnIndex(basicinfo.COL_MOBILE_KEY);
                String MOBILE_KEY = c.getString(index16);
                int index17 = c.getColumnIndex(basicinfo.COL_MOBILE_NO);
                String MOBILE_NO = c.getString(index17);
                int index18 = c.getColumnIndex(basicinfo.COL_STREET_NO);
                String STREET_NO = c.getString(index18);
                basicinfo f = new basicinfo(USER_ID,name,FNAME,SNAME,TNAME,LNAME,gender,DOB,COUNTRY_NAME_OB,CITY_NAME_OB,REGION,CITIZEN,GOVERNORTATE,CITY_NAME,MOBILE_KEY,MOBILE_NO,PASSPORT_NO,STREET_NO);
                doc.add(f);
            }
            c.close();
            return doc;
        }

    public void serchupdate(String PASSPORT_NO,String s_name,String fname_ar,  String tname_ar, String lname_en,String mobile_key, String mobile_no){
      // boolean res=false;
        SQLiteDatabase db =getReadableDatabase();
        String sql = "SELECT * FROM " + basicinfo.TABLE_NAME + " WHERE " + basicinfo.COL_PASSPORT_NO_ID + " = ? ";
        String[] selectionArgs = new String[]{PASSPORT_NO };
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if(cursor !=null && cursor.moveToFirst()){
            int index1 = cursor.getColumnIndex(basicinfo.COL_FNAME_EN);
            String fname = cursor.getString(index1);
            int index2 = cursor.getColumnIndex(basicinfo.COL_FNAME_EN);
            String sname = cursor.getString(index2);
            int index3 = cursor.getColumnIndex(basicinfo.COL_FNAME_EN);
            String tname = cursor.getString(index3);
            int index4 = cursor.getColumnIndex(basicinfo.COL_FNAME_EN);
            String lname = cursor.getString(index4);
            int index5 = cursor.getColumnIndex(basicinfo.COL_FNAME_EN);
            String kmobile = cursor.getString(index5);
            int index6 = cursor.getColumnIndex(basicinfo.COL_FNAME_EN);
            String Nmobile = cursor.getString(index6);

            if(!fname.equals(fname_ar)){
               updateFname(PASSPORT_NO,fname_ar);
               //res=true;
            }
            if(!sname.equals(s_name)){
                updateSname(PASSPORT_NO,s_name);
               // res=true;
            }
            if(!tname.equals(tname_ar)){
                updateTname(PASSPORT_NO,tname_ar);
               // res=true;
            }
            if(!lname.equals(lname_en)){
                updateLname(PASSPORT_NO,lname_en);
                //res=true;
            }
//            if(kmobile.equals(mobile_key)){
//                up(PASSPORT_NO,lname_en);
//                res=true;
//            }
//            if(Nmobile.equals(mobile_no)){
//                updateLname(PASSPORT_NO,lname_en);
//                res=true;
//            }

        }
        //return res;
    }
    public boolean updateFname(String id, String F_name) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db =getWritableDatabase();
        cv.put(basicinfo.COL_FNAME_EN, F_name);
        int count = db.update(basicinfo.TABLE_NAME, cv, basicinfo.COL_PASSPORT_NO_ID + "= " + id, null);
        return count > 0;
    }
    public boolean updateSname(String id, String S_name) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db =getWritableDatabase();
        cv.put(basicinfo.COL_SNAME_EN, S_name);
        int count = db.update(basicinfo.TABLE_NAME, cv, basicinfo.COL_PASSPORT_NO_ID + "= " + id, null);
        return count > 0;
    }
    public boolean updateTname(String id, String T_name) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db =getWritableDatabase();
        cv.put(basicinfo.COL_TNAME_EN, T_name);
        int count = db.update(basicinfo.TABLE_NAME, cv, basicinfo.COL_PASSPORT_NO_ID + "= " + id, null);
        return count > 0;
    }
    public boolean updateLname(String id, String L_name) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db =getWritableDatabase();
        cv.put(basicinfo.COL_LNAME_EN, L_name);
        int count = db.update(basicinfo.TABLE_NAME, cv, basicinfo.COL_PASSPORT_NO_ID + "= " + id, null);
        return count > 0;
    }
    }




