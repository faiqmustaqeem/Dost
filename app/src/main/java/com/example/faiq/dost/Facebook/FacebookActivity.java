package com.example.faiq.dost.Facebook;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.faiq.dost.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class FacebookActivity extends AppCompatActivity {


    private static final String EMAIL = "email";
    private static final String USER_POSTS = "user_posts";
    private TextView tvfirst_name, tvlast_namee, tvfull_name, tvEmail, login_status;
    String email,name,first_name,last_name;
    private CallbackManager mCallbackManager;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        mCallbackManager = CallbackManager.Factory.create();

        final LoginButton mLoginButton = findViewById(R.id.login_button);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Set the initial permissions to request from the user while logging in

        //  tvfirst_name        = (TextView) findViewById(R.id.first_name);
        // tvlast_namee        = (TextView) findViewById(R.id.last_name);
        tvfull_name         = (TextView) findViewById(R.id.full_name);
        tvEmail             = (TextView) findViewById(R.id.email);
        login_status= (TextView) findViewById(R.id.login_status);


        mLoginButton.setReadPermissions(Arrays.asList("public_profile","email"));

        // Register a callback to respond to the user
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                setResult(RESULT_OK);
                // finish();
                Log.e("facebook","success");
                // mLoginButton.setVisibility(View.GONE);

                GraphRequest graphRequest   =   GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback()
                {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response)
                    {
                        Log.d("JSON", ""+response.getJSONObject().toString());

                        try
                        {
                            email       =   object.getString("email");
                            name        =   object.getString("name");
                            // first_name  =   object.optString("first_name");
                            // last_name   =   object.optString("last_name");

                            tvEmail.setText(email);
                            //  tvfirst_name.setText(first_name);
                            // tvlast_namee.setText(last_name);
                            tvfull_name.setText(name);
                            login_status.setText("You are now logged in as facebook !");
                            LoginManager.getInstance().logOut();
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,first_name,last_name,email");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }

            @Override

            public void onCancel() {
                setResult(RESULT_CANCELED);
                Log.e("facebook","cancel");
                //finish();
            }

            @Override
            public void onError(FacebookException e) {
                // Handle exception
                Log.e("facebook","error");
                login_status.setText("Facebook login Error !");

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

    }
    private void printKeyhash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.faiq.dost", PackageManager.GET_SIGNATURES);
            for (Signature sign : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(sign.toByteArray());
                Log.e("Hash-key", Base64.encodeToString(md.digest(), Base64.DEFAULT));


            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

}
