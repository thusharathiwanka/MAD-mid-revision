package com.example.mid_revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView readerName;
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void okBtnClick(View view) {
        readerName = findViewById(R.id.readerName);
        okBtn = findViewById(R.id.okBtn);

        String name = readerName.getText().toString();

        if(name.length() >= 1) {
            Intent intent = new Intent(getApplicationContext(), ReadingCollectionsActivity.class);
            intent.putExtra("READER'S_NAME", name);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Reader's name cannot be empty !", Toast.LENGTH_LONG).show();
        }
    }
}