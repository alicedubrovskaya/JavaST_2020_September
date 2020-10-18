package by.training.dao.implementation;

import by.training.dao.BookDao;
import by.training.data.BookList;
import by.training.entity.Book;

public class BookDaoImpl implements BookDao {
    private BookList bookList;

    @Override
    public void create(Book book) {
        bookList.add(book);
    }

    @Override
    public void delete(Book book) {
        bookList.delete(book);
    }

    @Override
    public Book get(String title) {
        return bookList.get(title);
    }
}
