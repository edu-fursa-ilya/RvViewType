package com.lesson.rvviewtype.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SeparatorHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;

    public SeparatorHolder(View itemView, TextView title) {
        super(itemView);
        this.tvTitle = title;
    }
}
