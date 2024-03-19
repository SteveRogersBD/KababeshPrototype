package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import com.example.foodorderapp.Adapters.OrderAdapter;
import com.example.foodorderapp.Models.OrderModel;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));
        }

        DBHelper helper = new DBHelper(this);
        ArrayList<OrderModel> list = helper.getOrders();


        OrderAdapter adapter = new OrderAdapter(list,this);
        binding.orderRecycle.setAdapter(adapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        binding.orderRecycle.setLayoutManager(lm);



    }
}