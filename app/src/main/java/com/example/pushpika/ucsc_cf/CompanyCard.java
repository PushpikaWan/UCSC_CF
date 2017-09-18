package com.example.pushpika.ucsc_cf;

/**
 * Created by pushpika on 8/25/17.
 */

public class CompanyCard {
    private String stoleName;
    private String isAvailable;
    private String authorizedUser;
    private long stoleNumber;
    private String stoleID;
    private int key;
    private String floor;
    private int thumbnail;

    public CompanyCard() {
    }

    public CompanyCard(String stoleName, String isAvailable,String authorizedUser,long stoleNumber,String stoleID, int key,String floor,int thumbnail) {
        this.stoleName = stoleName;
        this.isAvailable = isAvailable;
        this.authorizedUser = authorizedUser;
        this.stoleNumber = stoleNumber;
        this.key = key;
        this.floor = floor;
        this.thumbnail = thumbnail;
        this.stoleID= stoleID;
    }

    public String getStoleName() {
        return stoleName;
    }

    public void setStoleName(String stoleName) {
        this.stoleName = stoleName;
    }

    public String getIsAvailable(){return isAvailable;}

    public void setIsAvailable(String isAvailable){this.isAvailable = isAvailable;}

    public String getAuthorizedUser(){return authorizedUser;}

    public void setAuthorizedUser(String authorizedUser){this.authorizedUser = authorizedUser;}

    public long getStoleNumber(){return stoleNumber;}

    public void setStoleNumber(int stoleNumber){this.stoleNumber = stoleNumber;}

    public int getKey(){return key;}

    public void setKey(int key){ this.key = key;}

    public String getStoleID() {
        return stoleID;
    }

    public void setStoleID(String stoleID) {
        this.stoleID = stoleID;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }


    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }


}
