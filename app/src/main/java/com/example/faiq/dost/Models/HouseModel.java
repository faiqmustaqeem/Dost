package com.example.faiq.dost.Models;

/**
 * Created by CodianSoft on 29/01/2018.
 */

public class HouseModel {
    private String price ;
    private String desc1;
    private String desc2;
    private String sqft;
    private String no_of_beds;
    private String imageLink;

    public HouseModel(String price ,String desc1,String desc2,String sqft,String no_of_beds,String imageLink)
    {
        this.setPrice(price);
        this.setDesc1(desc1);
        this.setDesc2(desc2);
        this.setSqft(sqft);
        this.setNo_of_beds(no_of_beds);
        this.setImageLink(imageLink);
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }

    public String getNo_of_beds() {
        return no_of_beds;
    }

    public void setNo_of_beds(String no_of_beds) {
        this.no_of_beds = no_of_beds;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
