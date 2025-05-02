package com.textbooksale.app.model;

public class Textbook {
    private final String title;
    private final double price;
    private final int copies;
    private final String seller;
    private final String author;
    private final String imageUrl;

    // Primary constructor
    public Textbook(String title, double price, int copies,
                    String seller, String author, String imageUrl) {
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.seller = seller;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    // Overloaded constructor (without image)
    public Textbook(String title, double price, int copies,
                    String seller, String author) {
        this(title, price, copies, seller, author, "");
    }

    // Getters
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getCopies() { return copies; }
    public String getSeller() { return seller; }
    public String getAuthor() { return author; }
    public String getImageUrl() { return imageUrl; }

    public String getFormattedPrice() {
        return String.format("R%.2f", price);
    }

    public String getDetails() {
        return String.format("%s\nby %s\n%s • %d available",
                title, author, getFormattedPrice(), copies);
    }
}