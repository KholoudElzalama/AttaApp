package com.nevdia.atta.atta_app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nevdia.atta.atta_app.Classes.Service;
import com.nevdia.atta.atta_app.R;

import java.util.ArrayList;

public class ServiceAdapter extends  RecyclerView.Adapter<ServiceAdapter.MyHolder> {
    private Context context ;
    private ArrayList<Service> phone_list;
    private  static  final String TAG = "Main parts adapter";
    private static final String BASEURL = "http://elatta-eg.com/";

    public ServiceAdapter(Context context, ArrayList<Service> mainList) {
        this.context = context;
        this.phone_list = mainList;
    }

    @Override
    public ServiceAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.service_item,parent,false);
        ServiceAdapter.MyHolder holder =new ServiceAdapter.MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ServiceAdapter.MyHolder holder, int position) {
        Service phone = phone_list.get(position);
        holder.name.setText("اسم الشركة : "+phone.getMaintenanceServiceName());
        holder.address.setText("العنوان : "+phone.getMaintenanceServiceAddress());
        holder.phones.setText("أرقام الهاتف : "+"\n" +phone.getMaintenanceServicePhones());
        Log.d("phoneAdapter",""+phone_list.get(position));

    }

    @Override
    public int getItemCount() {

        return phone_list.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {



        private TextView name,address,phones;
        private View parent;


        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            address= (TextView) itemView.findViewById(R.id.address);
            phones= (TextView) itemView.findViewById(R.id.phones);
            parent =itemView;
        }


    }
}
