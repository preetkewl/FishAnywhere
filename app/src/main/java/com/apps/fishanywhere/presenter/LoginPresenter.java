package com.apps.fishanywhere.presenter;

import android.content.Context;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.AppConstants;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetLoginCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.apps.fishanywhere.model.Callbacks.GetResetPasswordCallback;
import com.apps.fishanywhere.model.webrequest.RetrofitPost;
import com.apps.fishanywhere.view.interfaces.LoginInterface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginPresenter {
    private Context context;
    private LoginInterface loginInterface;
    public LoginPresenter(Context context, LoginInterface loginInterface){
        this.context = context;
        this.loginInterface = loginInterface;
    }


    public void validateLogin(final String username,
                              final String password,
                              final String fcmToken
//                              final String role
    ) throws IOException {
        loginInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetLoginCallback> call = service.validateLogin(
                    AppConstants.CONTENT_TYPE_XFORM,
                    username,
                    password,
                    fcmToken);
            call.enqueue(new Callback<GetLoginCallback>() {
                @Override
                public void onResponse(Call<GetLoginCallback> call, Response<GetLoginCallback> response) {
                    loginInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){
                        loginInterface.getLogin(response.body());
                    }else if(response!=null && response.body()==null && response.code()==401){
                        loginInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));



//                        Gson gson = new Gson();
//                        String json = response.errorBody().toString();
//                        JSONObject jsonObject = null;
//                        try {
//                            jsonObject = new JSONObject(response.body().toString());
//                            if (jsonObject != null && jsonObject.getString("code") != null) {
//                                ErrorModel errorModel =
//                                        gson.fromJson(json, ErrorModel.class);
//                                loginInterface.onFinish(errorModel.getCode());
//                            } else {
////                                GetPassengerInfoCallbcak getPassengerInfoCallbcak =
////                                        gson.fromJson(json, GetPassengerInfoCallbcak.class);
////                                passengerInfoInterfcace.getPassenderInfo(getPassengerInfoCallbcak);
//                            }
//                        } catch (JSONException e) {
//                            loginInterface.onFinish(context.getResources().getString(R.string.something_went_wrong));
//                            e.printStackTrace();
//                        }
                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        loginInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        loginInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }

                }

                @Override
                public void onFailure(Call<GetLoginCallback> call, Throwable t) {
                    loginInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                loginInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }



    public void resetPassword(final String username
    ) throws IOException {
        loginInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetResetPasswordCallback> call = service.resetPassword(AppConstants.CONTENT_TYPE_XFORM,
                    username);
            call.enqueue(new Callback<GetResetPasswordCallback>() {
                @Override
                public void onResponse(Call<GetResetPasswordCallback> call, Response<GetResetPasswordCallback> response) {
                    loginInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        loginInterface.getResetPassword(response.body());
                    }else if(response!=null && response.body()==null && response.code()==401){
                        loginInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));



//                        Gson gson = new Gson();
//                        String json = response.errorBody().toString();
//                        JSONObject jsonObject = null;
//                        try {
//                            jsonObject = new JSONObject(response.body().toString());
//                            if (jsonObject != null && jsonObject.getString("code") != null) {
//                                ErrorModel errorModel =
//                                        gson.fromJson(json, ErrorModel.class);
//                                loginInterface.onFinish(errorModel.getCode());
//                            } else {
////                                GetPassengerInfoCallbcak getPassengerInfoCallbcak =
////                                        gson.fromJson(json, GetPassengerInfoCallbcak.class);
////                                passengerInfoInterfcace.getPassenderInfo(getPassengerInfoCallbcak);
//                            }
//                        } catch (JSONException e) {
//                            loginInterface.onFinish(context.getResources().getString(R.string.something_went_wrong));
//                            e.printStackTrace();
//                        }
                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        loginInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        loginInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }

                }

                @Override
                public void onFailure(Call<GetResetPasswordCallback> call, Throwable t) {
                    loginInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                loginInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }




    public void registerCaptain(final String username,
                                final String email,
                                final String password,
                                final String fcmTOken
    ) throws IOException {
        loginInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetRegisterCallback> call = service.registerCaptain(AppConstants.CONTENT_TYPE_XFORM,
                    username,
                    "",
                    password,
                    email,
                    "",
                    "PayPal",
                    "",
                    "",
                    "",
                    "",
                    "Yes",
                    "Yes",
                    "Yes",
                    "Yes",
                    "",
                    "",
                    "",
                    "Yes",
                    fcmTOken
                    );
            call.enqueue(new Callback<GetRegisterCallback>() {
                @Override
                public void onResponse(Call<GetRegisterCallback> call, Response<GetRegisterCallback> response) {
                    loginInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        loginInterface.registerCaptain(response.body());
                    }else if(response!=null && response.body()==null && response.code()==401){
                        loginInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));



//                        Gson gson = new Gson();
//                        String json = response.errorBody().toString();
//                        JSONObject jsonObject = null;
//                        try {
//                            jsonObject = new JSONObject(response.body().toString());
//                            if (jsonObject != null && jsonObject.getString("code") != null) {
//                                ErrorModel errorModel =
//                                        gson.fromJson(json, ErrorModel.class);
//                                loginInterface.onFinish(errorModel.getCode());
//                            } else {
////                                GetPassengerInfoCallbcak getPassengerInfoCallbcak =
////                                        gson.fromJson(json, GetPassengerInfoCallbcak.class);
////                                passengerInfoInterfcace.getPassenderInfo(getPassengerInfoCallbcak);
//                            }
//                        } catch (JSONException e) {
//                            loginInterface.onFinish(context.getResources().getString(R.string.something_went_wrong));
//                            e.printStackTrace();
//                        }
                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        loginInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        loginInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }

                }

                @Override
                public void onFailure(Call<GetRegisterCallback> call, Throwable t) {
                    loginInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                loginInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }
}
