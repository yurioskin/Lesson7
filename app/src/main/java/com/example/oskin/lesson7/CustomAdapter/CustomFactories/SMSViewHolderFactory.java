package com.example.oskin.lesson7.CustomAdapter.CustomFactories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oskin.lesson7.CustomAdapter.CustomHolders.SMSViewHolder;
import com.example.oskin.lesson7.R;

import androidx.recyclerview.widget.RecyclerView;

public class SMSViewHolderFactory implements ViewHolderFactory {
    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {

        View itemView = inflater.inflate(R.layout.sms_feed_layout, parent, false);
        RecyclerView.ViewHolder holder = new SMSViewHolder(itemView);
        return holder;
    }
}