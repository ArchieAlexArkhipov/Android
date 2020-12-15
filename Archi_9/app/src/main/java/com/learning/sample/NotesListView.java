package com.learning.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class NotesListView extends RelativeLayout implements NoteAdapter.Listener {

    private RecyclerView recyclerView;
    private NoteAdapter noteAdapter = new NoteAdapter();
    LayoutInflater mInflater;
    public NotesListView(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
        init(context);

    }
    public NotesListView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
        init(context);
    }
    public NotesListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init(context);
    }
    public void init(Context context)
    {
        View v = mInflater.inflate(R.layout.notes_list, this, true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 5);

        recyclerView.setAdapter(noteAdapter);
        noteAdapter.setListener(this);

    }

    public void setData(List<Note> notesList) {
        noteAdapter.setNotes(notesList);

    }

    @Override
    public void onNoteClick(final long id) {
        getContext().startActivity(DetailViewActivity.getIntent(getContext(), id));
    }
}

