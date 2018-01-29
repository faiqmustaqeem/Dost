package com.example.faiq.dost.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.faiq.dost.Adapter.FeatureAddAdapter;
import com.example.faiq.dost.Adapter.SelectCategoryAdapter;
import com.example.faiq.dost.Interfaces.RecycleTouchListener;
import com.example.faiq.dost.Models.FeatureAddModel;
import com.example.faiq.dost.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

public class SelectCategory extends AppCompatActivity {


    @BindView(R.id.recycleview1)
    RecyclerView recyclerView1;
    @BindView(R.id.recycleview2)
    RecyclerView recyclerView2;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    SelectCategoryAdapter adapter1;
    FeatureAddAdapter adapter2;

    @BindView(R.id.back)
    ImageView back;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        ButterKnife.bind(this);

        activity=this;

        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        adapter1 = new SelectCategoryAdapter(getSelection() , getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(adapter1);

        recyclerView1.addOnItemTouchListener(new RecycleTouchListener(
                        activity, new RecycleTouchListener.OnItemClickListener(){
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        //Toast.makeText(getActivity() , "item "+position , Toast.LENGTH_LONG).show();
                        switch (position)
                        {
                            case 2:

                                Intent i1=new Intent(activity , HouseActivity.class);
                                startActivity(i1);
                                break;

                        }
                    }
                })
        );

        adapter2 = new FeatureAddAdapter(getFeatureAdds() , getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView2.setLayoutManager(mLayoutManager1);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(adapter2);


    }
   List<String> getSelection()
   {
       List<String> list=new ArrayList<>();
       list.add("All in property for sale");
       list.add("Appartments ans flats");
       list.add("Houses");
       list.add("Lands and plots");
       list.add("Portions an d floors");
       list.add("shops - offices - commercial space");
       return list;
   }
    List<FeatureAddModel> getFeatureAdds()
    {
        List<FeatureAddModel> list=new ArrayList<>();
        list.add(new FeatureAddModel("demo" , "120" , ""));
        list.add(new FeatureAddModel("demo" , "120" , ""));

        list.add(new FeatureAddModel("demo" , "120" , ""));

        list.add(new FeatureAddModel("demo" , "120" , ""));

        list.add(new FeatureAddModel("demo" , "120" , ""));
    return list;
    }

}
