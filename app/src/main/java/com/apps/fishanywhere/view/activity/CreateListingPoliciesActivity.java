package com.apps.fishanywhere.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.apps.fishanywhere.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateListingPoliciesActivity extends AppCompatActivity {

    ImageView iv_cllist_paging;

    TextView tv_createlist_heading;
    //    @BindView(R.id.bt_launchlocation_previous)
//    Button btLaunchlocationPrevious;
//    @BindView(R.id.bt_launchlocation_next)
//    Button btLaunchlocationNext;
//    @BindView(R.id.bt_launchlocation_save_exit)
//    Button btLaunchlocationSaveExit;
    TextView tv_createlist_subheading;
    @BindView(R.id.bt_boatinfo_previous)
    Button btBoatinfoPrevious;
    @BindView(R.id.bt_boatinfo_next)
    Button btBoatinfoNext;
    @BindView(R.id.bt_boatinfo_save_exit)
    Button btBoatinfoSaveExit;
    @BindView(R.id.iv_createlist_back)
    ImageView ivCreatelistBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_policies);

        ButterKnife.bind(this);


        setStatusBarColor();

        iv_cllist_paging = (ImageView) findViewById(R.id.iv_cllist_paging);

        iv_cllist_paging.setImageDrawable(getResources().getDrawable(R.drawable.im_cl_polices));

        tv_createlist_heading = (TextView) findViewById(R.id.tv_createlist_heading);
        tv_createlist_heading.setText(getResources().getText(R.string.policy_));

        tv_createlist_subheading = (TextView) findViewById(R.id.tv_createlist_subheading);
        tv_createlist_subheading.setText(getResources().getText(R.string.policy));
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @OnClick({R.id.bt_boatinfo_previous, R.id.bt_boatinfo_next, R.id.bt_boatinfo_save_exit, R.id.iv_createlist_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.iv_createlist_back:
                finish();
                break;
            case R.id.bt_boatinfo_previous:
                startActivity(new Intent(this, CreateListingIncludedListingPriceActivity.class));
                break;
            case R.id.bt_boatinfo_next:
                startActivity(new Intent(this, CreatListingPhotos.class));
                break;
            case R.id.bt_boatinfo_save_exit:
                startActivity(new Intent(this, DashboardActivity.class));

                break;
        }
    }

    @OnClick(R.id.iv_createlist_back)
    public void onViewClicked() {
        startActivity(new Intent(this, CreateListingIncludedListingPriceActivity.class));

    }

//    @OnClick({R.id.bt_launchlocation_previous, R.id.bt_launchlocation_next, R.id.bt_launchlocation_save_exit})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.bt_launchlocation_previous:
//                break;
//            case R.id.bt_launchlocation_next:
//                startActivity(new Intent(this, CreateListingBoatInfoActivity.class));
//
//
//                break;
//            case R.id.bt_launchlocation_save_exit:
//                break;
//        }
//    }
}