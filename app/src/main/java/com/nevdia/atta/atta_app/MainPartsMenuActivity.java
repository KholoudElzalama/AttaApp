package com.nevdia.atta.atta_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nevdia.atta.atta_app.Adapter.MainPartsAdapter;
import com.nevdia.atta.atta_app.Classes.MainpartsClass;

import java.util.ArrayList;

public class MainPartsMenuActivity extends AppCompatActivity {
  private RecyclerView MainRec;
    private MainPartsAdapter mainPartsAdapter;
    private ArrayList<MainpartsClass> MainArrayList;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parts_menu);
        MainRec=(RecyclerView)findViewById(R.id.mainRec);
        MainArrayList=new ArrayList<>();
        mainPartsAdapter=new MainPartsAdapter(this,MainArrayList);
        manager = new LinearLayoutManager(this);
        MainRec.setLayoutManager(manager);
        MainRec.setAdapter(mainPartsAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
