package com.app.fishanywhere.presenter;

import android.content.Context;

import com.app.fishanywhere.R;
import com.app.fishanywhere.misc.AppConstants;
import com.app.fishanywhere.misc.Utils;
import com.app.fishanywhere.model.Callbacks.GetAddTripRecordCallback;
import com.app.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.app.fishanywhere.model.Callbacks.GetTripCalenderCallback;
import com.app.fishanywhere.model.webrequest.RetrofitPost;
import com.app.fishanywhere.view.interfaces.CalenderInterface;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CalenderPresenter {

    private Context context;
    private CalenderInterface calenderInterface;

    public CalenderPresenter(Context context, CalenderInterface calenderInterface) {
        this.context = context;
        this.calenderInterface = calenderInterface;
    }

    public void getTripCalender(final String userId, final String id
    ) throws IOException {
        calenderInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<ArrayList<GetTripCalenderCallback>> call = service.getTripCalender(
                    AppConstants.CONTENT_TYPE,
                    userId,
                    id);
            call.enqueue(new Callback<ArrayList<GetTripCalenderCallback>>() {
                @Override
                public void onResponse(Call<ArrayList<GetTripCalenderCallback>> call, Response<ArrayList<GetTripCalenderCallback>> response) {
                    calenderInterface.finish("");
                    if (response != null && response.body() != null && response.code() == 200) {
                        calenderInterface.getTripCalender(response.body());
                    } else if (response != null && response.body() == null && response.code() == 401) {
                        calenderInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    } else if (response != null && response.body() == null && response.code() == 400) {
                        calenderInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.code() == 500) {
                        calenderInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<GetTripCalenderCallback>> call, Throwable t) {
                    calenderInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                calenderInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }


    public void addTripAvailabilty(final String userId,
                                   final String id,
                                   final String blockingNotes,
                                   final String tripdates
    ) throws IOException {
        calenderInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {


            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetAddTripRecordCallback> call = service.addTripAvailabilty(
                    AppConstants.CONTENT_TYPE_XFORM,
                    userId,
                    id,
                    blockingNotes,
                    tripdates);
            call.enqueue(new Callback<GetAddTripRecordCallback>() {
                @Override
                public void onResponse(Call<GetAddTripRecordCallback> call, Response<GetAddTripRecordCallback> response) {
                    calenderInterface.finish("");
                    if (response != null && response.body() != null && response.code() == 200) {

                        calenderInterface.addTripAvailbilty(response.body());
                    } else if (response != null && response.body() == null && response.code() == 401) {
                        calenderInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    } else if (response != null && response.body() == null && response.code() == 400) {
                        calenderInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.code() == 500) {
                        calenderInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<GetAddTripRecordCallback> call, Throwable t) {
                    calenderInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                calenderInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }


    public void deleteTripAvailabilty(final String userId,
                                      final String charaterId,
                                      final String tripdates,
                                      int postion, Context context) throws IOException {
        calenderInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<JsonElement> call = service.deletTripAvailabilty(
//                    AppConstants.CONTENT_TYPE_XFORM,
                    userId,
                    charaterId,
                    tripdates);
            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    calenderInterface.finish("");
                    if (response != null && response.body() != null && response.code() == 200) {

                        calenderInterface.deleteTripAvailbilty(response.body(), postion);
                    } else if (response != null && response.body() == null && response.code() == 401) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    } else if (response != null && response.body() == null && response.code() == 400) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.body() == null && response.code() == 404) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.code() == 500) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
                    calenderInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (this.context != null)
                calenderInterface.failed(this.context.getResources().getString(R.string.url_not_working));
        }
    }


    public void getCharaterId(final String userId) throws IOException {
        calenderInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<ArrayList<GetCharterIDsCallback>> call = service.getCharterList(AppConstants.CONTENT_TYPE,
                    userId);
            call.enqueue(new Callback<ArrayList<GetCharterIDsCallback>>() {
                @Override
                public void onResponse(Call<ArrayList<GetCharterIDsCallback>> call, Response<ArrayList<GetCharterIDsCallback>> response) {
                    calenderInterface.finish("");
                    if (response != null && response.body() != null && response.code() == 200) {

                        calenderInterface.getCharterList(response.body());
                    } else if (response != null && response.body() == null && response.code() == 401) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    } else if (response != null && response.body() == null && response.code() == 400) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.body() == null && response.code() == 404) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.code() == 500) {
                        calenderInterface.finish(CalenderPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<GetCharterIDsCallback>> call, Throwable t) {
                    calenderInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (this.context != null)
                calenderInterface.failed(this.context.getResources().getString(R.string.url_not_working));
        }
    }
}
