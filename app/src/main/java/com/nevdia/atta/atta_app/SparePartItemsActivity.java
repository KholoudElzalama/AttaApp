package com.nevdia.atta.atta_app;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.nevdia.atta.atta_app.Adapter.MainItemAdapter;
import com.nevdia.atta.atta_app.Api.Apis;
import com.nevdia.atta.atta_app.Classes.MainPartItem;
import com.nevdia.atta.atta_app.Classes.MainPartsClass;
import com.nevdia.atta.atta_app.Connection.Connection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SparePartItemsActivity extends AppCompatActivity {

    private static final String TAG = "SparePartItemsActivity" ;
    private Drawable d;
    private RecyclerView MainRec;
    private Apis Api;
    private Connection connection;
    private ArrayList<MainPartItem> items;
    private MainPartsClass item;
    private MainItemAdapter mainItemAdapter;
    private  RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_part_items);
        d= getResources().getDrawable(R.drawable.upperheader);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        MainRec = (RecyclerView) findViewById(R.id.recycle);
        items = new ArrayList<>();
        item = new MainPartsClass();
        item =(MainPartsClass) getIntent().getExtras().getSerializable("Sparedata");
        manager = new LinearLayoutManager(this);
        MainRec.setLayoutManager(manager);
        d= getResources().getDrawable(R.drawable.upperheader);
        getAllItems(1,item.getId());
    }


    private void getAllItems(int retrieveAllItems , String id) {
        Api = connection.connect().create(Apis.class);
        Log.d("Mazen1", "Problem " + Api);
        Call<ArrayList<MainPartItem>> call = Api.getAllMainItems(retrieveAllItems,id);
        Log.d("Mazen2", "Problem " + call);
        call.enqueue(new Callback<ArrayList<MainPartItem>>() {
            @Override
            public void onResponse(Call<ArrayList<MainPartItem>> call, Response<ArrayList<MainPartItem>> response) {
                items = response.body();
                int resCOde = response.code();
                Log.d(TAG, "Test Result " + items.get(0).getItemName());
                //Log.d("Mazen3", "Test Result " + brandsArrayList.get(0).getBrandName());
                // progressBar.setVisibility(View.GONE);
                if(items.get(0).getStatus()!=null){
                    Toast.makeText(SparePartItemsActivity.this,"لا يوجد منتجات في هذا الصنف",Toast.LENGTH_LONG).show();
                }
                else {
                    mainItemAdapter = new MainItemAdapter(SparePartItemsActivity.this, items, item);
                    MainRec.setAdapter(mainItemAdapter);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<MainPartItem>> call, Throwable t) {
                Log.d(TAG, "Test Result : " + "failed");
            }
        });
    }
}
