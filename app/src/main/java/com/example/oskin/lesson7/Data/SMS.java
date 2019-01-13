package com.example.oskin.lesson7.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class SMS extends MyNotification {
    private String mSenderName;
    private String mSMSContent;
    private String mSMSTime;

    public SMS(String senderName, String smsContent, String smsTime) {
        mSenderName = senderName;
        mSMSContent = smsContent;
        mSMSTime = smsTime;
    }

    public String getSenderName() {
        return mSenderName;
    }

    public String getSMSContent() {
        return mSMSContent;
    }

    public String getSMSTime() {
        return mSMSTime;
    }

    @Override
    public int getType() {
        return ItemTypes.SMS.getType();
    }

    protected SMS(Parcel in) {
        mSenderName = in.readString();
        mSMSContent = in.readString();
        mSMSTime = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSenderName);
        dest.writeString(mSMSContent);
        dest.writeString(mSMSTime);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SMS> CREATOR = new Parcelable.Creator<SMS>() {
        @Override
        public SMS createFromParcel(Parcel in) {
            return new SMS(in);
        }

        @Override
        public SMS[] newArray(int size) {
            return new SMS[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SMS sms = (SMS) o;
        return Objects.equals(mSenderName, sms.mSenderName) &&
                Objects.equals(mSMSContent, sms.mSMSContent) &&
                Objects.equals(mSMSTime, sms.mSMSTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mSenderName, mSMSContent, mSMSTime);
    }
}
