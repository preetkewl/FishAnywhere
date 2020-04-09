package com.apps.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetCharterIDsCallback implements Serializable {

    @Override
    public String toString() {
        return title;
    }

    @SerializedName("title")
    @Expose
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose
    public int id;
}
