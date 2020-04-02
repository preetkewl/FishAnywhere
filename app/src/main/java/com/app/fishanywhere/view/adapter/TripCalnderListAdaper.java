package com.app.fishanywhere.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fishanywhere.R;
import com.app.fishanywhere.misc.ProgressHUD;
import com.app.fishanywhere.misc.Utils;
import com.app.fishanywhere.model.Callbacks.GetAddTripRecordCallback;
import com.app.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.app.fishanywhere.model.Callbacks.GetTripCalenderCallback;
import com.app.fishanywhere.presenter.CalenderPresenter;
import com.app.fishanywhere.view.activity.CalenderActivity;
import com.app.fishanywhere.view.interfaces.CalenderInterface;
import com.applandeo.materialcalendarview.CalendarView;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TripCalnderListAdaper extends RecyclerView.Adapter<TripCalnderListAdaper.ScanHistoryVH> implements CalenderInterface {



    private Context context;
    private ArrayList<GetTripCalenderCallback> tripListData = new ArrayList<>();
    private ArrayList<GetTripCalenderCallback> tripListDataFinalList = new ArrayList<>();
    CalenderPresenter calenderPresenter;
    RecyclerView rvTriCalender;

    private String userId="";

    private ProgressHUD progressHUD;
    int charterId;
    List<Calendar> calendarList;



    public TripCalnderListAdaper(Context ctx, ArrayList<GetTripCalenderCallback> tripListData,
                                 CalenderPresenter calenderPresenter,
                                 RecyclerView rvTriCalender, String userId, int charterId) {
        this.context = ctx;
        this.tripListData = tripListData;
        this.calenderPresenter = new CalenderPresenter(context,this);

        this.rvTriCalender =rvTriCalender;
        this.userId= userId;
        this.charterId=charterId;
        calendarList= new ArrayList<>();
    }

    @NonNull
    @Override
    public ScanHistoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_trip_list_item, viewGroup, false);
        return new ScanHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScanHistoryVH viewHolder, int postion) {
        GetTripCalenderCallback data = tripListData.get(postion);
        String fromDate = "";
        String toDate = "";
        String type = "";
        String blockingNote = "";

        if(data!=null){
            if(data.getFrom()!=null && !data.getFrom().isEmpty()){
                fromDate= data.getFrom();
                viewHolder.tvFromDate.setText(fromDate);
            }
            if(data.getTo()!=null && !data.getTo().isEmpty()){
                toDate= data.getTo();
                viewHolder.tvToDate.setText(toDate);
            }
            if(data.getType()!=null && !data.getType().isEmpty()){
                type= data.getType();
                viewHolder.tvType.setText(type);
            }
            if(data.getBlockingNote()!=null && !data.getBlockingNote().isEmpty()){
                blockingNote= data.getBlockingNote();
                viewHolder.tvBlockingNote.setText(blockingNote);
            }
        }

        String finalBlockingNote = blockingNote;
        String finalToDate = toDate;
        String finalFromDate = fromDate;
        viewHolder.rlDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPogress();

                try {
                    String tripdates = "type:custom,priority:10,bookable:no," + "from:" + finalFromDate + ",to:" + finalToDate + ",blocking_note:" + finalBlockingNote;
                    calenderPresenter.deleteTripAvailabilty(userId, String.valueOf(charterId), tripdates,postion,context);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return tripListData.size();
    }


    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public void setList(ArrayList<GetTripCalenderCallback> tripListData) {
        this.tripListData = tripListData;
        notifyDataSetChanged();
    }

    public void removeItem(int postion) {
        if(tripListData!=null && tripListData.size()>0) {
            tripListData.remove(postion);
            tripListDataFinalList = tripListData;
            this.tripListData= tripListDataFinalList;
            notifyDataSetChanged();
        }

    }

    @Override
    public void getTripCalender(ArrayList<GetTripCalenderCallback> data) {

    }

    @Override
    public void addTripAvailbilty(GetAddTripRecordCallback data) {

    }

    @Override
    public void deleteTripAvailbilty(JsonElement jsonElement, int postion) {
        hideProgress();
        ((CalenderActivity) context).update();
        removeItem(postion);
        Utils.showToast(context, "Record removed successfully!");
    }

    @Override
    public void getCharterList(ArrayList<GetCharterIDsCallback> listData) {

    }

    @Override
    public void start() {

    }

    @Override
    public void finish(String message) {

        hideProgress();
        Utils.showToast(context, message);
    }

    @Override
    public void failed(String message) {

        hideProgress();
        Utils.showToast(context, message);

    }

    public class ScanHistoryVH extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_from_date)
        TextView tvFromDate;
        @BindView(R.id.tv_to_date)
        TextView tvToDate;
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.tv_blocking_note)
        TextView tvBlockingNote;
        @BindView(R.id.iv_close)
        ImageView ivClose;
        @BindView(R.id.iv_close_cross)
        ImageView ivCloseCross;
        @BindView(R.id.rl_delete)
        RelativeLayout rlDelete;


        public ScanHistoryVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }
    }


    void showPogress() {
        progressHUD = ProgressHUD.show(context, "", true, false, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // TODO Auto-generated method stub
            }
        });
    }

    void hideProgress() {
        if (progressHUD != null && progressHUD.isShowing()) {
            progressHUD.dismiss();
        }
    }


}