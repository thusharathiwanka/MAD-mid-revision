package com.example.mid_revision;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddReading extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reading);

        changeFragments();
    }

    public void changeFragments() {
        TextView author, title;
        Intent intent = getIntent();
        Fragment fragment1, fragment2;
        String status = intent.getStringExtra("READING_TYPE");

        author = findViewById(R.id.lblAuthor);
        title = findViewById(R.id.lblTitle);

        if(status != null) {
            if(status.equals("1")) {
                author.setText("Author");
                title.setText("Book Title");

                fragment1 = new BookFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentDefault,fragment1);
                ft.commit();
            }
            if(status.equals("0")) {
                author.setText("Editor");
                title.setText("Title of the article");

                fragment2 = new PaperFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentDefault, fragment2);
                ft.commit();
            }
        }
    }

    public void clickAlert(View view) {
        EditText author, title;
        AlertDialog dialog;

        author = findViewById(R.id.txtAuthor);
        title = findViewById(R.id.txtTitle);

        if(author.length() >= 1 || title.length() >= 1) {
            String authorVal = author.getText().toString();
            String titleVal = title.getText().toString();

            System.out.println(authorVal);
            System.out.println(titleVal);

            AlertDialog.Builder builder = new AlertDialog.Builder(AddReading.this);
            builder.setTitle("You're Reading");
            builder.setMessage(titleVal + " by " + authorVal);
            builder.setPositiveButton("OK", null);
            dialog = builder.create();
            dialog.show();
        } else {
            Toast.makeText(getApplicationContext(), "Inputs cannot be empty !", Toast.LENGTH_LONG).show();
        }
    }
}