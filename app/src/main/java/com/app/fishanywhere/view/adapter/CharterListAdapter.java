package com.app.fishanywhere.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fishanywhere.R;
import com.app.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.app.fishanywhere.view.activity.CalenderActivity;
import com.app.fishanywhere.view.activity.CharterActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharterListAdapter extends RecyclerView.Adapter<CharterListAdapter.ScanHistoryVH> {

    private Context context;
    ArrayList<GetCharterIDsCallback> data=new ArrayList<>();

    public CharterListAdapter(Context ctx, ArrayList<GetCharterIDsCallback> data) {
        this.context = ctx;
        this.data=data;
    }

    @NonNull
    @Override
    public ScanHistoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item_charter, viewGroup, false);
        return new ScanHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScanHistoryVH scanHistoryVH, int postion) {
        scanHistoryVH.tvTitle.setText(data.get(postion).getTitle());
        scanHistoryVH.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CalenderActivity.class).putExtra("charterId", data.get(postion).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ScanHistoryVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        public ScanHistoryVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }
    }
}
