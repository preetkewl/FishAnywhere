package com.apps.fishanywhere.misc;

import android.content.Context;
import android.content.SharedPreferences;

public class CommonSharedPref {
    private Context context;

    public CommonSharedPref(Context context){
        this.context = context;

    }

    //To save email
    public static void setUserEmail(Context context, String email){
        SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(AppConstants.PREF_LOGIN_EMAIL,email);
        editor.commit();
    }

    //To retrieve email
    public static String getUserEmail(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
            return settings.getString(AppConstants.PREF_LOGIN_EMAIL, "");
        }return "";
    }


    //To save userPassword
    public static void setUserPassword(Context context, String email){
        SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(AppConstants.PREF_LOGIN_PASSWORD,email);
        editor.commit();
    }

    //To retrieve userPassword
    public static String getUserPassword(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
            return settings.getString(AppConstants.PREF_LOGIN_PASSWORD, "");
        }return "";
    }



    //To save userid
    public static void setUserId(Context context, String userId){
        SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(AppConstants.PREF_USER_ID,userId);
        editor.commit();
    }

    //To retrieve userid
    public static String getUserId(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
            return settings.getString(AppConstants.PREF_USER_ID, "");
        }return "";
    }


    //To save userName
    public static void setUserName(Context context, String userName){
        SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(AppConstants.PREF_USER_NAME, userName);
        editor.commit();
    }

    //To retrieve userid
    public static String getUserName(Context context){

        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
            return settings.getString(AppConstants.PREF_USER_NAME, "");
        }return "";
    }

    //To save loginToken
    public static void setUserTokenLogout(Context context, String token){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGOUT, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(AppConstants.PREF_LOGIN_TOKEN, token);
            editor.commit();
        }
    }

    //To retrieve loginToken
    public static String getUserTokenLogout(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGOUT, 0);
            return settings.getString(AppConstants.PREF_LOGIN_TOKEN, "");
        }
        return "";
    }

    public static void clearLogoutPref(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGOUT, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.clear();
            editor.commit();
        }
    }


    public static void clearLoginPref(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.clear();
            editor.commit();
        }
    }



    //To save loginToken
    public static void setRole(Context context, String role){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGOUT, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(AppConstants.PREF_LOGIN_ROLE, role);
            editor.commit();
        }
    }

    //To retrieve loginToken
    public static String getRole(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGOUT, 0);
            return settings.getString(AppConstants.PREF_LOGIN_ROLE, "");
        }
        return "";
    }


    //To save loginToken
    public static void setRoleSignUp(Context context, String role){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGOUT, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(AppConstants.PREF_LOGIN_SIGN_UP_ROLE, role);
            editor.commit();
        }
    }

    //To retrieve loginToken
    public static String getRoleSignUp(Context context){
        if(context!=null) {
            SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGOUT, 0);
            return settings.getString(AppConstants.PREF_LOGIN_SIGN_UP_ROLE, "");
        }
        return "";
    }


    public static void setSharedPreferenceString(Context context, String fcm_token, String s) {
        SharedPreferences settings = context.getSharedPreferences(AppConstants.PREF_LOGIN, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(AppConstants.PREF_LOGIN_FCM_TOKEN,s);
        editor.commit();
    }
}
