package com.lesson.rvviewtype.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NoteHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView text;

    public NoteHolder(View itemView, TextView title, TextView text) {
        super(itemView);
        this.title = title;
        this.text = text;
    }
}
