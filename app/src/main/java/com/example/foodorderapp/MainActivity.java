package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actionBar = getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));
        }

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.ctm,"Chicken Tikka Masala","15.99", "Made of tomato, ginger, garlic"));
        list.add(new MainModel(R.drawable.bc,"Butter Chicken","15.99", "Made of ginger, garlic"));
        list.add(new MainModel(R.drawable.korma,"Chicken Korma","15.99", "Made of tomato, ginger, garlic"));
        list.add(new MainModel(R.drawable.jhal_farazi,"Chicken Jhal Farazi","15.99", "Made of tomato, ginger, garlic"));
        list.add(new MainModel(R.drawable.tofu,"Tofu Curry","15.99", "Made of tofu"));


        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
    }
}