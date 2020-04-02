package com.app.fishanywhere.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.fishanywhere.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewFishingReportActivity extends AppCompatActivity {

//    @BindView(R.id.iv_toggle)
//    ImageView ivToggle;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.shadow)
    View shadow;
    @BindView(R.id.tv_reel_n_deals_list)
    TextView tvReelNDealsList;
    @BindView(R.id.underline)
    View underline;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.bt_add_your_fishing_report)
    Button btAddYourFishingReport;
    @BindView(R.id.iv_back)
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fishing_report);
        ButterKnife.bind(this);

        intit();
    }

    private void intit() {
        TextView textView = (TextView) findViewById(R.id.toolbar_title);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
//        imageView.setOnClickListener(this);
        textView.setText("Fishing Report");
    }



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
