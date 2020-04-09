package com.apps.fishanywhere.view.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.CompoundButtonCompat;

import com.apps.fishanywhere.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateListingOverviewActivity extends AppCompatActivity {

    @BindView(R.id.bt_next)
    Button btNext;
    @BindView(R.id.bt_save_exit)
    Button btSaveExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_overview);
        ButterKnife.bind(this);

//        setToolbaarTitle();
        setStatusBarColor();


        CheckBox checkBox = new CheckBox(this);
        RelativeLayout relativeLayout = findViewById(R.id.cb_usrcharter_guidename);
        checkBox.setText("User charter and guide service name");
        checkBox.setTextColor(getResources().getColor(R.color.createlist_formguide));
        LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        checkParams.setMargins(10, 10, 10, 10);

        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked}, // unchecked
                        new int[]{android.R.attr.state_checked}, // checked
                },
                new int[]{
                        Color.parseColor("#818181"),
                        Color.parseColor("#357DAF"),
                }
        );

        CompoundButtonCompat.setButtonTintList(checkBox, colorStateList);
        checkParams.gravity = Gravity.START;
        checkBox.setChecked(false);
        relativeLayout.addView(checkBox, checkParams);
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @OnClick({R.id.bt_next, R.id.bt_save_exit, R.id.iv_createlist_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.iv_createlist_back:
                finish();
                break;
            case R.id.bt_next:
                startActivity(new Intent(this, CreatelistingLaunchLocationActivity.class));

                break;
            case R.id.bt_save_exit:
                startActivity(new Intent(this, DashboardActivity.class));

                break;
        }
    }
}
