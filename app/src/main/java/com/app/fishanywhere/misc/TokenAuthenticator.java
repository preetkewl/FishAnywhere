//package com.example.fishanywhere.misc;
//
////import java.io.IOException;
////import java.net.Authenticator;
////import java.net.Proxy;
////
////import okhttp3.Request;
////import okhttp3.Response;
//
//import android.net.Proxy;
//
//import java.io.IOException;
//
//import okhttp3.Authenticator;
//import okhttp3.Request;
//import okhttp3.Response;
//
//public class TokenAuthenticator implements Authenticator {
//    private String newAccessToken;
//    @Override
//    public Request authenticate(Proxy proxy, Response response) throws IOException {
//        // Refresh your access_token using a synchronous api request
//        Object service = null;
//        newAccessToken = service.refreshToken();
//
//        // Add new header to rejected request and retry it
//        return response.request().newBuilder()
//                .header(AUTHORIZATION, newAccessToken)
//                .build();
//    }
//
//    @Override
//    public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
//        // Null indicates no attempt to authenticate.
//        return null;
//    }
//}
