package com.example.oskin.lesson7.CustomAdapter.CustomFactories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public interface ViewHolderFactory {

    RecyclerView.ViewHolder createViewHolder(Context context, ViewGroup parent, LayoutInflater inflater);
}
