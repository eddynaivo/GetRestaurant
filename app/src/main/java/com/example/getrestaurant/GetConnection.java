package com.example.getrestaurant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class GetConnection extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean onConnection = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
        if (onConnection){
            Toast.makeText(context,"No Data Connection Please\nRemember this App need internet access",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context,"Congratulations ,You have internet access now",Toast.LENGTH_LONG).show();
        }
    }
}
