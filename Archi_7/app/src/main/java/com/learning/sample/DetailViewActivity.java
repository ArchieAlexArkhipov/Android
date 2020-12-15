package com.learning.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Detail View");

        setContentView(R.layout.activity_detail_view);
    }
}