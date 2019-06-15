package com.example.distributednfcchatapp.Model;

public class User {
    private String uuid;
    private String userName;
    private String profilePictureURL;


    public User(String uuid, String userName, String profilePictureURL) {
        this.uuid = uuid;
        this.userName = userName;
        this.profilePictureURL = profilePictureURL;
    }

    public User() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }
}
