package com.app.fishanywhere.model.Callbacks;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUploadImageCallback {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("ID")
    @Expose
    public int id;

    Uri uri;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
}
