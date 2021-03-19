package com.daniluk.testrandomuser.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {
    public UserData(UserName name, UserLocation location, String email, UserPicture picture) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.picture = picture;
    }

    @SerializedName("name")
    @Expose
    private UserName name;
    @SerializedName("location")
    @Expose
    private UserLocation location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("picture")
    @Expose
    private UserPicture picture;

    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public UserLocation getLocation() {
        return location;
    }

    public void setLocation(UserLocation location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserPicture getPicture() {
        return picture;
    }

    public void setPicture(UserPicture picture) {
        this.picture = picture;
    }

}
