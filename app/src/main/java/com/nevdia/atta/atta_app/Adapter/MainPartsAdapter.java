package com.nevdia.atta.atta_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Classes.MainPartsClass;
import com.nevdia.atta.atta_app.MainItemDetailsActivity;
import com.nevdia.atta.atta_app.R;

import java.util.ArrayList;

/**
 * Created by hadirsamir on 27/03/18.
 */

public class MainPartsAdapter extends  RecyclerView.Adapter<MainPartsAdapter.MyHolder> {
    private Context context ;
    private ArrayList<MainPartsClass> mainList;

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

        public void setData(MainPartsClass mainpartsClass) {

            TitleTextView.setText(mainpartsClass.getMainData());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainItemDetailsActivity.class);
                    context.startActivity(intent);

                }
            });

        }

    }
}
