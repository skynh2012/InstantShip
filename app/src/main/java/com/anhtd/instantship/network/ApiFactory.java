package com.anhtd.instantship.network;

import com.anhtd.instantship.config.Contanst;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by anhtd on 5/21/2018.
 */

public class ApiFactory {
    public static UsersService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Contanst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(UsersService.class);
    }

}
