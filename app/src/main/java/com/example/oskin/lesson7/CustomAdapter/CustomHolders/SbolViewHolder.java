package com.example.oskin.lesson7.CustomAdapter.CustomHolders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.oskin.lesson7.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SbolViewHolder extends RecyclerView.ViewHolder{

    public TextView storePurchase;
    public TextView cardNumber;
    public TextView writeOff;
    public TextView balance;
    public TextView time;
    public ImageView storeLogo;

    public SbolViewHolder(Context context, ViewGroup parent, @NonNull View itemView) {
        super(itemView);
        storePurchase = itemView.findViewById(R.id.sbol_layout_purchase);
        cardNumber = itemView.findViewById(R.id.sbol_layout_card_number);
        writeOff = itemView.findViewById(R.id.sbol_layout_write_off);
        balance = itemView.findViewById(R.id.sbol_layout_balance);
        time = itemView.findViewById(R.id.sbol_layout_time);
        storeLogo = itemView.findViewById(R.id.sbol_layout_store_image);

        itemView.setOnClickListener((View.OnClickListener) context);
    }


}