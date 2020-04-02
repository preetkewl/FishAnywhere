package com.app.fishanywhere.model.Callbacks;

import com.app.fishanywhere.model.pojo.RegisterUserPojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRegisterCallback {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("redirect")
    @Expose
    public String redirect;
    @SerializedName("data")
    @Expose
    public RegisterUserPojo registerUserPojo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public RegisterUserPojo getRegisterUserPojo() {
        return registerUserPojo;
    }

    public void setRegisterUserPojo(RegisterUserPojo registerUserPojo) {
        this.registerUserPojo = registerUserPojo;
    }
}
