package com.apps.fishanywhere.view.interfaces;

import android.net.Uri;

import com.apps.fishanywhere.model.Callbacks.GetAllFishReportDataCallback;
import com.apps.fishanywhere.model.Callbacks.GetFishSpeciesCallback;
import com.apps.fishanywhere.model.Callbacks.GetUploadImageCallback;
import com.google.gson.JsonElement;

import java.util.ArrayList;

public interface GetFishReportInterface extends BaseInterface {
    void getFishSpecies(ArrayList<GetFishSpeciesCallback> getFishSpeciesCallback);
    void uploadMedia(GetUploadImageCallback getFishSpeciesCallback, Uri bitmapImageToUplaod);
    void postFishReport(JsonElement jsonElement);
    void getAllFishReport(GetAllFishReportDataCallback getAllFishReportDataCallback);
}
