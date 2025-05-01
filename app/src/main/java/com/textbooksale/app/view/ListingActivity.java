package com.textbooksale.app.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.textbooksale.app.R;
import com.textbooksale.app.controller.TextbookManager;
import com.textbooksale.app.model.Textbook;
import com.textbooksale.app.utils.DuplicateEntryException;

public class ListingActivity extends AppCompatActivity {
    private EditText etTitle, etAuthor, etSeller, etCopies, etPrice, etBankInfo;
    private Button btnSubmit;

    private TextbookManager textbookManager = TextbookManager.getInstance(); // ✅

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        // Find Views
        etTitle = findViewById(R.id.etTitle);
        etAuthor = findViewById(R.id.etAuthor);
        etSeller = findViewById(R.id.etSeller);
        etCopies = findViewById(R.id.etCopies);
        etPrice = findViewById(R.id.etPrice);
        etBankInfo = findViewById(R.id.etBankInfo);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Handle Submit
        btnSubmit.setOnClickListener(v -> {
            try {
                String title = etTitle.getText().toString().trim();
                String author = etAuthor.getText().toString().trim();
                String seller = etSeller.getText().toString().trim();
                int copies = Integer.parseInt(etCopies.getText().toString().trim());
                double price = Double.parseDouble(etPrice.getText().toString().trim());
                String bankInfo = etBankInfo.getText().toString().trim();

                Textbook book = new Textbook(title, price, copies, seller, author);
                textbookManager.addBook(book);

                Toast.makeText(this, "Book listed successfully", Toast.LENGTH_SHORT).show();
                clearFields();

            } catch (DuplicateEntryException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void clearFields() {
        etTitle.setText("");
        etAuthor.setText("");
        etSeller.setText("");
        etCopies.setText("");
        etPrice.setText("");
        etBankInfo.setText("");
    }
}


