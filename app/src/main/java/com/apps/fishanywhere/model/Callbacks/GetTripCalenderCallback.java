package com.apps.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTripCalenderCallback {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookable() {
        return bookable;
    }

    public void setBookable(String bookable) {
        this.bookable = bookable;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBlockingNote() {
        return blockingNote;
    }

    public void setBlockingNote(String blockingNote) {
        this.blockingNote = blockingNote;
    }

    @SerializedName("option value")
    @Expose
    public String type;
    @SerializedName("bookable")
    @Expose
    public String bookable;
    @SerializedName("priority")
    @Expose
    public String priority;
    @SerializedName("from_date")
    @Expose
    public String fromDate;
    @SerializedName("to_date")
    @Expose
    public String toDate;
    @SerializedName("from")
    @Expose
    public String from;
    @SerializedName("to")
    @Expose
    public String to;
    @SerializedName("blocking_note")
    @Expose
    public String blockingNote;
}
