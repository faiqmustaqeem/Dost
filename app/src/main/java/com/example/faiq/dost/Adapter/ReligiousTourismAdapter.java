package com.example.faiq.dost.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.faiq.dost.Models.ReligiousTourismModel;
import com.example.faiq.dost.R;

import java.util.List;

/**
 * Created by CodianSoft on 29/01/2018.
 */

public class ReligiousTourismAdapter extends RecyclerView.Adapter<ReligiousTourismAdapter.MyViewHolder> {

    List<ReligiousTourismModel> list;
    Context context;

    public ReligiousTourismAdapter(List<ReligiousTourismModel> list,Context context)
    {
        this.list=list;
        this.context=context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.religious_tourism_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ReligiousTourismModel model=list.get(position);

        holder.title.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
        }
    }
}
