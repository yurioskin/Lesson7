package com.example.oskin.lesson7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.oskin.lesson7.CustomAdapter.CustomAdapter;
import com.example.oskin.lesson7.Data.DataUtils;
import com.example.oskin.lesson7.Data.MyNotification;
import com.example.oskin.lesson7.LoadData.MyIntentService;
import com.example.oskin.lesson7.LoadData.MyResultReceiver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyResultReceiver.Receiver {

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyResultReceiver mResultReceiver;
    private ProgressBar mProgressBar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<MyNotification> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.main_progressBar);
        mSwipeRefreshLayout = findViewById(R.id.main_swipe_refresh_layout);

        //TODO separate method
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });

        initRecyclerView();
        initData();
    }

    private void refreshItem(){
        Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
        MyIntentService.startActionUpdateData(this,mResultReceiver);
    }

    private void initData() {
        mProgressBar.setVisibility(View.VISIBLE);
        mResultReceiver = new MyResultReceiver(new Handler());
        mResultReceiver.setReceiver(this);
        MyIntentService.startActionLoadData(this,mResultReceiver);
    }

    private void initRecyclerView(){
        mRecyclerView = findViewById(R.id.main_recycler_view);
        mAdapter = new CustomAdapter(this);
        mLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

        if (resultCode == MyIntentService.GET_DATA){
            mData = resultData.getParcelableArrayList(MyResultReceiver.RESULT_RECEIVER);
            mAdapter.setData(mData);
            mProgressBar.setVisibility(View.GONE);
        } else if (resultCode == MyIntentService.GET_UPDATED_DATA){
            mData = resultData.getParcelableArrayList(MyResultReceiver.RESULT_RECEIVER);
            mSwipeRefreshLayout.setRefreshing(false);
            mAdapter.updateData(mData);
            mLayoutManager.scrollToPosition(0);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.call_layout){
            Toast.makeText(this, "Call notification", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.sms_layout){
            Toast.makeText(this, "SMS notification", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.sbol_layout){
            Toast.makeText(this, "Sberbank notification", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.item_layout){
            Toast.makeText(this, "Item notification", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.section_layout){
            Toast.makeText(this, "Section items notification", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.section_layout_btn){
            Toast.makeText(this, "Button pressed", Toast.LENGTH_SHORT).show();
        }
    }
}
