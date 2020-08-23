package com.example.mid_revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ReadingCollectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_collections);

        Intent intent = getIntent();
        String name = intent.getStringExtra("READER'S_NAME");

        Toast.makeText(getApplicationContext(), "Welcome " + name + "\nPlease enter what you read.", Toast.LENGTH_SHORT).show();
    }
}