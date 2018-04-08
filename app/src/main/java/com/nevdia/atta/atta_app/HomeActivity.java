package com.nevdia.atta.atta_app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button catBtn,Brandbtn,repairBtn,contactBtn;
    private SliderLayout mDemoSlider;
    private Drawable d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        catBtn=(Button)findViewById(R.id.firstbtn);
        Brandbtn=(Button)findViewById(R.id.secbtn);
        repairBtn=(Button)findViewById(R.id.thirdbtn);
        contactBtn=(Button)findViewById(R.id.fourthbtn);
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        catBtn.setOnClickListener(this);
        Brandbtn.setOnClickListener(this);
        repairBtn.setOnClickListener(this);
        contactBtn.setOnClickListener(this);

        final HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("truck1",R.drawable.g1);
        file_maps.put("truck2",R.drawable.g2);
        file_maps.put("truck3",R.drawable.g3);
        file_maps.put("truck4", R.drawable.g4);
        file_maps.put("truck5", R.drawable.g5);


        d= getResources().getDrawable(R.drawable.upperheader);
        getSupportActionBar().setBackgroundDrawable(d);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("");

        for(final String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView

                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    //Toast.makeText(HomeActivity.this,file_maps.get(name), Toast.LENGTH_SHORT).show();
                }
            });


            mDemoSlider.addSlider(textSliderView);
        }


        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("Slider Demo", "Page Changed: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstbtn:
                Intent intent = new Intent(HomeActivity.this,CategoriesActivity.class);
                startActivity(intent);
             break;
            case R.id.secbtn:
                Intent intent1 = new Intent(HomeActivity.this,BrandsMenuActivity.class);
                startActivity(intent1);
             break;
            case R.id.thirdbtn:
                Intent intent2= new Intent(HomeActivity.this,RepairActivity.class);
                startActivity(intent2);

                break;
            case R.id.fourthbtn:
                Intent intent3 = new Intent(HomeActivity.this,ContactUSActivity.class);
                startActivity(intent3);
                break;
        }
    }
}