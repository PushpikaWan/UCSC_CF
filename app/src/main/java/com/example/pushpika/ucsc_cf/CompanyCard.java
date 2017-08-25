package com.example.pushpika.ucsc_cf;

/**
 * Created by pushpika on 8/25/17.
 */

public class CompanyCard {
    private String stoleName;
    private String isAvailable;
    private String authorizedUser;
    private long stoleNumber;
    private int key;
    private int thumbnail;

    public CompanyCard() {
    }

    public CompanyCard(String stoleName, String isAvailable,String authorizedUser,long stoleNumber, int key, int thumbnail) {
        this.stoleName = stoleName;
        this.isAvailable = isAvailable;
        this.authorizedUser = authorizedUser;
        this.stoleNumber = stoleNumber;
        this.key = key;
        this.thumbnail = thumbnail;
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

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
