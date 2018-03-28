package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactUSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
