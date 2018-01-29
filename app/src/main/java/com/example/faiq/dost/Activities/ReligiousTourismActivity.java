package com.example.faiq.dost.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.faiq.dost.Adapter.ReligiousTourismAdapter;
import com.example.faiq.dost.Models.ReligiousTourismModel;
import com.example.faiq.dost.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReligiousTourismActivity extends AppCompatActivity {

    @BindView(R.id.recycle_view_religious)
    RecyclerView recyclerView;
    @BindView(R.id.back)
    ImageView back;

    ReligiousTourismAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religious_tourism);
        ButterKnife.bind(this);


        adapter = new ReligiousTourismAdapter(getReligiousTourismItems() , getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    List<ReligiousTourismModel> getReligiousTourismItems()
    {
        List<ReligiousTourismModel> list=new ArrayList<>();
        list.add(new ReligiousTourismModel("Religious Tourism","",""));
        list.add(new ReligiousTourismModel("Religious Tourism","",""));
        list.add(new ReligiousTourismModel("Religious Tourism","",""));
        list.add(new ReligiousTourismModel("Religious Tourism","",""));
        list.add(new ReligiousTourismModel("Religious Tourism","",""));
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
