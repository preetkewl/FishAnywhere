package com.apps.fishanywhere.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.CompoundButtonCompat;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.CommonSharedPref;
import com.apps.fishanywhere.misc.ProgressHUD;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetLoginCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.apps.fishanywhere.model.Callbacks.GetResetPasswordCallback;
import com.apps.fishanywhere.presenter.LoginPresenter;
import com.apps.fishanywhere.view.interfaces.LoginInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginInterface {

    public static String valueauth="";

    @BindView(R.id.iv_top)
    ImageView ivTop;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.underline)
    View underline;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.iv_ic_user)
    ImageView ivIcUser;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.tv_password)
    TextView tvPassword;
    @BindView(R.id.tv_forgot)
    TextView tvForgot;
    @BindView(R.id.iv_ic_password)
    ImageView ivIcPassword;
    @BindView(R.id.et_pswd)
    EditText etPswd;
    @BindView(R.id.remberme)
    RelativeLayout remberme;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.iv_bottom)
    ImageView ivBottom;
    @BindView(R.id.tv_signupascaptain)
    TextView tvSignupascaptain;
    @BindView(R.id.underline2)
    View underline2;
    @BindView(R.id.tv_inforegisterascaptain)
    TextView tvInforegisterascaptain;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.iv_back)
    ImageView ivBack;

    private Context context= this;
    private LoginPresenter loginPresenter;
    private String jwtToken="";
    private String ID="";
    private String email="";
    private String userId="";

    CommonSharedPref commonSharedPref;
    String password ="";
    private ProgressHUD progressHUD;
    String fcmToken="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        init();

//        String token= FirebaseAnalytics.getInstance(context).getFirebaseInstanceId();
        getToken();
        setStatusBarColor();
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();


        CheckBox checkBox = new CheckBox(this);
        RelativeLayout relativeLayout = findViewById(R.id.remberme);
        checkBox.setText("Keep me signed in");
        checkBox.setTextColor(getResources().getColor(R.color.login_text_grey));
        LinearLayout.LayoutParams checkParams = new LinearLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        checkParams.setMargins(10, 10, 10, 10);

        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked}, // unchecked
                        new int[]{android.R.attr.state_checked}, // checked
                },
                new int[]{
                        Color.parseColor("#000000"),
                        Color.parseColor("#357DAF"),
                }
        );

        CompoundButtonCompat.setButtonTintList(checkBox, colorStateList);
        checkParams.gravity = Gravity.START;
        checkBox.setChecked(true);
        relativeLayout.addView(checkBox, checkParams);
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

    private void init() {
        loginPresenter = new LoginPresenter(context, this);
        commonSharedPref= new CommonSharedPref(context);
        userId = commonSharedPref.getUserId(context);
        startDashboardActivity(userId);

    }

    private void startDashboardActivity(String userId) {
        if(userId!=null && !userId.isEmpty()){
            if (getIntent().hasExtra("pushnotification")) {
                Intent intent = new Intent(LoginActivity.this, BookingsActivity.class);
                intent.putExtra("pushnotification", "yes");
                startActivity(intent);
                finish();
            }else {
                startActivity(new Intent(this, DashboardActivity.class));
                finish();
            }
        }
    }


    private void setStatusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @OnClick({R.id.bt_login, R.id.bt_register, R.id.tv_forgot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String username= etEmail.getText().toString().trim();
                password = etPswd.getText().toString().trim();

                boolean isDetailsEnetered= validateFields(username, password);
                if(isDetailsEnetered){
                    try {
                        showPogress();
                        loginPresenter.validateLogin(username,password,fcmToken);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                break;
            case R.id.bt_register:
                startActivity(new Intent(this, SignupActivity.class));

                break;

            case R.id.tv_forgot:
                startActivity(new Intent(this, ForgetPasswordActivity.class));

                break;
        }
    }

    private boolean validateFields(String username, String password) {

//        if(!isValidEmail(username)){
        if(username==null || username.isEmpty()){
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

    @OnClick(R.id.iv_back)
    public void onViewClicked() {

        startActivity(new Intent(this, InfoActivity.class));


    }

    @Override
    public void getLogin(GetLoginCallback getLoginCallback) {
        hideProgress();
        if(getLoginCallback!=null ){
            jwtToken= getLoginCallback.getJwt();
            email= getLoginCallback.getUserEmail();
            ID= getLoginCallback.getiD();
            userId= getLoginCallback.getiD();
            if(userId!=null && !userId.isEmpty() && userId!=null && !userId.isEmpty() && email!=null && !email.isEmpty()){
                commonSharedPref.setUserEmail(context, email);
                commonSharedPref.setUserPassword(context, password);
                commonSharedPref.setUserId(context, userId);
                commonSharedPref.setUserName(context, getLoginCallback.getUserNicename());
                commonSharedPref.setUserTokenLogout(context, ID);
                valueauth = "Bearer "+ID ;
                startActivity(new Intent(this, DashboardActivity.class));
                finish();
            }
        }else{
            Utils.showToast(context, getResources().getString(R.string.something_went_wrong));
        }
    }

    @Override
    public void getResetPassword(GetResetPasswordCallback getResetPasswordCallback) {

    }

    @Override
    public void registerCaptain(GetRegisterCallback getRegisterCallback) {

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
}
