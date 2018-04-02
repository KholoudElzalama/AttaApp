package com.nevdia.atta.atta_app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.nevdia.atta.atta_app.Adapter.MainPartsAdapter;
import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.MainPartsClass;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPartsMenuActivity extends AppCompatActivity {
  private RecyclerView MainRec;
    private MainPartsAdapter mainPartsAdapter;
    private ArrayList<MainPartsClass> MainArrayList;
    private RecyclerView.LayoutManager manager;
    private Apis brandsApi;
    private Connection connection;
    private ProgressBar progressBar;
    private Drawable d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parts_menu);

        MainRec=(RecyclerView)findViewById(R.id.mainRec);
        progressBar=(ProgressBar)findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        MainArrayList=new ArrayList<>();

        manager = new LinearLayoutManager(this);
        MainRec.setLayoutManager(manager);

        getAllCats(1);
        d= getResources().getDrawable(R.drawable.logo4);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");





    }
    private void getAllCats(int retriveAllMainEquipmentCats ){
        brandsApi = connection.connect().create(Apis.class);
        Call<ArrayList<MainPartsClass>> call = brandsApi.getMyCats(retriveAllMainEquipmentCats);
        call.enqueue(new Callback<ArrayList<MainPartsClass>>() {
            @Override
            public void onResponse(Call<ArrayList<MainPartsClass>> call, Response<ArrayList<MainPartsClass>> response) {
                MainArrayList = response.body();
                int resCOde = response.code();
                Log.d("Mazen3","Test Result "+resCOde);
                Log.d("Mazen3","Test Result "+MainArrayList.get(0).getId());
                progressBar.setVisibility(View.GONE);
                mainPartsAdapter = new MainPartsAdapter(MainPartsMenuActivity.this,MainArrayList);
                MainRec.setAdapter(mainPartsAdapter);

            }


            @Override
            public void onFailure(Call<ArrayList<MainPartsClass>> call, Throwable t) {

            }
        });

    }
}
