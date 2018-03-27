package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nevdia.atta.atta_app.Adapter.BrandsAdapter;
import com.nevdia.atta.atta_app.Classes.Brands;

import java.util.ArrayList;

public class BrandsMenuActivity extends AppCompatActivity {
    private View brandView;
    private RecyclerView brandsRec;
    private BrandsAdapter brandsAdapter;
    private ArrayList<Brands> brandsArrayList;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands_menu);
        brandsRec = (RecyclerView) findViewById(R.id.brand_rec);
        brandsArrayList=new ArrayList<>();

        manager = new LinearLayoutManager(this);
        brandsRec.setLayoutManager(manager);

        brandsAdapter=new BrandsAdapter(brandsArrayList,this);
        brandsRec.setAdapter(brandsAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
