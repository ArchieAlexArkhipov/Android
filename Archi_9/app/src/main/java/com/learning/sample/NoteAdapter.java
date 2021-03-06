package com.learning.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    public interface Listener {

        void onNoteClick( long id );

    }

    private List<Note> notes = new ArrayList<>();
    private Listener listener;

    public void setListener( final Listener listener )
    {
        this.listener = listener;
    }

    public void setNotes( final List<Note> notes )
    {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType )
    {
        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        final View view = layoutInflater.inflate(
                R.layout.note_item,
                parent,
                false
        );
        return new NoteViewHolder( view, listener );
    }

    @Override
    public void onBindViewHolder( @NonNull final NoteViewHolder holder, final int position )
    {
        holder.bind( notes.get( position ) );
    }

    @Override
    public int getItemCount()
    {
        return notes.size();
    }
}