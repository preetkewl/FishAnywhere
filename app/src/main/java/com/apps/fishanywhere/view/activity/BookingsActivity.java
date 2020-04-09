package com.apps.fishanywhere.view.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.CommonSharedPref;
import com.apps.fishanywhere.misc.ProgressHUD;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetBookingRecordCallback;
import com.apps.fishanywhere.model.Callbacks.GetBookingStatusCallback;
import com.apps.fishanywhere.model.MenuModel;
import com.apps.fishanywhere.presenter.BookingPresenter;
import com.apps.fishanywhere.view.adapter.BookingListAdapter;
import com.apps.fishanywhere.view.adapter.ExpandableListAdapter;
import com.apps.fishanywhere.view.interfaces.BookingInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookingsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BookingInterface {
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    @BindView(R.id.toolbar_title)
    ImageView toolbarTitle;

    @BindView(R.id.shadow)
    View shadow;

    @BindView(R.id.underline)
    View underline;

    @BindView(R.id.bt_add_your_trip)
    Button btAddYourTrip;

    @BindView(R.id.iv_realndeal)
    ImageView ivRealndeal;

    @BindView(R.id.ll_realndeal)
    LinearLayout llRealndeal;

    @BindView(R.id.iv_trips)
    ImageView ivTrips;
    @BindView(R.id.ll_trips)
    LinearLayout llTrips;
    @BindView(R.id.iv_bookings)
    ImageView ivBookings;
    @BindView(R.id.ll_bookings)
    LinearLayout llBookings;
    @BindView(R.id.iv_fishing_report)
    ImageView ivFishingReport;
    @BindView(R.id.ll_fishing_reports)
    LinearLayout llFishingReports;
    @BindView(R.id.fb_dashboard)
    FloatingActionButton ivDashboard;
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

    @BindView(R.id.iv_toggle)
    ImageView ivToggle;

    @BindView(R.id.tv_realndeal)
    TextView tvRealndeal;

    @BindView(R.id.tv_trips)
    TextView tvTrips;

    @BindView(R.id.tv_bookings)
    TextView bookings;

    @BindView(R.id.tv_fishingreport)
    TextView tvFishingreport;

    @BindView(R.id.rv_booling_list)
    RecyclerView rvBookingList;



    private Activity activity = this;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private Context context = this;

    private BookingPresenter bookingPresenter;
    private CommonSharedPref commonSharedPref;
    private String userId="";
    private ArrayList<GetBookingRecordCallback> recordCallback=new ArrayList<>();
    private  BookingListAdapter bookingListAdapter;
    private ProgressHUD progressHUD;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setStatusBarColor();
        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.setStatusBarBackgroundColor(getResources().getColor(R.color.colorDrawerBg));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer_toggle);
        }
        setBootomNavigation();
        setdata();

        toggle.onDrawerStateChanged(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        toggle.setDrawerIndicatorEnabled(false);

        init();
    }

    private void init() {
        context = this;
        bookingPresenter= new BookingPresenter(context, this);
        commonSharedPref = new CommonSharedPref(context);
        userId = commonSharedPref.getUserId(context);
//        userId = "7223";
        bookingListAdapter= new BookingListAdapter(context, recordCallback, userId, bookingPresenter,rvBookingList, bookingListAdapter);
        if(userId!=null && !userId.isEmpty()){
            try {
                showPogress();
                bookingPresenter.getBookingRecord(userId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    private void setdata() {
        rvBookingList.setAdapter(bookingListAdapter);
        rvBookingList.setLayoutManager(new LinearLayoutManager(context));
    }

    private void setBootomNavigation() {
//        ivTrips.setImageResource(R.drawable.ic_dash_booking);
//        tvTrips.setTextColor(getResources().getColor(R.color.login_text_grey));

        ivBookings.setImageResource(R.drawable.ic_booking_selected);
        bookings.setTextColor(getResources().getColor(R.color.colorDrawerBg));

//        ivFishingReport.setImageResource(R.drawable.ic_dash_fishingreport);
//        ivRealndeal.setImageResource(R.drawable.ic_real_n_deal);


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
                ActivityCompat.finishAffinity(BookingsActivity.this);
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
            R.id.iv_bookings, R.id.tv_bookings, R.id.ll_bookings,
            R.id.iv_fishing_report, R.id.tv_fishingreport, R.id.ll_fishing_reports,
            R.id.fb_dashboard})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
            case R.id.tv_bookings:
            case R.id.ll_bookings:
                startActivity(new Intent(this, BookingsActivity.class));

                break;

            case R.id.iv_fishing_report:
            case R.id.tv_fishingreport:
            case R.id.ll_fishing_reports:
                startActivity(new Intent(this, FishingReportActivity.class));

                break;
            case R.id.fb_dashboard:
                startActivity(new Intent(this, DashboardActivity.class));

                break;
        }
    }

    @Override
    public void getBokingList(ArrayList<GetBookingRecordCallback> recordCallback2) {
        hideProgress();

        if (recordCallback2 != null && recordCallback2.size() > 0) {
            ArrayList<GetBookingRecordCallback> list = new ArrayList<>();
            Collections.sort(recordCallback2);
            Collections.reverse(recordCallback2);
            list.addAll(recordCallback2);
            RecyclerView recyclerView = this.rvBookingList;
            BookingListAdapter bookingListAdapter2 = new BookingListAdapter(this.context, list, this.userId, this.bookingPresenter, recyclerView, this.bookingListAdapter);
            recyclerView.setAdapter(bookingListAdapter2);
        }

//        if(recordCallback!=null && recordCallback.size()>0){
//            ArrayList<GetBookingRecordCallback> list= recordCallback;
//            rvBookingList.setAdapter(bookingListAdapter);
//            bookingListAdapter.updateList(list);
//        }

    }

    @Override
    public void getBoookingAccept(GetBookingStatusCallback jsonElement, String userId, BookingPresenter bookingPresenter, RecyclerView rvBookingList, BookingListAdapter bookingListAdapter, Context context) {

    }

    @Override
    public void getBoookingReject(GetBookingStatusCallback jsonElement, String userId, BookingPresenter bookingPresenter, RecyclerView rvBookingList, BookingListAdapter bookingListAdapter, Context context) {

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
}