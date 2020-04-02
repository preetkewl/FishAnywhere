package com.app.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBookingStatusCallback {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("status")
    @Expose
    public String status;
}
