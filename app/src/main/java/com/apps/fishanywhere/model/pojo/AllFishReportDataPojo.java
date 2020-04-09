package com.apps.fishanywhere.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllFishReportDataPojo {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("post_title")
    @Expose
    public String postTitle;
    @SerializedName("post_content")
    @Expose
    public String postContent;
    @SerializedName("wpuf_fishing_report_trip_date")
    @Expose
    public String wpufFishingReportTripDate;
    @SerializedName("wpuf_fishing_report_gallery")
    @Expose
    public Object wpufFishingReportGallery;
    @SerializedName("wpuf_fishing_report_gallery_url")
    @Expose
    public List<String> wpufFishingReportGalleryUrl = null;
    @SerializedName("fish_species")
    @Expose
    public List<Integer> fishSpecies = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getWpufFishingReportTripDate() {
        return wpufFishingReportTripDate;
    }

    public void setWpufFishingReportTripDate(String wpufFishingReportTripDate) {
        this.wpufFishingReportTripDate = wpufFishingReportTripDate;
    }

    public Object getWpufFishingReportGallery() {
        return wpufFishingReportGallery;
    }

    public void setWpufFishingReportGallery(Object wpufFishingReportGallery) {
        this.wpufFishingReportGallery = wpufFishingReportGallery;
    }

    public List<String> getWpufFishingReportGalleryUrl() {
        return wpufFishingReportGalleryUrl;
    }

    public void setWpufFishingReportGalleryUrl(List<String> wpufFishingReportGalleryUrl) {
        this.wpufFishingReportGalleryUrl = wpufFishingReportGalleryUrl;
    }

    public List<Integer> getFishSpecies() {
        return fishSpecies;
    }

    public void setFishSpecies(List<Integer> fishSpecies) {
        this.fishSpecies = fishSpecies;
    }
}
