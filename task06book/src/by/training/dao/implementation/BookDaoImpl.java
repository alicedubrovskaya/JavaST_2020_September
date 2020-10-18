package by.training.dao.implementation;

import by.training.dao.BookDao;
import by.training.entity.data.BookList;
import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;

public class BookDaoImpl implements BookDao {
    private BookList bookList = new BookList();

    @Override
    public void create(Book book) throws BookAlreadyExistsException {
        if (!bookList.bookExists(book.getTitle())) {
            bookList.add(book);
        } else throw new BookAlreadyExistsException(book.getTitle());
    }

    @Override
    public void delete(String title) throws BookNotFoundException {
        bookList.delete(title);
    }

    @Override
    public Book get(String title) throws BookNotFoundException {
        return bookList.get(title);
    }
}
