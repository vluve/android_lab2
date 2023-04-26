package com.vluve.mmogames;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    public static final String base_url = "https://www.mmobomb.com/api1/";
    private static Retrofit retrofit = null;

    public static API_Interface getRetrofit(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(API_Interface.class);
    }
}
