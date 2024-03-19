package com.example.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodorderapp.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    static final String DBNAME = "mydatabase.db";
    final static int version = 1;
    public DBHelper(@Nullable Context context) {
        super(context,DBNAME,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE orders (" +
                "id integer primary key autoincrement," +
                "name text," +
                "phone text," +
                "price integer," +
                "image integer," +
                "quantity integer," +
                "description text," +
                "foodName text)"
        );

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders");
        onCreate(db);
    }

    public boolean insertOrder(String name,String phone,int price,int image,String des,String foodName,int quantity)
    {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",des);
        values.put("foodName",foodName);
        values.put("quantity",quantity);

        long id = database.insert("orders",null,values);
        if(id<=0) return  false;
        return true;
    }
    public ArrayList<OrderModel> getOrders() {
        ArrayList<OrderModel> list = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodName,image,price from orders", null);
        // * means all field. I could have written name,price,description instead of *
        //limit 10 means 10 cols
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrderModel model = new OrderModel();
                model.setOrderNumber(cursor.getInt(0) + ""); // ID
                model.setSoldItemName(cursor.getString(1)); // Name
                model.setOrderImage(cursor.getInt(2)); // Image
                model.setPrice(cursor.getInt(3) + ""); // Price
                list.add(model);
            }
        }
        cursor.close();
        database.close();
        return list;
    }

    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = "+id,null);
        if(cursor!=null) cursor.moveToFirst();
        return cursor;
    }

    public boolean updateOrder(String name,String phone,int price,int image,String des,String foodName,int quantity,int id)
    {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",des);
        values.put("foodName",foodName);
        values.put("quantity",quantity);

        long row = database.update("orders",values,"id="+id,null);
        if(row<=0) return  false;
        return true;
    }

    public int deleteOrder(String id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id "+ id,null);
    }
}
