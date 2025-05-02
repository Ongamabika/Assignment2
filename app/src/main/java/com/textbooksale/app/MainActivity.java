package com.textbooksale.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.textbooksale.app.view.ListingActivity;
import com.textbooksale.app.view.BrowseActivity;

public class MainActivity extends AppCompatActivity {
    Button listBookButton, browseBookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBookButton = findViewById(R.id.btnListBook);
        browseBookButton = findViewById(R.id.btnBrowseBooks);  // New button

        listBookButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListingActivity.class);
            startActivity(intent);
        });

        browseBookButton = findViewById(R.id.btnBrowseBooks);
        browseBookButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BrowseActivity.class);
            startActivity(intent);
        });

    }
}
