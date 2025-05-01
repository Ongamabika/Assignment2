package com.textbooksale.app.model;

public class Textbook {


    private String title, author, seller;
    private int copies;
    private double price;


    public Textbook(String title, double price, int copies, String seller, String author) {
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.seller = seller;
        this.author = author;
    }

    public String getDetails(){
        return title+" by " + author + ", sold by: "+ seller + ", Price: R"+ price;
    }
    public String getTitle() {
        return title;
    }

    public String getSeller() {
        return seller;
    }

    public boolean equals(Object obj){
        if(obj instanceof Textbook){
            Textbook textbook = (Textbook) obj;
            return  this.title.equalsIgnoreCase(textbook.title)&&
                    this.seller.equalsIgnoreCase(textbook.seller);
        }
        return false;
    }
}
