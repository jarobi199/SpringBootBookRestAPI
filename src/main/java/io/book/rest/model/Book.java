package io.book.rest.model;

import org.springframework.data.annotation.Id;

public class Book {

    @Id
    private String id;
    private String name;
    private String author;
    private String sku;

    public Book() {
        //No argument constructor
    }

    public Book(String id, String name, String author, String sku) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sku = sku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
