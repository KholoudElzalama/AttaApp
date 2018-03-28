package com.nevdia.atta.atta_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parts_menu);
        MainRec=(RecyclerView)findViewById(R.id.mainRec);
        MainArrayList=new ArrayList<>();

        manager = new LinearLayoutManager(this);
        MainRec.setLayoutManager(manager);

        getAllCats(1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void getAllCats(int retriveAllCats){
        brandsApi = connection.connect().create(Apis.class);
        Call<ArrayList<MainPartsClass>> call = brandsApi.getMyCats(retriveAllCats);
        call.enqueue(new Callback<ArrayList<MainPartsClass>>() {
            @Override
            public void onResponse(Call<ArrayList<MainPartsClass>> call, Response<ArrayList<MainPartsClass>> response) {
                MainArrayList = response.body();
                int resCOde = response.code();
                Log.d("Mazen3","Test Result "+resCOde);
                Log.d("Mazen3","Test Result "+MainArrayList.get(0).getId());

                mainPartsAdapter = new MainPartsAdapter(MainPartsMenuActivity.this,MainArrayList);
                MainRec.setAdapter(mainPartsAdapter);

            }


            @Override
            public void onFailure(Call<ArrayList<MainPartsClass>> call, Throwable t) {

            }
        });

    }
}
