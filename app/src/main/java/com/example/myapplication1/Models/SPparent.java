package com.example.myapplication1.Models;

import java.util.List;

public class SPparent {

    private String NUMmasak;
    private String NAMEmasak;
    private String sa3at;
    private String daraja;

    private SPfooter footer;

    public SPparent(String NUMmasak, String NAMEmasak, String sa3at, String daraja, SPfooter footer) {
        this.NUMmasak = NUMmasak;
        this.NAMEmasak = NAMEmasak;
        this.sa3at = sa3at;
        this.daraja = daraja;
        this.footer = footer;
    }

    public SPparent(String NUMmasak, String NAMEmasak, String sa3at, String daraja) {
        this.NUMmasak = NUMmasak;
        this.NAMEmasak = NAMEmasak;
        this.sa3at = sa3at;
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

    public String getSa3at() {
        return sa3at;
    }

    public void setSa3at(String sa3at) {
        this.sa3at = sa3at;
    }

    public String getDaraja() {
        return daraja;
    }

    public void setDaraja(String daraja) {
        this.daraja = daraja;
    }

    public SPfooter getFooter() {
        return footer;
    }

    public void setFooter(SPfooter footer) {
        this.footer = footer;
    }
}
