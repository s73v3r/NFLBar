package com.stevemalsam.nflbar.Models;

import java.util.List;

public class Venue {

    // Core fields
    private long mId;
    private int mPcode;
    private int mLatitude;
    private int mLongitude;
    private String mName;
    private String mAddress;
    private String mCity;
    private String mState;
    private String mZip;
    private String mPhone;

    // Super Bowl venue fields
    private String mTollFreePhone;
    private String mUrl;
    private String mDescription;
    private String mTicketLink;
    private String mImageUrl;
    private List<ScheduleItem> mSchedule;

    // computed fields
    private float mDistance;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getTicketLink() {
        return mTicketLink;
    }

    public void setTicketLink(String ticketLink) {
        mTicketLink = ticketLink;
    }

    public List<ScheduleItem> getSchedule() {
        return mSchedule;
    }

    public void setSchedule(List<ScheduleItem> schedule) {
        mSchedule = schedule;
    }

    public String getTollFreePhone() {
        return mTollFreePhone;
    }

    public void setTollFreePhone(String tollFreePhone) {
        mTollFreePhone = tollFreePhone;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Venue() {

    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getZip() {
        return mZip;
    }

    public void setZip(String zip) {
        mZip = zip;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public int getLatitude() {
        return mLatitude;
    }

    public void setLatitude(int latitude) {
        mLatitude = latitude;
    }

    public int getLongitude() {
        return mLongitude;
    }

    public void setLongitude(int longitude) {
        mLongitude = longitude;
    }

    public float getDistance() {
        return mDistance;
    }

    public void setDistance(float distance) {
        mDistance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Venue && ((Venue) o).getId() == mId) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(mId).hashCode();
    }

    public int getPcode() {
        return mPcode;
    }

    public void setPcode(int pcode) {
        mPcode = pcode;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

}