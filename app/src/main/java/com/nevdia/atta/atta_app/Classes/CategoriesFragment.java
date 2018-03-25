package com.nevdia.atta.atta_app.Classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nevdia.atta.atta_app.R;

/**
 * Created by hadirsamir on 24/03/18.
 */

public class CategoriesFragment extends Fragment {
    private View catView;
    private Button categoryBtn, spareBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catView = inflater.inflate(R.layout.categories_fragment, container, false);
        categoryBtn = (Button) catView.findViewById(R.id.cat_btn);
        spareBtn =(Button) catView.findViewById(R.id.spare_btn);

        return catView;

    }
    public void CatEvent(View view){
        //categories list activity

    }
    public void SpareEvent(View view){
        //spareparts list activity
    }
}
