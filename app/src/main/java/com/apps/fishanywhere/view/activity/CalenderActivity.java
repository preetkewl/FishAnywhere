package com.apps.fishanywhere.view.activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;
import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.CommonSharedPref;
import com.apps.fishanywhere.misc.ProgressHUD;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetAddTripRecordCallback;
import com.apps.fishanywhere.model.Callbacks.GetTripCalenderCallback;
import com.apps.fishanywhere.presenter.CalenderPresenter;
import com.apps.fishanywhere.view.adapter.TripCalnderListAdaper;
import com.apps.fishanywhere.view.interfaces.CalenderInterface;
import com.google.gson.JsonElement;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.apps.fishanywhere.view.adapter.TripCalnderListAdaper.toCalendar;

public class CalenderActivity extends AppCompatActivity implements CalenderInterface {

    private boolean todate, fromdate;
    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;

    TextView tv_createlist_heading;

    @BindView(R.id.iv_createlist_back)
    ImageView ivCreatelistBack;

    @BindView(R.id.rv_trip_calender_listing)
    RecyclerView rvTriCalender;

    @BindView(R.id.tv_appbar_tittle)
    TextView tvAppbarTittle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.shadow)
    View shadow;

    @BindView(R.id.ll_calender)
    LinearLayout llCalender;

    @BindView(R.id.tv_from_date)
    TextView tvFromDate;

    @BindView(R.id.et_from_date)
    EditText etFromDate;

    @BindView(R.id.tv_to_date)
    TextView tvToDate;

    @BindView(R.id.et_to_date)
    EditText etToDate;

    @BindView(R.id.ll_from_date)
    LinearLayout llFromDate;

    @BindView(R.id.tv_trip_name)
    TextView tvTripName;

    @BindView(R.id.iv_down_trip_duration)
    ImageView ivDownTripDuration;

    @BindView(R.id.iv_down_trip_duration_arrow)
    ImageView ivDownTripDurationArrow;

    @BindView(R.id.ll_to_date)
    LinearLayout llToDate;

    @BindView(R.id.tv_reasons)
    TextView tvReasons;

    @BindView(R.id.et_noteforblocking)
    EditText etNoteforblocking;

    @BindView(R.id.ll_noteforblocking)
    LinearLayout llNoteforblocking;

    @BindView(R.id.bt_calender_add)
    Button btCalenderAdd;

    @BindView(R.id.sp_type)
    Spinner spType;

    private CalenderPresenter calenderPresenter;
    private CommonSharedPref commonSharedPref;
    private Context context;
    private String userId = "";
    private ProgressHUD progressHUD;
    private MaterialCalendarView materialCalendarView;
    List<EventDay> eventDayList;
    ArrayList<GetTripCalenderCallback> tripListData = new ArrayList<>();
    TripCalnderListAdaper tripCalnderListAdaper;
    //    CalendarView calendarView;
    String from = "";
    String to = "";
    boolean Nextfromdate;
    boolean Nexttodate;
    int charterId;
    List<Calendar> calendarList = new ArrayList<>();
    List<String> mHighlightDatesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        ButterKnife.bind(this);
        tv_createlist_heading = findViewById(R.id.tv_appbar_tittle);
        tv_createlist_heading.setText(getResources().getText(R.string.calender));
        materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_NONE);
        materialCalendarView.state().edit().setFirstDayOfWeek(Calendar.SUNDAY).setMinimumDate(CalendarDay.from(2020, 1, 1)).setMaximumDate(CalendarDay.from(2022, 12, 31)).setCalendarDisplayMode(CalendarMode.MONTHS).commit();

        date = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        init();
        setData();
    }

    private void setData() {
        tripCalnderListAdaper = new TripCalnderListAdaper(context, tripListData, calenderPresenter, rvTriCalender, userId, charterId);
        rvTriCalender.setAdapter(tripCalnderListAdaper);
        rvTriCalender.setLayoutManager(new LinearLayoutManager(context));
    }

    private void init() {
        context = this;
        Intent intent = getIntent();
        if (intent != null) {
            charterId = intent.getIntExtra("charterId", -1);
        }
        calenderPresenter = new CalenderPresenter(context, this);
//        calendarView = (CalendarView) findViewById(R.id.calendarView);
        userId = commonSharedPref.getUserId(context);
//        userId = "7223";
        if (userId != null && !userId.isEmpty()) {
            try {
                showPogress();
                calenderPresenter.getTripCalender(userId, String.valueOf(charterId));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Calendar updateFromdate = null;

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse("2020/02/03");
            updateFromdate = toCalendar(date);
            calendarList.add(updateFromdate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar updateTodate = null;
        String todate = "2020/02/03";
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(todate);
            updateTodate = toCalendar(date1);
            calendarList.add(updateTodate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void getTripCalender(ArrayList<GetTripCalenderCallback> data) {
        hideProgress();

        mHighlightDatesList.clear();
        materialCalendarView.clearSelection();
        String str = "MM/dd/yyyy";

        if (data != null && data.size() > 0) {
            tripListData = data;
            rvTriCalender.setAdapter(tripCalnderListAdaper);
            tripCalnderListAdaper.setList(tripListData);
        }

        for (GetTripCalenderCallback callback : data) {

            Date startDate = new Date(), endDate = new Date();

            if ((callback.from.equals("00") && callback.to.equals("12")) || (callback.from.equals("12") && callback.to.equals("00"))) {
                mHighlightDatesList.add(callback.fromDate);
                continue;
            } else {
                try {
                    startDate = new SimpleDateFormat(str).parse(callback.from);
                    endDate = new SimpleDateFormat(str).parse(callback.to);
                } catch (ParseException e) {
                    e.printStackTrace();
                    mHighlightDatesList.add(callback.from);
                    continue;
                }
            }
            mHighlightDatesList.addAll(prepairHighlightList(startDate, endDate));
        }


        for (String s : mHighlightDatesList) {
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(new SimpleDateFormat(str, Locale.ENGLISH).parse(s));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            this.materialCalendarView.setDateSelected(cal, true);
        }

    }

    @Override
    public void addTripAvailbilty(GetAddTripRecordCallback data) {
        if (data != null) {
            if (data.getStatus() != null && data.getStatus().equals("success") && data.getMessage() != null) {
                etFromDate.setText("");
                etToDate.setText("");
                etNoteforblocking.setText("");
                String message = data.getMessage();
                try {
                    showPogress();
                    calenderPresenter.getTripCalender(userId, String.valueOf(charterId));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteTripAvailbilty(JsonElement jsonElement, int postion) {
        progressHUD.dismiss();
        if (jsonElement != null) {
        }
        tripCalnderListAdaper.removeItem(postion);
        Utils.showToast(context, "Record removed successfully! calender");
    }

    @Override
    public void getCharterList(ArrayList<GetCharterIDsCallback> listData) {
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
                // TODO Auto/generated method stub
            }
        });
    }

    void hideProgress() {
        if (progressHUD != null && progressHUD.isShowing()) {
            progressHUD.dismiss();
        }
    }

    @OnClick({R.id.bt_calender_add, R.id.iv_createlist_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_calender_add:
                String note = etNoteforblocking.getText().toString().trim();
                String type = "Half Day";
                String fromDate = etFromDate.getText().toString();
                String toDate = etToDate.getText().toString();

                String spTypeData = spType.getSelectedItem().toString();

                if (spTypeData.equals("- Half Day AM-")) {

                    if (!toDate.equals("")){
                        Toast.makeText(context, "Please update Type", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    boolean isDetialsEntered = isDetailsedEntered(note, fromDate, toDate);
                    if (isDetialsEntered && userId != null && !userId.equals("")) {
                        String tripdates = "type:custom,priority:10,bookable:no," + "from:" + "00:00" + ",to:" + "12:00" +
                                ",from_date:" + fromDate + ",to_date:" + toDate + ",blocking_note:" + note;
                        try {
                            showPogress();
                            calenderPresenter.addTripAvailabilty(userId, String.valueOf(charterId), note, tripdates);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (spTypeData.equals("- Half Day PM-")) {

                    if (!toDate.equals("")){
                        Toast.makeText(context, "Please update Type", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    boolean isDetialsEntered = isDetailsedEntered(note, fromDate, toDate);
                    if (isDetialsEntered && userId != null && !userId.equals("")) {
                        String tripdates = "type:custom,priority:10,bookable:no," + "from:" + "12:00" + ",to:" + "00:00" +
                                ",from_date:" + fromDate + ",to_date:" + toDate + ",blocking_note:" + note;
                        try {
                            showPogress();
                            calenderPresenter.addTripAvailabilty(userId, String.valueOf(charterId), note, tripdates);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (spTypeData.equals("- Full Day-")) {
                    boolean isDetialsEntered = isDetailsedEntered(note, fromDate, toDate);
                    if (isDetialsEntered && userId != null && !userId.equals("")) {
                        String tripdates = "type:custom,priority:10,bookable:no," + "from:" + fromDate + ",to:" + toDate + ",blocking_note:" + note;
                        try {
                            showPogress();
                            calenderPresenter.addTripAvailabilty(userId, String.valueOf(charterId), note, tripdates);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (spTypeData.equals("- Select Your Day-")) {

                    Utils.showToast(context, "please Select Your Day-");
                }


                break;
            case R.id.iv_createlist_back:

                finish();

        }
    }

    private OnSelectDateListener listener = new OnSelectDateListener() {
        @Override
        public void onSelect(List<Calendar> calendars) {

        }
    };

    private boolean isDetailsedEntered(String note, String fromDate, String toDate) {

        if (fromDate == null || fromDate.isEmpty()) {
            Utils.showToast(context, getResources().getString(R.string.enter_from_date));
            return false;
        } else {
            return true;
        }
    }

    public void showDatePickerDialog(View v) {
        switch (v.getId()) {
            case R.id.et_from_date:
            case R.id.ll_from_date:
            case R.id.tv_from_date:
                fromdate = true;
                break;

            case R.id.et_to_date:
            case R.id.ll_to_date:
            case R.id.tv_to_date:
                todate = true;
                break;
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void updateLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (fromdate) {
            etFromDate.setText(sdf.format(this.myCalendar.getTime()));
            fromdate = false;
            todate = false;
        }
        if (todate) {
            etToDate.setText(sdf.format(this.myCalendar.getTime()));
            fromdate = false;
            todate = false;
        }
    }

    public static List<String> prepairHighlightList(Date startdate, Date enddate) {
        List<String> dates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startdate);
        while (!calendar.getTime().after(enddate)) {
            dates.add(new SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dates;
    }


    public void update() {
        try {
            showPogress();
            calenderPresenter.getTripCalender(this.userId, String.valueOf(this.charterId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}