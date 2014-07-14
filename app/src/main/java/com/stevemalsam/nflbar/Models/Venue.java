package com.stevemalsam.nflbar.Models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {

    @Expose
    private String zip;
    @Expose
    private String phone;
    @SerializedName("ticket_link")
    @Expose
    private String ticketLink;
    @Expose
    private String state;
    @Expose
    private Integer pcode;
    @Expose
    private String city;
    @Expose
    private Integer id;
    @Expose
    private String tollfreephone;
    @Expose
    private List<ScheduleItem> schedule = new ArrayList<ScheduleItem>();
    @Expose
    private String address;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @Expose
    private String description;
    @Expose
    private String name;
    @Expose
    private Double longitude;
    @Expose
    private Double latitude;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTicketLink() {
        return ticketLink;
    }

    public void setTicketLink(String ticketLink) {
        this.ticketLink = ticketLink;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPcode() {
        return pcode;
    }

    public void setPcode(Integer pcode) {
        this.pcode = pcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTollfreephone() {
        return tollfreephone;
    }

    public void setTollfreephone(String tollfreephone) {
        this.tollfreephone = tollfreephone;
    }

    public List<ScheduleItem> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<ScheduleItem> schedule) {
        this.schedule = schedule;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

}