package com.app.fishanywhere.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fishanywhere.R;

import butterknife.ButterKnife;

public class RealnDealsAdapter extends RecyclerView.Adapter<RealnDealsAdapter.ScanHistoryVH> {

    private Context context;

    public RealnDealsAdapter(Context ctx) {
        this.context = ctx;
    }

    @NonNull
    @Override
    public RealnDealsAdapter.ScanHistoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_reels_n_deals_list_item, viewGroup, false);
        return new RealnDealsAdapter.ScanHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RealnDealsAdapter.ScanHistoryVH scanHistoryVH, int postion) {


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
