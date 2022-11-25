package com.example.wheelsapp.ui.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wheelsapp.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListElement> mdata;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> mdata,Context context){
        this.mdata= mdata;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getItemCount(){return mdata.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
       View view = mInflater.inflate(R.layout.list_element,null);
       return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindDate(mdata.get(position));
    }

    public void setItems(List<ListElement> items ){ mdata = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView route,hour,stop1,stop2,stop3,driverName,model;

        ViewHolder(View itemView){
            super(itemView);
            route = itemView.findViewById(R.id.route);
            hour = itemView.findViewById(R.id.hour);
            stop1 = itemView.findViewById(R.id.stop1);
            stop2 = itemView.findViewById(R.id.stop2);
            stop3 = itemView.findViewById(R.id.stop3);
            driverName = itemView.findViewById(R.id.driverName);
            model = itemView.findViewById(R.id.model);
        }

        void bindDate(final ListElement item){
            route.setText(item.getRoute());
            hour.setText(item.getHour());
            stop1.setText(item.getStop1());
            stop2.setText(item.getStop2());
            stop3.setText(item.getStop3());
            driverName.setText(item.getDriverName());
            model.setText(item.getModel());
        }
    }

}
