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
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.nevdia.atta.atta_app.Classes.MainPartItem;
import com.nevdia.atta.atta_app.Classes.MainPartsClass;
import com.nevdia.atta.atta_app.MainItemDetailsActivity;
import com.nevdia.atta.atta_app.MainPartItemsActivity;
import com.nevdia.atta.atta_app.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class MainItemAdapter extends  RecyclerView.Adapter<MainItemAdapter.MyHolder> {
    private Context context ;
    private ArrayList<MainPartItem> mainList;
    private MainPartsClass mainPartsClass;
    private static final String BASEURL = "http://elatta-eg.com/";

    public MainItemAdapter(Context context, ArrayList<MainPartItem> mainList,MainPartsClass mainPartsClass) {
        this.context = context;
        this.mainList = mainList;
        this.mainPartsClass = mainPartsClass;
    }

    @Override
    public MainItemAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.main_part_items,parent,false);
        MainItemAdapter.MyHolder holder =new MainItemAdapter.MyHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(MainItemAdapter.MyHolder holder, int position) {
        MainPartItem mainPartItem = mainList.get(position);
        holder.setData(mainPartItem);

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {



        private TextView TitleTextView;
        private CardView cardView;
        private View parent;
        private CircularImageView img;


        public MyHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            img =(CircularImageView)itemView.findViewById(R.id.img);
            TitleTextView = (TextView) itemView.findViewById(R.id.textView);
            parent =itemView;


        }

        public void setData(final MainPartItem mainpartitem) {

            TitleTextView.setText(mainpartitem.getItemName());

            Picasso.with(context).load(BASEURL +mainpartitem.getImgSrcMini()).into(img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainItemDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Maindata", mainpartitem);
                    bundle.putSerializable("Itemdata", mainPartsClass);
                    intent.putExtras(bundle);
                    context.startActivity(intent);

                }
            });

        }

    }

}
