package com.tally_meals.ics.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tally_meals.ics.Model.Notify_data;
import com.tally_meals.ics.R;

import java.util.ArrayList;

public class Notify_adapter  extends RecyclerView.Adapter<Notify_adapter.ViewHolder>
{
    //List<Cart_data> dataList;
    ArrayList<Notify_data> dataList;

    Activity mactivity;

    private int cpos;

    public Notify_adapter(Activity mactivity,  ArrayList<Notify_data> dataList)
    {
        this.mactivity=mactivity;
        this.dataList=dataList;
    }


    @Override
    public Notify_adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_notify,viewGroup,false);
        return new Notify_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Notify_adapter.ViewHolder viewHolder, final int i) {
        if (viewHolder != null) {
                Notify_data nob = dataList.get(i);
                viewHolder.txLink.setText(""+nob.getLink());
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txLink;

        public ViewHolder(View itemview) {
            super(itemview);
            txLink = (TextView) itemview.findViewById(R.id.txlink);
        }
    }
}
