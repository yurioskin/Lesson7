package com.example.oskin.lesson7.CustomAdapter.CustomHolders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.oskin.lesson7.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView itemNumber;
    public TextView itemContent;

    public ItemViewHolder(Context context, @NonNull View itemView) {
        super(itemView);

        itemNumber = itemView.findViewById(R.id.item_layout_number);
        itemContent = itemView.findViewById(R.id.item_layout_content);

        itemView.setOnClickListener((View.OnClickListener) context);
    }
}
