package com.apps.fishanywhere.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.misc.CommonSharedPref;
import com.apps.fishanywhere.misc.ProgressHUD;
import com.apps.fishanywhere.misc.Utils;
import com.apps.fishanywhere.model.Callbacks.GetCaptainDetailsCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.apps.fishanywhere.presenter.EditCaptainDetailsPresenter;
import com.apps.fishanywhere.view.interfaces.EditCaptainDetailsInterface;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditProfileActivity extends AppCompatActivity implements EditCaptainDetailsInterface {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back_icon)
    RelativeLayout rlBackIcon;
    @BindView(R.id.tv_sendreviews)
    TextView tvSendreviews;
    @BindView(R.id.rl_sign)
    RelativeLayout rlSign;
    @BindView(R.id.tv_enter_your_customers_email_for_reviews)
    TextView tvEnterYourCustomersEmailForReviews;
    @BindView(R.id.tv_first_name)
    TextView tvFirstName;
    @BindView(R.id.et_first_name)
    EditText etFirstName;
    @BindView(R.id.tv_last_name)
    TextView tvLastName;
    @BindView(R.id.et_last_name)
    EditText etLastName;
    @BindView(R.id.tv_charter_guideservicename)
    TextView tvCharterGuideservicename;
    @BindView(R.id.et_charter_guideservicename)
    EditText etCharterGuideservicename;
    @BindView(R.id.tv_send_money)
    TextView tvSendMoney;
    @BindView(R.id.rb_paypal)
    RadioButton rbPaypal;
    @BindView(R.id.rb_manual)
    RadioButton rbManual;
    @BindView(R.id.rb_credit_card)
    RadioButton rbCreditCard;
    @BindView(R.id.groupradio)
    RadioGroup groupradio;
    @BindView(R.id.et_pay_pal_email)
    EditText etPayPalEmail;
    @BindView(R.id.tv_overnght)
    TextView tvOvernght;
    @BindView(R.id.et_company_mailing_address)
    EditText etCompanyMailingAddress;
    @BindView(R.id.ll_overnight)
    LinearLayout llOvernight;
    @BindView(R.id.tv_charter_company_details)
    TextView tvCharterCompanyDetails;
    @BindView(R.id.et_website)
    EditText etWebsite;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_mobile_phone_number)
    EditText etMobilePhoneNumber;
    @BindView(R.id.et_month)
    EditText etMonth;
    @BindView(R.id.et_year)
    EditText etYear;
    @BindView(R.id.cb_aggree)
    CheckBox cbAggree;
    @BindView(R.id.cb_aggree_consent)
    CheckBox cbAggreeCheckBox;
    @BindView(R.id.rb_legal_entity_yes)
    RadioButton rbLegalEntityYes;
    @BindView(R.id.rb_legal_entity_no)
    RadioButton rbLegalEntityNo;
    @BindView(R.id.rg_legal_entity)
    RadioGroup rgLegalEntity;
    @BindView(R.id.rb_insurance_yes)
    RadioButton rbInsuranceYes;
    @BindView(R.id.rb_insurance_no)
    RadioButton rbInsuranceNo;
    @BindView(R.id.rg_insurance)
    RadioGroup rgInsurance;
    @BindView(R.id.rb_license_permit_yes)
    RadioButton rbLicensePermitYes;
    @BindView(R.id.rb_license_permit_no)
    RadioButton rbLicensePermitNo;
    @BindView(R.id.rg_license_permit)
    RadioGroup rgLicensePermit;
    @BindView(R.id.bt_submit)
    Button btSubmit;
    @BindView(R.id.tv_radio_selection)
    TextView tvRadioSelection;
    @BindView(R.id.tv_pay_pal_email)
    TextView tvPayPalEmail;
    @BindView(R.id.ll_paypal_email)
    LinearLayout llPaypalEmail;

    boolean infoCurrentAccurate = false;

    private Context context;
    private EditCaptainDetailsPresenter editCaptainDetailsPresenter;
    private String userId;
    private CommonSharedPref commonSharedPref;
    String firstName = "";
    String lastName = "";
    String charterServiceName = "";
    String payPalPayment = "";
    String manualPayment = "";
    String creditCardPayment = "";
    String paypalEmail = "";
    String manulaEmail = "";
    String website = "";
    String phoneNumber = "";
    String mobileNumber = "";
    String esatblishedMonth = "";
    String esatblishedYear = "";
    List<String> currentInfoCurrnetAccurate;
    List<String> isBuisnesEntity;
    List<String> isInsuarance;
    List<String> isPermitLicense;
    String paymentMehtod = "";


    private ProgressHUD progressHUD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        context = this;
        editCaptainDetailsPresenter = new EditCaptainDetailsPresenter(context, this);
        commonSharedPref = new CommonSharedPref(context);
        userId = commonSharedPref.getUserId(context);
        if (userId != null && !userId.isEmpty()) {
            try {
                showPogress();
                editCaptainDetailsPresenter.getCaptainDetails(userId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


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

    @OnClick({R.id.rb_paypal, R.id.rb_manual, R.id.rb_credit_card,
            R.id.rb_legal_entity_yes, R.id.rb_legal_entity_no,
            R.id.rb_insurance_yes, R.id.rb_insurance_no,
            R.id.rb_license_permit_yes,
            R.id.rb_license_permit_no,
            R.id.bt_submit,
            R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rb_paypal:
                llPaypalEmail.setVisibility(View.VISIBLE);
                llOvernight.setVisibility(View.GONE);
                tvRadioSelection.setVisibility(View.GONE);
                break;

            case R.id.rb_manual:
                tvRadioSelection.setVisibility(View.VISIBLE);
                tvRadioSelection.setText(getResources().getText(R.string.manual_text));
                llPaypalEmail.setVisibility(View.GONE);
                llOvernight.setVisibility(View.VISIBLE);
                break;

            case R.id.rb_credit_card:
                tvRadioSelection.setVisibility(View.VISIBLE);
                tvRadioSelection.setText(getResources().getText(R.string.credit_card_text));
                llPaypalEmail.setVisibility(View.GONE);
                llOvernight.setVisibility(View.GONE);


                break;

            case R.id.rb_legal_entity_yes:
                break;

            case R.id.rb_legal_entity_no:
                break;
            case R.id.rb_insurance_yes:
                break;

            case R.id.rb_insurance_no:
                break;

            case R.id.rb_license_permit_yes:
                break;

            case R.id.rb_license_permit_no:
                break;

            case R.id.bt_submit:
                showPogress();
                firstName = etFirstName.getText().toString();
                lastName = etLastName.getText().toString();
                website = etWebsite.getText().toString();
                charterServiceName = etCharterGuideservicename.getText().toString();
                esatblishedMonth = etMonth.getText().toString();
                esatblishedYear = etYear.getText().toString();
                phoneNumber = etPhoneNumber.getText().toString();
                mobileNumber = etMobilePhoneNumber.getText().toString();

                if (rbPaypal.isChecked()) {
                    paymentMehtod = "PayPal";
                } else if (rbManual.isChecked()) {
                    paymentMehtod = "Manual (Overnight Check)";
                } else if (rbCreditCard.isChecked()) {
                    paymentMehtod = "Credit Card";
                }

                if (cbAggree.isChecked()) {
                    infoCurrentAccurate = true;
                    currentInfoCurrnetAccurate.set(0, "Yes");
                } else {
                    infoCurrentAccurate = false;
                    currentInfoCurrnetAccurate.set(0, "No");
                    hideProgress();
                    Toast.makeText(context, "Please agree for your information is current and accurate.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (cbAggreeCheckBox.isChecked()) {
                    infoCurrentAccurate = true;
                    currentInfoCurrnetAccurate.set(0, "Yes");
                } else {
                    infoCurrentAccurate = false;
                    currentInfoCurrnetAccurate.set(0, "No");
                    hideProgress();
                    Toast.makeText(context, "Please agree concent to receive SMS messages.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rbLegalEntityYes.isChecked()) {
                    isBuisnesEntity.set(0, "Yes");
                } else if (rbLegalEntityNo.isChecked()) {
                    isBuisnesEntity.set(0, "No");
                }

                if (rbInsuranceYes.isChecked()) {
                    isInsuarance.set(0, "Yes");

                } else if (rbInsuranceNo.isChecked()) {
                    isInsuarance.set(0, "No");
                }

                if (rbLicensePermitYes.isChecked()) {
                    isPermitLicense.set(0, "Yes");

                } else if (rbLicensePermitNo.isChecked()) {

                    isPermitLicense.set(0, "No");
                }

                if (paymentMehtod.equalsIgnoreCase("paypal")) {
                    paypalEmail = etPayPalEmail.getText().toString();
                } else {
                    paypalEmail = "";
                }
                if (paymentMehtod.equalsIgnoreCase("manual")) {
                    manulaEmail = etCompanyMailingAddress.getText().toString();
                } else {
                    manulaEmail = "";
                }


                boolean isDetaileEntered = isValidDetials(firstName,
                        lastName,
                        website,
                        charterServiceName,
                        phoneNumber,
                        mobileNumber);
                if (isDetaileEntered) {
                    try {
                        editCaptainDetailsPresenter.updateCaptainDetials(firstName,
                                lastName,
                                charterServiceName,
                                paymentMehtod,
                                paypalEmail,
                                manulaEmail,
                                phoneNumber,
                                mobileNumber,
                                website,
                                esatblishedMonth,
                                esatblishedYear,
                                infoCurrentAccurate,
                                isBuisnesEntity.get(0),
                                isInsuarance.get(0),
                                isPermitLicense.get(0),
                                userId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                break;
        }
    }


    private boolean isValidDetials(String firstName,
                                   String lastName,
                                   String website,
                                   String charterServiceName,
                                   String phoneNumber,
                                   String mobileNumber) {
        if (firstName == null || firstName.isEmpty()) {
            hideProgress();
            Utils.showToast(context, getResources().getString(R.string.enter_first_name));
            return false;
        } else if (lastName == null || lastName.isEmpty()) {
            hideProgress();
            Utils.showToast(context, getResources().getString(R.string.enter_last_name));
            return false;
        } else if (charterServiceName == null || charterServiceName.isEmpty()) {
            hideProgress();
            Utils.showToast(context, getResources().getString(R.string.enter_charater_service_name));
            return false;
        }

//        else if (website == null || website.isEmpty()) {
//            hideProgress();
//            Utils.showToast(context, getResources().getString(R.string.enter_website));
//            return false;
//        }
//        else if (phoneNumber == null || phoneNumber.isEmpty()) {
//            hideProgress();
//            Utils.showToast(context, getResources().getString(R.string.enter_phone_number));
//            return false;
//        }
        else if (mobileNumber == null || mobileNumber.isEmpty()) {
            hideProgress();
            Utils.showToast(context, getResources().getString(R.string.enter_mobile_number));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    public void getCaptainDetails(GetCaptainDetailsCallback getCaptainDetailsCallback) {
        hideProgress();
        if (getCaptainDetailsCallback != null) {

            if (getCaptainDetailsCallback.getFirstName() != null && !getCaptainDetailsCallback.getFirstName().isEmpty()) {
                firstName = getCaptainDetailsCallback.getFirstName();
                etFirstName.setText(firstName);
            }
            if (getCaptainDetailsCallback.getLastName() != null && !getCaptainDetailsCallback.getLastName().isEmpty()) {
                lastName = getCaptainDetailsCallback.getLastName();
                etLastName.setText(lastName);
            }
            if (getCaptainDetailsCallback.getProfileCharterCompanyName() != null && !getCaptainDetailsCallback.getProfileCharterCompanyName().isEmpty()) {
                charterServiceName = getCaptainDetailsCallback.getProfileCharterCompanyName();
                etCharterGuideservicename.setText(charterServiceName);
            }

            if (getCaptainDetailsCallback.getProfilePayoutMethod() != null && !getCaptainDetailsCallback.getProfileMobilePhoneNumber().isEmpty()) {
                paymentMehtod = getCaptainDetailsCallback.getProfilePayoutMethod();
                if (paymentMehtod != null && !paymentMehtod.isEmpty() && paymentMehtod.equalsIgnoreCase("PayPal")) {
                    etPayPalEmail.setText(getCaptainDetailsCallback.getProfilePayoutPaypalEmail());
                    rbPaypal.setChecked(true);
                } else if (paymentMehtod != null && !paymentMehtod.isEmpty() && paymentMehtod.equalsIgnoreCase("Manual (Overnight Check)")) {
                    rbManual.setChecked(true);
                } else if (paymentMehtod != null && !paymentMehtod.isEmpty() && paymentMehtod.equalsIgnoreCase("Credit Card")) {
                    rbCreditCard.setChecked(true);
                }
            }

            if (getCaptainDetailsCallback.getProfileCharterEstablishedMonth() != null && !getCaptainDetailsCallback.getProfileCharterEstablishedMonth().isEmpty()) {
                esatblishedMonth = getCaptainDetailsCallback.getProfileCharterEstablishedMonth();
                etMonth.setText(esatblishedMonth);
            }
            if (getCaptainDetailsCallback.getProfileCharterEstablishedYear() != null && !getCaptainDetailsCallback.getProfileCharterEstablishedYear().isEmpty()) {
                esatblishedYear = getCaptainDetailsCallback.getProfileCharterEstablishedYear();
                etYear.setText(esatblishedYear);
            }

            if (getCaptainDetailsCallback.getProfileWebsite() != null && !getCaptainDetailsCallback.getProfileWebsite().isEmpty()) {
                website = getCaptainDetailsCallback.getProfileWebsite();
                etWebsite.setText(website);
            }

            if (getCaptainDetailsCallback.getProfileMobilePhoneNumber() != null && !getCaptainDetailsCallback.getProfileMobilePhoneNumber().isEmpty()) {
                mobileNumber = getCaptainDetailsCallback.getProfileMobilePhoneNumber();
                etMobilePhoneNumber.setText(mobileNumber);
            }

            if (getCaptainDetailsCallback.getProfilePhoneNumber() != null && !getCaptainDetailsCallback.getProfilePhoneNumber().isEmpty()) {
                phoneNumber = getCaptainDetailsCallback.getProfilePhoneNumber();
                etPhoneNumber.setText(phoneNumber);
            }

            if (getCaptainDetailsCallback.getCapProfileInfoCurrentAccurate() != null && !getCaptainDetailsCallback.getCapProfileInfoCurrentAccurate().isEmpty()) {
                currentInfoCurrnetAccurate = getCaptainDetailsCallback.getCapProfileInfoCurrentAccurate();
                if (currentInfoCurrnetAccurate.contains("Yes")) {
                    cbAggree.setChecked(true);
                } else {
                    cbAggree.setChecked(false);
                }
            }

            if (getCaptainDetailsCallback.getProfileIncorporated() != null && !getCaptainDetailsCallback.getProfileIncorporated().isEmpty()) {
                isBuisnesEntity = getCaptainDetailsCallback.getProfileIncorporated();
                if (isBuisnesEntity.contains("Yes")) {
                    rbLegalEntityYes.setChecked(true);
                } else {
                    rbLegalEntityNo.setChecked(true);
                }
            }


            if (getCaptainDetailsCallback.getProfileInsurance() != null && !getCaptainDetailsCallback.getProfileInsurance().isEmpty()) {
                isInsuarance = getCaptainDetailsCallback.getProfileInsurance();
                if (isInsuarance.contains("Yes")) {
                    rbInsuranceYes.setChecked(true);
                } else {
                    rbInsuranceNo.setChecked(true);
                }
            }

            if (getCaptainDetailsCallback.getCapProfileRequiredLicenses() != null && !getCaptainDetailsCallback.getCapProfileRequiredLicenses().isEmpty()) {
                isPermitLicense = getCaptainDetailsCallback.getCapProfileRequiredLicenses();
                if (isPermitLicense.contains("Yes")) {
                    rbLicensePermitYes.setChecked(true);
                } else {
                    rbLicensePermitNo.setChecked(true);
                }
            }

            if (getCaptainDetailsCallback.getProfileSmsConsent() != null ) {

                if (getCaptainDetailsCallback.getProfileSmsConsent().get(0).equals("true")){
                    cbAggreeCheckBox.setChecked(true);
                }else {
                    cbAggreeCheckBox.setChecked(false);
                }

            }

            if (getCaptainDetailsCallback.getCapProfileInfoCurrentAccurate() != null ) {

                if (getCaptainDetailsCallback.getCapProfileInfoCurrentAccurate().get(0).equals("true")){
                    cbAggree.setChecked(true);
                }else {
                    cbAggree.setChecked(false);
                }
            }
        }
    }

    @Override
    public void updateCaptainDetails(GetRegisterCallback getRegisterCallback) {
        hideProgress();
        if (getRegisterCallback != null && getRegisterCallback.getStatus().equalsIgnoreCase("success")) {
            etFirstName.setText("");
            etLastName.setText("");
            etCharterGuideservicename.setText("");
            etYear.setText("");
            etMonth.setText("");
            etWebsite.setText("");
            etPhoneNumber.setText("");
            etMobilePhoneNumber.setText("");
            Utils.showToastLong(context, getResources().getString(R.string.profile_updated_successfully));
            finish();
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void finish(String message) {

        hideProgress();
//        Utils.showToastLong(context,getResources().getString(R.string.something_went_wrong));


    }

    @Override
    public void failed(String message) {
        hideProgress();
        Utils.showToastLong(context, getResources().getString(R.string.something_went_wrong));

    }
}
