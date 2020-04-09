package com.apps.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetLoginCallback {

    @SerializedName("ID")
    @Expose
    public String iD;
    @SerializedName("user_login")
    @Expose
    public String userLogin;
    @SerializedName("user_nicename")
    @Expose
    public String userNicename;

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @SerializedName("user_email")
    @Expose
    public String userEmail;
    @SerializedName("roles")
    @Expose
    public List<String> roles = null;
    @SerializedName("jwt")
    @Expose
    public String jwt;
}
