package com.learning.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Notes");

        setContentView(R.layout.activity_main);

        NotesListView notesListView = findViewById(R.id.notesListView);
        notesListView.setData(NoteRepository.getNotes());

    }
}
