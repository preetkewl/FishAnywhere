package com.apps.fishanywhere.view.interfaces;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.model.Callbacks.GetBookingRecordCallback;
import com.apps.fishanywhere.model.Callbacks.GetBookingStatusCallback;
import com.apps.fishanywhere.presenter.BookingPresenter;
import com.apps.fishanywhere.view.adapter.BookingListAdapter;

import java.util.ArrayList;

public interface BookingInterface extends BaseInterface {
    void getBokingList(ArrayList<GetBookingRecordCallback> recordCallback);
    void getBoookingAccept(GetBookingStatusCallback jsonElement, String userId, BookingPresenter bookingPresenter, RecyclerView rvBookingList, BookingListAdapter bookingListAdapter, Context context);
    void getBoookingReject(GetBookingStatusCallback jsonElement, String userId, BookingPresenter bookingPresenter, RecyclerView rvBookingList, BookingListAdapter bookingListAdapter, Context context);
}
