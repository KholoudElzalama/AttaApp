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

import com.nevdia.atta.atta_app.Classes.MainPartsClass;
import com.nevdia.atta.atta_app.MainItemDetailsActivity;
import com.nevdia.atta.atta_app.MainPartItemsActivity;
import com.nevdia.atta.atta_app.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by hadirsamir on 27/03/18.
 */

public class MainPartsAdapter extends  RecyclerView.Adapter<MainPartsAdapter.MyHolder> {
    private Context context ;
    private ArrayList<MainPartsClass> mainList;
    private  static  final String TAG = "Main parts adapter";
    private static final String BASEURL = "http://193.227.14.31/garar/";

    public MainPartsAdapter(Context context, ArrayList<MainPartsClass> mainList) {
        this.context = context;
        this.mainList = mainList;
    }

    @Override
    public MainPartsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.mainparts_item,parent,false);
        MainPartsAdapter.MyHolder holder =new MainPartsAdapter.MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainPartsAdapter.MyHolder holder, int position) {
        MainPartsClass mainpartsClass = mainList.get(position);
        holder.setData(mainpartsClass);

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {



        private TextView TitleTextView;
        private CardView cardView;
        private View parent;


        public MyHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

            TitleTextView = (TextView) itemView.findViewById(R.id.textView);
            parent =itemView;


        }

        public void setData(final MainPartsClass mainpartsClass) {

            TitleTextView.setText(mainpartsClass.getMainData());

            Picasso.with(context).load(BASEURL + mainpartsClass.getImgSrcMini()).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    cardView.setBackgroundDrawable(new BitmapDrawable(context.getResources(), bitmap));
                    Log.d(TAG,"done :D");
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        Log.d(TAG,"failed :(");
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        Log.d(TAG,"loading..... :)");
                        Log.d(TAG,mainpartsClass.getImgSrcMini());

                    }
                    });

                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, MainPartItemsActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("Maindata", mainpartsClass);
                            intent.putExtras(bundle);
                            context.startActivity(intent);

                        }
                    });

        }

    }
}
