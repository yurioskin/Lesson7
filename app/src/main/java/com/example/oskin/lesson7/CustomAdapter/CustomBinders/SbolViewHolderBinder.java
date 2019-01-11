package com.example.oskin.lesson7.CustomAdapter.CustomBinders;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.oskin.lesson7.CustomAdapter.CustomHolders.SbolViewHolder;
import com.example.oskin.lesson7.Data.MyNotification;
import com.example.oskin.lesson7.Data.Sbol;
import com.example.oskin.lesson7.R;

import androidx.recyclerview.widget.RecyclerView;

public class SbolViewHolderBinder extends ViewHolderBinder {

    private final Sbol mSbol;

    public SbolViewHolderBinder(MyNotification item, int viewType) {
        super(viewType);
        mSbol = (Sbol) item;
    }

    @Override
    public void bindViewHolder(Context context, RecyclerView.ViewHolder holder) {
        SbolViewHolder sbolViewHolder = (SbolViewHolder) holder;

        sbolViewHolder.storePurchase.setText(
                context.getResources().getString(R.string.purchase, mSbol.getStorePurchase()));

        sbolViewHolder.cardNumber.setText(
                context.getResources().getString(R.string.card_number, mSbol.getCardNumber()));

        sbolViewHolder.writeOff.setText(
                context.getResources().getString(R.string.write_off, mSbol.getWriteOff()));

        sbolViewHolder.balance.setText(
                context.getResources().getString(R.string.balance, mSbol.getBalance()));

        sbolViewHolder.time.setText(mSbol.getTime());

        Glide.with(context)
                .load(mSbol.getImageStoreUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(sbolViewHolder.storeLogo);
    }

    @Override
    public MyNotification getItem() {
        return mSbol;
    }
}
