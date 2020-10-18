package by.training.dao.implementation;

import by.training.dao.BookDao;
import by.training.entity.data.BookSet;
import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;

public class BookDaoImpl implements BookDao {
    private BookSet bookSet = new BookSet();

    @Override
    public void create(Book book) throws BookAlreadyExistsException {
        boolean doesntExist = bookSet.add(book);
        if (!doesntExist) {
            throw new BookAlreadyExistsException(book.getTitle());
        }
    }

    @Override
    public void delete(String title) throws BookNotFoundException {
        bookSet.delete(title);
    }

    @Override
    public Book get(String title) throws BookNotFoundException {
        return bookSet.get(title);
    }
}
