package com.example.oskin.lesson7.CustomAdapter.CustomBinders;

import android.content.Context;

import com.example.oskin.lesson7.CustomAdapter.CustomHolders.ItemViewHolder;
import com.example.oskin.lesson7.Data.Item;
import com.example.oskin.lesson7.Data.MyNotification;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolderBinder extends ViewHolderBinder {

    private Item mItem;

    public ItemViewHolderBinder(MyNotification item, int viewType) {
        super(viewType);
        mItem = (Item) item;
    }

    @Override
    public void bindViewHolder(Context context, RecyclerView.ViewHolder holder) {

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.itemNumber.setText(mItem.getNumber());
        itemViewHolder.itemContent.setText(mItem.getContent());

    }

    @Override
    public MyNotification getItem() {
        return null;
    }
}
