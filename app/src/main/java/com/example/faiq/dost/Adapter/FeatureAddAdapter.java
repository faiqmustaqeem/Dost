package com.example.faiq.dost.Adapter;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.faiq.dost.Models.FeatureAddModel;
import com.example.faiq.dost.R;

import java.util.List;

/**
 * Created by faiq on 28/01/2018.
 */

public class FeatureAddAdapter extends RecyclerView.Adapter<FeatureAddAdapter.MyViewHolder> {

    List<FeatureAddModel> list;
    Context context;
public FeatureAddAdapter(List<FeatureAddModel> list,Context context)
{
    this.list=list;
    this.context=context;
}
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feature_add_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeatureAddModel model=list.get(position);

        holder.title.setText(model.getTitle());
        holder.price.setText(model.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title , price;
        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title1);
            price=(TextView)itemView.findViewById(R.id.price1);

        }
    }
}
