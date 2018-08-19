package com.nevdia.atta.atta_app;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.nevdia.atta.atta_app.Classes.MainPartItem;
import com.nevdia.atta.atta_app.Classes.MainPartsClass;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainItemDetailsActivity extends AppCompatActivity {
  private TextView title,price,barcode,info;
  private ImageView MainImage;
  private MainPartItem mainPartsClass;
  private MainPartsClass mainPartItem;
  private LinearLayout layout;
    private static final String BASEURL = "http://elatta-eg.com/";
  ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_item_details);
        title=(TextView)findViewById(R.id.label);
        price=(TextView)findViewById(R.id.price);
        barcode=(TextView)findViewById(R.id.code);
        info=findViewById(R.id.info);
       // MainImage=(ImageView)findViewById(R.id.imageView2);
        layout =(LinearLayout)findViewById(R.id.layout);

        Drawable d = getResources().getDrawable(R.drawable.upperheader);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        mainPartsClass=(MainPartItem) getIntent().getExtras().getSerializable("Maindata");
        mainPartItem =(MainPartsClass) getIntent().getExtras().getSerializable("Itemdata");
        title.setText(" الاســم : "+mainPartsClass.getItemName());
        price.setText(" الســعر : "+mainPartsClass.getItemPrice()+" ج.م ");
        barcode.setText(" الكــود : "+mainPartsClass.getBarcode());
        info.setText(" الوصـــف : "+mainPartsClass.getItemDesc());




        Log.d("Tag", mainPartsClass.getImgSrcMini());
        Picasso.with(this).load(BASEURL + mainPartsClass.getImgSrcMini()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                layout.setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
                Log.d("Tag","done :D");
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Log.d("Tag","failed :(");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                Log.d("Tag","loading..... :)");


            }
        });



     //   actionBar.setIcon(R.drawable.logo2);
    }
}
