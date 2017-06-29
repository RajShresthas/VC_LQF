package com.yala.sushant.vc_lqf;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import Utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


      setupBottomNavigationView();
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_search:
//                        Intent intent1=new Intent(ProfileActivity.this,GroupListActivity.class);
//                        startActivity(intent1);
                        break;
                    case R.id.ic_contactList:
                        Intent intent2 = new Intent(ProfileActivity.this, ContactListActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_groupList:
                        Intent intent3 = new Intent(ProfileActivity.this, GroupListActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_createGroup:
                        Intent intent4 = new Intent(ProfileActivity.this, CreateGroupActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.ic_profile:
                        break;
                }

                return false;
            }
        });

    }

    private void setupBottomNavigationView() {


        Log.d(TAG, "onCreate: bottomNavigateioView");

        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }
}
