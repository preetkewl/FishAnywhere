package com.app.fishanywhere.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fishanywhere.R;
import com.app.fishanywhere.model.MenuModel;
import com.app.fishanywhere.view.adapter.ExpandableListAdapter;
import com.app.fishanywhere.view.adapter.AddYourTripsAdapter;
import com.app.fishanywhere.view.fragments.AddYourTripFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TripsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
AddYourTripFragment.OnFragmentInteractionListener{
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    @BindView(R.id.toolbar_title)
    ImageView toolbarTitle;
    @BindView(R.id.shadow)
    View shadow;
    @BindView(R.id.tv_trips_list)
    TextView tvTripsList;
    @BindView(R.id.underline)
    View underline;
    @BindView(R.id.tv_trips_list_text)
    TextView tvTripsListText;
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
    @BindView(R.id.rv_add_your_trips)
    RecyclerView rvAddYourTrips;



    private Activity activity = this;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.bt_add_your_trip_new)
    Button btAddYourTripNew;
    @BindView(R.id.container)
    FrameLayout container;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
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
    }

    private void setdata() {
        rvAddYourTrips.setAdapter(new AddYourTripsAdapter(context));
        rvAddYourTrips.setLayoutManager(new LinearLayoutManager(context));
    }

    private void setBootomNavigation() {
        ivTrips.setImageResource(R.drawable.ic_trips_selected);
        tvTrips.setTextColor(getResources().getColor(R.color.colorDrawerBg));
        
        ivBookings.setImageResource(R.drawable.ic_dash_booking);
        ivFishingReport.setImageResource(R.drawable.ic_dash_fishingreport);
        ivRealndeal.setImageResource(R.drawable.ic_real_n_deal);


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
                ActivityCompat.finishAffinity(TripsActivity.this);
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
            R.id.fb_dashboard,
            R.id.bt_add_your_trip, R.id.bt_add_your_trip_new
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_realndeal:
            case R.id.tv_realndeal:
            case R.id.ll_realndeal:
                startActivity(new Intent(this, RealnDealActivity.class));

                break;

            case R.id.iv_trips:
            case R.id.tv_trips:
            case R.id.ll_trips:
                startActivity(new Intent(this, TripsActivity.class));

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




            case R.id.bt_add_your_trip:
                container.setVisibility(View.VISIBLE);

                AddYourTripFragment addYourTripFragment = new AddYourTripFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container,addYourTripFragment,"Fragment Tag");
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case R.id.bt_add_your_trip_new:
                container.setVisibility(View.VISIBLE);

                AddYourTripFragment addYourTripFragment1 = new AddYourTripFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.add(R.id.container,addYourTripFragment1,"Fragment Tag");
                transaction1.addToBackStack(null);
                transaction1.commit();

                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
