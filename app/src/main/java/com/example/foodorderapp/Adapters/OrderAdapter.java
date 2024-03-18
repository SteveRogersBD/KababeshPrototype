package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.Models.OrderModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    ArrayList<OrderModel>list;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_order,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderModel model = list.get(position);
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());
        holder.itemName.setText(model.getSoldItemName());
        holder.itemImage.setImageResource(model.getOrderImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, orderNumber, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.order_image);
            itemName = itemView.findViewById(R.id.order_name);
            orderNumber = itemView.findViewById(R.id.order_num_tv);
            price = itemView.findViewById(R.id.priceItem_tv);
        }
    }
}
