package com.lesson.rvviewtype.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lesson.rvviewtype.R;
import com.lesson.rvviewtype.model.IListItem;
import com.lesson.rvviewtype.model.Note;
import com.lesson.rvviewtype.model.Remind;
import com.lesson.rvviewtype.model.Separator;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int NOTE_TYPE = 1;
    private static final int REMIND_TYPE = 2;
    private static final int SEPARATOR_TYPE = 3;

    private List<IListItem> mItemList;

    private LayoutInflater inflater;
    private View view;


    public RecyclerAdapter(List<IListItem> items) {
        this.mItemList = items;
    }

    public IListItem getItem(int pos) {
        return mItemList.get(pos);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case NOTE_TYPE:
                view = inflater.inflate(R.layout.note_row, parent, false);
                TextView tvNoteTitle = view.findViewById(R.id.title);
                TextView tvNoteText = view.findViewById(R.id.text);
                return new NoteHolder(view, tvNoteTitle, tvNoteText);
            case REMIND_TYPE:
                view = inflater.inflate(R.layout.remind_row, parent, false);
                TextView tvRemindTitle = view.findViewById(R.id.title);
                TextView tvRemindText = view.findViewById(R.id.text);
                TextView tvRemindDate = view.findViewById(R.id.date);
                return new RemindHolder(view, tvRemindTitle, tvRemindText,tvRemindDate);
            case SEPARATOR_TYPE:
                view = inflater.inflate(R.layout.separator_row, parent, false);
                TextView tvSeparatorTitle = view.findViewById(R.id.title);
                return new SeparatorHolder(view, tvSeparatorTitle);
        }

        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        IListItem item = mItemList.get(position);
        if(item.isNote()) {
            final NoteHolder noteHolder = (NoteHolder) holder;
            Note note = (Note) item;
            noteHolder.title.setText(note.getTitle());
            noteHolder.text.setText(note.getText());
        } else if(item.isRemind()) {
            final RemindHolder remindHolder = (RemindHolder) holder;
            Remind remind = (Remind) item;
            remindHolder.title.setText(remind.getTitle());
            remindHolder.text.setText(remind.getText());
            remindHolder.date.setText(new SimpleDateFormat("d MMMM yyyy HH:mm", new Locale("ru")).format(remind.getDate()));
        } else if(!item.isRemind() || !item.isNote()) {
            final SeparatorHolder separatorHolder = (SeparatorHolder) holder;
            Separator separator = (Separator) item;
            separatorHolder.tvTitle.setText(separator.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).isNote()) {
            return NOTE_TYPE;
        } else if (getItem(position).isRemind()) {
            return REMIND_TYPE;
        } else return SEPARATOR_TYPE;
    }
}
