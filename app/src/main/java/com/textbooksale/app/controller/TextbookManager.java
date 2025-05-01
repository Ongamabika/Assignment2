package com.textbooksale.app.controller;

import com.textbooksale.app.model.Textbook;
import com.textbooksale.app.utils.DuplicateEntryException;
import java.util.ArrayList;
public class TextbookManager {
    private static TextbookManager instance;
    private ArrayList<Textbook> bookList = new ArrayList<>();

    private TextbookManager() {}

    public static TextbookManager getInstance() {
        if (instance == null) {
            instance = new TextbookManager();
        }
        return instance;
    }

    public void addBook(Textbook book) throws DuplicateEntryException {
        if(bookList.contains(book)) {
            throw new DuplicateEntryException("This textbook is already listed!");
        }
        bookList.add(book);
    }

    public ArrayList<Textbook> searchByTitleOrSeller(String query) {
        ArrayList<Textbook> result = new ArrayList<>();
        for (Textbook book : bookList) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getSeller().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Textbook> getAllBooks() {
        return new ArrayList<>(bookList); // Defensive copy
    }
}

