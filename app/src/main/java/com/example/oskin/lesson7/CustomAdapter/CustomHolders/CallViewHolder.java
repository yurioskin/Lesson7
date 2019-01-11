package com.example.oskin.lesson7.CustomAdapter.CustomHolders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.example.oskin.lesson7.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CallViewHolder extends RecyclerView.ViewHolder{

    public TextView callerName;
    public TextView time;

    public CallViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        callerName = itemView.findViewById(R.id.call_layout_caller_name);
        time = itemView.findViewById(R.id.call_layout_time);

        itemView.setOnClickListener((View.OnClickListener) context);
    }
}