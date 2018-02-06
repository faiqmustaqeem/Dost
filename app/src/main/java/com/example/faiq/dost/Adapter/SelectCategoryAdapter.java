package com.example.faiq.dost.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.faiq.dost.Activities.HouseActivity;
import com.example.faiq.dost.R;

import java.util.List;

/**
 * Created by faiq on 28/01/2018.
 */

public class SelectCategoryAdapter extends RecyclerView.Adapter<SelectCategoryAdapter.MyViewHolder> {

    List<String> list;
    Context context;

    public SelectCategoryAdapter( List<String> list,Context context)
    {
        this.list=list;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_category_item, parent, false);

        return new MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.text.setText(list.get(position).toString());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.text);
        }
    }
}
