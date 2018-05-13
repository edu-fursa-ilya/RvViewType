package com.lesson.rvviewtype.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RemindHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView text;
    public TextView date;

    public RemindHolder(View itemView, TextView title, TextView text, TextView date) {
        super(itemView);
        this.title = title;
        this.text = text;
        this.date = date;
    }
}
