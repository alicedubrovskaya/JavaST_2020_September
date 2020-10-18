package by.training.entity;

import java.util.ArrayList;
import java.util.List;

public class PublishedBook extends Book {
    private List<Author> authors=new ArrayList<>();
    private PublishingHouse publishingHouse;

    public PublishedBook(String title, int numberOfPages, int yearOfPublishing, PublishingHouse publishingHouse) {
        super(title, numberOfPages, yearOfPublishing);
        this.publishingHouse=publishingHouse;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
