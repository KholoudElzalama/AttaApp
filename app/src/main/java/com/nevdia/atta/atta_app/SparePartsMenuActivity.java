package com.nevdia.atta.atta_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nevdia.atta.atta_app.Adapter.SparePartsAdapter;
import com.nevdia.atta.atta_app.Classes.SparePartsClass;

import java.util.ArrayList;

public class SparePartsMenuActivity extends AppCompatActivity {

    private RecyclerView spareRec;
    private SparePartsAdapter sparePartsAdapter;
    private ArrayList<SparePartsClass> SpareArrayList;
    private RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_parts_menu);
        spareRec=(RecyclerView) findViewById(R.id.spareRec) ;
        SpareArrayList=new ArrayList<>();
        sparePartsAdapter=new SparePartsAdapter(this,SpareArrayList);
        manager = new LinearLayoutManager(this);
        spareRec.setLayoutManager(manager);
        spareRec.setAdapter(sparePartsAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
