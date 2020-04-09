package com.apps.fishanywhere.view.adapter;

import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.ride.rideafide.R;
//import com.ride.rideafide.model.callbacks.GetScanHistoryCallback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.R;

import butterknife.ButterKnife;


public class AddYourTripsAdapter extends RecyclerView.Adapter<AddYourTripsAdapter.ScanHistoryVH> {

    private Context context;

    public AddYourTripsAdapter(Context ctx) {
        this.context = ctx;
    }

    @NonNull
    @Override
    public ScanHistoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_add_your_trips_list_item, viewGroup, false);
        return new ScanHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScanHistoryVH scanHistoryVH, int postion) {


    }



    @Override
    public int getItemCount() {
        return 2;
    }

    public class ScanHistoryVH extends RecyclerView.ViewHolder {

        public ScanHistoryVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }
    }


}
