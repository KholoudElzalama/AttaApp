package com.nevdia.atta.atta_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Classes.MainPartsClass;

public class MainItemDetailsActivity extends AppCompatActivity {
  private TextView title,price;
  private ImageView MainImage;
  private MainPartsClass mainPartsClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_item_details);
        title=(TextView)findViewById(R.id.textView2);
        price=(TextView)findViewById(R.id.textView3);
        MainImage=(ImageView)findViewById(R.id.imageView2);

        mainPartsClass=(MainPartsClass) getIntent().getExtras().getSerializable("Maindata");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
