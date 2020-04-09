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

public class CreateListingSafetyPersonalEqpActivity extends AppCompatActivity {


    ImageView iv_cllist_paging;

    TextView tv_createlist_heading;

    TextView tv_createlist_subheading;

    @BindView(R.id.iv_createlist_back)
    ImageView ivCreatelistBack;
    @BindView(R.id.bt_safety_personal_previous)
    Button btSafetyPersonalPrevious;
    @BindView(R.id.bt_safety_personal_next)
    Button btSafetyPersonalNext;
    @BindView(R.id.bt_safety_personal_save_exit)
    Button btSafetyPersonalSaveExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_safety_personal_eqp);
        ButterKnife.bind(this);

        setStatusBarColor();

        iv_cllist_paging = (ImageView) findViewById(R.id.iv_cllist_paging);

        iv_cllist_paging.setImageDrawable(getResources().getDrawable(R.drawable.im_cl_safety_eqp));

        tv_createlist_heading = (TextView) findViewById(R.id.tv_createlist_heading);
        tv_createlist_heading.setText(getResources().getText(R.string.safety_personal_eqp));

        tv_createlist_subheading = (TextView) findViewById(R.id.tv_createlist_subheading);
        tv_createlist_subheading.setText(getResources().getText(R.string.safety_personal_subheading));
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }



    @OnClick({R.id.iv_createlist_back, R.id.bt_safety_personal_previous, R.id.bt_safety_personal_next, R.id.bt_safety_personal_save_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_createlist_back:
                finish();
//                startActivity(new Intent(this, CreateNavigationalEquipmentActivity.class));

                break;
            case R.id.bt_safety_personal_previous:
                startActivity(new Intent(this, CreateNavigationalEquipmentActivity.class));

                break;
            case R.id.bt_safety_personal_next:
                startActivity(new Intent(this, CreatelistingFishingGearCrewActivity.class));

                break;
            case R.id.bt_safety_personal_save_exit:
                startActivity(new Intent(this, DashboardActivity.class));

                break;
        }
    }
}
