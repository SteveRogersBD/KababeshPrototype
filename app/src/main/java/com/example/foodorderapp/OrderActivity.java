package com.example.foodorderapp;

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

        ArrayList<OrderModel>list = new ArrayList<>();
        list.add(new OrderModel(R.drawable.ctm,"Chicken Tikka Masala","15.00","123456"));
        list.add(new OrderModel(R.drawable.bc,"Butter Chicken","15.00","123456"));
        list.add(new OrderModel(R.drawable.jhal_farazi,"Chicken Jhal Farazi","15.00","123456"));
        list.add(new OrderModel(R.drawable.tofu,"Tofu Curry","15.00","123456"));
        list.add(new OrderModel(R.drawable.korma,"Chicken Korma","15.00","123456"));

        OrderAdapter adapter = new OrderAdapter(list,this);
        binding.orderRecycle.setAdapter(adapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        binding.orderRecycle.setLayoutManager(lm);


    }
}