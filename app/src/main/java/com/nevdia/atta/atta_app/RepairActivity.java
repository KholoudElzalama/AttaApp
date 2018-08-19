package com.nevdia.atta.atta_app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.api.Api;
import com.nevdia.atta.atta_app.Adapter.BrandsAdapter;
import com.nevdia.atta.atta_app.Adapter.PhoneNumbersAdapter;
import com.nevdia.atta.atta_app.Adapter.ServiceAdapter;
import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.Classes.Service;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepairActivity extends AppCompatActivity {


    private Drawable d;
    private Apis api;
    private Connection connection;
    private RecyclerView rv_phones;
    private ServiceAdapter adapter;
    private ArrayList<String> phone ;
    private LinearLayoutManager manager;
    ArrayList<Service> services ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //this number to call funcation retriveAllBrands from webservice //

        d = getResources().getDrawable(R.drawable.upperheader);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("");


        phone = new ArrayList<>();
        services=new ArrayList<>();
        phone.add("01010446229");

        rv_phones=findViewById(R.id.rv_phones);
        manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_phones.setLayoutManager(manager);
        getAllservices(1);

    }



    private void getAllservices(int retriveAllservices) {
        api = connection.connect().create(Apis.class);
        Log.d("Mazen1", "Problem " + api);
        Call<ArrayList<Service>> call = api.getAllServices(retriveAllservices);
        Log.d("Mazen2", "Problem " + call);
        call.enqueue(new Callback<ArrayList<Service>>() {
            @Override
            public void onResponse(Call<ArrayList<Service>> call, Response<ArrayList<Service>> response) {
                services = response.body();
                int resCOde = response.code();
               // progressBar.setVisibility(View.GONE);
                Log.d("servicesActivity",""+services.size());
                adapter = new ServiceAdapter(RepairActivity.this,services);
                rv_phones.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Service>> call, Throwable t) {

                Log.d("servicesActivity","failed" + t.getLocalizedMessage());
            }
        });
    }
}
