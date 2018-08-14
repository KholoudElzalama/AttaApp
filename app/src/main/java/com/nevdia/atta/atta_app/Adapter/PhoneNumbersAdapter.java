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
import com.nevdia.atta.atta_app.MainPartItemsActivity;
import com.nevdia.atta.atta_app.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class PhoneNumbersAdapter extends  RecyclerView.Adapter<PhoneNumbersAdapter.MyHolder> {
    private Context context ;
    private ArrayList<String> phone_list;
    private  static  final String TAG = "Main parts adapter";
    private static final String BASEURL = "http://elatta-eg.com/";

    public PhoneNumbersAdapter(Context context, ArrayList<String> mainList) {
        this.context = context;
        this.phone_list = mainList;
    }

    @Override
    public PhoneNumbersAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
        PhoneNumbersAdapter.MyHolder holder =new PhoneNumbersAdapter.MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PhoneNumbersAdapter.MyHolder holder, int position) {
        String phone = phone_list.get(position);
        holder.TitleTextView.setText(phone);
        Log.d("phoneAdapter",""+phone_list.get(position));

    }

    @Override
    public int getItemCount() {

        return phone_list.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {



        private TextView TitleTextView;
        private View parent;


        public MyHolder(View itemView) {
            super(itemView);
            TitleTextView = (TextView) itemView.findViewById(android.R.id.text1);
            TitleTextView.setTextColor(context.getResources().getColor(android.R.color.white));
            TitleTextView.setPadding(0,0,0,0);
            parent =itemView;
          }


    }
}
