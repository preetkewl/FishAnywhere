package com.apps.fishanywhere.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.model.Callbacks.GetUploadImageCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UploadImageAdapter extends RecyclerView.Adapter<UploadImageAdapter.ScanHistoryVH> {

    private Context context;
    ArrayList<GetUploadImageCallback> getUploadImageCallback;

    public UploadImageAdapter(Context context, ArrayList<GetUploadImageCallback> getUploadImageCallback) {
        this.context = context;
        this.getUploadImageCallback = getUploadImageCallback;
    }

    @NonNull
    @Override
    public ScanHistoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_upload_image_list_item, viewGroup, false);
        return new ScanHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScanHistoryVH viewholder, int postion) {
        GetUploadImageCallback uplaodImage = getUploadImageCallback.get(postion);
        Uri bitmap = uplaodImage.getUri();
        Bitmap bitmap1 = null;

        try {
            bitmap1 = MediaStore.Images.Media.getBitmap(context.getContentResolver(), bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 75, bytes);

        viewholder.ivImageToset.setImageBitmap(bitmap1);

        viewholder.ivImageCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUploadImageCallback.remove(postion);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {

        return getUploadImageCallback.size();
    }

    public void setNewImage(GetUploadImageCallback uploadImageCallback) {
        getUploadImageCallback.add(uploadImageCallback);
        notifyDataSetChanged();
        notify();
    }

    public class ScanHistoryVH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image1)
        ImageView ivImageToset;

        @BindView(R.id.iv_imageCross)
        ImageView ivImageCross;

        public ScanHistoryVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }
    }
}

