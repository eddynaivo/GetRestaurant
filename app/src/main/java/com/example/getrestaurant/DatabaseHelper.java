package com.example.getrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
     public DatabaseHelper(Context context){
         super(context,"Login.db",null,1);
     }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table users(id integer not null primary key autoincrement,username text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP Table if exists users");
        onCreate(db);
    }
    public boolean sendData(String name,String password){
        SQLiteDatabase db=this.getWritableDatabase();
     ContentValues contentValues=new ContentValues();
    contentValues.put("username",name);
    contentValues.put("password",password);
    long put=db.insert("users",null,contentValues);
    if (put==-1){
        return false;
    }
    else{
        return true;
    }
}
//Checking wheather the use exits in th database
    public boolean checkUserInfo(String name,String password){
         SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * from Users WHERE username=? and password=?",new String[]{name,password});
        if (cursor.getCount()>0){
            return true;
        }
         else{
             return false;
        }
    }
//    checking for the account existance to avoid redudance in login
   public  boolean checkUserCredentials( String name){
         SQLiteDatabase db=this.getReadableDatabase();
         Cursor cursor=db.rawQuery("SELECT username from users where username=?",new String[]{name});
         if (cursor.getCount()>0){
             return true;
         }
         else{
             return  false;
         }

    }

}

