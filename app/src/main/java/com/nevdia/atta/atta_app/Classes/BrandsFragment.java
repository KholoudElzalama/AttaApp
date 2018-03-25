package com.nevdia.atta.atta_app.Classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nevdia.atta.atta_app.Adapter.BrandsAdapter;
import com.nevdia.atta.atta_app.R;

import java.util.ArrayList;

/**
 * Created by hadirsamir on 24/03/18.
 */

public class BrandsFragment extends Fragment {
    private View brandView;
    private RecyclerView brandsRec;
    private BrandsAdapter brandsAdapter;
    private ArrayList<Brands> brandsArrayList;
    private RecyclerView.LayoutManager manager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        brandView = inflater.inflate(R.layout.brands_fragment, container, false);
        brandsRec = (RecyclerView) brandView.findViewById(R.id.brand_rec);
        brandsArrayList=new ArrayList<>();

        manager = new LinearLayoutManager(getActivity());
        brandsRec.setLayoutManager(manager);

        brandsAdapter=new BrandsAdapter(brandsArrayList,getActivity());
        brandsRec.setAdapter(brandsAdapter);



        return brandView;
    }
}
