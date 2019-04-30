package com.example.getrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateMeal extends SQLiteOpenHelper {
    public CreateMeal(Context context){
        super(context,"meal.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table meals(id integer not null primary key autoincrement,Foods text,Sauce text,drink text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MEALS");
        onCreate(db);
    }
    public boolean addMeal(String food,String sauce, String drink){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Foods",food);
        contentValues.put("Sauce",sauce);
        contentValues.put("drink",drink);
            long insert=db.insert("meals",null,contentValues);
            if (insert==-1){
                return  false;
            }
            else return true;
    }
    public Cursor getMeals(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor data=db.rawQuery("SELECT * from  meals",null);
        return  data;
    }
}
