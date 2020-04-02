package com.app.fishanywhere.misc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.app.fishanywhere.R;
import com.app.fishanywhere.view.activity.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {

    public static Retrofit retrofitObject(Context context) {
        try {
            if (context != null) {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(300, TimeUnit.SECONDS)
                        .writeTimeout(300, TimeUnit.SECONDS)
                        .readTimeout(300, TimeUnit.SECONDS)
                        .followRedirects(false)
                        .cache(null)
                        .build();

                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(AppConstants.BASE_URL) //serverUrl
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                return retrofit;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void showToast(Context context, String message) {
        if (context != null && message!=null && message != "" && !message.isEmpty()) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showToastLong(Context context, String message) {
        if (context != null && message != "" && !message.isEmpty()) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }


    public static void logout(final Context context, final Activity activity) {
        if(context!=null && activity!=null){
            CommonSharedPref commonSharedPref = new CommonSharedPref(context);
            commonSharedPref.clearLogoutPref(context);
            showToast(context, context.getResources().getString(R.string.logout_successfully));
            context.startActivity(new Intent(context, LoginActivity.class));
//            context.startActivity(new Intent(context, LoginActivity.class));
            activity.moveTaskToBack(false);
            activity.finish();

        }
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }




    public static OkHttpClient getUnsafeOkHttpClient() {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
