package com.example.faiq.dost.Models;

/**
 * Created by CodianSoft on 06/02/2018.
 */

public class EventManagementModel {
    private String event_name;
    private String event_contact_number;
    private String image_link;


    public EventManagementModel(  String event_name,String event_contact_number,String image_link)
    {
        this.setEvent_name(event_name);
        this.setEvent_contact_number(event_contact_number);
        this.setImage_link(image_link);
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_contact_number() {
        return event_contact_number;
    }

    public void setEvent_contact_number(String event_contact_number) {
        this.event_contact_number = event_contact_number;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }
}
