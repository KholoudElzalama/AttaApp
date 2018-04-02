package com.nevdia.atta.atta_app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button categoryBtn, spareBtn;
    private Drawable d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        categoryBtn = (Button) findViewById(R.id.cat_btn);
        spareBtn =(Button) findViewById(R.id.spare_btn);


        categoryBtn.setOnClickListener(this);
        spareBtn.setOnClickListener(this);
        d= getResources().getDrawable(R.drawable.shadow);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cat_btn:
                Intent intent1 = new Intent(CategoriesActivity.this,MainPartsMenuActivity.class);
                startActivity(intent1);
                break;
            case R.id.spare_btn:
                Intent intent = new Intent(CategoriesActivity.this,SparePartsMenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
