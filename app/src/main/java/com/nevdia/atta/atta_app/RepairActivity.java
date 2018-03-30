package com.nevdia.atta.atta_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RepairActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //this number to call funcation retriveAllBrands from webservice //
    }



}
