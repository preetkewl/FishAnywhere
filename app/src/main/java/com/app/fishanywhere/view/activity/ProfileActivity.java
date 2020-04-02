package com.app.fishanywhere.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.fishanywhere.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProfileActivity extends AppCompatActivity  {
//    public SupportMapFragment map;

    @BindView(R.id.iv_back)
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setStatusBarColor();

//        map = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        map.getMapAsync((OnMapReadyCallback) this);
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.send_reviews_statusbar));
        }
    }

//    @Override
//    public void onMapReady(GoogleMap map) {
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
//                new LatLng(47.17, 27.5699), 16));
//        map.addMarker(new MarkerOptions()
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_back))
//                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
//                .position(new LatLng(47.17, 27.5699))); //Iasi, Romania
//        map.setMyLocationEnabled(true);
//    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
