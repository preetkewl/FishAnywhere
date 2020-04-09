package com.apps.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUploadMediaCallback {
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("ID")
    @Expose
    public int iD;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }
}
