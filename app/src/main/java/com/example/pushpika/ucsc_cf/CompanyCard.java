package com.example.pushpika.ucsc_cf;

import android.util.Log;

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

    int[] company_pics = new int[]{
            /* default one*/ R.drawable.default_comp,
            R.drawable.simcentric,
            R.drawable.inova_it,
            R.drawable.virtusa, R.drawable.virtusa,
            R.drawable.sysco_labs, R.drawable.sysco_labs, R.drawable.sysco_labs,
            R.drawable.synopsys,
            R.drawable.codegen, R.drawable.codegen,
            R.drawable.ifs,
            R.drawable.camms,
            R.drawable.eypax,
            R.drawable.f_ortude,R.drawable.f_ortude,
            R.drawable.geveo,
            R.drawable.ninty_nine_x,
            R.drawable.vm_matix,
            R.drawable.mobitel,
            R.drawable.rez_gateway,
            R.drawable.ismapac,
            R.drawable.nable,
            R.drawable.earth_uni,
            R.drawable.ncinga,
            R.drawable.orange_hrm,
            R.drawable.wso2,
            R.drawable.mass, R.drawable.mass,
            R.drawable.cambio, R.drawable.cambio
    };

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
        Log.d("Company Card","is : "+this.stoleNumber);
        if(this.stoleNumber < company_pics.length){
            Log.d("Company ","company pic selected");
            return company_pics[(int) this.stoleNumber];
        }
        return company_pics[0];
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }


}
