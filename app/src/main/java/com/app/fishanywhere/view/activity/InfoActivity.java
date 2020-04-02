package com.app.fishanywhere.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.fishanywhere.R;
import com.app.fishanywhere.misc.CommonSharedPref;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoActivity extends AppCompatActivity {

    Button bookingnow;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_infotagline)
    TextView tvInfotagline;
    @BindView(R.id.tv_rucaptain)
    TextView tvRucaptain;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.tv_bookingcharter)
    TextView tvBookingcharter;
    @BindView(R.id.bt_bookingnow)
    Button btBookingnow;
    private Context context= this;
    private String userId="";
    CommonSharedPref commonSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        setStatusBarColor();
        init();
    }

    private void init() {

        context= this;
        String token= FirebaseAnalytics.getInstance(context).getFirebaseInstanceId();
        getToken();
        commonSharedPref= new CommonSharedPref(context);
        userId = commonSharedPref.getUserId(context);
        startDashboardActivity(userId);
    }

    private void getToken() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
//                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();


                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
//                        Log.d(TAG, msg);
//                        Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void startDashboardActivity(String userId) {
        if(userId!=null && !userId.isEmpty()){
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        }
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }


    @OnClick({R.id.bt_login, R.id.bt_register, R.id.bt_bookingnow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.bt_register:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.bt_bookingnow:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fishanywhere.com"));
                startActivity(browserIntent);
                break;
        }
    }
}
