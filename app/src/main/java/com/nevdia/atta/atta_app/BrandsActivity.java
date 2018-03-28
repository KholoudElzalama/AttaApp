package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Adapter.BrandsAdapter;
import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);


    }





}
