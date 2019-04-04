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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail=findViewById(R.id.email);
        userPassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.login);
        btnRegister=findViewById(R.id.register);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserLogin(userEmail.getText().toString(),userPassword.getText().toString());
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserRegister(userEmail.getText().toString(),userPassword.getText().toString());
            }
        });
    }
    //CREATING THE USER LOGIN METHOD
    public void setUserLogin(String mail,String pass){
        if (TextUtils.isEmpty(mail)|| TextUtils.isEmpty(pass)){
            Toast.makeText(getApplicationContext(),"Cannot Login Empty Fields",Toast.LENGTH_SHORT).show();
        }

        else {
            Intent homeIntent=new Intent(getApplicationContext(),HotelActivity.class);
            startActivity(homeIntent);
            LoginActivity.this.finish();


        }
    }
    //CREATING THE USER RESISTER METHOD
    public void setUserRegister(String mail,String pass){
        if (TextUtils.isEmpty(mail)|| TextUtils.isEmpty(pass)){
            Toast.makeText(getApplicationContext(),"Cannot Register Empty Fields",Toast.LENGTH_SHORT).show();
        }
        else if (pass.length()<8){
            userPassword.setError("The password must contain atleast 8 characters");
        }

        else {


        }

    }

}
