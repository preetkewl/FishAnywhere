package com.app.fishanywhere.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.fishanywhere.R;
import com.app.fishanywhere.misc.CommonSharedPref;
import com.app.fishanywhere.misc.ProgressHUD;
import com.app.fishanywhere.misc.Utils;
import com.app.fishanywhere.model.Callbacks.GetLoginCallback;
import com.app.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.app.fishanywhere.model.Callbacks.GetResetPasswordCallback;
import com.app.fishanywhere.presenter.LoginPresenter;
import com.app.fishanywhere.view.interfaces.LoginInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import android.support.v7.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity implements LoginInterface {


    @BindView(R.id.tv_basic_info)
    TextView tvBasicInfo;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_logo)
    RelativeLayout rlLogo;
    @BindView(R.id.iv_sign_up)
    ImageView ivSignUp;
    @BindView(R.id.rl_sign)
    RelativeLayout rlSign;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_password)
    TextView tvPassword;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_confirmation_link)
    TextView tvConfirmationLink;
    @BindView(R.id.rl_basic)
    RelativeLayout rlBasic;

    private String email="";
    private String username="";
    private String password="";
    private CommonSharedPref commonSharedPref;
    private LoginPresenter loginPresenter;
    private Context context= this;
    private ProgressHUD progressHUD;
    String fcmToken="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        setStatusBarColor();

        init();

        getToken();

    }

    private void init() {
        loginPresenter = new LoginPresenter(context, this);
    }

    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
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
                        fcmToken = task.getResult().getToken();


                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
//                        Log.d(TAG, msg);
//                        Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }

//    @OnClick(R.id.bt_register)
//    public void onViewClicked() {
//    }

    @Override
    public void onBackPressed() {
        // code here to show dialog
        super.onBackPressed();
        finish();// optional depending on your needs
    }

    @OnClick({R.id.iv_back, R.id.bt_register})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.bt_register:
                username= etUsername.getText().toString().trim();
                email = etEmail.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                boolean isDetailsEnetered= isValidDetials(username, email, password);
                if(isDetailsEnetered){
                    try {
                        showPogress();
                        loginPresenter.registerCaptain(username,email, password, fcmToken);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }
    }

    private boolean isValidDetials(String username, String email, String password) {
        if(username==null || username.isEmpty()){
            Utils.showToast(context, getResources().getString(R.string.enter_username));
            return false;
        }else if(!isValidEmail(email)){
            Utils.showToast(context, getResources().getString(R.string.enter_email));
            return false;
        }else if(password==null || password.isEmpty() && password.length()<8){
            Utils.showToast(context, getResources().getString(R.string.enter_password));
            return false;
        }else{
            return true;
        }
    }


    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    public void getLogin(GetLoginCallback getLoginCallback) {

    }

    @Override
    public void getResetPassword(GetResetPasswordCallback getResetPasswordCallback) {

    }

    @Override
    public void registerCaptain(GetRegisterCallback getRegisterCallback) {
        hideProgress();
        if(getRegisterCallback!=null && getRegisterCallback.getRegisterUserPojo()!=null &&
                getRegisterCallback.getRegisterUserPojo().getiD()!=-1){
            commonSharedPref.setUserEmail(context, getRegisterCallback.getRegisterUserPojo().getUserEmail());
            commonSharedPref.setUserPassword(context, getRegisterCallback.getRegisterUserPojo().getUserPass());
            commonSharedPref.setUserId(context, String.valueOf(getRegisterCallback.getRegisterUserPojo().getiD()));
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        }else{
            Utils.showToastLong(context, getResources().getString(R.string.something_went_wrong));
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

//    @OnClick(R.id.bt_register)
//    public void onViewClicked() {
//    }
}
