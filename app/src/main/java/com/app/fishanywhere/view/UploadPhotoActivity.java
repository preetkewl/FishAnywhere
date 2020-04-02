package com.app.fishanywhere.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.app.fishanywhere.R;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UploadPhotoActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();

    TextView txtString;

    public String url = "https://fastagingclone.flywheelsites.com/wp-json/app/v2/captain/upload_media";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);

        txtString= (TextView)findViewById(R.id.txtString);

        OkHttpHandler okHttpHandler= new OkHttpHandler();
        okHttpHandler.execute(url);
    }

    private class OkHttpHandler extends AsyncTask {
        @Override
        protected String doInBackground(Object[] objects) {


            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", "56654333233.png")
                    .build();
            Request request = new Request.Builder()
                    .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NzM0MDkwNTAsImp0aSI6ImIwUGlncUJOb2E4SUdhWFVxUlM4MFhqQmVxNTBKY0hpbk91WE9uRXo5cVE9IiwiaXNzIjoidXMxMTcuc2l0ZWdyb3VuZC51cyIsIm5iZiI6MTU3MzQwOTA1MCwiZXhwIjoxNTc0MDEzODUwLCJkYXRhIjp7InVzZXJJZCI6NDc3fX0.2HyGyjm6aUkMkD3ZuvXvoCj28bmHhCdqlEpTdL0xKtM")
                    .url("https://fastagingclone.flywheelsites.com/wp-json/app/v2/captain/upload_media")
                    .post(requestBody)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }



    }
}



