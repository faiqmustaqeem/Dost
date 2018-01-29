package com.example.faiq.dost.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.faiq.dost.Adapter.HouseAdapter;
import com.example.faiq.dost.Interfaces.RecycleTouchListener;
import com.example.faiq.dost.Models.HouseModel;
import com.example.faiq.dost.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HouseActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
@BindView(R.id.recycle_view_house)
    RecyclerView recyclerView;

    HouseAdapter adapter;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        activity=this;
        ButterKnife.bind(this);

        adapter = new HouseAdapter(getHouses() , getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecycleTouchListener(
                        activity, new RecycleTouchListener.OnItemClickListener(){
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                                Intent i1=new Intent(activity , PropertyDetailsActivity.class);
                                startActivity(i1);
                    }
                })
        );

    }

    List<HouseModel> getHouses()
    {
        List<HouseModel> list=new ArrayList<>();
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        list.add(new HouseModel("4 crore ","4 bed appartment available for sale...","crescent bay DHA Phase 8 , DHA Defence ..." , "2,600 sq. ft ", "4 Beds" , ""));
        return list;
    }
    @OnClick({R.id.back})
    void OnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.back:
                finish();
                break;
        }
    }
}
