package com.example.oskin.lesson7.CustomAdapter.CustomBinders;

import android.content.Context;

import com.example.oskin.lesson7.CustomAdapter.CustomHolders.SMSViewHolder;
import com.example.oskin.lesson7.Data.MyNotification;
import com.example.oskin.lesson7.Data.SMS;

import androidx.recyclerview.widget.RecyclerView;

public class SMSViewHolderBinder extends ViewHolderBinder {

    private final SMS mSMS;

    public SMSViewHolderBinder(MyNotification item, int viewType) {
        super(viewType);
        mSMS = (SMS) item;
    }

    @Override
    public void bindViewHolder(Context context, RecyclerView.ViewHolder holder) {
        SMSViewHolder smsViewHolder = (SMSViewHolder) holder;
        smsViewHolder.senderName.setText(mSMS.getSenderName());
        smsViewHolder.smsContent.setText(mSMS.getSMSContent());
        smsViewHolder.time.setText(mSMS.getSMSTime());
    }

    @Override
    public MyNotification getItem() {
        return mSMS;
    }
}
