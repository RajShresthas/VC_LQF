package com.yala.sushant.vc_lqf;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

import Utils.BottomNavigationViewHelper;
import Utils.ContactListAdapter;
import model.User;


public class ContactListActivity extends AppCompatActivity {
    private static String TAG = "ContactListActivity";


    //listview
    ListView listViewUser;

    ///firebase
    DatabaseReference databaseUser;
    List<User> userList;

    @Override

    protected void onStart() {
        super.onStart();
        databaseUser = FirebaseDatabase.getInstance().getReference("users");
        userList = new ArrayList<>();

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userList.clear();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    User u = userSnapshot.getValue(User.class);
                    userList.add(u);
                    Toast.makeText(getBaseContext(), "onDataExchange  ", Toast.LENGTH_SHORT).show();
                }

                ContactListAdapter contactListAdapter = new ContactListAdapter(ContactListActivity.this, userList);

                listViewUser.setAdapter(contactListAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getBaseContext(), "errorrr  ", Toast.LENGTH_SHORT).show();
            }
        });


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        Log.d(TAG, "onCreate: started");

        listViewUser = (ListView) findViewById(R.id.listViewContactUser);

        setupBottomNavigationView();
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_search:
//                        Intent intent1=new Intent(ContactListActivity.this,SearchActivity.class);
//                        startActivity(intent1);
                        break;
                    case R.id.ic_contactList:
                        break;
                    case R.id.ic_groupList:
                        Intent intent2 = new Intent(ContactListActivity.this, GroupListActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_createGroup:
                        Intent intent3 = new Intent(ContactListActivity.this, CreateGroupActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_profile:
                        Intent intent4 = new Intent(ContactListActivity.this, ProfileActivity.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }

    //bottomNav setup
    private void setupBottomNavigationView() {


        Log.d(TAG, "onCreate: bottomNavigateioView");

        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }
}
