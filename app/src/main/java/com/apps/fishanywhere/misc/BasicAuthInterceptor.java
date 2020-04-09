package com.apps.fishanywhere.misc;

//import java.io.IOException;
//
//import okhttp3.Credentials;
//import okhttp3.Interceptor;
//import okhttp3.Request;
//import okhttp3.Response;

//import okhttp3.Interceptor;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicAuthInterceptor implements Interceptor {

    private String credentials;
    private String token;

    public BasicAuthInterceptor(String token) {
//        this.credentials = Credentials.basic(user);
        this.token= "Bearer "+token;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", token).build();
        return chain.proceed(authenticatedRequest);
    }
}
