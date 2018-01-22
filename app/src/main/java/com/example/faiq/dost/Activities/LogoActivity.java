package com.example.faiq.dost.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.faiq.dost.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogoActivity extends AppCompatActivity {

    Activity activity;
    @BindView(R.id.create_wallet)
    Button create_wallet;

    @BindView(R.id.login)
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        ButterKnife.bind(this);
        activity=this;




    }
    @OnClick ({R.id.login , R.id.create_wallet})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.login:
                Intent i=new Intent(activity , LoginActivity.class);
                startActivity(i);
                break;
            case R.id.create_wallet:
                break;
        }
    }
}
