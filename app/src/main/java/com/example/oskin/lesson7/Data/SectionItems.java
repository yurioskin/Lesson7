package com.example.oskin.lesson7.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class SectionItems extends MyNotification {

    private String mSectionName;
    private List<MyNotification> mItemList;

    public SectionItems (String sectionName, List<MyNotification> itemList){
        mSectionName = sectionName;
        mItemList = itemList;
    }

    public List<MyNotification> getItemList(){
        return mItemList;
    }

    public String getSectionName(){
        return mSectionName;
    }

    @Override
    public int getType() {
        return ItemTypes.SECTION_ITEM.getType();
    }

    protected SectionItems(Parcel in) {
        mSectionName = in.readString();
        if (in.readByte() == 0x01) {
            mItemList = new ArrayList<MyNotification>();
            in.readList(mItemList, Item.class.getClassLoader());
        } else {
            mItemList = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSectionName);
        if (mItemList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mItemList);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SectionItems> CREATOR = new Parcelable.Creator<SectionItems>() {
        @Override
        public SectionItems createFromParcel(Parcel in) {
            return new SectionItems(in);
        }

        @Override
        public SectionItems[] newArray(int size) {
            return new SectionItems[size];
        }
    };
}
