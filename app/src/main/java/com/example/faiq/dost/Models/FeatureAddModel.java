package com.example.faiq.dost.Models;

/**
 * Created by faiq on 28/01/2018.
 */

public class FeatureAddModel {

    private String title;
    private String price;
    private String imageLink;

    public FeatureAddModel( String title,String price,String imageLink)
    {
        this.title=title;
        this.price=price;
        this.imageLink=imageLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
