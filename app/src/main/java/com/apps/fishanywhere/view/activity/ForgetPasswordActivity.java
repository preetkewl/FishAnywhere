package com.apps.fishanywhere.view.activity;

import android.content.Context;
import android.content.DialogInterface;
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

import androidx.appcompat.app.AppCompatActivity;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.CommonSharedPref;
import com.apps.fishanywhere.misc.ProgressHUD;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetLoginCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.apps.fishanywhere.model.Callbacks.GetResetPasswordCallback;
import com.apps.fishanywhere.presenter.LoginPresenter;
import com.apps.fishanywhere.view.interfaces.LoginInterface;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPasswordActivity extends AppCompatActivity implements LoginInterface {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_logo)
    RelativeLayout rlLogo;
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.underline)
    View underline;
    @BindView(R.id.rl_sign)
    RelativeLayout rlSign;
    @BindView(R.id.tv_enter_your_acnt_email)
    TextView tvEnterYourAcntEmail;
    @BindView(R.id.tv_email_address)
    TextView tvEmailAddress;
    @BindView(R.id.et_email_address)
    EditText etEmailAddress;
    @BindView(R.id.tv_send_password_to_mail)
    TextView tvSendPasswordToMail;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.rl_basic)
    RelativeLayout rlBasic;

    private Context context= this;
    private LoginPresenter loginPresenter;
    private String email="";
    CommonSharedPref commonSharedPref;

    private ProgressHUD progressHUD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        init();
        setStatusBarColor();

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

    @OnClick({R.id.iv_back, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_register:
                email = etEmailAddress.getText().toString().trim();
                if(isValidEmail(email)){
                    try {
                        showPogress();
                        loginPresenter.resetPassword(email);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Utils.showToast(context, getResources().getString(R.string.enter_email));
                }
                break;
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
        hideProgress();
        if(getResetPasswordCallback!=null &&
                getResetPasswordCallback.getStatus()!=null && getResetPasswordCallback.getStatus().contains("mail_sent_ok") &&
                getResetPasswordCallback.getMesage()!=null && getResetPasswordCallback.getMesage().contains("Reset password email send successfull.")){
            if(tvSendPasswordToMail!=null) {
                tvSendPasswordToMail.setVisibility(View.VISIBLE);
            }
            if(etEmailAddress!=null) {
                etEmailAddress.setText("");
            }
        }else{
            Utils.showToast(context, getResources().getString(R.string.something_went_wrong));
        }
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
