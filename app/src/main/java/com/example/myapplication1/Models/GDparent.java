package com.example.myapplication1.Models;

public class GDparent {

    private String NUMmasak;
    private String NAMEmasak;
    private String daraja;



    public GDparent(String NUMmasak, String NAMEmasak, String daraja) {
        this.NUMmasak = NUMmasak;
        this.NAMEmasak = NAMEmasak;
        this.daraja = daraja;
    }




    public String getNUMmasak() {
        return NUMmasak;
    }

    public void setNUMmasak(String NUMmasak) {
        this.NUMmasak = NUMmasak;
    }

    public String getNAMEmasak() {
        return NAMEmasak;
    }

    public void setNAMEmasak(String NAMEmasak) {
        this.NAMEmasak = NAMEmasak;
    }

    public String getDaraja() {
        return daraja;
    }

    public void setDaraja(String daraja) {
        this.daraja = daraja;
    }


}
