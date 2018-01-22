package com.example.faiq.dost.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import com.example.faiq.dost.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    Activity activity;
    @BindView(R.id.signin)
    AppCompatEditText signin;
    @BindView(R.id.btn_continue)
    Button btn_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity=this;
        ButterKnife.bind(this);
    }

    @OnClick({R.id.signin , R.id.btn_continue})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.signin:
                Intent i=new Intent(activity , SignInActivity.class);
                startActivity(i);
                break;
            case R.id.btn_continue:
                Intent i1=new Intent(activity , MainActivity.class);
                startActivity(i1);
                break;
        }

    }
}
