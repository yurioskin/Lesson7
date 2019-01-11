package com.example.oskin.lesson7.Data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.oskin.lesson7.R;

public class Sbol extends MyNotification {
    private String mStorePurchase;
    private String mImageStoreUrl;
    private String mCardNumber;
    private String mWriteOff;
    private String mBalance;
    private String mTime;

    public Sbol(String storePurchase, String imageStoreUrl, String cardNumber, String writeOff, String balance, String time) {
        mStorePurchase = storePurchase;
        mImageStoreUrl = imageStoreUrl;
        mCardNumber = cardNumber;
        mWriteOff = writeOff;
        mBalance = balance;
        mTime = time;
    }

    public String getStorePurchase() {
        return mStorePurchase;
    }

    public String getImageStoreUrl() {
        return mImageStoreUrl;
    }

    public String getCardNumber() {
        return mCardNumber;
    }

    public String getWriteOff() {
        return mWriteOff;
    }

    public String getBalance() {
        return mBalance;
    }

    public String getTime() {
        return mTime;
    }

    @Override
    public int getType() {
        return ItemTypes.SBOL.getType();
    }

    protected Sbol(Parcel in) {
        mStorePurchase = in.readString();
        mImageStoreUrl = in.readString();
        mCardNumber = in.readString();
        mWriteOff = in.readString();
        mBalance = in.readString();
        mTime = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mStorePurchase);
        dest.writeString(mImageStoreUrl);
        dest.writeString(mCardNumber);
        dest.writeString(mWriteOff);
        dest.writeString(mBalance);
        dest.writeString(mTime);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sbol> CREATOR = new Parcelable.Creator<Sbol>() {
        @Override
        public Sbol createFromParcel(Parcel in) {
            return new Sbol(in);
        }

        @Override
        public Sbol[] newArray(int size) {
            return new Sbol[size];
        }
    };
}
