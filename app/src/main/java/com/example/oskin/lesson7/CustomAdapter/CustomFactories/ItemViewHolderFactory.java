package com.example.oskin.lesson7.CustomAdapter.CustomFactories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oskin.lesson7.CustomAdapter.CustomHolders.ItemViewHolder;
import com.example.oskin.lesson7.CustomAdapter.CustomHolders.SectionItemsViewHolder;
import com.example.oskin.lesson7.R;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolderFactory implements ViewHolderFactory {
    @Override
    public RecyclerView.ViewHolder createViewHolder(Context context, ViewGroup parent, LayoutInflater inflater) {

        View itemView = inflater.inflate(R.layout.item_layout,parent,false);
        RecyclerView.ViewHolder holder = new ItemViewHolder(context, itemView);
        return holder;
    }
}
