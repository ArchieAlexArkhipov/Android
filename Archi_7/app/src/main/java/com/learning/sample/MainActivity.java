package com.learning.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learning.sample.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Notes");

        setContentView(R.layout.activity_main);

        final CardView cardView = findViewById(R.id.card_view);
        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        final Intent intent;
        switch (view.getId()) {
            case R.id.card_view:
                intent = new Intent(this, DetailViewActivity.class);
                break;

            default:
                throw new IllegalArgumentException("Unknown button");
        }
        startActivity(intent);
    }
}
