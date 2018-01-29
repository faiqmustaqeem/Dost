package com.example.faiq.dost.Models;

/**
 * Created by CodianSoft on 29/01/2018.
 */


public class ReligiousTourismModel {

    private String title;
    private String contactNo;
    private String imageLink;

    public ReligiousTourismModel(String title,String contactNo,String imageLink)
    {
        this.setTitle(title);
        this.setContactNo(contactNo);
        this.setImageLink(imageLink);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
