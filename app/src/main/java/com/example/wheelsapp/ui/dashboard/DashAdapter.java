package com.example.wheelsapp.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wheelsapp.R;

import java.util.List;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder>{
    private List<DashElement> mdata;
    private LayoutInflater mInflater;
    private Context context;

    public DashAdapter(List<DashElement> mdata, Context context){
        this.mdata= mdata;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getItemCount(){return mdata.size();}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
       View view = mInflater.inflate(R.layout.dashboard_element,null);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindDate(mdata.get(position));
    }

    public void setItems(List<DashElement> items ){ mdata = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView route;
        TextView hour;
        TextView stop1;
        TextView stop2;
        TextView stop3;

        ViewHolder(View itemView){
            super(itemView);
            route = itemView.findViewById(R.id.route);
            hour = itemView.findViewById(R.id.hour);
            stop1 = itemView.findViewById(R.id.stop1);
            stop2 = itemView.findViewById(R.id.stop2);
            stop3 = itemView.findViewById(R.id.stop3);
        }

        void bindDate(final DashElement item){
            route.setText(item.getRoute());
            hour.setText(item.getHour());
            stop1.setText(item.getStop1());
            stop2.setText(item.getStop2());
            stop3.setText(item.getStop3());
        }
    }

}
