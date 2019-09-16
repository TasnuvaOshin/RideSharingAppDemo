package com.joytechnologies.rentacar.Recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.joytechnologies.rentacar.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class top_viewHolder extends RecyclerView.ViewHolder {

    public TextView car_amount,car_capacity,car_rating,car_name;
    public ImageView car_img;
    public top_viewHolder(@NonNull View itemView) {
        super(itemView);

        car_amount = itemView.findViewById(R.id.car_amount);
        car_capacity = itemView.findViewById(R.id.car_capacity);
        car_rating = itemView.findViewById(R.id.car_rating);
        car_name = itemView.findViewById(R.id.car_name);
        car_img = itemView.findViewById(R.id.car_img);
    }
}
