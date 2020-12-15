package com.learning.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class DetailViewActivity extends AppCompatActivity {

    private static final String ID_KEY = "ID_KEY";
    private static final List<String> hor_cards  = Arrays.asList("Card 1", "Card 2", "Card 3", "Card 4", "Card 5");

    public static Intent getIntent(final Context context, final long id) {
        final Intent intent = new Intent(context, DetailViewActivity.class);
        intent.putExtra(ID_KEY, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Detail View");

        setContentView(R.layout.activity_detail_view);

        final long id = getIntent().getLongExtra(ID_KEY, -1);
        final Note person = NoteRepository.getNoteWithId(id);

        final TextView textView = findViewById(R.id.detail_text);
        textView.setText( person.getText() );
        final ImageView imageView = findViewById(R.id.detail_img);
        imageView.setImageResource( person.getDrawableRes() );

        RecyclerView recyclerView = findViewById(R.id.horRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        HorRecyclerViewAdapter adapter = new HorRecyclerViewAdapter(this, hor_cards);
//        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}