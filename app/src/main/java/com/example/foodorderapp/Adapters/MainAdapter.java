package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.DetailActivity;
import com.example.foodorderapp.MainActivity;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    ArrayList<MainModel>list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainModel model = list.get(position);

        holder.description.setText(model.getDescription());
        holder.foodImage.setImageResource(model.getImage());
        holder.price.setText(model.getPrice());
        holder.name.setText(model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name",model.getName());
                intent.putExtra("description",model.getDescription());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("image",model.getImage());
                intent.putExtra("type",1);

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView foodImage;
    TextView description, price, name;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        foodImage = itemView.findViewById(R.id.food_image);
        description = itemView.findViewById(R.id.description_tv);
        price = itemView.findViewById(R.id.price_tv);
        name = itemView.findViewById(R.id.name_tv);
    }
}
}
