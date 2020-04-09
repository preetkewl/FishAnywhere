package com.apps.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetResetPasswordCallback {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("mesage")
    @Expose
    public String mesage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
}
