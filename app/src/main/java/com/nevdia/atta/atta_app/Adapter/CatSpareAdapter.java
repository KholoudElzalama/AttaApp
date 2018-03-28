package com.nevdia.atta.atta_app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.R;

/**
 * Created by hadirsamir on 25/03/18.
 */

public class CatSpareAdapter extends RecyclerView.Adapter<CatSpareAdapter.MyHolder> {
    private Context context;
    // arraylist of the class

    public CatSpareAdapter(Context context) {
        this.context = context;
        //initialize array list in constructor
    }

    @Override
    public CatSpareAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.categ_spare_item,parent,false);
        CatSpareAdapter.MyHolder holder =new CatSpareAdapter.MyHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(CatSpareAdapter.MyHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class MyHolder extends RecyclerView.ViewHolder {



        private TextView textView;



        public MyHolder(View itemView) {
            super(itemView);


            textView=(TextView)itemView.findViewById(R.id.textView) ;




        }


        public void setData(Brands brands) {
            //textView.setText();

        }

    }
}
