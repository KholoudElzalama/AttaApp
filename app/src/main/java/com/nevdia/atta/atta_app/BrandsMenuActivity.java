package com.nevdia.atta.atta_app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.nevdia.atta.atta_app.Adapter.BrandsAdapter;
import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandsMenuActivity extends AppCompatActivity {
    private RecyclerView brandsRec;
    private BrandsAdapter brandsAdapter;
    private ArrayList<Brands> brandsArrayList;
    private RecyclerView.LayoutManager manager;
    private Apis brandsApi;
    private Connection connection;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands_menu);
        brandsRec = (RecyclerView) findViewById(R.id.brand_rec);
        progressBar =(ProgressBar)findViewById(R.id.progress) ;
        progressBar.setVisibility(View.VISIBLE);
        brandsArrayList = new ArrayList<>();

        manager = new LinearLayoutManager(this);
        brandsRec.setLayoutManager(manager);
        getAllBrands(1);
        Drawable d = getResources().getDrawable(R.drawable.upperheader);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


    }

    private void getAllBrands(int retriveAllBrands) {
        brandsApi = connection.connect().create(Apis.class);
        Log.d("Mazen1", "Problem " + brandsApi);
        Call<ArrayList<Brands>> call = brandsApi.getMyBrand(retriveAllBrands);
        Log.d("Mazen2", "Problem " + call);
        call.enqueue(new Callback<ArrayList<Brands>>() {
            @Override
            public void onResponse(Call<ArrayList<Brands>> call, Response<ArrayList<Brands>> response) {
                brandsArrayList = response.body();
                int resCOde = response.code();
               // Log.d("Mazen3", "Test Result " + resCOde);
                //Log.d("Mazen3", "Test Result " + brandsArrayList.get(0).getBrandName());
                progressBar.setVisibility(View.GONE);
                brandsAdapter = new BrandsAdapter(brandsArrayList, BrandsMenuActivity.this);
                brandsRec.setAdapter(brandsAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Brands>> call, Throwable t) {

            }
        });
    }
}
