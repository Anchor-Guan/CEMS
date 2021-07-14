package com.BaseClass;

public class Dish {
    private String dId;
    private String dName;
    private String dLocation;
    private String dShop;
    private int dUp;
    private int dDown;
    private String imageURL;

    public Dish(String dId, String dName, String dLocation, String dShop, int dUp, int dDown, String imageURL) {
        this.dId = dId;
        this.dName = dName;
        this.dLocation = dLocation;
        this.dShop = dShop;
        this.dUp = dUp;
        this.dDown = dDown;
        this.imageURL = imageURL;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdLocation() {
        return dLocation;
    }

    public void setdLocation(String dLocation) {
        this.dLocation = dLocation;
    }

    public String getdShop() {
        return dShop;
    }

    public void setdShop(String dShop) {
        this.dShop = dShop;
    }

    public int getdUp() {
        return dUp;
    }

    public void setdUp(int dUp) {
        this.dUp = dUp;
    }

    public int getdDown() {
        return dDown;
    }

    public void setdDown(int dDown) {
        this.dDown = dDown;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}