package com.nevdia.atta.atta_app.Api;

import com.nevdia.atta.atta_app.Classes.Brands;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Eng.Mazen on 3/22/2018.
 */

public interface Apis {
    @POST("")
    Call<ArrayList<Brands>> getMyBrand();
}
