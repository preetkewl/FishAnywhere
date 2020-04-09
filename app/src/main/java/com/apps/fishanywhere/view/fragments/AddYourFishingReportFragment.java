package com.apps.fishanywhere.view.fragments;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.CameraUtils;
import com.apps.fishanywhere.misc.CommonSharedPref;
import com.apps.fishanywhere.misc.ProgressHUD;
import com.apps.fishanywhere.misc.UtilityLocation;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetAddTripRecordCallback;
import com.apps.fishanywhere.model.Callbacks.GetAllFishReportDataCallback;
import com.apps.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.apps.fishanywhere.model.Callbacks.GetFishSpeciesCallback;
import com.apps.fishanywhere.model.Callbacks.GetTripCalenderCallback;
import com.apps.fishanywhere.model.Callbacks.GetUploadImageCallback;
import com.apps.fishanywhere.presenter.CalenderPresenter;
import com.apps.fishanywhere.presenter.FishingReportPresenter;
import com.apps.fishanywhere.view.activity.DashboardActivity;
import com.apps.fishanywhere.view.adapter.FishSpeciesAdapter;
import com.apps.fishanywhere.view.adapter.UploadImageAdapter;
import com.apps.fishanywhere.view.interfaces.CalenderInterface;
import com.apps.fishanywhere.view.interfaces.GetFishReportInterface;
import com.google.gson.JsonElement;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;
import static com.apps.fishanywhere.misc.UtilityLocation.MICROPHONE_PERMISSIONS;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddYourFishingReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddYourFishingReportFragment extends Fragment implements GetFishReportInterface, CalenderInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //    @BindView(R.id.iv_toggle)
//    ImageView ivToggle;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.shadow)
    View shadow;
    @BindView(R.id.tv_trip_name)
    TextView tvTripName;
    @BindView(R.id.et_fishing_report_title)
    EditText etFishingReportTitle;
    @BindView(R.id.tv_select_your_character)
    TextView tvSelectYourCharacter;
    @BindView(R.id.iv_down_cancelation_policy)
    ImageView ivDownCancelationPolicy;
    @BindView(R.id.iv_down_cancelation_policy_arrow)
    ImageView ivDownCancelationPolicyArrow;
    @BindView(R.id.tv_date_of_trips)
    TextView tvDateOfTrips;
    @BindView(R.id.et_date_of_trip)
    EditText etDateOfTrip;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.et_description)
    EditText etDescription;
    @BindView(R.id.tv_add_photos)
    TextView tvAddPhotos;
    @BindView(R.id.tv_year_built)
    TextView tvYearBuilt;
    @BindView(R.id.et_other_included_items)
    EditText etOtherIncludedItems;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.bt_add_your_fishing_report)
    Button btAddYourFishingReport;

    @BindView(R.id.rv_fish_species)
    RecyclerView rvFishSpecies;

    @BindView(R.id.rv_upload_image)
    RecyclerView rvUploadImage;

    @BindView(R.id.sp_charter)
    Spinner spCharter;


    @BindView(R.id.iv_back)
    ImageView ivBack;

//    @BindView(R.id.iv_image1)
//    ImageView ivImage;




//    @BindView(R.id.toolbar_title)
//    TextView toolbarTitle;
    @BindView(R.id.ll_upload_photo)
    LinearLayout llUploadPhoto;

    private Context context = getContext();
    private FishingReportPresenter fishingReportPresenter;
    CommonSharedPref commonSharedPref;
//    private String token;
    ArrayList<GetFishSpeciesCallback> getFishSpeciesCallback=new ArrayList<>();
    ArrayList<GetUploadImageCallback> getUploadImageCallback = new ArrayList<>();


    View view;
    private final String VEHICLE_IMAGE = "vehicle_image";
    private final int PICK_IMAGE_CAMERA = 1, PICK_IMAGE_GALLERY = 2;
    private final int PICK_IMAGE_VEHICLE = 3, PICK_IMAGE_VEHICLE_GALLERY = 4;
    private final int PICK_IMAGE_VEHICLE_PLATE = 5, PICK_IMAGE_VEHICLE_PLATE_GALLERY = 6;
    private Bitmap bitmap;
    private File destination = null;
    private InputStream inputStreamImg;
    private String imagPathVehicle = null;
    private String imagPathVehiclePlate = null;
    private int vehicleImageID = -1;

    public static final int CAMERA_PERMISSIONS = 124;

    UploadImageAdapter uploadImageAdapter;

    private String userId;
    private FishSpeciesAdapter fishSpeciesAdapter;


    Calendar myCalendar;
    private DatePickerDialog mDatePickerDialog;

    private ProgressHUD progressHUD;

    private CalenderPresenter calenderPresenter;

    String[] spinnerArray;
    HashMap<Integer,String> spinnerMap = new HashMap<Integer, String>();








    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddYourFishingReportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddYourFishingReportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddYourFishingReportFragment newInstance(String param1, String param2) {
        AddYourFishingReportFragment fragment = new AddYourFishingReportFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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

        view = inflater.inflate(R.layout.fragment_add_your_fishing_report, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button btAddPostFisingReport = (Button) view.findViewById(R.id.bt_add_your_fishing_report);
//        btAddPostFisingReport.setOnClickListener(this);
        init();
        setdata();



        getPermissionSetData();
        checkCameraPermission();
//        getMicorphonePermissionSetData();

        if (CameraUtils.checkPermissions(context)) {
//            captureVideo();
        } else {
            requestCameraPermission(MEDIA_TYPE_VIDEO);
        }
    }
    private void getPermissionSetData() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // only for gingerbread and newer versions
            boolean resultLocation = UtilityLocation.checkPermission(context);
            if (resultLocation) {
                checkCameraPermission();
            }
        } else {
            checkCameraPermission();
        }
    }


    private void requestCameraPermission(final int type) {
        Dexter.withActivity(getActivity())
                .withPermissions(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                        } else if (report.isAnyPermissionPermanentlyDenied()) {
                            showPermissionsAlert();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    /**
     * Alert dialog to navigate to app settings
     * to enable necessary permissions
     */
    private void showPermissionsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Permissions required!")
                .setMessage("Camera needs few permissions to work properly. Grant them in settings.")
                .setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        CameraUtils.openSettings(getActivity());
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


    private boolean checkCameraPermission() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean resultLocation = UtilityLocation.checkCameraPermission(context);
            if (resultLocation) {
//                getMicorphonePermissionSetData();
            }
        } else {
//            getMicorphonePermissionSetData();
        }
        return true;
    }

    private void requestPermissionCamera() {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.CAMERA},
                CAMERA_PERMISSIONS);
    }

    private void requestPermissionMicrophone() {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{RECORD_AUDIO},
                MICROPHONE_PERMISSIONS);
    }


    private void init() {
        context = getContext();
        // Adding an Network Interceptor for Debugging purpose :
//        OkHttpClient okHttpClient = new OkHttpClient() .newBuilder()
//                .addNetworkInterceptor(new StethoInterceptor())
//                .build();
        AndroidNetworking.initialize(context, Utils.getUnsafeOkHttpClient());

        fishingReportPresenter = new FishingReportPresenter(context, this);
        calenderPresenter = new CalenderPresenter(context, this);


        uploadImageAdapter = new UploadImageAdapter(context,getUploadImageCallback);
        fishSpeciesAdapter = new FishSpeciesAdapter(context,getFishSpeciesCallback);
        commonSharedPref = new CommonSharedPref(context);
        userId = commonSharedPref.getUserId(context);
//        userId = "7223";
        if (userId != null && !userId.isEmpty()) {
            try {
                fishingReportPresenter.getFishSpecies(userId);
                calenderPresenter.getCharaterId(userId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            setDateTimeField();
        }

        etDateOfTrip.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDatePickerDialog.show();
                return false;
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                String fdate = sd.format(startDate);

                etDateOfTrip.setText(fdate);

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        mDatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }



    private void setdata() {
        rvFishSpecies.setAdapter(new FishSpeciesAdapter(context,getFishSpeciesCallback));
        rvFishSpecies.setLayoutManager(new GridLayoutManager(context,2));

//        rvUploadImage.setAdapter(new UploadImageAdapter(context,getFishSpeciesCallback));
        rvUploadImage.setAdapter(new UploadImageAdapter(context,getUploadImageCallback));
        rvUploadImage.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

//        rvUploadImage.setLayoutManager(new GridLayoutManager(context,3));


    }

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

//    @OnClick(R.id.bt_add_your_fishing_report)
//    public void onViewClicked() {
//
//    }

//    @Override
//    public void onClick(View v) {
//
//        Intent intent = new Intent(getActivity(), ViewFishingReportActivity.class);
//        startActivity(intent);
//
//    }

    @Override
    public void getFishSpecies(ArrayList<GetFishSpeciesCallback> data) {
        if(data!=null && data.size()>0) {
            for (GetFishSpeciesCallback callback: data){
                if (callback.getName().matches("^[ A-Za-z]+$")){
                    this.getFishSpeciesCallback.add(callback);
                }
            }
            rvFishSpecies.setAdapter(new FishSpeciesAdapter(context, getFishSpeciesCallback));
        }
    }

    @Override
    public void uploadMedia(GetUploadImageCallback uploadImageCallback, Uri imageToupload) {
        hideProgress();
        if (uploadImageCallback != null) {
            if (uploadImageCallback.getStatus() != null && uploadImageCallback.getStatus().equals("success") &&
                    uploadImageCallback.getID() != -1) {
                vehicleImageID = uploadImageCallback.getID();
                uploadImageCallback.setUri(imageToupload);
                getUploadImageCallback.add(uploadImageCallback);


//                uploadImageAdapter.setNewImage(uploadImageCallback);
//                uploadImageAdapter.notifyDataSetChanged();

                rvUploadImage.setAdapter(new UploadImageAdapter(context,getUploadImageCallback));

                int listsize = getUploadImageCallback.size();

                int uploadimagearray[] = new int[listsize];

             for (int i=0;i<listsize;i++)
             {

                 uploadimagearray[i] = getUploadImageCallback.get(i).getID();

             }



            }
        }
    }

    @Override
    public void postFishReport(JsonElement jsonElement) {
        hideProgress();
        Utils.showToast(context,"Fishing Report created Successfully.");
        context.startActivity(new Intent(context, DashboardActivity.class));
        getActivity().finish();
//        if(jsonElement!=null && ((JsonObject) jsonElement).get("message")!=null
//                && ((JsonObject) jsonElement).get("message").equals("Fishing Report created Successfully.")){
//            Utils.showToast(context,"Fishing Report created Successfully.");
//        }

    }

    @Override
    public void getAllFishReport(GetAllFishReportDataCallback getAllFishReportDataCallback) {

    }




    void showPogress(){
        progressHUD = ProgressHUD.show(context, "", true, false, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // TODO Auto-generated method stub
            }
        });
    }

    void hideProgress(){
        if(progressHUD!=null && progressHUD.isShowing()){
            progressHUD.dismiss();
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

    @OnClick({R.id.iv_back, R.id.ll_upload_photo, R.id.bt_add_your_fishing_report})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
//                FragmentManager fm = getActivity()
//                        .getSupportFragmentManager();
//                fm.popBackStack ("FishingReportFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);

                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack();
                }
                break;
            case R.id.bt_add_your_fishing_report:

                String title= etFishingReportTitle.getText().toString().trim();
                String content= etDescription.getText().toString().toLowerCase();
                String date = etDateOfTrip.getText().toString().trim();
                ArrayList<String> fishSpecies= new ArrayList<>();
                fishSpecies= fishSpeciesAdapter.getFishSpeciesList();
                ArrayList<String> imageList= new ArrayList<>();
                imageList= getImageList();

//                String name = spCharter.getSelectedItem().toString();
                String charterId = spinnerMap.get(spCharter.getSelectedItemPosition());

                boolean isDetailsEntered = isValidDetials(title, content, date, fishSpecies, imageList);
                if(isDetailsEntered) {
                    try {
                        showPogress();
                        fishingReportPresenter.postFishReport(title,
                                content,
                                date,
                                fishSpecies,
                                imageList,
                                userId);
                    } catch (Exception e) {

                    }
                }

                break;
            case R.id.ll_upload_photo:

                selectImage(VEHICLE_IMAGE);
                break;
        }
    }
    private boolean isValidDetials(String title, String content, String date, ArrayList<String> fishSpecies, ArrayList<String> imageList) {
        if(title==null || title.isEmpty()){
            Utils.showToast(context, getResources().getString(R.string.enter_title));
            return false;
        }else if(content==null || content.isEmpty()){
            Utils.showToast(context, getResources().getString(R.string.enter_content));
            return false;
        }else if(date==null || date.isEmpty()){
            Utils.showToast(context, getResources().getString(R.string.enter_date));
            return false;
        }else if(fishSpecies==null || fishSpecies.size()==0){
            Utils.showToast(context, getResources().getString(R.string.select_fishe_species));
            return false;
        }else if(imageList==null || imageList.size()==0){
            Utils.showToast(context, getResources().getString(R.string.upload_image));
            return false;
        }else{
            return true;
        }
    }

    ArrayList<String> getImageList(){
        ArrayList<String> list= new ArrayList<>();
        for(GetUploadImageCallback listItem:getUploadImageCallback){
            list.add(String.valueOf(listItem.getID()));
        }
        return list;
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
    public void getCharterList(ArrayList<GetCharterIDsCallback> listData) {
        if(listData!=null && listData.size()>0){

            spinnerArray = new String[listData.size()];
            spinnerMap = new HashMap<Integer, String>();
            for (int i = 0; i < listData.size(); i++)
            {
                spinnerMap.put(i, String.valueOf(listData.get(i).getId()));
                spinnerArray[i] = listData.get(i).getTitle();
            }

            ArrayAdapter<GetCharterIDsCallback> adapter =new ArrayAdapter<GetCharterIDsCallback>(context,android.R.layout.simple_spinner_item, listData);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spCharter.setAdapter(adapter);

        }

    }

//    spCharter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            Country country = (Country) parent.getSelectedItem();
//            Toast.makeText(context, "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//        }
//    });

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


    private void selectImage(String image) {
        if (image.equals(VEHICLE_IMAGE)) {
            try {
                PackageManager pm = context.getPackageManager();
                int hasPerm = pm.checkPermission(Manifest.permission.CAMERA, context.getPackageName());
                if (hasPerm == PackageManager.PERMISSION_GRANTED) {
                    final CharSequence[] options = {"Take Photo", "Choose From Gallery", "Cancel"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Select Option");
                    builder.setItems(options, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            if (options[item].equals("Take Photo")) {
                                dialog.dismiss();
                                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
                                String fileName = "IMG_" + timeStamp + ".jpg";
                                ContentValues values = new ContentValues();
                                values.put(MediaStore.Images.Media.TITLE, fileName);
                                String mCapturedImageURI = String.valueOf(context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values));

                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                intent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);
                                startActivityForResult(intent, PICK_IMAGE_VEHICLE);


                            } else if (options[item].equals("Choose From Gallery")) {
                                dialog.dismiss();
                                Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(pickPhoto, PICK_IMAGE_VEHICLE_GALLERY);
                            } else if (options[item].equals("Cancel")) {
                                dialog.dismiss();
                            }
                        }
                    });
                    builder.show();
                } else
                    Toast.makeText(context, "Camera Permission error", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(context, "Camera Permission error", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        inputStreamImg = null;
        if (requestCode == PICK_IMAGE_VEHICLE) {
            try {
                Uri selectedImage = data.getData();
                bitmap = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, bytes);

//                ivImage.setImageBitmap(bitmap);


                String[] projection = { MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().managedQuery(selectedImage, projection, null, null, null);
                int column_index_data = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                imagPathVehicle = cursor.getString(column_index_data);

                if (imagPathVehicle != null && !imagPathVehicle.equals("") && userId != null) {
                    showPogress();

                    fishingReportPresenter.uploadMedia(imagPathVehicle, userId,selectedImage);


                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (requestCode == PICK_IMAGE_VEHICLE_GALLERY) {
            Uri selectedImage = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), selectedImage);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, bytes);
                Log.e("Activity", "Pick from Gallery::>>> ");

                imagPathVehicle = getRealPathFromURI(selectedImage);
                destination = new File(imagPathVehicle.toString());
//                ivImage.setImageBitmap(bitmap);
                if (imagPathVehicle != null && !imagPathVehicle.equals("") && userId != null) {
                    showPogress();
                    fishingReportPresenter.uploadMedia(imagPathVehicle, userId, selectedImage);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Audio.Media.DATA};
        Cursor cursor = getActivity().managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
