package com.app.fishanywhere.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.fishanywhere.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateListingAdditionalFeaturesActivity extends AppCompatActivity {

    ImageView iv_cllist_paging;

    TextView tv_createlist_heading;

    TextView tv_createlist_subheading;
    @BindView(R.id.iv_createlist_back)
    ImageView ivCreatelistBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_additional_features);
        ButterKnife.bind(this);
        setStatusBarColor();

        iv_cllist_paging = (ImageView) findViewById(R.id.iv_cllist_paging);

        iv_cllist_paging.setImageDrawable(getResources().getDrawable(R.drawable.im_cl_add_features));

        tv_createlist_heading = (TextView) findViewById(R.id.tv_createlist_heading);
        tv_createlist_heading.setText(getResources().getText(R.string.add_features));


        tv_createlist_subheading = (TextView) findViewById(R.id.tv_createlist_subheading);
        tv_createlist_subheading.setText(getResources().getText(R.string.add_features_subheading));
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @OnClick({R.id.bt_add_features_previous, R.id.bt_add_features_next, R.id.bt_add_features_save_exit, R.id.iv_createlist_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.iv_createlist_back:
                finish();
                break;
            case R.id.bt_add_features_next:
                startActivity(new Intent(this, CreateListingSpeciesActivity.class));
                break;
            case R.id.bt_add_features_save_exit:
                startActivity(new Intent(this, DashboardActivity.class));

                break;
        }
    }

//    @OnClick(R.id.iv_createlist_back)
//    public void onViewClicked() {
//        startActivity(new Intent(this, CreateListingAmenitiesActivity.class));
//
//    }
}
