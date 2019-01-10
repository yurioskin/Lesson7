package com.example.oskin.lesson7.Data;

import android.content.Context;

import com.example.oskin.lesson7.R;

public class Sbol implements MyNotification {
    private Context mContext;
    private String mStorePurchase;
    private String mImageStoreUrl;
    private String mCardNumber;
    private String mWriteOff;
    private String mBalance;
    private String mTime;

    public Sbol(Context context, String storePurchase, String imageStoreUrl, String cardNumber, String writeOff, String balance, String time) {
        mContext = context;
        mStorePurchase = context.getResources().getString(R.string.purchase, storePurchase);
        mImageStoreUrl = imageStoreUrl;
        mCardNumber = context.getResources().getString(R.string.card_number, cardNumber);
        mWriteOff = context.getResources().getString(R.string.write_off, writeOff);
        mBalance = context.getResources().getString(R.string.balance, balance);
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
}
