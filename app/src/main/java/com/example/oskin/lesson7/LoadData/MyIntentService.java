package com.example.oskin.lesson7.LoadData;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import com.example.oskin.lesson7.Data.DataUtils;
import com.example.oskin.lesson7.Data.MyNotification;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    public static final String LOAD_DATA = "com.example.oskin.lesson7.action.FOO";

    public static final int GET_DATA = 1;

    private List<MyNotification> mMyNotifications;

    public MyIntentService() {
        super("MyIntentService");
    }

    public static void startActionLoadData(Context context, MyResultReceiver resultReceiver){
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(MyIntentService.LOAD_DATA);
        intent.putExtra(MyResultReceiver.RESULT_RECEIVER, resultReceiver);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null){
            final String action = intent.getAction();
            if (LOAD_DATA.equals(action)){
                ResultReceiver resultReceiver = intent.getParcelableExtra(MyResultReceiver.RESULT_RECEIVER);
                handleActionLoadData(resultReceiver);
            }
        }
    }

    private void handleActionLoadData(ResultReceiver resultReceiver){
        mMyNotifications = DataUtils.generateData();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(MyResultReceiver.RESULT_RECEIVER, (ArrayList<MyNotification>) mMyNotifications);
        resultReceiver.send(GET_DATA, bundle);
    }
}
