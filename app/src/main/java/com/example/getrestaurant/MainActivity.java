package com.example.getrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        new Splash().start();
    }
    class  Splash extends  Thread{
        @Override
        public void run() {
            try{
                sleep(2000);
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }catch (Exception e){
                e.getStackTrace();
            }
            super.run();
        }
    }
}
