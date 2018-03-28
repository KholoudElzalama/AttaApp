package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class CategoryActivity extends AppCompatActivity {
  private RecyclerView CategoryView;
    private RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_category);
        //CategoryView=(RecyclerView)findViewById(R.id.category_rec);

        manager = new LinearLayoutManager(this);
        CategoryView.setLayoutManager(manager);
    }
}
