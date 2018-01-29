package com.example.faiq.dost.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.faiq.dost.Activities.PropertyDetailsActivity;
import com.example.faiq.dost.Models.HouseModel;
import com.example.faiq.dost.R;

import java.util.List;

/**
 * Created by CodianSoft on 29/01/2018.
 */

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.MyViewHolder> {
    List<HouseModel> list;
    Context context;

    public HouseAdapter(List<HouseModel> list,Context context)
    {
        this.list=list;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.house_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HouseModel model=list.get(position);

        holder.price.setText(model.getPrice());
        holder.desc1.setText(model.getDesc1());
        holder.desc2.setText(model.getDesc2());
        holder.sqft.setText(model.getSqft());
        holder.no_of_beds.setText(model.getNo_of_beds());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView price , desc1 , desc2 , sqft , no_of_beds;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            price=itemView.findViewById(R.id.house_price);
            desc1=itemView.findViewById(R.id.desc1);
            desc2=itemView.findViewById(R.id.desc2);
            sqft=itemView.findViewById(R.id.text_sq_ft);
            no_of_beds=itemView.findViewById(R.id.text_no_of_beds);
        }
    }
}
