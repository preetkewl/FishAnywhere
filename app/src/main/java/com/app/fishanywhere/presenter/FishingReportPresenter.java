package com.app.fishanywhere.presenter;

import android.content.Context;
import android.net.Uri;

import com.app.fishanywhere.R;
import com.app.fishanywhere.misc.AppConstants;
import com.app.fishanywhere.misc.Utils;
import com.app.fishanywhere.model.Callbacks.GetAllFishReportDataCallback;
import com.app.fishanywhere.model.Callbacks.GetFishSpeciesCallback;
import com.app.fishanywhere.model.Callbacks.GetUploadImageCallback;
import com.app.fishanywhere.model.webrequest.RetrofitPost;
import com.app.fishanywhere.view.interfaces.GetFishReportInterface;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FishingReportPresenter {

    private Context context;
    private GetFishReportInterface fishReportInterface;
    public FishingReportPresenter(Context context, GetFishReportInterface fishReportInterface){


        this.context = context;
        this.fishReportInterface = fishReportInterface;
    }

    public void uploadMedia(String imagPathVehicle, String userId, Uri bitmapImageToUplaod){
        fishReportInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            File imageFile = new File(imagPathVehicle);
            RequestBody imageBody = RequestBody.create(MediaType.parse("image/*"), imageFile);

            RequestBody reqFile = RequestBody.create(MediaType.parse("text"), userId);
            MultipartBody.Part imageToUpload = MultipartBody.Part.createFormData("file", imageFile.getName(), imageBody);
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetUploadImageCallback> call = service.uplaoMediaImage(
//                    AppConstants.CONTENT_TYPE,
                    reqFile,

//                    headers,
                    imageToUpload

            );
            call.enqueue(new Callback<GetUploadImageCallback>() {
                @Override
                public void onResponse(Call<GetUploadImageCallback> call, Response<GetUploadImageCallback> response) {
                    fishReportInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        fishReportInterface.uploadMedia(response.body(), bitmapImageToUplaod);

                    }else if(response!=null && response.body()==null && response.code()==401){
                        fishReportInterface.finish(context.getResources().getString(R.string.internal_server_error));

                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        fishReportInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        fishReportInterface.finish(context.getResources().getString(R.string.internal_server_error));
                    }

                }

                @Override
                public void onFailure(Call<GetUploadImageCallback> call, Throwable t) {
                    fishReportInterface.finish(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                fishReportInterface.finish(context.getResources().getString(R.string.url_not_working));
        }

    }


    public void getFishSpecies(final String userid

    ) throws IOException {
        fishReportInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<ArrayList<GetFishSpeciesCallback>> call = service.getFishSpecies(AppConstants.CONTENT_TYPE,
                    userid
            );
            call.enqueue(new Callback<ArrayList<GetFishSpeciesCallback>>() {
                @Override
                public void onResponse(Call<ArrayList<GetFishSpeciesCallback>> call, Response<ArrayList<GetFishSpeciesCallback>> response) {
                    fishReportInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                    fishReportInterface.getFishSpecies(response.body());

                    }

                    else if(response!=null && response.body()==null && response.code()==401){
                        fishReportInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));

                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        fishReportInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null && response.code()==500){
                        fishReportInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }

                }

                @Override
                public void onFailure(Call<ArrayList<GetFishSpeciesCallback>> call, Throwable t) {
                    fishReportInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                fishReportInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }




    public void postFishReport(String postTitle,
                               String postContent,
                               String tripDate,
                               ArrayList<String> fishSpeciesList,
                               ArrayList<String> galleyImages,
                               String userid
                               

    ) throws IOException {
        fishReportInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<JsonElement> call = service.postFishReport(
                    AppConstants.CONTENT_TYPE_XFORM,
                    postTitle,
                    postContent,
                    tripDate,
                    fishSpeciesList,
                    galleyImages,
                    userid
            );
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

                    fishReportInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        fishReportInterface.postFishReport(response.body());

                    }

                    else if(response!=null && response.body()==null && response.code()==401){
                        fishReportInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));

                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        fishReportInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null && response.code()==500){
                        fishReportInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }

                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
//                    Utils.showToast(context, t.getMessage());
                    fishReportInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                fishReportInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }



    public void getAllFishReport(String userid) throws IOException {
        fishReportInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetAllFishReportDataCallback> call = service.getAllFishReport(
                    AppConstants.CONTENT_TYPE,
                    userid
            );
            call.enqueue(new Callback<GetAllFishReportDataCallback>() {
                @Override
                public void onResponse(Call<GetAllFishReportDataCallback> call, Response<GetAllFishReportDataCallback> response) {

                    fishReportInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        fishReportInterface.getAllFishReport(response.body());

                    }

                    else if(response!=null && response.body()==null && response.code()==401){
                        fishReportInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));

                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        fishReportInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null && response.code()==500){
                        fishReportInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }

                }

                @Override
                public void onFailure(Call<GetAllFishReportDataCallback> call, Throwable t) {
//                    Utils.showToast(context, t.getMessage());
                    fishReportInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                fishReportInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }
}