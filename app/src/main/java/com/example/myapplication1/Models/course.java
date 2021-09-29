package com.example.myapplication1.Models;

public class course {
    public course(String name, String division, String classroom, String time) {
        Name = name;
        Division = division;
        Classroom = classroom;
        Time = time;
    }

    public course() {

    }

    private String Name ;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getClassroom() {
        return Classroom;
    }

    public void setClassroom(String classroom) {
        Classroom = classroom;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    private String Division;
    private String Classroom;
    private String Time;


}
