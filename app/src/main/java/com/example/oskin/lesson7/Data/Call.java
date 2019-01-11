package com.example.oskin.lesson7.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class Call extends MyNotification{
    private String mCallerName;
    private String mCallTime;

    public Call(String callerName, String callTime){
        mCallerName = callerName;
        mCallTime = callTime;
    }

    public String getCallerName() {
        return mCallerName;
    }

    public String getCallTime() {
        return mCallTime;
    }

    @Override
    public int getType() {
        return ItemTypes.CALL.getType();
    }

    protected Call(Parcel in) {
        mCallerName = in.readString();
        mCallTime = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCallerName);
        dest.writeString(mCallTime);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Call> CREATOR = new Parcelable.Creator<Call>() {
        @Override
        public Call createFromParcel(Parcel in) {
            return new Call(in);
        }

        @Override
        public Call[] newArray(int size) {
            return new Call[size];
        }
    };
}
