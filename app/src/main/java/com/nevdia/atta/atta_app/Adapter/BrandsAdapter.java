package com.nevdia.atta.atta_app.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by hadirsamir on 25/03/18.
 */

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.MyHolder> {
    private ArrayList<Brands> list ;
    private Context context ;

    public BrandsAdapter(ArrayList<Brands> list, Context context ) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BrandsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.brands_items,parent,false);
        MyHolder holder =new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BrandsAdapter.MyHolder holder, int position) {
        Brands brands = list.get(position);
        holder.setData(brands);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyHolder extends RecyclerView.ViewHolder {


        private ImageView imageView;
        private TextView TitleTextView;
        private CardView cardView;



        public MyHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.card_view);
            imageView =(ImageView) itemView.findViewById(R.id.imageView);
            TitleTextView=(TextView)itemView.findViewById(R.id.textView) ;




        }



        public void setData(Brands brands) {
            TitleTextView.setText(brands.getBrandName());
            try {

                Picasso.with(context).load(brands.getImgSrc().toString()).centerCrop().placeholder(R.drawable.logo).into(imageView);
            }
            catch (Exception e){
                Log.d("Brands Adapter","msg : "+e.toString());
                Picasso.with(context).load(R.drawable.logo).into(imageView);}
      }

    }

}
