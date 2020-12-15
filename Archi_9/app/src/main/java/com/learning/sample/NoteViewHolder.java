package com.learning.sample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private CardView noteCard;
    private ImageView noteImageView;
    private TextView noteDateTextView;
    private TextView noteTextTextView;
    private long id;
    private NoteAdapter.Listener listener;

    public NoteViewHolder(
            final View itemView,
            final NoteAdapter.Listener listener
    )
    {
        super( itemView );
        noteCard = itemView.findViewById( R.id.card_view );

        noteImageView = itemView.findViewById( R.id.card_img );
        noteDateTextView = itemView.findViewById( R.id.card_date );
        noteTextTextView = itemView.findViewById( R.id.card_text );

        noteCard.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( final View v )
            {
                if( listener != null ) {
                    listener.onNoteClick( id );
                }
            }
        } );
    }

    public void bind( final Note note )
    {
        noteImageView.setImageResource( note.getDrawableRes() );
        noteDateTextView.setText( note.getDate() );
        noteTextTextView.setText( note.getText() );
        id = note.getId();
    }
}