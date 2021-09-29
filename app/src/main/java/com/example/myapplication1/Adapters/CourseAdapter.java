package com.example.myapplication1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication1.Models.course;
import com.example.myapplication1.Models.semester_table;
import com.example.myapplication1.R;

import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    List<semester_table> semester_table;
    Context context;

    public CourseAdapter(Context context, List<semester_table> semester_table) {
        this.context = context;
        this.semester_table = semester_table;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nameOfCourse = semester_table.get(position).getSubject_name_ar();
        String Division = semester_table.get(position).getLect_cd();
        String Classroom = semester_table.get(position).getDay_we();
        String Time = semester_table.get(position).getDay_mo();
        String subject_cd = semester_table.get(position).getSubject_cd();
        holder.subject_cd.setText(subject_cd);
        holder.mnameOfCourse.setText(nameOfCourse);
        holder.mDivision.setText(Division);
//        holder.mClassroom.setText(Classroom);
        holder.mTime.setText(Time);
    }

    @Override
    public int getItemCount() {
        return semester_table.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mnameOfCourse, mDivision, mClassroom, mTime, subject_cd;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject_cd = itemView.findViewById(R.id.subject_cd);
            mnameOfCourse = itemView.findViewById(R.id.CourseName);
            mDivision = itemView.findViewById(R.id.Division);
//            mClassroom = itemView.findViewById(R.id.Classroom);
            mTime = itemView.findViewById(R.id.Time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

        }
    }
}
