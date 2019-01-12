package com.example.oskin.lesson7.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class Item extends MyNotification {

    private String mNumber;
    private String mContent;

    public Item(String number, String content) {
        mNumber = number;
        mContent = content;
    }

    public String getNumber() {
        return mNumber;
    }

    public String getContent() {
        return mContent;
    }

    @Override
    public int getType() {
        return ItemTypes.ITEM.getType();
    }

    protected Item(Parcel in) {
        mNumber = in.readString();
        mContent = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mNumber);
        dest.writeString(mContent);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
