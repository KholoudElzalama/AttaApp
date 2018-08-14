package com.nevdia.atta.atta_app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nevdia.atta.atta_app.Adapter.PhoneNumbersAdapter;

import java.util.ArrayList;

public class RepairActivity extends AppCompatActivity {


    private Drawable d;
    private RecyclerView rv_phones;
    private PhoneNumbersAdapter adapter;
    private ArrayList<String> phone ;
    private LinearLayoutManager manager;
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
        phone.add("01010446229");

        rv_phones=findViewById(R.id.rv_phones);
        adapter = new PhoneNumbersAdapter(this,phone);
        manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_phones.setAdapter(adapter);
        rv_phones.setLayoutManager(manager);


    }



}
