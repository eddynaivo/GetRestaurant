package com.example.getrestaurant;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class AccountActivity extends AppCompatActivity {
private LinearLayout linearLayout;
private UserAccountFragment userAccountFragment;
private ContactUsFragment contactUsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        linearLayout=findViewById(R.id.liner_layout);

        //instatiating fragments
        userAccountFragment=new UserAccountFragment();
        contactUsFragment=new ContactUsFragment();
        setFragment(userAccountFragment);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int click=item.getItemId();
        switch (click){
            case R.id.help:
                return  true;
            case R.id.feedback:
                return true;
            case R.id.account:
                setFragment(userAccountFragment);
                return true;
            case R.id.contact:
                setFragment(contactUsFragment);
                return true;
        default:
            return super.onOptionsItemSelected(item);

        }
    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.liner_layout,fragment).commit();

    }



}
