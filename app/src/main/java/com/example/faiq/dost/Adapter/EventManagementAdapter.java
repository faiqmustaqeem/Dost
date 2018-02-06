package com.example.faiq.dost.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.faiq.dost.Activities.EventManagement;
import com.example.faiq.dost.Models.EventManagementModel;
import com.example.faiq.dost.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by CodianSoft on 06/02/2018.
 */

public class EventManagementAdapter extends RecyclerView.Adapter<EventManagementAdapter.MyViewHolder> {

    List<EventManagementModel> list;
    Context context;
    Activity activity;


    public EventManagementAdapter(List<EventManagementModel> list, Context context , Activity activity) {
        this.list = list;
        this.context = context;
        this.activity=activity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_management_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final EventManagementModel model = list.get(position);

        holder.event_name.setText(model.getEvent_name());

        holder.layout_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCallPermissions(model.getEvent_contact_number());
            }
        });
    }


    void getCallPermissions(String contact_number)
    {
        EventManagement.permissionStatus = activity.getSharedPreferences("call_permission",MODE_PRIVATE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CALL_PHONE)) {
                //Show Information about why you need the permission
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Need Call Permission");
                builder.setMessage("This app needs Call permission.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, EventManagement.CALL_PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            } else if (EventManagement.permissionStatus.getBoolean(Manifest.permission.CALL_PHONE,false)) {
                //Previously Permission Request was cancelled with 'Dont Ask Again',
                // Redirect to Settings after showing Information about why you need the permission
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Need Call Permission");
                builder.setMessage("This app needs Call permission.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        EventManagement.sentToSettings = true;
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                        intent.setData(uri);
                        activity.startActivityForResult(intent, EventManagement.REQUEST_PERMISSION_SETTING);
                        Toast.makeText(context, "Go to Permissions to Grant Call Permission", Toast.LENGTH_LONG).show();
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
                //just request the permission
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, EventManagement.CALL_PERMISSION_CONSTANT);
            }

            SharedPreferences.Editor editor = EventManagement.permissionStatus.edit();
            editor.putBoolean(Manifest.permission.CALL_PHONE,true);
            editor.commit();


        } else {
            //You already have the permission, just go ahead.
            call(contact_number);
        }
    }

    void call(final String contact_number)
    {
        new MaterialDialog.Builder(activity)
                .title("Call")
                .content("Are you sure you want to call to this number ? " + contact_number)
                .positiveText("Yes , im sure")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact_number));
                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                })
                .negativeText("Cancel")
                .canceledOnTouchOutside(false)
                .show();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView event_name;
        LinearLayout layout_call;
        public MyViewHolder(View itemView) {
            super(itemView);
            event_name=itemView.findViewById(R.id.event_name);
            layout_call=itemView.findViewById(R.id.layout_call);
        }
    }
}
