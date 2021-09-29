package com.example.myapplication1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.Models.Notifications;
import com.example.myapplication1.Models.sms_recived;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.notificationHolderView> {
    List<sms_recived> sms_recived;
    Context context;

    public NotificationAdapter(List<sms_recived> sms_recived,Context context) {
        this.sms_recived = sms_recived;
        this.context = context;
    }

    @NonNull
    @Override
    public notificationHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,null,false);
        notificationHolderView t = new notificationHolderView(v);
        return t;
    }

    @Override
    public void onBindViewHolder(@NonNull notificationHolderView holder, int position) {
        sms_recived n=sms_recived.get(position);
        holder.title.setText((n.getMsg_code()));
        holder.content.setText((n.getText_ar()));
    }

    @Override
    public int getItemCount() {
        return sms_recived.size();
    }

    public class notificationHolderView extends RecyclerView.ViewHolder {
        TextView title,content;
        public notificationHolderView(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            title=itemView.findViewById(R.id.notiTitle);
            content=itemView.findViewById(R.id.noticontent);
        }
    }
}
