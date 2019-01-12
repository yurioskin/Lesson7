package com.example.oskin.lesson7.CustomAdapter.CustomHolders;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oskin.lesson7.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SectionItemsViewHolder extends RecyclerView.ViewHolder {

    public TextView sectionName;
    public Button sectionBtn;
    public RecyclerView sectionItemsRecyclerView;


    public SectionItemsViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        sectionName = itemView.findViewById(R.id.section_layout_title);
        sectionBtn = itemView.findViewById(R.id.section_layout_btn);
        sectionItemsRecyclerView = itemView.findViewById(R.id.section_item_recycler);

        sectionBtn.setOnClickListener((View.OnClickListener) context);
        itemView.setOnClickListener((View.OnClickListener) context);
    }
}
