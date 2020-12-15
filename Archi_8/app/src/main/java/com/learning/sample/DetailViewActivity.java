package com.learning.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailViewActivity extends AppCompatActivity {

    private static final String ID_KEY = "ID_KEY";

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
    }
}