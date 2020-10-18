package by.training.entity;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String surname;
    private List<Book> books = new ArrayList<>();

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public boolean wroteBook(Book book){
        if (books.contains(book)){
            return true;
        }
        return false;
    }
}
