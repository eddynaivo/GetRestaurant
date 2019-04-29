package com.example.getrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userEmail;
    EditText userPassword;
    Button btnLogin,btnRegister;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail=findViewById(R.id.email);
        userPassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.login);
        btnRegister=findViewById(R.id.register);
//        instatiating the class database helper
databaseHelper=new DatabaseHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserLogin(userEmail.getText().toString(),userPassword.getText().toString());
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserRegister();
            }
        });
    }
    //CREATING THE USER LOGIN METHOD
    public void setUserLogin(String mail,String pass){
        if (TextUtils.isEmpty(mail)|| TextUtils.isEmpty(pass)){
            Toast.makeText(getApplicationContext(),"Cannot Login Empty Fields",Toast.LENGTH_SHORT).show();
        }

        else {
            boolean getUser=databaseHelper.checkUserInfo(mail, pass);
            if (getUser==true) {
                Intent homeIntent = new Intent(getApplicationContext(), HotelActivity.class);
                startActivity(homeIntent);
                LoginActivity.this.finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "Sorry you dont have an account with the application\n Click Register to create new account", Toast.LENGTH_SHORT).show();
            }

        }
    }
    //CREATING THE USER RESISTER METHOD
    public void setUserRegister(){
       Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
       startActivity(intent);



    }

}
