package by.training.dao;

import by.training.entity.Author;
import by.training.entity.Book;

import java.util.List;

public interface AuthorDao {
    List<Author> fetchAuthorsOfBook(Book book);
}
