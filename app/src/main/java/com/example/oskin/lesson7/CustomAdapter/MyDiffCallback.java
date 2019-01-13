package com.example.oskin.lesson7.CustomAdapter;

import com.example.oskin.lesson7.Data.MyNotification;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class MyDiffCallback extends DiffUtil.Callback {

    private List<MyNotification> mOldNotifications;
    private List<MyNotification> mNewNotifications;

    public MyDiffCallback(List<MyNotification> oldNotifications, List<MyNotification> newNotifications) {
        mOldNotifications = oldNotifications;
        mNewNotifications = newNotifications;
    }

    @Override
    public int getOldListSize() {
        return mOldNotifications.size();
    }

    @Override
    public int getNewListSize() {
        return mNewNotifications.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldNotifications.get(oldItemPosition).hashCode() == mNewNotifications.get(newItemPosition).hashCode();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldNotifications.get(oldItemPosition).equals(mNewNotifications.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
