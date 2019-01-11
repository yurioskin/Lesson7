package com.example.oskin.lesson7.CustomAdapter.CustomBinders;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.oskin.lesson7.CustomAdapter.CustomHolders.CallViewHolder;
import com.example.oskin.lesson7.Data.Call;
import com.example.oskin.lesson7.Data.MyNotification;
import com.example.oskin.lesson7.R;

import androidx.recyclerview.widget.RecyclerView;

public class CallViewHolderBinder extends ViewHolderBinder {

    private final Call mCallItem;

    public CallViewHolderBinder(MyNotification item, int viewType) {
        super(viewType);
        mCallItem = (Call) item;
    }

    @Override
    public void bindViewHolder(final Context context, RecyclerView.ViewHolder holder) {
        CallViewHolder callViewHolder = (CallViewHolder) holder;
        callViewHolder.callerName.setText(mCallItem.getCallerName());
        callViewHolder.time.setText(mCallItem.getCallTime());
    }

    @Override
    public MyNotification getItem() {
        return mCallItem;
    }
}
