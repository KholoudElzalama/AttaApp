package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SparePartsActivity extends AppCompatActivity {
    private RecyclerView SpareView;
    private RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_parts);
        SpareView=(RecyclerView)findViewById(R.id.Spare_rec);

        manager = new LinearLayoutManager(this);
        SpareView.setLayoutManager(manager);

    }
}
