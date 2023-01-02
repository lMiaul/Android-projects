package com.example.myapib1m.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionREST {
    private static final String URL = "http://ddiazuniversidad-001-site1.gtempurl.com/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getConnection(){

        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
