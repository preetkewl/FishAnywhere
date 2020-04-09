package com.apps.fishanywhere.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.model.Callbacks.GetFishSpeciesCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FishSpeciesAdapter extends RecyclerView.Adapter<FishSpeciesAdapter.ScanHistoryVH> {

    static ArrayList<String> fishSpeciesList= new ArrayList<>();


    private Context context;
    private ArrayList<GetFishSpeciesCallback> getFishSpeciesCallbackArrayList;

    public FishSpeciesAdapter(Context ctx, ArrayList<GetFishSpeciesCallback> getFishSpeciesCallbackArrayList) {
        this.context = ctx;
        this.getFishSpeciesCallbackArrayList = getFishSpeciesCallbackArrayList;
    }

    @NonNull
    @Override
    public FishSpeciesAdapter.ScanHistoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_fish_species_list_item, viewGroup, false);
        return new FishSpeciesAdapter.ScanHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishSpeciesAdapter.ScanHistoryVH viewholder, int postion) {

        GetFishSpeciesCallback getFishSpeciesCallback = getFishSpeciesCallbackArrayList.get(postion);
        String name = getFishSpeciesCallback.getName();
        int id = getFishSpeciesCallback.getTermId();
        viewholder.tvFishspeciesChecked.setText(name);
        viewholder.tvFishspeciesUnchecked.setText(name);
        viewholder.llUnchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewholder.llChecked.setVisibility(View.VISIBLE);
                viewholder.llUnchecked.setVisibility(View.GONE);

                fishSpeciesList.add(String.valueOf(id));

            }
        });
        viewholder.llChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewholder.llChecked.setVisibility(View.GONE);
                viewholder.llUnchecked.setVisibility(View.VISIBLE);
                for(String list: fishSpeciesList){
                    if(list.equals(id)){
                        fishSpeciesList.remove(String.valueOf(id));
                    }
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return getFishSpeciesCallbackArrayList.size();
    }

    public class ScanHistoryVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_fishspecies_checked)
        TextView tvFishspeciesChecked;
        @BindView(R.id.ll_checked)
        LinearLayout llChecked;
        @BindView(R.id.tv_fishspecies_unchecked)
        TextView tvFishspeciesUnchecked;
        @BindView(R.id.ll_unchecked)
        LinearLayout llUnchecked;

        public ScanHistoryVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }
    }

    public ArrayList<String> getFishSpeciesList(){
        return fishSpeciesList;
    }
}