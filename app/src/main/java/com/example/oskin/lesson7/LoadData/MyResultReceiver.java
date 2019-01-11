package com.example.oskin.lesson7.LoadData;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class MyResultReceiver extends ResultReceiver {

    public static final String RESULT_RECEIVER = "com.example.oskin.lesson7.action.MY_RESULT_RECEIVER";

    private Receiver mReceiver;

    public MyResultReceiver(Handler handler) {
        super(handler);
    }

    public void setReceiver(Receiver receiver){
        mReceiver = receiver;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        if (mReceiver != null){
            mReceiver.onReceiveResult(resultCode,resultData);
        }
    }

    public interface Receiver{
        void onReceiveResult(int resultCode, Bundle resultData);
    }
}
