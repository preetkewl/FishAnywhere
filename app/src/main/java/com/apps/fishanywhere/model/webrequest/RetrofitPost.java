package com.apps.fishanywhere.model.webrequest;


import com.apps.fishanywhere.model.Callbacks.GetAddTripRecordCallback;
import com.apps.fishanywhere.model.Callbacks.GetAllFishReportDataCallback;
import com.apps.fishanywhere.model.Callbacks.GetBookingRecordCallback;
import com.apps.fishanywhere.model.Callbacks.GetBookingStatusCallback;
import com.apps.fishanywhere.model.Callbacks.GetCaptainDetailsCallback;
import com.apps.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.apps.fishanywhere.model.Callbacks.GetFishSpeciesCallback;
import com.apps.fishanywhere.model.Callbacks.GetLoginCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.apps.fishanywhere.model.Callbacks.GetResetPasswordCallback;
import com.apps.fishanywhere.model.Callbacks.GetTripCalenderCallback;
import com.apps.fishanywhere.model.Callbacks.GetUploadImageCallback;
import com.google.gson.JsonElement;


import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitPost {
    //////////////////Authenticaiton Api started////////////////////////

    //validate login
    @FormUrlEncoded
    @POST("wp-json/app/v2/auth/login")
    Call<GetLoginCallback> validateLogin(
            @Header("Content-Type") String contentType,
            @Field("username") String email,
            @Field("password") String password,
            @Field("fcm_token") String fcmToken
    );

    //Forgot password
    @FormUrlEncoded
    @POST("wp-json/app/v2/auth/reset_password")
    Call<GetResetPasswordCallback> resetPassword(
            @Header("Content-Type") String contentType,
            @Field("user_login") String email
    );


    //Forgot password
    @FormUrlEncoded
    @POST("wp-json/app/v2/auth/register_captain")
    Call<GetRegisterCallback> registerCaptain(
            @Header("Content-Type") String contentType,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("user_password") String userPassword,
            @Field("user_email") String userEmail,
            @Field("profile_charter_company_name") String profile_charter_company_name,
            @Field("profile_payout_method") String profile_payout_method,
            @Field("profile_payout_paypal_email") String profile_payout_paypal_email,
            @Field("profile_check_mailing_address") String profile_check_mailing_address,
            @Field("profile_charter_established_month") String profile_charter_established_month,
            @Field("profile_charter_established_year") String profile_charter_established_year,
            @Field("cap-profile-info-current-accurate") String cap_profile_info_current_accurate,
            @Field("profile_incorporated") String profile_incorporated,
            @Field("profile_insurance") String profile_insurance,
            @Field("cap-profile-required-licenses") String cap_profile_required_licenses,
            @Field("profile_website") String profile_website,
            @Field("profile_phone_number") String profile_phone_number,
            @Field("profile_mobile_phone_number") String profile_mobile_phone_number,
            @Field("profile_sms_consent") String profile_sms_consent,
            @Field("fcm_token") String fcmToken
    );

    //////////////////Authenticaiton Api ended////////////////////////



    //////////////////Profile Api started////////////////////////

    //get user profile info
    @GET("wp-json/app/v2/captain/edit")
    Call<GetCaptainDetailsCallback> getCaptainDetails(
            @Header("Content-Type") String contentType,
            @Query("user_id") String loginToken
    );

    //update user profile
    @FormUrlEncoded
    @POST("wp-json/app/v2/captain/update")
    Call<GetRegisterCallback> udpateCaptainDetails(
            @Header("Content-Type") String contentType,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("profile_charter_company_name") String charaterCompany,
            @Field("profile_payout_method") String payoutMethod,
            @Field("profile_payout_paypal_email") String payPalEmail,
            @Field("profile_check_mailing_address") String checkMailingAddress,
            @Field("profile_charter_established_month") String establishedMonth,
            @Field("profile_charter_established_year") String establishedYear,
            @Field("cap-profile-info-current-accurate") String infoCurrentAccurate,
            @Field("profile_incorporated") String incorporarted,
            @Field("profile_insurance") String insuarance,
            @Field("cap-profile-required-licenses") String license,
            @Field("profile_website") String website,
            @Field("profile_phone_number") String phoneNumber,
            @Field("profile_mobile_phone_number") String mobiliPhoneNumber,
            @Field("profile_sms_consent") String smsContent,
            @Field("description") String description,
            @Field("user_id") String userId
    );



    //////////////////Profile Api ended////////////////////////



    //////////////////Fishing Report Api started////////////////////////

    // to upload image of vehicle and plate
    @Multipart
    @POST("wp-json/app/v2/captain/upload_media")
    Call<GetUploadImageCallback> uplaoMediaImage(
            @Part("user_id") RequestBody token,
            @Part MultipartBody.Part image
    );

    //fish species
    @GET("/wp-json/app/v2/get_fish_species")
    Call<ArrayList<GetFishSpeciesCallback>> getFishSpecies(
            @Header("Content-Type") String contentType,
            @Query("user_id") String loginToken
    );

    //post fish report
    @FormUrlEncoded
    @POST("wp-json/app/v2/captain/create_fishing_report")
    Call<JsonElement> postFishReport(
            @Header("Content-Type") String contentType,
            @Field("post_title") String postTitle,
            @Field("post_content") String postContent,
            @Field("wpuf_fishing_report_trip_date") String tripDate,
            @Field("fish_species") ArrayList<String> fishSpicesList,
            @Field("wpuf_fishing_report_gallery") ArrayList<String> uplaodMediaList,
            @Field("user_id") String userId
    );

    //get all fish report listing
    @GET("wp-json/app/v2/captain/get_all_fishing_report")
    Call<GetAllFishReportDataCallback> getAllFishReport(
            @Header("Content-Type") String contentType,
            @Query("user_id") String loginToken
    );

    //////////////////Fishing Report Api ended////////////////////////


    //////////////////Calender Api started////////////////////////

    //get trip calender info
    @GET("wp-json/app/v2/captain/get_trip_calender")
    Call<ArrayList<GetTripCalenderCallback>> getTripCalender(
            @Header("Content-Type") String contentType,
            @Query("user_id") String userId,
            @Query("id") String charterId
    );



    //updage trip calender info
    @FormUrlEncoded
    @POST("wp-json/app/v2/captain/update_trip_availability")
    Call<GetAddTripRecordCallback> addTripAvailabilty(
            @Header("Content-Type") String contentType,
            @Field("user_id") String userId,
            @Field("charter_id") String charterId,
            @Field("blocking_note") String blockingNote,
            @Field("tripdates") String tripDtripdatesates
    );


    //delete trip calender info
    @FormUrlEncoded
    @POST("wp-json/app/v2/captain/delete_trip_availability")
    Call<JsonElement> deletTripAvailabilty(
//            @Header("Content-Type") String contentType,
            @Field("user_id") String userId,
            @Field("charter_id") String charterId,
            @Field("tripdates") String tripDates
    );




    //////////////////Calender Api ended////////////////////////




    //////////////////Booking Api started////////////////////////

    //get trip calender info
    @GET("wp-json/app/v2/captain/get_all_trip_booking")
    Call<ArrayList<GetBookingRecordCallback>> getBookingRecord(
            @Header("Content-Type") String contentType,
            @Query("user_id") String userId
    );

    //get accept booking record
    @FormUrlEncoded
    @POST("wp-json/app/v2/captain/accept_decline_booking")
    Call<GetBookingStatusCallback> getBookingAccept(
            @Header("Content-Type") String contentType,
            @Field("user_id") String userId,
            @Field("booking_id") String bookingId,
            @Field("status") String status
    );

    //get accept booking record
//    @FormUrlEncoded
    @POST("wp-json/app/v2/captain/accept_decline_booking")
    Call<GetBookingStatusCallback> getBookingReject(
            @Header("Content-Type") String contentType,
            @Query("user_id") String userId,
            @Query("booking_id") String bookingId,
            @Query("status") String status,
            @Query("intent") String intent
    );








    //////////////////Booking Api ended////////////////////////




    //get trip calender info
    @GET("/wp-json/app/v2/captain/get_all_charter")
    Call<ArrayList<GetCharterIDsCallback>> getCharterList(
            @Header("Content-Type") String contentType,
            @Query("user_id") String userId
    );

    //get accept booking record

}


