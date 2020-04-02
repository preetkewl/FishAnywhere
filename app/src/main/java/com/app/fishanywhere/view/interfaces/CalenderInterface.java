package com.app.fishanywhere.view.interfaces;

import com.app.fishanywhere.model.Callbacks.GetAddTripRecordCallback;
import com.app.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.app.fishanywhere.model.Callbacks.GetTripCalenderCallback;
import com.google.gson.JsonElement;

import java.util.ArrayList;

public interface CalenderInterface extends BaseInterface {
    void getTripCalender(ArrayList<GetTripCalenderCallback> data);
    void addTripAvailbilty(GetAddTripRecordCallback data);
    void deleteTripAvailbilty(JsonElement jsonElement, int postion);
    void getCharterList(ArrayList<GetCharterIDsCallback> listData);
}
