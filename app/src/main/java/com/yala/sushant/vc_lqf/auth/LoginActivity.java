package com.yala.sushant.vc_lqf.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.quickblox.auth.session.QBSettings;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;
import com.yala.sushant.vc_lqf.ContactListActivity;
import com.yala.sushant.vc_lqf.R;

public class LoginActivity extends AppCompatActivity {

    //from https://admin.quickblox.com/apps/57374/edit   OR Dashbord->Overview
    static final String APP_ID = "57374";
    static final String AUTH_KEY = "8fgG65VBwJpO7qO";
    static final String AUTH_SECRET = "Z94hXOZE87YDSUu";
    static final String ACCOUNT_KEY = "G6xoiezxzj8w3f4wpA9A";//setting from  https://admin.quickblox.com/account/settings


    EditText input_username, input_password;
    Button btn_login;
    TextView link_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initializeFramework();
        initUI();


        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String user = input_username.getText().toString();
                final String password = input_password.getText().toString();

                //creating QBUser firebase to be added function
                QBUser qbUser = new QBUser(user, password);
                QBUsers.signIn(qbUser).performAsync(new QBEntityCallback<QBUser>() {
                    @Override
                    public void onSuccess(QBUser qbUser, Bundle bundle) {
                        Toast.makeText(getBaseContext(), "LoginSucessful", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(LoginActivity.this, ContactListActivity.class);
//                        intent.putExtra("user",user);
//                        intent.putExtra("password",password);
                        startActivity(intent);

                    }

                    @Override
                    public void onError(QBResponseException e) {

                        Toast.makeText(getBaseContext(), "ERROR!!" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }


    private void initUI() {
        input_username = (EditText) findViewById(R.id.input_username);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        link_signup = (TextView) findViewById(R.id.link_signup);
    }

    //QuickBlox framework initialize
    private void initializeFramework() {

        QBSettings.getInstance().init(getApplicationContext(), APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);

    }
}
