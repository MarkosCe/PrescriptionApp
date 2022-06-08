package com.proyect.prescriptionapp.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static final String BASEURL = "http://192.168.0.107/API_amsterdan/public/api/";
    //private static final String BASEURL = "http://127.0.0.1:8000/api/";
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if (retrofit == null){
            Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();

            retrofit = new retrofit2.Retrofit.Builder()
                                                .baseUrl(BASEURL)
                                                .addConverterFactory(GsonConverterFactory.create(gson))
                                                .build();
        }
        return retrofit;
    }
}
