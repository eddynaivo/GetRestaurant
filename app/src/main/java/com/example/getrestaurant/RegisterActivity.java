package com.example.getrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
EditText username,password,confirm;
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username= findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirm=findViewById(R.id.confirm);
databaseHelper=new DatabaseHelper(this);
    }

    public void registerNow(View view) {
        methodToValidateandSaveUser();

    }

    private void methodToValidateandSaveUser() {
        String name=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        String conf=confirm.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(conf)){
            Toast.makeText(getApplicationContext(), "Please some field are left blank\n Cannot Register this acount", Toast.LENGTH_SHORT).show();
        }
        else if(pass.length()<8){
            Toast.makeText(getApplicationContext(),"Please the password doesnot satsify the length\n Password must contain atleast 8 charater",Toast.LENGTH_LONG).show();

        }
        else if (!pass.equals(conf)){
            Toast.makeText(getApplicationContext(), "The password confirmation failed \n PLease try again", Toast.LENGTH_LONG).show();
        }
        else{
boolean send=databaseHelper.sendData(name,pass);
if (send==true){
    Toast.makeText(getApplicationContext(),"Account has been created successfull",Toast.LENGTH_LONG).show();
    username.setText("");
    password.setText("");
    confirm.setText("");
    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
}
else{
    System.out.println(Toast.makeText(getApplicationContext(), "Sorry something went wrong while adding your account\nPlease try again", Toast.LENGTH_LONG));
}

        }

    }


}
