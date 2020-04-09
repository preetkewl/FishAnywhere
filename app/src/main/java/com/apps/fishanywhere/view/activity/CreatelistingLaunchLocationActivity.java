package com.apps.fishanywhere.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.apps.fishanywhere.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreatelistingLaunchLocationActivity extends AppCompatActivity {

    ImageView iv_cllist_paging;


    TextView tv_createlist_heading;
    @BindView(R.id.bt_launchlocation_previous)
    Button btLaunchlocationPrevious;
    @BindView(R.id.bt_launchlocation_next)
    Button btLaunchlocationNext;
    @BindView(R.id.bt_launchlocation_save_exit)
    Button btLaunchlocationSaveExit;
    @BindView(R.id.iv_createlist_back)
    ImageView ivCreatelistBack;
    @BindView(R.id.tv_appbar_tittle)
    TextView tvAppbarTittle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.shadow)
    View shadow;
    @BindView(R.id.iv_cllist_paging)
    ImageView ivCllistPaging;
    @BindView(R.id.tv_createlist_heading)
    TextView tvCreatelistHeading;
    @BindView(R.id.tv_createlist_subheading)
    TextView tvCreatelistSubheading;
    @BindView(R.id.tv_address_info)
    TextView tvAddressInfo;
    @BindView(R.id.tv_street_name)
    TextView tvStreetName;
    @BindView(R.id.et_street_name)
    EditText etStreetName;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.et_state)
    EditText etState;
    @BindView(R.id.tv_postalcode)
    TextView tvPostalcode;
    @BindView(R.id.et_postalcode)
    EditText etPostalcode;
    @BindView(R.id.tv_country)
    TextView tvCountry;
    @BindView(R.id.et_country)
    EditText etCountry;
    @BindView(R.id.tv_launchlatitude)
    TextView tvLaunchlatitude;
    @BindView(R.id.et_launchlatitude)
    EditText etLaunchlatitude;
    @BindView(R.id.tv_launchlongitude)
    TextView tvLaunchlongitude;
    @BindView(R.id.et_launchlongitude)
    EditText etLaunchlongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createlisting_launch_location);
        ButterKnife.bind(this);


        setStatusBarColor();

        iv_cllist_paging = (ImageView) findViewById(R.id.iv_cllist_paging);

        iv_cllist_paging.setImageDrawable(getResources().getDrawable(R.drawable.im_cl_launch_location));

        tv_createlist_heading = (TextView) findViewById(R.id.tv_createlist_heading);
        tv_createlist_heading.setText(getResources().getText(R.string.launch_location));
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @OnClick({R.id.bt_launchlocation_previous, R.id.bt_launchlocation_next, R.id.bt_launchlocation_save_exit, R.id.iv_createlist_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.iv_createlist_back:
                finish();
                break;
            case R.id.bt_launchlocation_previous:
                startActivity(new Intent(this, CreateListingOverviewActivity.class));
                break;
            case R.id.bt_launchlocation_next:
                startActivity(new Intent(this, CreateListingBoatInfoActivity.class));


                break;
            case R.id.bt_launchlocation_save_exit:
                startActivity(new Intent(this, DashboardActivity.class));
                break;
        }
    }

    @OnClick(R.id.iv_createlist_back)
    public void onViewClicked() {
        startActivity(new Intent(this, CreateListingOverviewActivity.class));


    }
}
