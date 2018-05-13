package com.lesson.rvviewtype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lesson.rvviewtype.model.IListItem;
import com.lesson.rvviewtype.model.Note;
import com.lesson.rvviewtype.model.Remind;
import com.lesson.rvviewtype.model.Separator;
import com.lesson.rvviewtype.recycler.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mAdapter = new RecyclerAdapter(fill());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<IListItem> fill() {
        List<IListItem> items = new ArrayList<>();

        items.add(new Separator("Мои заметки"));

        items.add(new Note("Note title 0", "Note text 0"));
        items.add(new Note("Note title 1", "Note text 1"));
        items.add(new Note("Note title 2", "Note text 2"));
        items.add(new Note("Note title 3", "Note text 3"));

        items.add(new Separator("Мои напоминания"));

        items.add(new Remind("Remind title 0", "Remind text 0", new Date()));
        items.add(new Remind("Remind title 1", "Remind text 1", new Date()));
        items.add(new Remind("Remind title 2", "Remind text 2", new Date()));
        return items;
    }
}
