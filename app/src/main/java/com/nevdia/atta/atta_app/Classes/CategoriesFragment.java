package com.nevdia.atta.atta_app.Classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nevdia.atta.atta_app.R;

import java.util.HashMap;

/**
 * Created by hadirsamir on 24/03/18.
 */

public class CategoriesFragment extends Fragment {
    private View catView;
    private Button categoryBtn, spareBtn;
    private SliderLayout mDemoSlider;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catView = inflater.inflate(R.layout.categories_fragment, container, false);
        categoryBtn = (Button) catView.findViewById(R.id.cat_btn);
        spareBtn =(Button) catView.findViewById(R.id.spare_btn);
        mDemoSlider = (SliderLayout)catView.findViewById(R.id.slider);


        final HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Desert",R.drawable.desert);
        file_maps.put("Flower",R.drawable.flowers);
        file_maps.put("Android Versions",R.drawable.android_versions);
        file_maps.put("Jelly fish", R.drawable.jellyfish);



        for(final String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            Toast.makeText(getActivity(),file_maps.get(name), Toast.LENGTH_SHORT).show();
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



        return catView;

    }
    public void CatEvent(View view){
        //categories list activity

    }
    public void SpareEvent(View view){
        //spareparts list activity
    }
}
