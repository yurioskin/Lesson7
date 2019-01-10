package com.example.oskin.lesson7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;

import com.example.oskin.lesson7.CustomAdapter.CustomAdapter;
import com.example.oskin.lesson7.Data.DataUtils;
import com.example.oskin.lesson7.Data.MyNotification;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<MyNotification> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();


    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
        mAdapter.setData(mData);

    }

    private void initData() {
        mData = DataUtils.generateData(this);
    }

    private void initRecyclerView(){
        mRecyclerView = findViewById(R.id.main_recycler_view);
        mAdapter = new CustomAdapter(this, mData);
        //В примере был LinerLayoutManager.VERTICAL
        mLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    class MyResultReceiver extends ResultReceiver{

        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);

            //ЭТО не точно


            //TODO receive result, set progress bar visibility GONE
        }
    }
}
