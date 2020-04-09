package com.apps.fishanywhere.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.apps.fishanywhere.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendReviewActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back_icon)
    RelativeLayout rlBackIcon;
    @BindView(R.id.tv_sendreviews)
    TextView tvSendreviews;
    @BindView(R.id.rl_sign)
    RelativeLayout rlSign;
    @BindView(R.id.tv_enter_your_customers_email_for_reviews)
    TextView tvEnterYourCustomersEmailForReviews;
    @BindView(R.id.tv_enter_email)
    TextView tvEnterEmail;
    @BindView(R.id.et_enter_email)
    EditText etEnterEmail;
    @BindView(R.id.bt_submit)
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_review);
        ButterKnife.bind(this);
        setStatusBarColor();
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.send_reviews_statusbar));
        }
    }

    @OnClick({R.id.iv_back, R.id.bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_submit:
                break;
        }
    }
}

