package com.example.myapplication1.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.Models.Exams;
import com.example.myapplication1.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<Exams> data ;

    public CategoryAdapter(Activity activity, ArrayList data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(activity).inflate(R.layout.exam_item, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Tvmasak.setText(data.get(position).getMasaak());
        holder.Tvtareekh.setText(data.get(position).getTareekh());
        holder.Tvfatra.setText(data.get(position).getFatra());
        holder.Tvga2a.setText(data.get(position).getGa2a());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView Tvmasak;
        public TextView Tvtareekh;
        public TextView Tvfatra;
        public TextView Tvga2a;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Tvmasak = itemView.findViewById(R.id.Tvmasak);
            Tvtareekh = itemView.findViewById(R.id.Tvtareekh);
            Tvfatra = itemView.findViewById(R.id.Tvfatra);
            Tvga2a = itemView.findViewById(R.id.Tvga2a);

        }
    }
}
