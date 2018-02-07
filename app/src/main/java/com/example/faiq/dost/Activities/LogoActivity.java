package com.example.faiq.dost.Activities;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.faiq.dost.Facebook.FacebookActivity;
import com.example.faiq.dost.Google.GoogleActivity;
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
    @BindView(R.id.facebook_logo)
    ImageView facebook_logo;
    @BindView(R.id.google_logo)
    ImageView google_logo;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        ButterKnife.bind(this);
        activity=this;




    }
    @OnClick ({R.id.login , R.id.create_wallet,R.id.facebook_logo,R.id.google_logo})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.login:
                Intent i=new Intent(activity , LoginActivity.class);
                startActivity(i);
                break;
            case R.id.create_wallet:
                Intent i3=new Intent(activity , ManualPairingActivity.class);
                startActivity(i3);
                break;
            case R.id.facebook_logo:
                Intent i1=new Intent(activity , FacebookActivity.class);
                startActivity(i1);
                break;
            case R.id.google_logo:
                Intent i2=new Intent(activity , GoogleActivity.class);
                startActivity(i2);
                break;
        }
    }
}
