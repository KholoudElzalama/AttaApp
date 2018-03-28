package com.nevdia.atta.atta_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_parts_menu);
        spareRec=(RecyclerView) findViewById(R.id.spareRec) ;
        SpareArrayList=new ArrayList<>();

        manager = new LinearLayoutManager(this);
        spareRec.setLayoutManager(manager);

        getAllSpare(1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void getAllSpare(int retriveAllSparePartsCats){
        brandsApi = connection.connect().create(Apis.class);
        Call<ArrayList<SparePartsClass>> call = brandsApi.getMySpare(retriveAllSparePartsCats);
        call.enqueue(new Callback<ArrayList<SparePartsClass>>() {
            @Override
            public void onResponse(Call<ArrayList<SparePartsClass>> call, Response<ArrayList<SparePartsClass>> response) {
                SpareArrayList = response.body();
                int resCOde = response.code();

                sparePartsAdapter = new SparePartsAdapter(SparePartsMenuActivity.this,SpareArrayList);
                spareRec.setAdapter(sparePartsAdapter);

            }


            @Override
            public void onFailure(Call<ArrayList<SparePartsClass>> call, Throwable t) {

            }
        });
    }
}
