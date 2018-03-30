package com.nevdia.atta.atta_app;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Classes.MainPartsClass;

public class MainItemDetailsActivity extends AppCompatActivity {
  private TextView title,price;
  private ImageView MainImage;
  private MainPartsClass mainPartsClass;
  ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_item_details);
        title=(TextView)findViewById(R.id.textView2);
        price=(TextView)findViewById(R.id.textView3);
        MainImage=(ImageView)findViewById(R.id.imageView2);

        mainPartsClass=(MainPartsClass) getIntent().getExtras().getSerializable("Maindata");
        title.setText(mainPartsClass.getMainData());


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     //   actionBar.setIcon(R.drawable.logo2);
    }
}
