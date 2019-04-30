package com.example.getrestaurant;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserAccountFragment extends Fragment {
ListView listView;
ArrayAdapter arrayAdapter;
ArrayList arrayList;
EditText food,soucce, drink;
Button save;
CreateMeal createMeal;
    public UserAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_user_account, container, false);
        listView=v.findViewById(R.id.mymeal);
        save=v.findViewById(R.id.save);
        food=v.findViewById(R.id.food);
        createMeal=new CreateMeal(getContext());
        drink=v.findViewById(R.id.drink);
        soucce=v.findViewById(R.id.sauce);
        arrayList=new ArrayList();
        arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);
        Cursor data=createMeal.getMeals();
        while (data.moveToNext()){
            arrayList.add("Food:\t"+data.getString(1).toUpperCase()+"\nSauce:\t" +data.getString(2).toUpperCase()+"\nDrink:\t"+data.getString(3).toUpperCase());
        }
        listView.setAdapter(arrayAdapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        return v;
    }
public  void saveData(){
        String f=food.getText().toString().trim();
        String s=soucce.getText().toString().trim();
        String d=drink.getText().toString().trim();
        if (TextUtils.isEmpty(f) ||TextUtils.isEmpty(s) || TextUtils.isEmpty(d)){
            Toast.makeText(getContext(), "Please some field are left empty", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean set=createMeal.addMeal(f,s,d);
            if (set==true){
                Toast.makeText(getContext(), "Success ! You have successfully save your meal", Toast.LENGTH_SHORT).show();
                food.setText("");
                drink.setText("");
                soucce.setText("");
            }
            else{
                Toast.makeText(getContext(), "Sorry an error occurred while saving your meal \n Please try again latter", Toast.LENGTH_SHORT).show();
            }

        }
}
}
