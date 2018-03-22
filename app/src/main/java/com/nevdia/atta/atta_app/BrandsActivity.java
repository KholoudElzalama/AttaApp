package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandsActivity extends AppCompatActivity {

    Apis brandsApi;
    Connection connection;
    ArrayList<Brands> brandsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);
        getAllCats();
    }


    private void getAllCats(){
           brandsApi = connection.connect().create(Apis.class);
        Log.d("Mazen1","Problem "+brandsApi);
           Call<ArrayList<Brands>> call = brandsApi.getMyBrand();
        Log.d("Mazen2","Problem "+call);
        call.enqueue(new Callback<ArrayList<Brands>>() {
            @Override
            public void onResponse(Call<ArrayList<Brands>> call, Response<ArrayList<Brands>> response) {
                brandsArrayList = response.body();
                Log.d("Mazen3","Problem "+brandsArrayList.get(0).getBrandName());
            }

            @Override
            public void onFailure(Call<ArrayList<Brands>> call, Throwable t) {

            }
        });
    }


}
