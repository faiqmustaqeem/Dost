package com.example.faiq.dost.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.faiq.dost.Adapter.EventManagementAdapter;
import com.example.faiq.dost.Models.EventManagementModel;
import com.example.faiq.dost.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventManagement extends AppCompatActivity {

    @BindView(R.id.rv_event_management)
    RecyclerView recyclerView;

    EventManagementAdapter adapter;
    Activity activity;


    public static final int CALL_PERMISSION_CONSTANT = 100;
    public static final int REQUEST_PERMISSION_SETTING = 101;
    public static boolean sentToSettings = false;
    public static SharedPreferences permissionStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_management);
        activity = this;
        ButterKnife.bind(activity);


        adapter = new EventManagementAdapter(getList(), getApplicationContext(), activity);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    List<EventManagementModel> getList() {
        List<EventManagementModel> list = new ArrayList<>();
        list.add(new EventManagementModel("Event Management", "03128676054", ""));
        list.add(new EventManagementModel("Event Management", "03128676054", ""));
        list.add(new EventManagementModel("Event Management", "03128676054", ""));
        list.add(new EventManagementModel("Event Management", "03128676054", ""));
        list.add(new EventManagementModel("Event Management", "03128676054", ""));
        list.add(new EventManagementModel("Event Management", "03128676054", ""));

        return list;

    }

    @OnClick({R.id.back})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PERMISSION_CONSTANT) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // proceedAfterPermission();
                Toast.makeText(activity, "Permision Granted !", Toast.LENGTH_SHORT).show();
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CALL_PHONE)) {
                    //Show Information about why you need the permission
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Need Call Permission");
                    builder.setMessage("This app needs Call permission");
                    builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();


                            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_CONSTANT);


                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                } else {
                    Toast.makeText(getBaseContext(), "Unable to get Permission", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            if (ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                //Got Permission
                // proceedAfterPermission();
                Toast.makeText(activity, "Permission Granted ! You can call now ", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (sentToSettings) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                //Got Permission
                //proceedAfterPermission();
                Toast.makeText(activity, "Permission Granted ! you can call now ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
