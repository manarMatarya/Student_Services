package com.example.myapplication1.Models;

public class Exams {

    private String masaak;
    private String tareekh;
    private String fatra;
    private String ga2a;

    public Exams(String masaak, String tareekh, String fatra, String ga2a) {
        this.masaak = masaak;
        this.tareekh = tareekh;
        this.fatra = fatra;
        this.ga2a = ga2a;
    }

    public String getMasaak() {
        return masaak;
    }

    public void setMasaak(String masaak) {
        this.masaak = masaak;
    }

    public String getTareekh() {
        return tareekh;
    }

    public void setTareekh(String tareek) {
        this.tareekh = tareekh;
    }

    public String getFatra() {
        return fatra;
    }

    public void setFatra(String fatra) {
        this.fatra = fatra;
    }

    public String getGa2a() {
        return ga2a;
    }

    public void setGa2a(String ga2a) {
        this.ga2a = ga2a;
    }
}
