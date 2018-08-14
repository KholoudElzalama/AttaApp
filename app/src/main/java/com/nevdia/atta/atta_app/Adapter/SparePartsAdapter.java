package com.nevdia.atta.atta_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Classes.SparePartsClass;
import com.nevdia.atta.atta_app.R;
import com.nevdia.atta.atta_app.SpareItemDetailsActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by hadirsamir on 27/03/18.
 */

public class SparePartsAdapter extends RecyclerView.Adapter<SparePartsAdapter.MyHolder> {
    private Context context ;
    private ArrayList<SparePartsClass> spareList;
    private  static  final String TAG = "Spare parts adapter";
    private static final String BASEURL = "http://elatta-eg.com/";

    public SparePartsAdapter(Context context, ArrayList<SparePartsClass> spareList) {
        this.context = context;
        this.spareList = spareList;
    }

    @Override
    public SparePartsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.mainparts_item,parent,false);
        SparePartsAdapter.MyHolder holder =new SparePartsAdapter.MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        SparePartsClass sparePartsClass = spareList.get(position);
        holder.setData(sparePartsClass);

    }


    @Override
    public int getItemCount() {
        return spareList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {



        private TextView TitleTextView;
        private CardView cardView;
        private View parent;


        public MyHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

            TitleTextView = (TextView) itemView.findViewById(R.id.textView);
            parent=itemView;


        }

        public void setData(final SparePartsClass sparePartsClass) {
            TitleTextView.setText(sparePartsClass.getMainData());
            try {
                Picasso.with(context).load(BASEURL + sparePartsClass.getImgSrcMini()).into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        cardView.setBackgroundDrawable(new BitmapDrawable(context.getResources(), bitmap));
                        Log.d(TAG, "done :D");
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        Log.d(TAG, "failed :(");
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        Log.d(TAG, "loading..... :)");
                      //  Log.d(TAG, sparePartsClass.getImgSrcMini());

                    }
                });
            }catch(Exception e){}
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SpareItemDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Sparedata",sparePartsClass);
                    intent.putExtras(bundle);
                    context.startActivity(intent);

                }
            });

        }

    }

}

