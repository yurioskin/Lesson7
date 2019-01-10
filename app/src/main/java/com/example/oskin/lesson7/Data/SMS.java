package com.example.oskin.lesson7.Data;

public class SMS implements MyNotification {
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
}
