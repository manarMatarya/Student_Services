package com.example.myapplication1.Models;

public class childItem {
    public String name;
    public  int imageUrl;
    public String switchname;

    public childItem(String name, int imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public childItem(String name) {
        this.name = name;
    }

    public childItem(String name, String switchname) {
        this.name = name;
        this.switchname = switchname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSwitchname() {
        return switchname;
    }

    public void setSwitchname(String switchname) {
        this.switchname = switchname;
    }
}
