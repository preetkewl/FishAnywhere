package com.app.fishanywhere.model.Callbacks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCaptainDetailsCallback {
    @SerializedName("ID")
    @Expose
    public int iD;
    @SerializedName("user_login")
    @Expose
    public String userLogin;
    @SerializedName("user_nicename")
    @Expose
    public String userNicename;
    @SerializedName("user_email")
    @Expose
    public String userEmail;
    @SerializedName("user_url")
    @Expose
    public String userUrl;
    @SerializedName("user_registered")
    @Expose
    public String userRegistered;
    @SerializedName("display_name")
    @Expose
    public String displayName;
    @SerializedName("filter")
    @Expose
    public Object filter;
    @SerializedName("\u0000WP_User\u0000site_id")
    @Expose
    public int wPUserSiteId;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(String userRegistered) {
        this.userRegistered = userRegistered;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    public int getwPUserSiteId() {
        return wPUserSiteId;
    }

    public void setwPUserSiteId(int wPUserSiteId) {
        this.wPUserSiteId = wPUserSiteId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelatedVendor() {
        return relatedVendor;
    }

    public void setRelatedVendor(String relatedVendor) {
        this.relatedVendor = relatedVendor;
    }

    public String getMailchimpWoocommerceIsSubscribed() {
        return mailchimpWoocommerceIsSubscribed;
    }

    public void setMailchimpWoocommerceIsSubscribed(String mailchimpWoocommerceIsSubscribed) {
        this.mailchimpWoocommerceIsSubscribed = mailchimpWoocommerceIsSubscribed;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getProfileCharterCompanyName() {
        return profileCharterCompanyName;
    }

    public void setProfileCharterCompanyName(String profileCharterCompanyName) {
        this.profileCharterCompanyName = profileCharterCompanyName;
    }

    public String getProfilePayoutMethod() {
        return profilePayoutMethod;
    }

    public void setProfilePayoutMethod(String profilePayoutMethod) {
        this.profilePayoutMethod = profilePayoutMethod;
    }

    public String getProfilePayoutPaypalEmail() {
        return profilePayoutPaypalEmail;
    }

    public void setProfilePayoutPaypalEmail(String profilePayoutPaypalEmail) {
        this.profilePayoutPaypalEmail = profilePayoutPaypalEmail;
    }

    public String getProfileCheckMailingAddress() {
        return profileCheckMailingAddress;
    }

    public void setProfileCheckMailingAddress(String profileCheckMailingAddress) {
        this.profileCheckMailingAddress = profileCheckMailingAddress;
    }

    public String getProfileCharterEstablishedMonth() {
        return profileCharterEstablishedMonth;
    }

    public void setProfileCharterEstablishedMonth(String profileCharterEstablishedMonth) {
        this.profileCharterEstablishedMonth = profileCharterEstablishedMonth;
    }

    public String getProfileCharterEstablishedYear() {
        return profileCharterEstablishedYear;
    }

    public void setProfileCharterEstablishedYear(String profileCharterEstablishedYear) {
        this.profileCharterEstablishedYear = profileCharterEstablishedYear;
    }

    public List<String> getCapProfileInfoCurrentAccurate() {
        return capProfileInfoCurrentAccurate;
    }

    public void setCapProfileInfoCurrentAccurate(List<String> capProfileInfoCurrentAccurate) {
        this.capProfileInfoCurrentAccurate = capProfileInfoCurrentAccurate;
    }

    public List<String> getProfileIncorporated() {
        return profileIncorporated;
    }

    public void setProfileIncorporated(List<String> profileIncorporated) {
        this.profileIncorporated = profileIncorporated;
    }

    public List<String> getProfileInsurance() {
        return profileInsurance;
    }

    public void setProfileInsurance(List<String> profileInsurance) {
        this.profileInsurance = profileInsurance;
    }

    public List<String> getCapProfileRequiredLicenses() {
        return capProfileRequiredLicenses;
    }

    public void setCapProfileRequiredLicenses(List<String> capProfileRequiredLicenses) {
        this.capProfileRequiredLicenses = capProfileRequiredLicenses;
    }

    public String getProfileWebsite() {
        return profileWebsite;
    }

    public void setProfileWebsite(String profileWebsite) {
        this.profileWebsite = profileWebsite;
    }

    public String getProfilePhoneNumber() {
        return profilePhoneNumber;
    }

    public void setProfilePhoneNumber(String profilePhoneNumber) {
        this.profilePhoneNumber = profilePhoneNumber;
    }

    public String getProfileMobilePhoneNumber() {
        return profileMobilePhoneNumber;
    }

    public void setProfileMobilePhoneNumber(String profileMobilePhoneNumber) {
        this.profileMobilePhoneNumber = profileMobilePhoneNumber;
    }

    public List<String> getProfileSmsConsent() {
        return profileSmsConsent;
    }

    public void setProfileSmsConsent(List<String> profileSmsConsent) {
        this.profileSmsConsent = profileSmsConsent;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUmEmailAsUsernameTest21gmailCom() {
        return umEmailAsUsernameTest21gmailCom;
    }

    public void setUmEmailAsUsernameTest21gmailCom(String umEmailAsUsernameTest21gmailCom) {
        this.umEmailAsUsernameTest21gmailCom = umEmailAsUsernameTest21gmailCom;
    }

    public String getUmUserProfileUrlSlugUserLogin() {
        return umUserProfileUrlSlugUserLogin;
    }

    public void setUmUserProfileUrlSlugUserLogin(String umUserProfileUrlSlugUserLogin) {
        this.umUserProfileUrlSlugUserLogin = umUserProfileUrlSlugUserLogin;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileClaimedListingDate() {
        return profileClaimedListingDate;
    }

    public void setProfileClaimedListingDate(String profileClaimedListingDate) {
        this.profileClaimedListingDate = profileClaimedListingDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWoocommerceLoadSavedCartAfterLogin() {
        return woocommerceLoadSavedCartAfterLogin;
    }

    public void setWoocommerceLoadSavedCartAfterLogin(String woocommerceLoadSavedCartAfterLogin) {
        this.woocommerceLoadSavedCartAfterLogin = woocommerceLoadSavedCartAfterLogin;
    }

    public String getTripAvail() {
        return tripAvail;
    }

    public void setTripAvail(String tripAvail) {
        this.tripAvail = tripAvail;
    }

    public String getTripAvailArray() {
        return tripAvailArray;
    }

    public void setTripAvailArray(String tripAvailArray) {
        this.tripAvailArray = tripAvailArray;
    }

    public String getAccountStatusName() {
        return accountStatusName;
    }

    public void setAccountStatusName(String accountStatusName) {
        this.accountStatusName = accountStatusName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRedirectHomepage() {
        return redirectHomepage;
    }

    public void setRedirectHomepage(String redirectHomepage) {
        this.redirectHomepage = redirectHomepage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutoApproveAct() {
        return autoApproveAct;
    }

    public void setAutoApproveAct(String autoApproveAct) {
        this.autoApproveAct = autoApproveAct;
    }

    public String getAutoApproveUrl() {
        return autoApproveUrl;
    }

    public void setAutoApproveUrl(String autoApproveUrl) {
        this.autoApproveUrl = autoApproveUrl;
    }

    public String getLoginEmailActivate() {
        return loginEmailActivate;
    }

    public void setLoginEmailActivate(String loginEmailActivate) {
        this.loginEmailActivate = loginEmailActivate;
    }

    public String getCheckmailAction() {
        return checkmailAction;
    }

    public void setCheckmailAction(String checkmailAction) {
        this.checkmailAction = checkmailAction;
    }

    public String getCheckmailMessage() {
        return checkmailMessage;
    }

    public void setCheckmailMessage(String checkmailMessage) {
        this.checkmailMessage = checkmailMessage;
    }

    public String getCheckmailUrl() {
        return checkmailUrl;
    }

    public void setCheckmailUrl(String checkmailUrl) {
        this.checkmailUrl = checkmailUrl;
    }

    public String getUrlEmailActivate() {
        return urlEmailActivate;
    }

    public void setUrlEmailActivate(String urlEmailActivate) {
        this.urlEmailActivate = urlEmailActivate;
    }

    public String getPendingAction() {
        return pendingAction;
    }

    public void setPendingAction(String pendingAction) {
        this.pendingAction = pendingAction;
    }

    public String getPendingMessage() {
        return pendingMessage;
    }

    public void setPendingMessage(String pendingMessage) {
        this.pendingMessage = pendingMessage;
    }

    public String getPendingUrl() {
        return pendingUrl;
    }

    public void setPendingUrl(String pendingUrl) {
        this.pendingUrl = pendingUrl;
    }

    public String getAfterLogin() {
        return afterLogin;
    }

    public void setAfterLogin(String afterLogin) {
        this.afterLogin = afterLogin;
    }

    public String getLoginRedirectUrl() {
        return loginRedirectUrl;
    }

    public void setLoginRedirectUrl(String loginRedirectUrl) {
        this.loginRedirectUrl = loginRedirectUrl;
    }

    public String getAfterLogout() {
        return afterLogout;
    }

    public void setAfterLogout(String afterLogout) {
        this.afterLogout = afterLogout;
    }

    public String getLogoutRedirectUrl() {
        return logoutRedirectUrl;
    }

    public void setLogoutRedirectUrl(String logoutRedirectUrl) {
        this.logoutRedirectUrl = logoutRedirectUrl;
    }

    public String getAfterDelete() {
        return afterDelete;
    }

    public void setAfterDelete(String afterDelete) {
        this.afterDelete = afterDelete;
    }

    public String getDeleteRedirectUrl() {
        return deleteRedirectUrl;
    }

    public void setDeleteRedirectUrl(String deleteRedirectUrl) {
        this.deleteRedirectUrl = deleteRedirectUrl;
    }

    public int getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(int superAdmin) {
        this.superAdmin = superAdmin;
    }

    @SerializedName("nickname")
    @Expose
    public String nickname;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("related_vendor")
    @Expose
    public String relatedVendor;
    @SerializedName("mailchimp_woocommerce_is_subscribed")
    @Expose
    public String mailchimpWoocommerceIsSubscribed;
    @SerializedName("last_update")
    @Expose
    public String lastUpdate;
    @SerializedName("profile_charter_company_name")
    @Expose
    public String profileCharterCompanyName;
    @SerializedName("profile_payout_method")
    @Expose
    public String profilePayoutMethod;
    @SerializedName("profile_payout_paypal_email")
    @Expose
    public String profilePayoutPaypalEmail;
    @SerializedName("profile_check_mailing_address")
    @Expose
    public String profileCheckMailingAddress;
    @SerializedName("profile_charter_established_month")
    @Expose
    public String profileCharterEstablishedMonth;
    @SerializedName("profile_charter_established_year")
    @Expose
    public String profileCharterEstablishedYear;
    @SerializedName("cap-profile-info-current-accurate")
    @Expose
    public List<String> capProfileInfoCurrentAccurate = null;
    @SerializedName("profile_incorporated")
    @Expose
    public List<String> profileIncorporated = null;
    @SerializedName("profile_insurance")
    @Expose
    public List<String> profileInsurance = null;
    @SerializedName("cap-profile-required-licenses")
    @Expose
    public List<String> capProfileRequiredLicenses = null;
    @SerializedName("profile_website")
    @Expose
    public String profileWebsite;
    @SerializedName("profile_phone_number")
    @Expose
    public String profilePhoneNumber;
    @SerializedName("profile_mobile_phone_number")
    @Expose
    public String profileMobilePhoneNumber;
    @SerializedName("profile_sms_consent")
    @Expose
    public List<String> profileSmsConsent = null;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("um_email_as_username_test21gmail-com")
    @Expose
    public String umEmailAsUsernameTest21gmailCom;
    @SerializedName("um_user_profile_url_slug_user_login")
    @Expose
    public String umUserProfileUrlSlugUserLogin;
    @SerializedName("account_status")
    @Expose
    public String accountStatus;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("profile_claimed_listing_date")
    @Expose
    public String profileClaimedListingDate;
    @SerializedName("user_id")
    @Expose
    public String userId;
    @SerializedName("_woocommerce_load_saved_cart_after_login")
    @Expose
    public String woocommerceLoadSavedCartAfterLogin;
    @SerializedName("trip_avail")
    @Expose
    public String tripAvail;
    @SerializedName("trip_avail_array")
    @Expose
    public String tripAvailArray;
    @SerializedName("account_status_name")
    @Expose
    public String accountStatusName;
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("priority")
    @Expose
    public String priority;
    @SerializedName("redirect_homepage")
    @Expose
    public String redirectHomepage;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("auto_approve_act")
    @Expose
    public String autoApproveAct;
    @SerializedName("auto_approve_url")
    @Expose
    public String autoApproveUrl;
    @SerializedName("login_email_activate")
    @Expose
    public String loginEmailActivate;
    @SerializedName("checkmail_action")
    @Expose
    public String checkmailAction;
    @SerializedName("checkmail_message")
    @Expose
    public String checkmailMessage;
    @SerializedName("checkmail_url")
    @Expose
    public String checkmailUrl;
    @SerializedName("url_email_activate")
    @Expose
    public String urlEmailActivate;
    @SerializedName("pending_action")
    @Expose
    public String pendingAction;
    @SerializedName("pending_message")
    @Expose
    public String pendingMessage;
    @SerializedName("pending_url")
    @Expose
    public String pendingUrl;
    @SerializedName("after_login")
    @Expose
    public String afterLogin;
    @SerializedName("login_redirect_url")
    @Expose
    public String loginRedirectUrl;
    @SerializedName("after_logout")
    @Expose
    public String afterLogout;
    @SerializedName("logout_redirect_url")
    @Expose
    public String logoutRedirectUrl;
    @SerializedName("after_delete")
    @Expose
    public String afterDelete;
    @SerializedName("delete_redirect_url")
    @Expose
    public String deleteRedirectUrl;
    @SerializedName("super_admin")
    @Expose
    public int superAdmin;

//    @SerializedName("ID")
//    @Expose
//    public int iD;
//    @SerializedName("user_login")
//    @Expose
//    public String userLogin;
//    @SerializedName("user_pass")
//    @Expose
//    public String userPass;
//    @SerializedName("user_nicename")
//    @Expose
//    public String userNicename;
//    @SerializedName("user_email")
//    @Expose
//    public String userEmail;
//    @SerializedName("user_url")
//    @Expose
//    public String userUrl;
//    @SerializedName("user_registered")
//    @Expose
//    public String userRegistered;
//    @SerializedName("user_status")
//    @Expose
//    public String userStatus;
//    @SerializedName("display_name")
//    @Expose
//    public String displayName;
//    @SerializedName("um_fa-captain")
//    @Expose
//    public Boolean umFaCaptain;
//    @SerializedName("wp_roles")
//    @Expose
//    public String wpRoles;
//    @SerializedName("edit_posts")
//    @Expose
//    public Boolean editPosts;
//    @SerializedName("edit_published_posts")
//    @Expose
//    public Boolean editPublishedPosts;
//    @SerializedName("read")
//    @Expose
//    public Boolean read;
//    @SerializedName("delete_posts")
//    @Expose
//    public Boolean deletePosts;
//    @SerializedName("delete_published_posts")
//    @Expose
//    public Boolean deletePublishedPosts;
//    @SerializedName("edit_products")
//    @Expose
//    public Boolean editProducts;
//    @SerializedName("edit_published_products")
//    @Expose
//    public Boolean editPublishedProducts;
//    @SerializedName("delete_published_products")
//    @Expose
//    public Boolean deletePublishedProducts;
//    @SerializedName("delete_products")
//    @Expose
//    public Boolean deleteProducts;
//    @SerializedName("filter")
//    @Expose
//    public Object filter;
//    @SerializedName("\u0000WP_User\u0000site_id")
//    @Expose
//    public int wPUserSiteId;
//    @SerializedName("nickname")
//    @Expose
//    public String nickname;
//    @SerializedName("first_name")
//    @Expose
//    public String firstName;
//    @SerializedName("last_name")
//    @Expose
//    public String lastName;
//    @SerializedName("description")
//    @Expose
//    public String description;
//    @SerializedName("rich_editing")
//    @Expose
//    public String richEditing;
//    @SerializedName("syntax_highlighting")
//    @Expose
//    public String syntaxHighlighting;
//    @SerializedName("comment_shortcuts")
//    @Expose
//    public String commentShortcuts;
//    @SerializedName("admin_color")
//    @Expose
//    public String adminColor;
//    @SerializedName("use_ssl")
//    @Expose
//    public String useSsl;
//    @SerializedName("show_admin_bar_front")
//    @Expose
//    public String showAdminBarFront;
//    @SerializedName("locale")
//    @Expose
//    public String locale;
//    @SerializedName("mfa_capabilities")
//    @Expose
//    public String mfaCapabilities;
//    @SerializedName("mfa_user_level")
//    @Expose
//    public String mfaUserLevel;
//    @SerializedName("related_vendor")
//    @Expose
//    public String relatedVendor;
//    @SerializedName("mailchimp_woocommerce_is_subscribed")
//    @Expose
//    public String mailchimpWoocommerceIsSubscribed;
//    @SerializedName("_yoast_wpseo_profile_updated")
//    @Expose
//    public String yoastWpseoProfileUpdated;
//    @SerializedName("synced_gravatar_hashed_id")
//    @Expose
//    public String syncedGravatarHashedId;
//    @SerializedName("submitted")
//    @Expose
//    public String submitted;
//    @SerializedName("profile_charter_company_name")
//    @Expose
//    public String profileCharterCompanyName;
//    @SerializedName("profile_payout_method")
//    @Expose
//    public String profilePayoutMethod;
//    @SerializedName("profile_payout_paypal_email")
//    @Expose
//    public String profilePayoutPaypalEmail;
//    @SerializedName("profile_check_mailing_address")
//    @Expose
//    public String profileCheckMailingAddress;
//    @SerializedName("profile_charter_established_month")
//    @Expose
//    public String profileCharterEstablishedMonth;
//    @SerializedName("profile_charter_established_year")
//    @Expose
//    public String profileCharterEstablishedYear;
//    @SerializedName("cap-profile-info-current-accurate")
//    @Expose
//    public String capProfileInfoCurrentAccurate;
//    @SerializedName("profile_incorporated")
//    @Expose
//    public String profileIncorporated;
//    @SerializedName("profile_insurance")
//    @Expose
//    public String profileInsurance;
//    @SerializedName("cap-profile-required-licenses")
//    @Expose
//    public String capProfileRequiredLicenses;
//    @SerializedName("profile_website")
//    @Expose
//    public String profileWebsite;
//    @SerializedName("profile_phone_number")
//    @Expose
//    public String profilePhoneNumber;
//    @SerializedName("profile_mobile_phone_number")
//    @Expose
//    public String profileMobilePhoneNumber;
//    @SerializedName("profile_sms_consent")
//    @Expose
//    public String profileSmsConsent;
//    @SerializedName("form_id")
//    @Expose
//    public String formId;
//    @SerializedName("mode")
//    @Expose
//    public String mode;
//    @SerializedName("timestamp")
//    @Expose
//    public String timestamp;
//    @SerializedName("um-mailchimp")
//    @Expose
//    public String umMailchimp;
//    @SerializedName("um_email_as_username_test26gmail-com")
//    @Expose
//    public String umEmailAsUsernameTest26gmailCom;
//    @SerializedName("um_user_profile_url_slug_user_login")
//    @Expose
//    public String umUserProfileUrlSlugUserLogin;
//    @SerializedName("last_update")
//    @Expose
//    public String lastUpdate;
//    @SerializedName("account_status")
//    @Expose
//    public String accountStatus;
//    @SerializedName("full_name")
//    @Expose
//    public String fullName;
//    @SerializedName("profile_claimed_listing_date")
//    @Expose
//    public String profileClaimedListingDate;
//    @SerializedName("wc_last_active")
//    @Expose
//    public String wcLastActive;
//    @SerializedName("_woocommerce_load_saved_cart_after_login")
//    @Expose
//    public String woocommerceLoadSavedCartAfterLogin;
//    @SerializedName("_um_last_login")
//    @Expose
//    public String umLastLogin;
//    @SerializedName("account_status_name")
//    @Expose
//    public String accountStatusName;
//    @SerializedName("role")
//    @Expose
//    public String role;
//    @SerializedName("roles")
//    @Expose
//    public List<String> roles = null;
//    @SerializedName("is_custom")
//    @Expose
//    public String isCustom;
//    @SerializedName("name")
//    @Expose
//    public String name;
//    @SerializedName("priority")
//    @Expose
//    public String priority;
//    @SerializedName("can_access_wpadmin")
//    @Expose
//    public String canAccessWpadmin;
//    @SerializedName("can_not_see_adminbar")
//    @Expose
//    public String canNotSeeAdminbar;
//    @SerializedName("can_edit_everyone")
//    @Expose
//    public String canEditEveryone;
//    @SerializedName("can_edit_roles")
//    @Expose
//    public String canEditRoles;
//    @SerializedName("can_delete_everyone")
//    @Expose
//    public String canDeleteEveryone;
//    @SerializedName("can_delete_roles")
//    @Expose
//    public String canDeleteRoles;
//    @SerializedName("can_edit_profile")
//    @Expose
//    public String canEditProfile;
//    @SerializedName("can_delete_profile")
//    @Expose
//    public String canDeleteProfile;
//    @SerializedName("can_view_all")
//    @Expose
//    public String canViewAll;
//    @SerializedName("can_view_roles")
//    @Expose
//    public String canViewRoles;
//    @SerializedName("can_make_private_profile")
//    @Expose
//    public String canMakePrivateProfile;
//    @SerializedName("can_access_private_profile")
//    @Expose
//    public String canAccessPrivateProfile;
//    @SerializedName("default_homepage")
//    @Expose
//    public String defaultHomepage;
//    @SerializedName("redirect_homepage")
//    @Expose
//    public String redirectHomepage;
//    @SerializedName("status")
//    @Expose
//    public String status;
//    @SerializedName("auto_approve_act")
//    @Expose
//    public String autoApproveAct;
//    @SerializedName("auto_approve_url")
//    @Expose
//    public String autoApproveUrl;
//    @SerializedName("login_email_activate")
//    @Expose
//    public String loginEmailActivate;
//    @SerializedName("checkmail_action")
//    @Expose
//    public String checkmailAction;
//    @SerializedName("checkmail_message")
//    @Expose
//    public String checkmailMessage;
//    @SerializedName("checkmail_url")
//    @Expose
//    public String checkmailUrl;
//    @SerializedName("url_email_activate")
//    @Expose
//    public String urlEmailActivate;
//    @SerializedName("pending_action")
//    @Expose
//    public String pendingAction;
//    @SerializedName("pending_message")
//    @Expose
//    public String pendingMessage;
//    @SerializedName("pending_url")
//    @Expose
//    public String pendingUrl;
//    @SerializedName("after_login")
//    @Expose
//    public String afterLogin;
//    @SerializedName("login_redirect_url")
//    @Expose
//    public String loginRedirectUrl;
//    @SerializedName("after_logout")
//    @Expose
//    public String afterLogout;
//    @SerializedName("logout_redirect_url")
//    @Expose
//    public String logoutRedirectUrl;
//    @SerializedName("after_delete")
//    @Expose
//    public String afterDelete;
//    @SerializedName("delete_redirect_url")
//    @Expose
//    public String deleteRedirectUrl;
//    @SerializedName("super_admin")
//    @Expose
//    public int superAdmin;
//
//    public int getiD() {
//        return iD;
//    }
//
//    public void setiD(int iD) {
//        this.iD = iD;
//    }
//
//    public String getUserLogin() {
//        return userLogin;
//    }
//
//    public void setUserLogin(String userLogin) {
//        this.userLogin = userLogin;
//    }
//
//    public String getUserPass() {
//        return userPass;
//    }
//
//    public void setUserPass(String userPass) {
//        this.userPass = userPass;
//    }
//
//    public String getUserNicename() {
//        return userNicename;
//    }
//
//    public void setUserNicename(String userNicename) {
//        this.userNicename = userNicename;
//    }
//
//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    public void setUserEmail(String userEmail) {
//        this.userEmail = userEmail;
//    }
//
//    public String getUserUrl() {
//        return userUrl;
//    }
//
//    public void setUserUrl(String userUrl) {
//        this.userUrl = userUrl;
//    }
//
//    public String getUserRegistered() {
//        return userRegistered;
//    }
//
//    public void setUserRegistered(String userRegistered) {
//        this.userRegistered = userRegistered;
//    }
//
//    public String getUserStatus() {
//        return userStatus;
//    }
//
//    public void setUserStatus(String userStatus) {
//        this.userStatus = userStatus;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public Boolean getUmFaCaptain() {
//        return umFaCaptain;
//    }
//
//    public void setUmFaCaptain(Boolean umFaCaptain) {
//        this.umFaCaptain = umFaCaptain;
//    }
//
//    public String getWpRoles() {
//        return wpRoles;
//    }
//
//    public void setWpRoles(String wpRoles) {
//        this.wpRoles = wpRoles;
//    }
//
//    public Boolean getEditPosts() {
//        return editPosts;
//    }
//
//    public void setEditPosts(Boolean editPosts) {
//        this.editPosts = editPosts;
//    }
//
//    public Boolean getEditPublishedPosts() {
//        return editPublishedPosts;
//    }
//
//    public void setEditPublishedPosts(Boolean editPublishedPosts) {
//        this.editPublishedPosts = editPublishedPosts;
//    }
//
//    public Boolean getRead() {
//        return read;
//    }
//
//    public void setRead(Boolean read) {
//        this.read = read;
//    }
//
//    public Boolean getDeletePosts() {
//        return deletePosts;
//    }
//
//    public void setDeletePosts(Boolean deletePosts) {
//        this.deletePosts = deletePosts;
//    }
//
//    public Boolean getDeletePublishedPosts() {
//        return deletePublishedPosts;
//    }
//
//    public void setDeletePublishedPosts(Boolean deletePublishedPosts) {
//        this.deletePublishedPosts = deletePublishedPosts;
//    }
//
//    public Boolean getEditProducts() {
//        return editProducts;
//    }
//
//    public void setEditProducts(Boolean editProducts) {
//        this.editProducts = editProducts;
//    }
//
//    public Boolean getEditPublishedProducts() {
//        return editPublishedProducts;
//    }
//
//    public void setEditPublishedProducts(Boolean editPublishedProducts) {
//        this.editPublishedProducts = editPublishedProducts;
//    }
//
//    public Boolean getDeletePublishedProducts() {
//        return deletePublishedProducts;
//    }
//
//    public void setDeletePublishedProducts(Boolean deletePublishedProducts) {
//        this.deletePublishedProducts = deletePublishedProducts;
//    }
//
//    public Boolean getDeleteProducts() {
//        return deleteProducts;
//    }
//
//    public void setDeleteProducts(Boolean deleteProducts) {
//        this.deleteProducts = deleteProducts;
//    }
//
//    public Object getFilter() {
//        return filter;
//    }
//
//    public void setFilter(Object filter) {
//        this.filter = filter;
//    }
//
//    public int getwPUserSiteId() {
//        return wPUserSiteId;
//    }
//
//    public void setwPUserSiteId(int wPUserSiteId) {
//        this.wPUserSiteId = wPUserSiteId;
//    }
//
//    public String getNickname() {
//        return nickname;
//    }
//
//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getRichEditing() {
//        return richEditing;
//    }
//
//    public void setRichEditing(String richEditing) {
//        this.richEditing = richEditing;
//    }
//
//    public String getSyntaxHighlighting() {
//        return syntaxHighlighting;
//    }
//
//    public void setSyntaxHighlighting(String syntaxHighlighting) {
//        this.syntaxHighlighting = syntaxHighlighting;
//    }
//
//    public String getCommentShortcuts() {
//        return commentShortcuts;
//    }
//
//    public void setCommentShortcuts(String commentShortcuts) {
//        this.commentShortcuts = commentShortcuts;
//    }
//
//    public String getAdminColor() {
//        return adminColor;
//    }
//
//    public void setAdminColor(String adminColor) {
//        this.adminColor = adminColor;
//    }
//
//    public String getUseSsl() {
//        return useSsl;
//    }
//
//    public void setUseSsl(String useSsl) {
//        this.useSsl = useSsl;
//    }
//
//    public String getShowAdminBarFront() {
//        return showAdminBarFront;
//    }
//
//    public void setShowAdminBarFront(String showAdminBarFront) {
//        this.showAdminBarFront = showAdminBarFront;
//    }
//
//    public String getLocale() {
//        return locale;
//    }
//
//    public void setLocale(String locale) {
//        this.locale = locale;
//    }
//
//    public String getMfaCapabilities() {
//        return mfaCapabilities;
//    }
//
//    public void setMfaCapabilities(String mfaCapabilities) {
//        this.mfaCapabilities = mfaCapabilities;
//    }
//
//    public String getMfaUserLevel() {
//        return mfaUserLevel;
//    }
//
//    public void setMfaUserLevel(String mfaUserLevel) {
//        this.mfaUserLevel = mfaUserLevel;
//    }
//
//    public String getRelatedVendor() {
//        return relatedVendor;
//    }
//
//    public void setRelatedVendor(String relatedVendor) {
//        this.relatedVendor = relatedVendor;
//    }
//
//    public String getMailchimpWoocommerceIsSubscribed() {
//        return mailchimpWoocommerceIsSubscribed;
//    }
//
//    public void setMailchimpWoocommerceIsSubscribed(String mailchimpWoocommerceIsSubscribed) {
//        this.mailchimpWoocommerceIsSubscribed = mailchimpWoocommerceIsSubscribed;
//    }
//
//    public String getYoastWpseoProfileUpdated() {
//        return yoastWpseoProfileUpdated;
//    }
//
//    public void setYoastWpseoProfileUpdated(String yoastWpseoProfileUpdated) {
//        this.yoastWpseoProfileUpdated = yoastWpseoProfileUpdated;
//    }
//
//    public String getSyncedGravatarHashedId() {
//        return syncedGravatarHashedId;
//    }
//
//    public void setSyncedGravatarHashedId(String syncedGravatarHashedId) {
//        this.syncedGravatarHashedId = syncedGravatarHashedId;
//    }
//
//    public String getSubmitted() {
//        return submitted;
//    }
//
//    public void setSubmitted(String submitted) {
//        this.submitted = submitted;
//    }
//
//    public String getProfileCharterCompanyName() {
//        return profileCharterCompanyName;
//    }
//
//    public void setProfileCharterCompanyName(String profileCharterCompanyName) {
//        this.profileCharterCompanyName = profileCharterCompanyName;
//    }
//
//    public String getProfilePayoutMethod() {
//        return profilePayoutMethod;
//    }
//
//    public void setProfilePayoutMethod(String profilePayoutMethod) {
//        this.profilePayoutMethod = profilePayoutMethod;
//    }
//
//    public String getProfilePayoutPaypalEmail() {
//        return profilePayoutPaypalEmail;
//    }
//
//    public void setProfilePayoutPaypalEmail(String profilePayoutPaypalEmail) {
//        this.profilePayoutPaypalEmail = profilePayoutPaypalEmail;
//    }
//
//    public String getProfileCheckMailingAddress() {
//        return profileCheckMailingAddress;
//    }
//
//    public void setProfileCheckMailingAddress(String profileCheckMailingAddress) {
//        this.profileCheckMailingAddress = profileCheckMailingAddress;
//    }
//
//    public String getProfileCharterEstablishedMonth() {
//        return profileCharterEstablishedMonth;
//    }
//
//    public void setProfileCharterEstablishedMonth(String profileCharterEstablishedMonth) {
//        this.profileCharterEstablishedMonth = profileCharterEstablishedMonth;
//    }
//
//    public String getProfileCharterEstablishedYear() {
//        return profileCharterEstablishedYear;
//    }
//
//    public void setProfileCharterEstablishedYear(String profileCharterEstablishedYear) {
//        this.profileCharterEstablishedYear = profileCharterEstablishedYear;
//    }
//
//    public String getCapProfileInfoCurrentAccurate() {
//        return capProfileInfoCurrentAccurate;
//    }
//
//    public void setCapProfileInfoCurrentAccurate(String capProfileInfoCurrentAccurate) {
//        this.capProfileInfoCurrentAccurate = capProfileInfoCurrentAccurate;
//    }
//
//    public String getProfileIncorporated() {
//        return profileIncorporated;
//    }
//
//    public void setProfileIncorporated(String profileIncorporated) {
//        this.profileIncorporated = profileIncorporated;
//    }
//
//    public String getProfileInsurance() {
//        return profileInsurance;
//    }
//
//    public void setProfileInsurance(String profileInsurance) {
//        this.profileInsurance = profileInsurance;
//    }
//
//    public String getCapProfileRequiredLicenses() {
//        return capProfileRequiredLicenses;
//    }
//
//    public void setCapProfileRequiredLicenses(String capProfileRequiredLicenses) {
//        this.capProfileRequiredLicenses = capProfileRequiredLicenses;
//    }
//
//    public String getProfileWebsite() {
//        return profileWebsite;
//    }
//
//    public void setProfileWebsite(String profileWebsite) {
//        this.profileWebsite = profileWebsite;
//    }
//
//    public String getProfilePhoneNumber() {
//        return profilePhoneNumber;
//    }
//
//    public void setProfilePhoneNumber(String profilePhoneNumber) {
//        this.profilePhoneNumber = profilePhoneNumber;
//    }
//
//    public String getProfileMobilePhoneNumber() {
//        return profileMobilePhoneNumber;
//    }
//
//    public void setProfileMobilePhoneNumber(String profileMobilePhoneNumber) {
//        this.profileMobilePhoneNumber = profileMobilePhoneNumber;
//    }
//
//    public String getProfileSmsConsent() {
//        return profileSmsConsent;
//    }
//
//    public void setProfileSmsConsent(String profileSmsConsent) {
//        this.profileSmsConsent = profileSmsConsent;
//    }
//
//    public String getFormId() {
//        return formId;
//    }
//
//    public void setFormId(String formId) {
//        this.formId = formId;
//    }
//
//    public String getMode() {
//        return mode;
//    }
//
//    public void setMode(String mode) {
//        this.mode = mode;
//    }
//
//    public String getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(String timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getUmMailchimp() {
//        return umMailchimp;
//    }
//
//    public void setUmMailchimp(String umMailchimp) {
//        this.umMailchimp = umMailchimp;
//    }
//
//    public String getUmEmailAsUsernameTest26gmailCom() {
//        return umEmailAsUsernameTest26gmailCom;
//    }
//
//    public void setUmEmailAsUsernameTest26gmailCom(String umEmailAsUsernameTest26gmailCom) {
//        this.umEmailAsUsernameTest26gmailCom = umEmailAsUsernameTest26gmailCom;
//    }
//
//    public String getUmUserProfileUrlSlugUserLogin() {
//        return umUserProfileUrlSlugUserLogin;
//    }
//
//    public void setUmUserProfileUrlSlugUserLogin(String umUserProfileUrlSlugUserLogin) {
//        this.umUserProfileUrlSlugUserLogin = umUserProfileUrlSlugUserLogin;
//    }
//
//    public String getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(String lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
//
//    public String getAccountStatus() {
//        return accountStatus;
//    }
//
//    public void setAccountStatus(String accountStatus) {
//        this.accountStatus = accountStatus;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getProfileClaimedListingDate() {
//        return profileClaimedListingDate;
//    }
//
//    public void setProfileClaimedListingDate(String profileClaimedListingDate) {
//        this.profileClaimedListingDate = profileClaimedListingDate;
//    }
//
//    public String getWcLastActive() {
//        return wcLastActive;
//    }
//
//    public void setWcLastActive(String wcLastActive) {
//        this.wcLastActive = wcLastActive;
//    }
//
//    public String getWoocommerceLoadSavedCartAfterLogin() {
//        return woocommerceLoadSavedCartAfterLogin;
//    }
//
//    public void setWoocommerceLoadSavedCartAfterLogin(String woocommerceLoadSavedCartAfterLogin) {
//        this.woocommerceLoadSavedCartAfterLogin = woocommerceLoadSavedCartAfterLogin;
//    }
//
//    public String getUmLastLogin() {
//        return umLastLogin;
//    }
//
//    public void setUmLastLogin(String umLastLogin) {
//        this.umLastLogin = umLastLogin;
//    }
//
//    public String getAccountStatusName() {
//        return accountStatusName;
//    }
//
//    public void setAccountStatusName(String accountStatusName) {
//        this.accountStatusName = accountStatusName;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public List<String> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<String> roles) {
//        this.roles = roles;
//    }
//
//    public String getIsCustom() {
//        return isCustom;
//    }
//
//    public void setIsCustom(String isCustom) {
//        this.isCustom = isCustom;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }
//
//    public String getCanAccessWpadmin() {
//        return canAccessWpadmin;
//    }
//
//    public void setCanAccessWpadmin(String canAccessWpadmin) {
//        this.canAccessWpadmin = canAccessWpadmin;
//    }
//
//    public String getCanNotSeeAdminbar() {
//        return canNotSeeAdminbar;
//    }
//
//    public void setCanNotSeeAdminbar(String canNotSeeAdminbar) {
//        this.canNotSeeAdminbar = canNotSeeAdminbar;
//    }
//
//    public String getCanEditEveryone() {
//        return canEditEveryone;
//    }
//
//    public void setCanEditEveryone(String canEditEveryone) {
//        this.canEditEveryone = canEditEveryone;
//    }
//
//    public String getCanEditRoles() {
//        return canEditRoles;
//    }
//
//    public void setCanEditRoles(String canEditRoles) {
//        this.canEditRoles = canEditRoles;
//    }
//
//    public String getCanDeleteEveryone() {
//        return canDeleteEveryone;
//    }
//
//    public void setCanDeleteEveryone(String canDeleteEveryone) {
//        this.canDeleteEveryone = canDeleteEveryone;
//    }
//
//    public String getCanDeleteRoles() {
//        return canDeleteRoles;
//    }
//
//    public void setCanDeleteRoles(String canDeleteRoles) {
//        this.canDeleteRoles = canDeleteRoles;
//    }
//
//    public String getCanEditProfile() {
//        return canEditProfile;
//    }
//
//    public void setCanEditProfile(String canEditProfile) {
//        this.canEditProfile = canEditProfile;
//    }
//
//    public String getCanDeleteProfile() {
//        return canDeleteProfile;
//    }
//
//    public void setCanDeleteProfile(String canDeleteProfile) {
//        this.canDeleteProfile = canDeleteProfile;
//    }
//
//    public String getCanViewAll() {
//        return canViewAll;
//    }
//
//    public void setCanViewAll(String canViewAll) {
//        this.canViewAll = canViewAll;
//    }
//
//    public String getCanViewRoles() {
//        return canViewRoles;
//    }
//
//    public void setCanViewRoles(String canViewRoles) {
//        this.canViewRoles = canViewRoles;
//    }
//
//    public String getCanMakePrivateProfile() {
//        return canMakePrivateProfile;
//    }
//
//    public void setCanMakePrivateProfile(String canMakePrivateProfile) {
//        this.canMakePrivateProfile = canMakePrivateProfile;
//    }
//
//    public String getCanAccessPrivateProfile() {
//        return canAccessPrivateProfile;
//    }
//
//    public void setCanAccessPrivateProfile(String canAccessPrivateProfile) {
//        this.canAccessPrivateProfile = canAccessPrivateProfile;
//    }
//
//    public String getDefaultHomepage() {
//        return defaultHomepage;
//    }
//
//    public void setDefaultHomepage(String defaultHomepage) {
//        this.defaultHomepage = defaultHomepage;
//    }
//
//    public String getRedirectHomepage() {
//        return redirectHomepage;
//    }
//
//    public void setRedirectHomepage(String redirectHomepage) {
//        this.redirectHomepage = redirectHomepage;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getAutoApproveAct() {
//        return autoApproveAct;
//    }
//
//    public void setAutoApproveAct(String autoApproveAct) {
//        this.autoApproveAct = autoApproveAct;
//    }
//
//    public String getAutoApproveUrl() {
//        return autoApproveUrl;
//    }
//
//    public void setAutoApproveUrl(String autoApproveUrl) {
//        this.autoApproveUrl = autoApproveUrl;
//    }
//
//    public String getLoginEmailActivate() {
//        return loginEmailActivate;
//    }
//
//    public void setLoginEmailActivate(String loginEmailActivate) {
//        this.loginEmailActivate = loginEmailActivate;
//    }
//
//    public String getCheckmailAction() {
//        return checkmailAction;
//    }
//
//    public void setCheckmailAction(String checkmailAction) {
//        this.checkmailAction = checkmailAction;
//    }
//
//    public String getCheckmailMessage() {
//        return checkmailMessage;
//    }
//
//    public void setCheckmailMessage(String checkmailMessage) {
//        this.checkmailMessage = checkmailMessage;
//    }
//
//    public String getCheckmailUrl() {
//        return checkmailUrl;
//    }
//
//    public void setCheckmailUrl(String checkmailUrl) {
//        this.checkmailUrl = checkmailUrl;
//    }
//
//    public String getUrlEmailActivate() {
//        return urlEmailActivate;
//    }
//
//    public void setUrlEmailActivate(String urlEmailActivate) {
//        this.urlEmailActivate = urlEmailActivate;
//    }
//
//    public String getPendingAction() {
//        return pendingAction;
//    }
//
//    public void setPendingAction(String pendingAction) {
//        this.pendingAction = pendingAction;
//    }
//
//    public String getPendingMessage() {
//        return pendingMessage;
//    }
//
//    public void setPendingMessage(String pendingMessage) {
//        this.pendingMessage = pendingMessage;
//    }
//
//    public String getPendingUrl() {
//        return pendingUrl;
//    }
//
//    public void setPendingUrl(String pendingUrl) {
//        this.pendingUrl = pendingUrl;
//    }
//
//    public String getAfterLogin() {
//        return afterLogin;
//    }
//
//    public void setAfterLogin(String afterLogin) {
//        this.afterLogin = afterLogin;
//    }
//
//    public String getLoginRedirectUrl() {
//        return loginRedirectUrl;
//    }
//
//    public void setLoginRedirectUrl(String loginRedirectUrl) {
//        this.loginRedirectUrl = loginRedirectUrl;
//    }
//
//    public String getAfterLogout() {
//        return afterLogout;
//    }
//
//    public void setAfterLogout(String afterLogout) {
//        this.afterLogout = afterLogout;
//    }
//
//    public String getLogoutRedirectUrl() {
//        return logoutRedirectUrl;
//    }
//
//    public void setLogoutRedirectUrl(String logoutRedirectUrl) {
//        this.logoutRedirectUrl = logoutRedirectUrl;
//    }
//
//    public String getAfterDelete() {
//        return afterDelete;
//    }
//
//    public void setAfterDelete(String afterDelete) {
//        this.afterDelete = afterDelete;
//    }
//
//    public String getDeleteRedirectUrl() {
//        return deleteRedirectUrl;
//    }
//
//    public void setDeleteRedirectUrl(String deleteRedirectUrl) {
//        this.deleteRedirectUrl = deleteRedirectUrl;
//    }
//
//    public int getSuperAdmin() {
//        return superAdmin;
//    }
//
//    public void setSuperAdmin(int superAdmin) {
//        this.superAdmin = superAdmin;
//    }
}
