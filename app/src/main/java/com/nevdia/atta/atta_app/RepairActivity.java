package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepairActivity extends AppCompatActivity {

    Apis brandsApi;
    Connection connection;
    ArrayList<Brands> brandsArrayList;
    TextView testTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        testTxt = (TextView)findViewById(R.id.testTxt);
        getAllCats(1); //this number to call funcation retriveAllBrands from webservice //
    }


    private void getAllCats(int retriveAllBrands){
        brandsApi = connection.connect().create(Apis.class);
        Log.d("Mazen1","Problem "+brandsApi);
        Call<ArrayList<Brands>> call = brandsApi.getMyBrand(retriveAllBrands);
        Log.d("Mazen2","Problem "+call);
        call.enqueue(new Callback<ArrayList<Brands>>() {
            @Override
            public void onResponse(Call<ArrayList<Brands>> call, Response<ArrayList<Brands>> response) {
                brandsArrayList = response.body();
                int resCOde = response.code();
               // Log.d("Mazen3","Test Result "+resCOde);
               // Log.d("Mazen3","Test Result "+brandsArrayList.get(0).getBrandName());

                    testTxt.setText(brandsArrayList.get(0).getBrandName() + "\n");

            }

            @Override
            public void onFailure(Call<ArrayList<Brands>> call, Throwable t) {

            }
        });
    }

}
