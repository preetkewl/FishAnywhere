package com.apps.fishanywhere.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.model.pojo.AllFishReportDataPojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FishingReportListingAdapter extends RecyclerView.Adapter<FishingReportListingAdapter.ScanHistoryVH> {


    private Context context;
    ArrayList<AllFishReportDataPojo> fishReportDataPojoArrayList;

    public FishingReportListingAdapter(Context ctx, ArrayList<AllFishReportDataPojo> fishReportDataPojoArrayList) {
        this.context = ctx;
        this.fishReportDataPojoArrayList = fishReportDataPojoArrayList;
    }

    @NonNull
    @Override
    public ScanHistoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_fishing_report_list_item, viewGroup, false);
        return new ScanHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScanHistoryVH viewHolder, int postion) {
        AllFishReportDataPojo data= fishReportDataPojoArrayList.get(postion);
        String title="";
        String content="";
        String imageUrl="";


        if(data!=null){
            if(data.getPostTitle()!=null && !data.getPostTitle().isEmpty()){
                title = data.getPostTitle();
                viewHolder.tvTitle.setText(title);
            }
            if(data.getPostContent()!=null && !data.getPostContent().isEmpty()){
                content = data.getPostContent();
                viewHolder.tvContent.setText(content);
            }
            if(data.getWpufFishingReportGalleryUrl()!=null &&
                    data.getWpufFishingReportGalleryUrl().get(0)!=null &&
                    !data.getWpufFishingReportGalleryUrl().get(0).isEmpty()){
                imageUrl = data.getWpufFishingReportGalleryUrl().get(0);

//                Glide.with(context).load(imageUrl).into(viewHolder.ivGallery);

                Picasso.get()
                        .load(imageUrl)
                        .into((ImageView) viewHolder.ivGallery);

//                Picasso
//                        .with(context)
//                        .load(imageUrls[position])
//                        .placeholder(R.drawable.ic_launcher) // can also be a drawable
//                        .fit() // will explain later
//                        .noFade()
//                        .into((ImageView) convertView.findViewbyId(R.id.ImageView));

            }
        }



//        String title="It is a long established fact that a reader will be distracted by the readable ";
//        String title2="<font color='#00B4E0'><b>See more<b></font>";
//        String text = title+title2;
////        String text = "This is <font color='red'>red</font>. This is <font color='blue'>blue</font>.";
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            scanHistoryVH.hereJourneySubheading.setText(Html.fromHtml(text,  Html.FROM_HTML_MODE_LEGACY), TextView.BufferType.SPANNABLE);
//        } else {
//            scanHistoryVH.hereJourneySubheading.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
//        }
//        scanHistoryVH.tvViewDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.startActivity(new Intent(context, ViewFishingReportActivity.class));
//            }
//        });



    }


    @Override
    public int getItemCount() {
        return fishReportDataPojoArrayList.size();
    }

    public class ScanHistoryVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_includes)
        TextView tvIncludes;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.see_more)
        TextView seeMore;
        @BindView(R.id.tv_view_details)
        TextView tvViewDetails;
        @BindView(R.id.iv_gallery)
        ImageView ivGallery;

        public ScanHistoryVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }
    }


}