package com.app.fishanywhere.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.app.fishanywhere.R;
import com.app.fishanywhere.view.activity.TripsActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddYourTripFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddYourTripFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.iv_toggle)
    ImageView ivToggle;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.shadow)
    View shadow;
    @BindView(R.id.tv_trip_name)
    TextView tvTripName;
    @BindView(R.id.et_trip_name)
    EditText etTripName;
    @BindView(R.id.tv_duration)
    TextView tvDuration;
    @BindView(R.id.iv_down_trip_duration)
    ImageView ivDownTripDuration;
    @BindView(R.id.iv_down_trip_duration_arrow)
    ImageView ivDownTripDurationArrow;
    @BindView(R.id.tv_max_guest)
    TextView tvMaxGuest;
    @BindView(R.id.iv_max_guest)
    ImageView ivMaxGuest;
    @BindView(R.id.iv_max_guest_arrow)
    ImageView ivMaxGuestArrow;
    @BindView(R.id.tv_alternate_fishing_locations)
    TextView tvAlternateFishingLocations;
    @BindView(R.id.et_alternate_fishing_locations)
    EditText etAlternateFishingLocations;
    @BindView(R.id.tv_trip_type)
    TextView tvTripType;
    @BindView(R.id.iv_down_trip_type)
    ImageView ivDownTripType;
    @BindView(R.id.iv_down_trip_type_arrow)
    ImageView ivDownTripTypeArrow;
    @BindView(R.id.tv_trip_cost)
    TextView tvTripCost;
    @BindView(R.id.et_trip_cost)
    EditText etTripCost;
    @BindView(R.id.cb_additonal_personal_charge)
    CheckBox cbAdditonalPersonalCharge;
    @BindView(R.id.tv_trip_description)
    TextView tvTripDescription;
    @BindView(R.id.et_trip_desciption)
    EditText etTripDesciption;
    @BindView(R.id.tv_includes)
    TextView tvIncludes;
    @BindView(R.id.cb_digital_photo)
    CheckBox cbDigitalPhoto;
    @BindView(R.id.cb_lunch)
    CheckBox cbLunch;
    @BindView(R.id.cb_drinks)
    CheckBox cbDrinks;
    @BindView(R.id.cb_snacks)
    CheckBox cbSnacks;
    @BindView(R.id.tv_other_included_items)
    TextView tvOtherIncludedItems;
    @BindView(R.id.et_other_included_items)
    EditText etOtherIncludedItems;
    @BindView(R.id.tv_createlist_heading)
    TextView tvCreatelistHeading;
    @BindView(R.id.tv_set_cancelation_policy)
    TextView tvSetCancelationPolicy;
    @BindView(R.id.iv_down_cancelation_policy)
    ImageView ivDownCancelationPolicy;
    @BindView(R.id.iv_down_cancelation_policy_arrow)
    ImageView ivDownCancelationPolicyArrow;
    @BindView(R.id.tv_time_date)
    TextView tvTimeDate;
    @BindView(R.id.tv_trip_start_at)
    TextView tvTripStartAt;
    @BindView(R.id.iv_tripsartat_dd)
    ImageView ivTripsartatDd;
    @BindView(R.id.iv_tripsartat_dd_arrow)
    ImageView ivTripsartatDdArrow;
    @BindView(R.id.iv_tripsartat_mm)
    ImageView ivTripsartatMm;
    @BindView(R.id.iv_tripsartat_mm_arrow)
    ImageView ivTripsartatMmArrow;
    @BindView(R.id.iv_tripsartat_yy)
    ImageView ivTripsartatYy;
    @BindView(R.id.iv_tripsartat_yy_arrow)
    ImageView ivTripsartatYyArrow;
    @BindView(R.id.tv_availablity_option)
    TextView tvAvailablityOption;
    @BindView(R.id.rl_day_mon_selected)
    RelativeLayout rlDayMonSelected;
    @BindView(R.id.rl_day_mon_un_selected)
    RelativeLayout rlDayMonUnSelected;
    @BindView(R.id.rl_day_tue_selected)
    RelativeLayout rlDayTueSelected;
    @BindView(R.id.rl_day_tue_un_selected)
    RelativeLayout rlDayTueUnSelected;
    @BindView(R.id.rl_day_wed_selected)
    RelativeLayout rlDayWedSelected;
    @BindView(R.id.rl_day_wed_un_selected)
    RelativeLayout rlDayWedUnSelected;
    @BindView(R.id.rl_day_thu_selected)
    RelativeLayout rlDayThuSelected;
    @BindView(R.id.rl_day_thu_un_selected)
    RelativeLayout rlDayThuUnSelected;
    @BindView(R.id.rl_day_fri_selected)
    RelativeLayout rlDayFriSelected;
    @BindView(R.id.rl_day_fri_un_selected)
    RelativeLayout rlDayFriUnSelected;
    @BindView(R.id.rl_day_sat_selected)
    RelativeLayout rlDaySatSelected;
    @BindView(R.id.rl_day_sat_un_selected)
    RelativeLayout rlDaySatUnSelected;
    @BindView(R.id.rl_day_sun_selected)
    RelativeLayout rlDaySunSelected;
    @BindView(R.id.rl_day_sun_un_selected)
    RelativeLayout rlDaySunUnSelected;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.bt_add_your_trip)
    Button btAddYourTrip;
//    @BindView(R.id.iv_toggle)
//    ImageView ivToggle;
//    @BindView(R.id.toolbar_title)
//    TextView toolbarTitle;
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;
//    @BindView(R.id.shadow)
//    View shadow;
//    @BindView(R.id.tv_trip_name)
//    TextView tvTripName;
//    @BindView(R.id.et_trip_name)
//    EditText etTripName;
//    @BindView(R.id.tv_duration)
//    TextView tvDuration;
//    @BindView(R.id.iv_down_trip_duration)
//    ImageView ivDownTripDuration;
//    @BindView(R.id.iv_down_trip_duration_arrow)
//    ImageView ivDownTripDurationArrow;
//    @BindView(R.id.tv_max_guest)
//    TextView tvMaxGuest;
//    @BindView(R.id.iv_max_guest)
//    ImageView ivMaxGuest;
//    @BindView(R.id.iv_max_guest_arrow)
//    ImageView ivMaxGuestArrow;
//    @BindView(R.id.tv_alternate_fishing_locations)
//    TextView tvAlternateFishingLocations;
//    @BindView(R.id.et_alternate_fishing_locations)
//    EditText etAlternateFishingLocations;
//    @BindView(R.id.tv_trip_type)
//    TextView tvTripType;
//    @BindView(R.id.iv_down_trip_type)
//    ImageView ivDownTripType;
//    @BindView(R.id.iv_down_trip_type_arrow)
//    ImageView ivDownTripTypeArrow;
//    @BindView(R.id.tv_trip_cost)
//    TextView tvTripCost;
//    @BindView(R.id.et_trip_cost)
//    EditText etTripCost;
//    //    @BindView(R.id.cb_usrcharter_guidename)
////    RelativeLayout cbUsrcharterGuidename;
//    @BindView(R.id.rl_top)
//    RelativeLayout rlTop;
//    @BindView(R.id.bt_add_your_trip)
//    Button btAddYourTrip;
//
    View view;
//    @BindView(R.id.cb_additonal_personal_charge)
//    CheckBox cbAdditonalPersonalCharge;
//    @BindView(R.id.tv_trip_description)
//    TextView tvTripDescription;
//    @BindView(R.id.et_trip_desciption)
//    EditText etTripDesciption;
//    @BindView(R.id.tv_includes)
//    TextView tvIncludes;
//    @BindView(R.id.cb_digital_photo)
//    CheckBox cbDigitalPhoto;
//    @BindView(R.id.cb_lunch)
//    CheckBox cbLunch;
//    @BindView(R.id.cb_drinks)
//    CheckBox cbDrinks;
//    @BindView(R.id.cb_snacks)
//    CheckBox cbSnacks;
//    @BindView(R.id.tv_other_included_items)
//    TextView tvOtherIncludedItems;
//    @BindView(R.id.et_other_included_items)
//    EditText etOtherIncludedItems;
//    @BindView(R.id.tv_createlist_heading)
//    TextView tvCreatelistHeading;
//    @BindView(R.id.tv_set_cancelation_policy)
//    TextView tvSetCancelationPolicy;
//    @BindView(R.id.iv_down_cancelation_policy)
//    ImageView ivDownCancelationPolicy;
//    @BindView(R.id.iv_down_cancelation_policy_arrow)
//    ImageView ivDownCancelationPolicyArrow;
//    @BindView(R.id.tv_time_date)
//    TextView tvTimeDate;
//    @BindView(R.id.tv_trip_start_at)
//    TextView tvTripStartAt;
//    @BindView(R.id.iv_tripsartat_dd)
//    ImageView ivTripsartatDd;
//    @BindView(R.id.iv_tripsartat_dd_arrow)
//    ImageView ivTripsartatDdArrow;
//    @BindView(R.id.iv_tripsartat_mm)
//    ImageView ivTripsartatMm;
//    @BindView(R.id.iv_tripsartat_mm_arrow)
//    ImageView ivTripsartatMmArrow;
//    @BindView(R.id.iv_tripsartat_yy)
//    ImageView ivTripsartatYy;
//    @BindView(R.id.iv_tripsartat_yy_arrow)
//    ImageView ivTripsartatYyArrow;
//    @BindView(R.id.tv_availablity_option)
//    TextView tvAvailablityOption;
//    @BindView(R.id.rl_day_mon_selected)
//    RelativeLayout rlDayMonSelected;
//    @BindView(R.id.rl_day_mon_un_selected)
//    RelativeLayout rlDayMonUnSelected;
//    @BindView(R.id.rl_day_tue_selected)
//    RelativeLayout rlDayTueSelected;
//    @BindView(R.id.rl_day_tue_un_selected)
//    RelativeLayout rlDayTueUnSelected;
//    @BindView(R.id.rl_day_wed_selected)
//    RelativeLayout rlDayWedSelected;
//    @BindView(R.id.rl_day_wed_un_selected)
//    RelativeLayout rlDayWedUnSelected;
//    @BindView(R.id.rl_day_thu_selected)
//    RelativeLayout rlDayThuSelected;
//    @BindView(R.id.rl_day_thu_un_selected)
//    RelativeLayout rlDayThuUnSelected;
//    @BindView(R.id.rl_day_fri_selected)
//    RelativeLayout rlDayFriSelected;
//    @BindView(R.id.rl_day_fri_un_selected)
//    RelativeLayout rlDayFriUnSelected;
//    @BindView(R.id.rl_day_sat_selected)
//    RelativeLayout rlDaySatSelected;
//    @BindView(R.id.rl_day_sat_un_selected)
//    RelativeLayout rlDaySatUnSelected;
//    @BindView(R.id.rl_day_sun_selected)
//    RelativeLayout rlDaySunSelected;
//    @BindView(R.id.rl_day_sun_un_selected)
//    RelativeLayout rlDaySunUnSelected;
//    @BindView(R.id.rl_top)
//    RelativeLayout rlTop;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddYourTripFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddYourTripFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddYourTripFragment newInstance(String param1, String param2) {
        AddYourTripFragment fragment = new AddYourTripFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static int newInstance() {
        return 0;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        return inflater.inflate(R.layout.fragment_add_your_trip, container, false);

        view = inflater.inflate(R.layout.fragment_add_your_trip, container, false);
//        ButterKnife.bind(view);
//
        btAddYourTrip= (Button)view.findViewById(R.id.bt_add_your_trip);
        btAddYourTrip.setOnClickListener(this);
////        setCheckbox( container);
        return view;


    }

//    private void setCheckbox(ViewGroup container) {
//        CheckBox checkBox = new CheckBox(getContext());
//        RelativeLayout relativeLayout = getActivity().findViewById(R.id.cb_usrcharter_guidename);
//        checkBox.setText("Keep me signed in");
//        checkBox.setTextColor(getResources().getColor(R.color.login_text_grey));
//        LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        checkParams.setMargins(10, 10, 10, 10);
//
//        ColorStateList colorStateList = new ColorStateList(
//                new int[][]{
//                        new int[]{-android.R.attr.state_checked}, // unchecked
//                        new int[]{android.R.attr.state_checked}, // checked
//                },
//                new int[]{
//                        Color.parseColor("#000000"),
//                        Color.parseColor("#357DAF"),
//                }
//        );
//
//
//        CompoundButtonCompat.setButtonTintList(checkBox, colorStateList);
//        checkParams.gravity = Gravity.START;
//        checkBox.setChecked(false);
//        relativeLayout.addView(checkBox, checkParams);
//    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    @OnClick(R.id.bt_add_your_trip)
//    public void onViewClicked(View view) {
//
//
//
//    }


//    @OnClick({R.id.bt_add_your_trip})
//    @Override
//    public void onClick(View v) {
//        switch (view.getId()) {
//            case R.id.bt_add_your_trip:
//                Intent intent = new Intent(getActivity(), TripsActivity.class);
//                startActivity(intent);
//        }
//    }

    @OnClick(R.id.bt_add_your_trip)
    public void onViewClicked() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add_your_trip:
                Intent intent = new Intent(getActivity(), TripsActivity.class);
                startActivity(intent);
            case R.id.bt_add_your_trip_new:
                Intent intent1 = new Intent(getActivity(), TripsActivity.class);
                startActivity(intent1);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
