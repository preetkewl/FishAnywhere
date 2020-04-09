package com.apps.fishanywhere.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.AppConstants;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetBookingRecordCallback;
import com.apps.fishanywhere.model.Callbacks.GetBookingStatusCallback;
import com.apps.fishanywhere.model.webrequest.RetrofitPost;
import com.apps.fishanywhere.view.adapter.BookingListAdapter;
import com.apps.fishanywhere.view.interfaces.BookingInterface;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BookingPresenter {

    private Context context;
    private BookingInterface bookingInterface;
    public BookingPresenter(Context context, BookingInterface bookingInterface){
        this.context = context;
        this.bookingInterface = bookingInterface;
    }

    public void getBookingRecord(final String userId
    ) throws IOException {
        bookingInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<ArrayList<GetBookingRecordCallback>> call = service.getBookingRecord(
                    AppConstants.CONTENT_TYPE,
                    userId);
            call.enqueue(new Callback<ArrayList<GetBookingRecordCallback>>() {
                @Override
                public void onResponse(Call<ArrayList<GetBookingRecordCallback>> call, Response<ArrayList<GetBookingRecordCallback>> response) {
                    bookingInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        bookingInterface.getBokingList(response.body());
                    }else if(response!=null && response.body()==null && response.code()==401){
                        bookingInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        bookingInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        bookingInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<GetBookingRecordCallback>> call, Throwable t) {
                    bookingInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                bookingInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }

    public void getBookingRecordValue(final String userId
    ) throws IOException {
        bookingInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<ArrayList<GetBookingRecordCallback>> call = service.getBookingRecord(
                    AppConstants.CONTENT_TYPE,
                    userId);
            call.enqueue(new Callback<ArrayList<GetBookingRecordCallback>>() {
                @Override
                public void onResponse(Call<ArrayList<GetBookingRecordCallback>> call, Response<ArrayList<GetBookingRecordCallback>> response) {
                    bookingInterface.finish("");
                    if(response!=null && response.body()!=null && response.code()==200){

                        bookingInterface.getBokingList(response.body());
                    }else if(response!=null && response.body()==null && response.code()==401){
                        bookingInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                    else if(response!=null && response.body()==null && response.code()==400){
                        bookingInterface.finish(context.getResources().getString(R.string.something_went_wrong));
                    }else if(response!=null &&  response.code()==500){
                        bookingInterface.finish(context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<GetBookingRecordCallback>> call, Throwable t) {
                    bookingInterface.failed(t.getMessage());
                }
            });

        } else if (retrofitObject == null) {
            if (context != null)
                bookingInterface.failed(context.getResources().getString(R.string.url_not_working));
        }
    }



    public void getBookingAccept(final String userId,
                                 String bookingid,
                                 String bookingstatus,
                                 BookingPresenter bookingPresenter,
                                 RecyclerView rvBookingList,
                                 BookingListAdapter bookingListAdapter,
                                 Context context) throws IOException {
        bookingInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(this.context);
        if (retrofitObject != null) {


            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetBookingStatusCallback> call = service.getBookingAccept(
                    AppConstants.CONTENT_TYPE_XFORM,
                    userId,
                    bookingid,
                    AppConstants.STATUS_ACCEPT
            );
            call.enqueue(new Callback<GetBookingStatusCallback>() {
                @Override
                public void onResponse(Call<GetBookingStatusCallback> call, Response<GetBookingStatusCallback> response) {
                    bookingInterface.finish("");
                    if (response != null && response.body() != null && response.code() == 200) {

                        bookingInterface.getBoookingAccept(response.body(), userId,bookingPresenter,rvBookingList,bookingListAdapter,context);

                    } else if (response != null && response.body() == null && response.code() == 401) {
                        bookingInterface.finish(BookingPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    } else if (response != null && response.body() == null && response.code() == 400) {
                        bookingInterface.finish(BookingPresenter.this.context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.code() == 500) {
                        bookingInterface.finish(BookingPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<GetBookingStatusCallback> call, Throwable t) {
                    bookingInterface.failed(t.getMessage());
                }
            });
        } else if (retrofitObject == null) {
            if (this.context != null)
                bookingInterface.failed(this.context.getResources().getString(R.string.url_not_working));
        }
    }


    public void getBookingReject(final String userId,
                                 String bookingid,
                                 String bookingstatus,
                                 BookingPresenter bookingPresenter,
                                 RecyclerView rvBookingList,
                                 BookingListAdapter bookingListAdapter,
                                 Context context) throws IOException {
        bookingInterface.start();
        Retrofit retrofitObject = Utils.retrofitObject(this.context);
        if (retrofitObject != null) {
            RetrofitPost service = retrofitObject.create(RetrofitPost.class);
            Call<GetBookingStatusCallback> call = service.getBookingReject(
                    AppConstants.CONTENT_TYPE,
                    userId,
                    bookingid,
                    AppConstants.STATUS_REJECT,
                    AppConstants.INTENT_REJECT
            );
            call.enqueue(new Callback<GetBookingStatusCallback>() {
                @Override
                public void onResponse(Call<GetBookingStatusCallback> call, Response<GetBookingStatusCallback
                        > response) {
                    bookingInterface.finish("");
                    if (response != null && response.body() != null && response.code() == 200) {
                        bookingInterface.getBoookingReject(response.body(),userId,bookingPresenter, rvBookingList,bookingListAdapter,context);
                    } else if (response != null && response.body() == null && response.code() == 401) {
                        bookingInterface.finish(BookingPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    } else if (response != null && response.body() == null && response.code() == 400) {
                        bookingInterface.finish(BookingPresenter.this.context.getResources().getString(R.string.something_went_wrong));
                    } else if (response != null && response.code() == 500) {
                        bookingInterface.finish(BookingPresenter.this.context.getResources().getString(R.string.invalid_user_name_password));
                    }
                }

                @Override
                public void onFailure(Call<GetBookingStatusCallback> call, Throwable t) {
                    bookingInterface.failed(t.getMessage());
                }
            });
        } else if (retrofitObject == null) {
            if (this.context != null)
                bookingInterface.failed(this.context.getResources().getString(R.string.url_not_working));
        }
    }
}
