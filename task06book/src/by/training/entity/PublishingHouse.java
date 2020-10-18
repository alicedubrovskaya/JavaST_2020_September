package by.training.entity;

import java.util.ArrayList;
import java.util.List;

public class PublishingHouse {
    List<Book> publishedBooks= new ArrayList<>();

    public void addBook(Book book){
        publishedBooks.add(book);
    }
}
