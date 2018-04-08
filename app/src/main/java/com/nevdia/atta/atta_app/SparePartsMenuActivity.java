package com.nevdia.atta.atta_app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.nevdia.atta.atta_app.Adapter.SparePartsAdapter;
import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.SparePartsClass;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SparePartsMenuActivity extends AppCompatActivity {

    private RecyclerView spareRec;
    private SparePartsAdapter sparePartsAdapter;
    private ArrayList<SparePartsClass> SpareArrayList;
    private RecyclerView.LayoutManager manager;
    private Apis brandsApi;
    private Connection connection;
    private ProgressBar progressBar;
    private Drawable d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_parts_menu);
        spareRec=(RecyclerView) findViewById(R.id.spareRec) ;
        progressBar = (ProgressBar)findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        SpareArrayList=new ArrayList<>();

        manager = new LinearLayoutManager(this);
        spareRec.setLayoutManager(manager);

        getAllSpare(1);
        d= getResources().getDrawable(R.drawable.upperheader);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


    }
    private void getAllSpare(int retriveAllSparePartsCats){
        brandsApi = connection.connect().create(Apis.class);
        Call<ArrayList<SparePartsClass>> call = brandsApi.getMySpare(retriveAllSparePartsCats);
        call.enqueue(new Callback<ArrayList<SparePartsClass>>() {
            @Override
            public void onResponse(Call<ArrayList<SparePartsClass>> call, Response<ArrayList<SparePartsClass>> response) {
                SpareArrayList = response.body();
                int resCOde = response.code();
                progressBar.setVisibility(View.GONE);
                sparePartsAdapter = new SparePartsAdapter(SparePartsMenuActivity.this,SpareArrayList);
                spareRec.setAdapter(sparePartsAdapter);

            }


            @Override
            public void onFailure(Call<ArrayList<SparePartsClass>> call, Throwable t) {

            }
        });
    }
}
