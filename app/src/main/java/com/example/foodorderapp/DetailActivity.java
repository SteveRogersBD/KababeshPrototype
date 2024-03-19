package com.example.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        final  DBHelper helper = new DBHelper(this);
        if(actionBar!=null)
        {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));
        }

        if(getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String des = getIntent().getStringExtra("description");

            binding.detailName.setText(name);
            binding.detailDescription.setText(des);
            binding.detailPriceTvBottom.setText(price + "");
            binding.detailImage.setImageResource(image);

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean insertId = helper.insertOrder(binding.detailNameET.getText().toString(),
                            binding.detailPhoneEt.getText().toString(),
                            price, image, des,name,
                            Integer.parseInt(binding.itemCount.getText().toString()));

                    Log.d("DetailActivity", "Insert ID: " + insertId);

                    if (insertId == true) {
                        Toast.makeText(DetailActivity.this, "Oder Placed!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            final int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);

            binding.detailImage.setImageResource(cursor.getInt(4));
            binding.detailNameET.setText(cursor.getString(1));
            binding.detailPhoneEt.setText(cursor.getString(2));
            binding.detailDescription.setText(cursor.getString(6));
            binding.detailName.setText(cursor.getString(7));
            binding.detailPriceTvBottom.setText(cursor.getString(3));
            binding.insertBtn.setText("Update order");

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    boolean isUpdated=helper.updateOrder(binding.detailNameET.getText().toString(),
                            binding.detailPhoneEt.getText().toString(),
                            Integer.parseInt(binding.detailPriceTvBottom.getText().toString()),
                            image,binding.detailDescription.getText().toString(),
                            binding.detailName.getText().toString(),
                            1,id);

                    if(isUpdated)
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                }
            });
        }




    }
}