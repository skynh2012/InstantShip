package com.anhtd.instantship.network;

import com.anhtd.instantship.model.ResponeData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by anhtd on 5/21/2018.
 */

public interface UsersService {
    @POST("/api/createUser")
    Observable<ResponeData> register(@Query("role_id") int roleId,
                                     @Query("phone_number") String phoneNumber,
                                     @Query("password") String password,
                                     @Query("email") String email
    );
}
