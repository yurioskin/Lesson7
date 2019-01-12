package com.example.oskin.lesson7.CustomAdapter.CustomBinders;

import android.content.Context;

import com.example.oskin.lesson7.CustomAdapter.CustomAdapter;
import com.example.oskin.lesson7.CustomAdapter.CustomHolders.SectionItemsViewHolder;
import com.example.oskin.lesson7.Data.Item;
import com.example.oskin.lesson7.Data.MyNotification;
import com.example.oskin.lesson7.Data.SectionItems;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SectionItemsViewHolderBinder extends ViewHolderBinder {

    private SectionItems mSectionItems;
    private CustomAdapter mCustomAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<MyNotification> mItemList;

    public SectionItemsViewHolderBinder(MyNotification item, int viewType) {
        super(viewType);
        mSectionItems = (SectionItems) item;
        mItemList = mSectionItems.getItemList();
    }

    @Override
    public void bindViewHolder(Context context, RecyclerView.ViewHolder holder) {
        SectionItemsViewHolder sectionItemsViewHolder = (SectionItemsViewHolder) holder;

        mCustomAdapter = new CustomAdapter(context);
        mLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);

        sectionItemsViewHolder.sectionName.setText(mSectionItems.getSectionName());
        sectionItemsViewHolder.sectionItemsRecyclerView.setAdapter(mCustomAdapter);
        sectionItemsViewHolder.sectionItemsRecyclerView.setLayoutManager(mLayoutManager);
        mCustomAdapter.setData(mItemList);

    }

    @Override
    public MyNotification getItem() {
        return null;
    }
}
