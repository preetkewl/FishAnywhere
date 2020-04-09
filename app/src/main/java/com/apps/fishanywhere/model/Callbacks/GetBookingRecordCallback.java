package com.apps.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GetBookingRecordCallback implements Comparable<GetBookingRecordCallback> {
    @SerializedName("booking_all_day")
    @Expose
    public String bookingAllDay;
    @SerializedName("booking_cost")
    @Expose
    public String bookingCost;
    @SerializedName("booking_end")
    @Expose
    public String bookingEnd;
    @SerializedName("booking_id")
    @Expose
    public Integer bookingId;
    @SerializedName("booking_order_item_title")
    @Expose
    public String bookingOrderItemTitle;
    @SerializedName("booking_persons")
    @Expose
    public ArrayList<Integer> bookingPersons = null;
    @SerializedName("booking_product")
    @Expose
    public String bookingProduct;
    @SerializedName("booking_resource")
    @Expose
    public String bookingResource;
    @SerializedName("booking_start")
    @Expose
    public String bookingStart;
    @SerializedName("customer_first_name")
    @Expose
    public String customerFirstName;
    @SerializedName("customer_last_name")
    @Expose
    public String customerLastName;
    private Date date;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("wc_booking_has_persons")
    @Expose
    public int wc_booking_has_persons;
    @SerializedName("wc_booking_max_persons_group")
    @Expose
    public int wc_booking_max_persons_group;
    @SerializedName("price_for_each_additional_person")
    @Expose
    public int price_for_each_additional_person;


    public int getWc_booking_has_persons() {
        return wc_booking_has_persons;
    }

    public void setWc_booking_has_persons(int wc_booking_has_persons) {
        this.wc_booking_has_persons = wc_booking_has_persons;
    }


    public int getPrice_for_each_additional_person() {
        return price_for_each_additional_person;
    }

    public void setPrice_for_each_additional_person(int price_for_each_additional_person) {
        this.price_for_each_additional_person = price_for_each_additional_person;
    }

    public int getWc_booking_max_persons_group() {
        return wc_booking_max_persons_group;
    }

    public void setWc_booking_max_persons_group(int wc_booking_max_persons_group) {
        this.wc_booking_max_persons_group = wc_booking_max_persons_group;
    }

    public Integer getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Integer bookingId2) {
        this.bookingId = bookingId2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getBookingAllDay() {
        return this.bookingAllDay;
    }

    public void setBookingAllDay(String bookingAllDay2) {
        this.bookingAllDay = bookingAllDay2;
    }

    public String getBookingCost() {
        return this.bookingCost;
    }

    public void setBookingCost(String bookingCost2) {
        this.bookingCost = bookingCost2;
    }

    public String getBookingOrderItemTitle() {
        return this.bookingOrderItemTitle;
    }

    public void setBookingOrderItemTitle(String bookingOrderItemTitle2) {
        this.bookingOrderItemTitle = bookingOrderItemTitle2;
    }

    public ArrayList<Integer> getBookingPersons() {
        return this.bookingPersons;
    }

    public void setBookingPersons(ArrayList<Integer> bookingPersons2) {
        this.bookingPersons = bookingPersons2;
    }

    public String getBookingProduct() {
        return this.bookingProduct;
    }

    public void setBookingProduct(String bookingProduct2) {
        this.bookingProduct = bookingProduct2;
    }

    public Date getDate() {
        String data = this.bookingResource.replaceFirst("^Booking &ndash; ", "");
        try {
            this.date = new SimpleDateFormat("MMM dd, yyyy ").parse(data.substring(0, data.indexOf("@")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this.date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public String getBookingResource() {
        return this.bookingResource.replaceFirst("^Booking &ndash;", "");
    }

    public String getBookingDate() {
        String date2 = this.bookingResource.replaceFirst("^Booking &ndash;", "");
        return date2.substring(0, date2.indexOf("@"));
    }

    public void setBookingResource(String bookingResource2) {
        this.bookingResource = bookingResource2;
    }

    public String getBookingStart() {
        return this.bookingStart;
    }

    public void setBookingStart(String bookingStart2) {
        this.bookingStart = bookingStart2;
    }

    public String getBookingEnd() {
        return this.bookingEnd;
    }

    public void setBookingEnd(String bookingEnd2) {
        this.bookingEnd = bookingEnd2;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price2) {
        this.price = price2;
    }

    public String getCustomerFirstName() {
        return this.customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName2) {
        this.customerFirstName = customerFirstName2;
    }

    public String getCustomerLastName() {
        return this.customerLastName;
    }

    public void setCustomerLastName(String customerLastName2) {
        this.customerLastName = customerLastName2;
    }

    public int compareTo(GetBookingRecordCallback o) {
        return getDate().compareTo(o.getDate());
    }
}
