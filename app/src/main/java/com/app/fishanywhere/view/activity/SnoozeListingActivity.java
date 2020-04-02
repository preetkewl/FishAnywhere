package com.app.fishanywhere.view.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.app.fishanywhere.R;

public class SnoozeListingActivity extends AppCompatActivity {
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snooze_listing);
        showSnoozListing();
    }

    private void showSnoozListing() {
        dialogBuilder = new AlertDialog.Builder(this);







        // ...Irrelevant code for customizing the buttons and title

        LayoutInflater inflater = this.getLayoutInflater();

        View dialogView= inflater.inflate(R.layout.snoooz_listing, null);
        dialogBuilder.setView(dialogView);

//        dialogBuilder.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogBuilder.setContentView(layoutResId);
//        View v = getWindow().getDecorView();
//        v.setBackgroundResource(android.R.color.transparent);

        Button buttonYes = (Button)dialogView.findViewById(R.id.bt_yes);
        Button buttonCancel = (Button)dialogView.findViewById(R.id.bt_cancel_deals);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                //Commond here......

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                //Commond here......

            }
        });


        dialogBuilder.create().show();
        alertDialog= dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        alertDialog.cancel();
        this.finish();
    }
}
