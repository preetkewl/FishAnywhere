package com.app.fishanywhere.view.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fishanywhere.R;
import com.app.fishanywhere.misc.CommonSharedPref;
import com.app.fishanywhere.misc.ProgressHUD;
import com.app.fishanywhere.misc.Utils;
import com.app.fishanywhere.model.Callbacks.GetAddTripRecordCallback;
import com.app.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.app.fishanywhere.model.Callbacks.GetTripCalenderCallback;
import com.app.fishanywhere.model.MenuModel;
import com.app.fishanywhere.presenter.CalenderPresenter;
import com.app.fishanywhere.view.adapter.ExpandableListAdapter;
import com.app.fishanywhere.view.interfaces.CalenderInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import android.widget.ExpandableListAdapter;

public class DashboardActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, CalenderInterface {
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    @BindView(R.id.iv_toggle)
    ImageView ivToggle;
    @BindView(R.id.toolbar_title)
    ImageView toolbarTitle;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_viewmyprofile)
    TextView tvViewmyprofile;
    @BindView(R.id.iv_profile_edit)
    ImageView ivProfileEdit;
    @BindView(R.id.tv_profile_edit)
    TextView tvProfileEdit;
    @BindView(R.id.iv_calender)
    ImageView ivCalender;
    @BindView(R.id.tv_calender)
    TextView tvCalender;
    @BindView(R.id.iv_sendreviews)
    ImageView ivSendreviews;
    @BindView(R.id.tv_sendreviews)
    TextView tvSendreviews;
    @BindView(R.id.iv_snoozelisting)
    ImageView ivSnoozelisting;
    @BindView(R.id.tv_snoozelisting)
    TextView tvSnoozelisting;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
//    @BindView(R.id.iv_fishing_report)
//    ImageView ivFishingReport;
    @BindView(R.id.tv_listourfishingservice)
    TextView tvListourfishingservice;
    @BindView(R.id.bt_createlisting)
    Button btCreatelisting;
    @BindView(R.id.iv_realndeal)
    ImageView ivRealndeal;
    @BindView(R.id.tv_realndeal)
    TextView tvRealndeal;
    @BindView(R.id.ll_realndeal)
    LinearLayout llRealndeal;
    @BindView(R.id.iv_trips)
    ImageView ivTrips;
    @BindView(R.id.tv_trips)
    TextView tvTrips;
    @BindView(R.id.ll_trips)
    LinearLayout llTrips;
    @BindView(R.id.iv_bookings)
    ImageView ivBookings;
    @BindView(R.id.tv_booking)
    TextView tvBooking;
    @BindView(R.id.ll_bookings)
    LinearLayout llBookings;
    @BindView(R.id.iv_fishing_report)
    ImageView ivFishingReportNav;
    @BindView(R.id.tv_fishingreport)
    TextView tvFishingreport;
    @BindView(R.id.ll_fishing_reports)
    LinearLayout llFishingReports;
    @BindView(R.id.iv_profile_pic)
    ImageView ivProfilePic;
    @BindView(R.id.tv_profile_name)
    TextView tvProfileName;
    @BindView(R.id.iv_profile_pic1)
    ImageView ivProfilePic1;
    @BindView(R.id.iv_profile_pic2)
    ImageView ivProfilePic2;
    @BindView(R.id.tv_profile_name1)
    TextView tvProfileName1;
    @BindView(R.id.rl_add_listing)
    RelativeLayout rlAddListing;
    @BindView(R.id.rl_profile_pic)
    RelativeLayout rlProfilePic;


    private Activity activity = this;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private Context context = this;
    CommonSharedPref commonSharedPref;
    private CalenderPresenter calenderPresenter;
    private ProgressHUD progressHUD;
    private String userId = "";


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setStatusBarColor();
        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);




//        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        drawer.setStatusBarBackgroundColor(getResources().getColor(R.color.colorDrawerBg));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setVisibility(View.GONE);

//        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer_toggle);
            getSupportActionBar().setHomeButtonEnabled(false);
        }

        init();

        toggle.onDrawerStateChanged(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        toggle.setDrawerIndicatorEnabled(false);



//        FirebaseInstanceId.getInstance().getInstanceId()
//                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
//                        if (!task.isSuccessful()) {
////                            Log.w(com.app.fishanywhere.view.activity.TAG, "getInstanceId failed", task.getException());
//                            return;
//                        }
//
//                        // Get new Instance ID token
//                        String token = task.getResult().getToken();
//
//                        // Log and toast
//                        @SuppressLint({"StringFormatInvalid", "LocalSuppress"})
//                        String msg = getString(R.string.msg_token_fmt, token);
////                        Log.d(TAG, msg);
//                        Toast.makeText(DashboardActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                });
//        menuView.getItem(findViewById(R.id.drawer_layout)).setEnabled(false);

    }

    void showPogress() {
        progressHUD = ProgressHUD.show(context, "", true, false, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // TODO Auto-generated method stub
            }
        });
    }

    void hideProgress() {
        if (progressHUD != null && progressHUD.isShowing()) {
            progressHUD.dismiss();
        }
    }

    private void init() {
        context= this;
        commonSharedPref= new CommonSharedPref(context);
        calenderPresenter = new CalenderPresenter(context,this);
        tvUsername.setText(CommonSharedPref.getUserName(context));
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            } else {
                ActivityCompat.finishAffinity(DashboardActivity.this);
            }


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        if (item.getItemId() == android.R.id.iv_toggle) {
//            if(drawerLayout.isDrawerOpen(Gravity.LEFT)) {
//                drawerLayout.closeDrawer(Gravity.LEFT);
//            }else{
//                drawerLayout.openDrawer(Gravity.LEFT);
//            }
//
//        }

//        else if (item.getItemId()== R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            startActivity(new Intent(this, MyProfileActivity.class));
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareMenuData() {

        MenuModel menuModel = new MenuModel(getResources().getString(R.string.dashboard), true, false, getResources().getDrawable(R.drawable.ic_home_d)); //Menu of Android Tutorial. No sub menus
        headerList.add(menuModel);

//        if (!menuModel.hasChildren) {
//            childList.put(menuModel, null);
//        }

        menuModel = new MenuModel(getResources().getString(R.string.profile), true, false, getResources().getDrawable(R.drawable.ic_profile_d)); //Menu of Java Tutorials
        headerList.add(menuModel);

        menuModel = new MenuModel(getResources().getString(R.string.snooz_listing), true, false, getResources().getDrawable(R.drawable.ic_snooz_listing_d));
        headerList.add(menuModel);

        menuModel = new MenuModel(getResources().getString(R.string.fishing_report), true, false, getResources().getDrawable(R.drawable.ic_fishing_report_d));
        headerList.add(menuModel);

        menuModel = new MenuModel(getResources().getString(R.string.share), false, false, getResources().getDrawable(R.drawable.ic_share));
        headerList.add(menuModel);

        menuModel = new MenuModel(getResources().getString(R.string.terms_and_condtion), true, true, getResources().getDrawable(R.drawable.ic_terms_condition_d)); //Menu of Java Tutorials
        headerList.add(menuModel);
    }

        private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    MenuModel model = headerList.get(groupPosition);
                    if (model != null && model.menuName.equals(getResources().getString(R.string.dashboard))) {
                        startActivity(new Intent(context, DashboardActivity.class));
                    } else if (model != null && model.menuName.equals(getResources().getString(R.string.logout))) {
//                        Utils.logout(context, activity);
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
//                    runActivity(model);
                }

                return false;
            }
        });
    }

    @OnClick({R.id.iv_realndeal, R.id.tv_realndeal, R.id.ll_realndeal,
            R.id.iv_trips, R.id.tv_trips, R.id.ll_trips,
            R.id.iv_bookings, R.id.tv_booking, R.id.ll_bookings,
            R.id.iv_fishing_report_, R.id.tv_fishingreport, R.id.ll_fishing_reports,R.id.ll_fishing_reports_,
            R.id.bt_createlisting, R.id.ll_send_reviews, R.id.ll_snooze_listing, R.id.ll_calender, R.id.ll_profile,
            R.id.ll_sign_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_sign_out:
                signOut();
                break;

            case R.id.ll_profile:
                startActivity(new Intent(this, EditProfileActivity.class));
//                startActivity(new Intent(this, ProfileActivity.class));

                break;
            case R.id.ll_calender:
                showPogress();
//                userId = "7223";
                userId = commonSharedPref.getUserId(context);
                if (userId != null && !userId.isEmpty()) {
                    try {
                        calenderPresenter.getCharaterId(userId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }




                break;
            case R.id.iv_realndeal:
            case R.id.tv_realndeal:
            case R.id.ll_realndeal:
                Utils.showToastLong(context,getResources().getString(R.string.cominng_soon));


//                startActivity(new Intent(this, RealnDealActivity.class));
                break;

            case R.id.iv_trips:
            case R.id.tv_trips:
            case R.id.ll_trips:
                Utils.showToastLong(context,getResources().getString(R.string.cominng_soon));

//                startActivity(new Intent(this, TripsActivity.class));

                break;

            case R.id.iv_bookings:
            case R.id.tv_booking:
            case R.id.ll_bookings:
//                Utils.showToastLong(context,getResources().getString(R.string.cominng_soon));

                startActivity(new Intent(this, BookingsActivity.class));

                break;

            case R.id.iv_fishing_report:
            case R.id.tv_fishingreport:
            case R.id.ll_fishing_reports:
            case R.id.ll_fishing_reports_:
                startActivity(new Intent(this, FishingReportActivity.class));

                break;


            case R.id.bt_createlisting:
                Utils.showToastLong(context,getResources().getString(R.string.cominng_soon));

//                startActivity(new Intent(this, CreateListingOverviewActivity.class));

                break;


            case R.id.ll_send_reviews:
                Utils.showToastLong(context,getResources().getString(R.string.cominng_soon));

//                startActivity(new Intent(this, SendReviewActivity.class));

                break;

            case R.id.ll_snooze_listing:
                Utils.showToastLong(context,getResources().getString(R.string.cominng_soon));

//                startActivity(new Intent(this, SnoozeListingActivity.class));
                break;
        }
    }

    private void signOut() {
        commonSharedPref.clearLoginPref(context);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void getTripCalender(ArrayList<GetTripCalenderCallback> data) {

    }

    @Override
    public void addTripAvailbilty(GetAddTripRecordCallback data) {

    }

    @Override
    public void deleteTripAvailbilty(JsonElement jsonElement, int postion) {

    }

    @Override
    public void getCharterList(ArrayList<GetCharterIDsCallback> data) {
        if(data!=null && data.size()>0) {
            startActivity(new Intent(this, CharterActivity.class).putExtra("charterlsit", data));
        }else{
            new AlertDialog.Builder(context)
                    .setTitle("FishAnywhere")
                    .setMessage("You have not added any charter yet!")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
//                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }



    @Override
    public void start() {

    }

    @Override
    public void finish(String message) {

        hideProgress();
    }

    @Override
    public void failed(String message) {
        hideProgress();
    }
}
