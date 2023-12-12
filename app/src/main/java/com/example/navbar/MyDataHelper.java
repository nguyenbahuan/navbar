package com.example.navbar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATASABE_NAME = "Test.db";
    private static final int DATASABE_VERSION = 1;
    private static final String TABLE_NAME = "menu";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PRICE = "price";



    public MyDataHelper( Context context) {
        super(context, DATASABE_NAME, null, DATASABE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "Create TABLE " + TABLE_NAME +
                        "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_PRICE + "INTEGER )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addFood(String name, int price) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv  = new ContentValues();

        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_PRICE,price);
        long result =  db.insert(TABLE_NAME,null,cv);
        if(result == -1) {
            Toast.makeText(context.getApplicationContext(), "Thêm thất bại",Toast.LENGTH_SHORT).show();
        } else  {
            Toast.makeText(context.getApplicationContext(), "Thêm thành công",Toast.LENGTH_SHORT).show();
        }
    }
}
