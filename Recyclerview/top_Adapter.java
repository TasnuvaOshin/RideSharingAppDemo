package com.joytechnologies.rentacar.Recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.joytechnologies.rentacar.R;
import com.joytechnologies.rentacar.Submit.SubmitFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class top_Adapter extends RecyclerView.Adapter<top_viewHolder> {

    Context context;
    ArrayList<top_Class> arrayList;

    public top_Adapter() {
    }

    public top_Adapter(Context context, ArrayList<top_Class> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public top_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_row, parent, false);
        return new top_viewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull top_viewHolder holder, int position) {
        final top_Class current = arrayList.get(position);

        Picasso.get().load(current.getCar_img()).into(holder.car_img);

        holder.car_name.setText(current.getCar_name());
        holder.car_rating.setText(current.getCar_rating()+" /10");
        holder.car_capacity.setText(current.getCar_capacity());
        holder.car_amount.setText(current.getCar_amount()+" /day");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle args = new Bundle();
                args.putString("car_name",current.getCar_name());
                args.putString("car_img",current.getCar_img());
                args.putString("car_amount",current.getCar_amount());
                SubmitFragment submitFragment = new SubmitFragment();
                submitFragment.setArguments(args);
                FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack("fragment").replace(R.id.frame_layout, submitFragment);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
