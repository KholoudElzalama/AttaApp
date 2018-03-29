package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SpareItemDetailsActivity extends AppCompatActivity {
    private TextView title ,price;
    private ImageView SpareImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spare_item_details);
        title=(TextView)findViewById(R.id.textView4);
        price=(TextView)findViewById(R.id.textView5);
        SpareImage=(ImageView)findViewById(R.id.imageView3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
