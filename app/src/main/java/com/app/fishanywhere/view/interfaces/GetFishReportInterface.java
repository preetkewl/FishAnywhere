package com.app.fishanywhere.view.interfaces;

import android.net.Uri;

import com.app.fishanywhere.model.Callbacks.GetAllFishReportDataCallback;
import com.app.fishanywhere.model.Callbacks.GetFishSpeciesCallback;
import com.app.fishanywhere.model.Callbacks.GetUploadImageCallback;
import com.google.gson.JsonElement;

import java.util.ArrayList;

public interface GetFishReportInterface extends BaseInterface {
    void getFishSpecies(ArrayList<GetFishSpeciesCallback> getFishSpeciesCallback);
    void uploadMedia(GetUploadImageCallback getFishSpeciesCallback, Uri bitmapImageToUplaod);
    void postFishReport(JsonElement jsonElement);
    void getAllFishReport(GetAllFishReportDataCallback getAllFishReportDataCallback);
}
