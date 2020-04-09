package com.apps.fishanywhere.presenter;

import android.content.Context;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.AppConstants;
import com.apps.fishanywhere.misc.Utils;
//import com.example.fishanywhere.model.Callbacks.ResponseBody;
//import com.example.fishanywhere.model.Callbacks.ResponseBody;
import com.apps.fishanywhere.model.Callbacks.GetCaptainDetailsCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.apps.fishanywhere.model.webrequest.RetrofitPost;
import com.apps.fishanywhere.view.interfaces.EditCaptainDetailsInterface;
//import com.example.fishanywhere.view.interfaces.editCaptainDetailsInterface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EditCaptainDetailsPresenter {

    private Context context;
    private EditCaptainDetailsInterface editCaptainDetailsInterface;
    public EditCaptainDetailsPresenter(Context context, EditCaptainDetailsInterface editCaptainDetailsInterface){
        this.context = context;
        this.editCaptainDetailsInterface = editCaptainDetailsInterface;
    }
    
    public void getCaptainDetails(final String token
    ) throws IOException {
        editCaptainDetailsInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetCaptainDetailsCallback> call = service.getCaptainDetails(
                    AppConstants.CONTENT_TYPE,
                    token);
            call.enqueue(new Callback<GetCaptainDetailsCallback>() {
                @Override
                public void onResponse(Call<GetCaptainDetailsCallback> call, Response<GetCaptainDetailsCallback> response) {
                    editCaptainDetailsInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        editCaptainDetailsInterface.getCaptainDetails(response.body());
                    }else if(response!=null && response.body()==null && response.code()==401){
                        editCaptainDetailsInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        editCaptainDetailsInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        editCaptainDetailsInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<GetCaptainDetailsCallback> call, Throwable t) {
                    editCaptainDetailsInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                editCaptainDetailsInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }



    public void updateCaptainDetials(String firstName,
                                     String lastName,
                                     String charterServiceName,
                                     String paymentMehtod,
                                     String payEmail,
                                     String manulaEmail,
                                     String phoneNumber,
                                     String mobileNumber,
                                     String website,
                                     String esatblishedMonth,
                                     String esatblishedYear,
                                     String currentInfoCurrnetAccurate,
                                     final String isBuisnesEntity,
                                     final String isInsuarance,
                                     final String isPermitLicense,
                                     String userId
    ) throws IOException {
        editCaptainDetailsInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetRegisterCallback> call = service.udpateCaptainDetails(
                    AppConstants.CONTENT_TYPE_XFORM,
                    firstName,
                    lastName,
                    charterServiceName,
                    paymentMehtod,
                    payEmail,
                    manulaEmail,
                    esatblishedMonth,
                    esatblishedYear,
                    currentInfoCurrnetAccurate,
                    isBuisnesEntity,
                    isInsuarance,
                    isPermitLicense,
                    website,
                    phoneNumber,
                    mobileNumber,
                    "Yes",
                    "Yes",
                    userId

            );
            call.enqueue(new Callback<GetRegisterCallback>() {
                @Override
                public void onResponse(Call<GetRegisterCallback> call, Response<GetRegisterCallback> response) {
                    editCaptainDetailsInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){
                        editCaptainDetailsInterface.updateCaptainDetails(response.body());
                    }else if(response!=null && response.body()==null && response.code()==401){
                        editCaptainDetailsInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        editCaptainDetailsInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        editCaptainDetailsInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<GetRegisterCallback> call, Throwable t) {
                    editCaptainDetailsInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                editCaptainDetailsInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }
}
