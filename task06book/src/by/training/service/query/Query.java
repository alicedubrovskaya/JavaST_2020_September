package by.training.service.query;

import by.training.entity.Book;

import java.util.Set;

public interface Query {
    Set<Book> query(Set<Book> books);
}
