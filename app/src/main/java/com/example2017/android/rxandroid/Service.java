package com.example2017.android.rxandroid;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by M7moud on 23-Dec-18.
 */
public interface Service {
    String baseURL="https://api.github.com/users/";

    @GET("mahmoudelgamal1997/repos")
    Observable<ArrayList <Example>> method();
}
