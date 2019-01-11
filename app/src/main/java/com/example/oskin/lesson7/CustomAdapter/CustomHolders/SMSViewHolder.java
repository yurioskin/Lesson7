package com.example.oskin.lesson7.CustomAdapter.CustomHolders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.example.oskin.lesson7.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SMSViewHolder extends RecyclerView.ViewHolder {

    public TextView senderName;
    public TextView smsContent;
    public TextView time;

    public SMSViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        senderName = itemView.findViewById(R.id.sms_layout_sender_name);
        smsContent = itemView.findViewById(R.id.sms_layout_content);
        time = itemView.findViewById(R.id.sms_layout_time);

        itemView.setOnClickListener((View.OnClickListener) context);
    }
}