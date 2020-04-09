package com.apps.fishanywhere.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterUserPojo {

    @SerializedName("jwt")
    @Expose
    public String jwt;
    @SerializedName("user_login")
    @Expose
    public String userLogin;
    @SerializedName("user_pass")
    @Expose
    public String userPass;
    @SerializedName("user_email")
    @Expose
    public String userEmail;
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("ID")
    @Expose
    public Integer iD;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }
}
