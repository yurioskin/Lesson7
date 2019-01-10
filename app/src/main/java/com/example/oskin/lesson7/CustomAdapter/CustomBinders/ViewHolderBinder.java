package com.example.oskin.lesson7.CustomAdapter.CustomBinders;

import android.content.Context;

import com.example.oskin.lesson7.Data.MyNotification;

import androidx.recyclerview.widget.RecyclerView;

public abstract class ViewHolderBinder {

    protected final int viewType;

    public ViewHolderBinder(int viewType){
        this.viewType = viewType;
    }

    public abstract void bindViewHolder(Context context, RecyclerView.ViewHolder holder);

    public abstract MyNotification getItem();
}
