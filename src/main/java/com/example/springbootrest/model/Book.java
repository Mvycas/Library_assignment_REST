package com.example.springbootrest.model;


import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @Column(name = "barcode")
    private long barcode;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;


    public Book() {}

    public Book(long barcode, String name, String author, int quantity, double price) {
        this.barcode = barcode;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public Book(String name, String author, int quantity, double price) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public Book(long barcode, String name, String author, int quantity) {
        this.barcode = barcode;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
