package by.training.dao.implementation;

import by.training.dao.AuthorDao;
import by.training.data.AuthorList;
import by.training.entity.Author;
import by.training.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    private AuthorList authorList;

    @Override
    public List<Author> fetchAuthorsOfBook(Book book) {
        List<Author> authors = new ArrayList<>();
        authorList.getAuthorsOfBook(book);
        return authors;
    }
}
