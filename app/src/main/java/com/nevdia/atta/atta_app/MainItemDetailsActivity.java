package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainItemDetailsActivity extends AppCompatActivity {
  private TextView title,price;
  private ImageView MainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_item_details);
        title=(TextView)findViewById(R.id.textView2);
        price=(TextView)findViewById(R.id.textView3);
        MainImage=(ImageView)findViewById(R.id.imageView2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
