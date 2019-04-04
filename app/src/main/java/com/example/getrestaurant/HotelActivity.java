package com.example.getrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {
ListView listView;
ArrayAdapter<String> arrayAdapter;
ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        //instantianting class
        listView=findViewById(R.id.list_view);
        arrayList=new ArrayList<String>();
        arrayList.add("Hungry Goose Restuarant");
        arrayList.add("Lily's Restuarant");
        arrayList.add("Sipers Restaurant");
        arrayList.add("Dacave Restuarant");
        arrayList.add("Katete Restaurant");
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),arrayList.get(position)+" is selected",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      int check=item.getItemId();
      switch (check){
          case R.id.setting:
              startActivity(new Intent(getApplicationContext(),AccountActivity.class));
              return true;
          case R.id.share:
              Intent intent1=new Intent(Intent.ACTION_SEND);
              intent1.setType("text/plain");
              intent1.putExtra("MY APP",true);
          startActivity(Intent.createChooser(intent1,"SHARE THE APP NOW"));
              return true;

              default:
                  return super.onOptionsItemSelected(item);
      }
    }
}
