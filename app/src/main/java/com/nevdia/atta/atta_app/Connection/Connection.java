package com.nevdia.atta.atta_app.Connection;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eng.Mazen on 3/22/2018.
 */

public class Connection {

    public static final String Base_url = "http://elatta-eg.com/webservices/";
    public static Retrofit retrofit = null;

    public static Retrofit connect(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Base_url).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        Log.d("Mazen0","Test Result "+retrofit);
        return retrofit;
    }


}
