package com.example.oskin.lesson7.Data;

public class Call implements MyNotification{
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
}
