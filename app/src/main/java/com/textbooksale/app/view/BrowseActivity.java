package com.textbooksale.app.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.text.TextWatcher;
import android.text.Editable;

import androidx.appcompat.app.AppCompatActivity;

import com.textbooksale.app.R;
import com.textbooksale.app.controller.TextbookManager;
import com.textbooksale.app.model.Textbook;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {
    private ListView listView;
    private EditText etSearch;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> bookDetails;
    private TextbookManager textbookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


        textbookManager = TextbookManager.getInstance(); // ✅ Use shared instance

        listView = findViewById(R.id.listViewBooks);
        etSearch = findViewById(R.id.etSearch);

        // ✅ Load all books initially
        bookDetails = new ArrayList<>();
        for (Textbook book : textbookManager.getAllBooks()) {
            bookDetails.add(book.getDetails());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookDetails);
        listView.setAdapter(adapter);

        // ✅ Search functionality
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Textbook> filtered = textbookManager.searchByTitleOrSeller(s.toString());
                ArrayList<String> searchResults = new ArrayList<>();

                for (Textbook book : filtered) {
                    searchResults.add(book.getDetails());
                }

                adapter.clear();
                if (searchResults.isEmpty()) {
                    adapter.add("No books found matching your search.");
                } else {
                    adapter.addAll(searchResults);
                }
                adapter.notifyDataSetChanged();
            }

            @Override public void afterTextChanged(Editable s) {}
        });
    }
}



