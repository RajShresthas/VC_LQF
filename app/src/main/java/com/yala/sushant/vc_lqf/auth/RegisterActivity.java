package com.yala.sushant.vc_lqf.auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;
import com.yala.sushant.vc_lqf.R;

import model.User;

public class RegisterActivity extends AppCompatActivity {



    EditText input_username, input_fullname, input_about, input_password;
    Button btn_register;

    String username, fullname, about, password;
    int id;
    //DBFB
    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        initUI();
        databaseUser = FirebaseDatabase.getInstance().getReference("users");

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gettingData
                username = input_username.getText().toString();
                fullname = input_fullname.getText().toString();
                about = input_about.getText().toString();
                password = input_password.getText().toString();

                QBUser qbUser = new QBUser(username, password);
                qbUser.setFullName(fullname);
                QBUsers.signUp(qbUser).performAsync(new QBEntityCallback<QBUser>() {
                    @Override
                    public void onSuccess(QBUser qbUser, Bundle bundle) {
                        Toast.makeText(getBaseContext(), "Signup Sucessful", Toast.LENGTH_SHORT).show();

                        id = qbUser.getId();

                        User user = new User(id, username, fullname, about, password);
                        databaseUser.child(String.valueOf(id)).setValue(user);

                        Toast.makeText(getBaseContext(), "Signup Sucessful firebase", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(QBResponseException e) {
                        Toast.makeText(getBaseContext(), "Signup Error.  " + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }

        });
    }



    private void initUI() {
        input_username = (EditText) findViewById(R.id.input_username);
        input_fullname = (EditText) findViewById(R.id.input_fullname);
        input_about = (EditText) findViewById(R.id.input_about);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_register = (Button) findViewById(R.id.btn_register);
    }

}
