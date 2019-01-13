package com.example.oskin.lesson7.CustomAdapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.oskin.lesson7.CustomAdapter.CustomBinders.CallViewHolderBinder;
import com.example.oskin.lesson7.CustomAdapter.CustomBinders.ItemViewHolderBinder;
import com.example.oskin.lesson7.CustomAdapter.CustomBinders.SMSViewHolderBinder;
import com.example.oskin.lesson7.CustomAdapter.CustomBinders.SbolViewHolderBinder;
import com.example.oskin.lesson7.CustomAdapter.CustomBinders.SectionItemsViewHolderBinder;
import com.example.oskin.lesson7.CustomAdapter.CustomBinders.ViewHolderBinder;
import com.example.oskin.lesson7.CustomAdapter.CustomFactories.CallViewHolderFactory;
import com.example.oskin.lesson7.CustomAdapter.CustomFactories.ItemViewHolderFactory;
import com.example.oskin.lesson7.CustomAdapter.CustomFactories.SMSViewHolderFactory;
import com.example.oskin.lesson7.CustomAdapter.CustomFactories.SbolViewHolderFactory;
import com.example.oskin.lesson7.CustomAdapter.CustomFactories.SectionItemsViewHolderFactory;
import com.example.oskin.lesson7.CustomAdapter.CustomFactories.ViewHolderFactory;
import com.example.oskin.lesson7.Data.MyNotification;
import com.example.oskin.lesson7.Data.ItemTypes;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MyNotification> mData = new ArrayList<>();
    private final List<ViewHolderBinder> mBinders;
    private SparseArray<ViewHolderFactory> mFactoryMap;
    private Context mContext;

    public CustomAdapter(Context context){
        mContext = context;
        mBinders = new ArrayList<>();
        initFactory();

    }

    public void setData(List<MyNotification> data) {
        mData = data;
        mBinders.clear();
        for (MyNotification notification: mData) {
            mBinders.add(generateBinder(notification));
        }
        notifyDataSetChanged();
    }

    public void updateData(List<MyNotification> data){
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffCallback(mData,data));
        mData = data;
        mBinders.clear();
        for (MyNotification notification: mData) {
            mBinders.add(generateBinder(notification));
        }
        diffResult.dispatchUpdatesTo(this);

    }


    private void initFactory() {
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(ItemTypes.CALL.getType(), new CallViewHolderFactory());
        mFactoryMap.put(ItemTypes.SMS.getType(), new SMSViewHolderFactory());
        mFactoryMap.put(ItemTypes.SBOL.getType(), new SbolViewHolderFactory());
        mFactoryMap.put(ItemTypes.ITEM.getType(), new ItemViewHolderFactory());
        mFactoryMap.put(ItemTypes.SECTION_ITEM.getType(), new SectionItemsViewHolderFactory());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolderFactory factory = mFactoryMap.get(viewType);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return factory.createViewHolder(mContext, parent, inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderBinder binder = mBinders.get(position);
        if (binder != null){
            binder.bindViewHolder(mContext, holder);
        }
    }


    private ViewHolderBinder generateBinder(MyNotification notification) {
        if (notification.getType() == ItemTypes.CALL.getType()){
            return new CallViewHolderBinder(notification,ItemTypes.CALL.getType());
        } else if (notification.getType() == ItemTypes.SMS.getType()) {
            return new SMSViewHolderBinder(notification, ItemTypes.SMS.getType());
        } else if (notification.getType() == ItemTypes.SBOL.getType()) {
            return new SbolViewHolderBinder(notification, ItemTypes.SBOL.getType());
        } else if (notification.getType() == ItemTypes.SECTION_ITEM.getType()) {
            return new SectionItemsViewHolderBinder(notification, ItemTypes.SECTION_ITEM.getType());
        } else if (notification.getType() == ItemTypes.ITEM.getType()) {
            return new ItemViewHolderBinder(notification, ItemTypes.ITEM.getType());
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getType() == ItemTypes.CALL.getType()) {
            return ItemTypes.CALL.getType();
        } else if (mData.get(position).getType() == ItemTypes.SMS.getType()) {
            return ItemTypes.SMS.getType();
        } else if (mData.get(position).getType() == ItemTypes.SBOL.getType()) {
            return ItemTypes.SBOL.getType();
        } else if (mData.get(position).getType() == ItemTypes.ITEM.getType()) {
            return ItemTypes.ITEM.getType();
        } else if (mData.get(position).getType() == ItemTypes.SECTION_ITEM.getType()) {
            return ItemTypes.SECTION_ITEM.getType();
        }
        return mData.get(position).getType();
    }
}
