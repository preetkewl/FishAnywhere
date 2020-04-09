package com.apps.fishanywhere.model.Callbacks;

import com.apps.fishanywhere.model.pojo.AllFishReportDataPojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetAllFishReportDataCallback {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("data")
    @Expose
    public ArrayList<AllFishReportDataPojo> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<AllFishReportDataPojo> getData() {
        return data;
    }

    public void setData(ArrayList<AllFishReportDataPojo> data) {
        this.data = data;
    }
}
