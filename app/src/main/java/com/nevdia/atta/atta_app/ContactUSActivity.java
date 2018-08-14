package com.nevdia.atta.atta_app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.nevdia.atta.atta_app.Adapter.PhoneNumbersAdapter;

import java.util.ArrayList;

public class ContactUSActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Drawable d;
    private TextView tv_email, tv_fb;
    private MapView map;
    private GoogleMap gmap;
    private RecyclerView rv_phones;
    private PhoneNumbersAdapter adapter;
    private ArrayList<String> phone ;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        d = getResources().getDrawable(R.drawable.upperheader);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("");


        phone = new ArrayList<>();
        phone.add("0473223163");
        phone.add("0473210644");
        phone.add("01010446229");


        tv_email = findViewById(R.id.tv_email);
        tv_fb = findViewById(R.id.tv_fb);
        map = findViewById(R.id.mapView);
        rv_phones=findViewById(R.id.rv_phones);


        map.getMapAsync(this);
        tv_email.setText("mh_saadatta@yahoo.com");
        tv_fb.setText("شركة عطا للميكنة الزراعية");
        tv_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/attaagriculture/?hc_ref=ARQcea7zbtv_KMH1DMZX0k6oEjYhvhUsinHXL3achCwcdpMMFYu7dck1spb3w8AD4O0&fref=tag")));
            }
        });


        adapter = new PhoneNumbersAdapter(this,phone);
        manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_phones.setAdapter(adapter);
        rv_phones.setLayoutManager(manager);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("MAP","readyyyyy");
        gmap = googleMap;
        gmap.setMinZoomPreference(12);
        LatLng ny = new LatLng(40.7143528, -74.0059731);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
    }

}
