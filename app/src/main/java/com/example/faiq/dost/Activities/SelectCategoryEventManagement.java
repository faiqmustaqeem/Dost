package com.example.faiq.dost.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.faiq.dost.Adapter.FeatureAddAdapter;
import com.example.faiq.dost.Adapter.SelectCategoryAdapter;
import com.example.faiq.dost.Models.FeatureAddModel;
import com.example.faiq.dost.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectCategoryEventManagement extends AppCompatActivity {



    @BindView(R.id.recycleview1)
    ListView listview;
    @BindView(R.id.recycleview2)
    RecyclerView recyclerView2;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

   // SelectCategoryAdapter adapter1;
    FeatureAddAdapter adapter2;

    @BindView(R.id.back)
    ImageView back;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category_event_management);

        ButterKnife.bind(this);

        activity=this;

        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listeview_item, getSelection());

        // ListView listView = (ListView) findViewById(R.id.recycleview1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 1:
                        Intent i1=new Intent(activity , EventManagement.class);
                        startActivity(i1);
                        break;

                }
            }
        });

        adapter2 = new FeatureAddAdapter(getFeatureAdds() , getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView2.setLayoutManager(mLayoutManager1);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(adapter2);
        recyclerView2.scrollToPosition(0);
    }
    List<String> getSelection()
    {
        List<String> list=new ArrayList<>();
        list.add("Advertisement Soultions");
        list.add("Events Management");
        list.add("Birthday Parties");
        list.add("Marriages");
        list.add("Corporate Events");
        return list;
    }
    List<FeatureAddModel> getFeatureAdds()
    {
        List<FeatureAddModel> list=new ArrayList<>();
        list.add(new FeatureAddModel("demo" , "120" , ""));
        list.add(new FeatureAddModel("demo" , "120" , ""));
        list.add(new FeatureAddModel("demo" , "120" , ""));
        list.add(new FeatureAddModel("demo" , "120" , ""));

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
